import scala.math.Numeric

trait Expr[T] {
  def literalInt(value: Int): T
  def variable(name: String): T
  def times(x: T, y: T): T
  def plus(x: T, y: T): T
  def minus(x: T, y: T): T = plus(x, negate(y))
  def negate(x: T): T = times(x, literalInt(-1))
}

object exprSyntax {
  def literalInt[T](value: Int)(implicit expr: Expr[T]): T = expr.literalInt(value)
  def X[T](implicit expr: Expr[T]): T = expr.variable("x")
  def Y[T](implicit expr: Expr[T]): T = expr.variable("y")
  def Z[T](implicit expr: Expr[T]): T = expr.variable("z")

  implicit class IntToExpr[T](x: Int)(implicit expr: Expr[T]) {
    def lit: T = expr.literalInt(x)
  }

  implicit class NumOps[T](val x: T) extends AnyVal {
    def +(y: T)(implicit expr: Expr[T]): T = expr.plus(x, y)
    def -(y: T)(implicit expr: Expr[T]): T = expr.minus(x, y)
    def *(y: T)(implicit expr: Expr[T]): T = expr.times(x, y)
    def unary_-(implicit expr: Expr[T]): T = expr.negate(x)
  }
}

type Calc[T] = Map[String, T] => T

implicit def numericExpr[T: Numeric]: Expr[Calc[T]] = new Expr[Calc[T]] {
  import Numeric.Implicits._

  override def literalInt(value: Int): Calc[T] =
    _ => implicitly[Numeric[T]].fromInt(value)

  override def variable(name: String): Calc[T] =
    variables => variables(name)

  override def times(x: Calc[T], y: Calc[T]): Calc[T] =
    variables => x(variables) * y(variables)

  override def plus(x: Calc[T], y: Calc[T]): Calc[T] =
    variables => x(variables) + y(variables)

  override def negate(x: Calc[T]): Calc[T] =
    variables => -x(variables)
}

final case class Print(s: String, priority: Int, isLit: Boolean = false) {
  def print(outer: Int = 0): String = if (outer <= priority) s else s"($s)"
}

implicit val stringOrderExpr: Expr[Print] = new Expr[Print] {
  override def literalInt(value: Int): Print =
    Print(value.toString, priority = 4, isLit = true)

  override def variable(name: String): Print =
    Print(name.toUpperCase, priority = 5)

  override def times(x: Print, y: Print): Print = {
    val xStr = x.print(3)
    val yStr = y.print(3)
    val separator = if (x.isLit) "" else "*"
    Print(s"$xStr$separator$yStr", priority = 3)
  }

  override def plus(x: Print, y: Print): Print = {
    val xStr = x.print(2)
    val yStr = y.print(2)
    Print(s"$xStr+$yStr", priority = 2)
  }

  override def minus(x: Print, y: Print): Print = {
    val xStr = x.print(2)
    val yStr = y.print(2)
    Print(s"$xStr-$yStr", priority = 2)
  }

  override def negate(x: Print): Print = {
    val xStr = x.print(1)
    Print(s"-$xStr", priority = 1)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    def function[T: Expr]: T = X * X + 2.lit * (Y + Z * X * 2.lit) - 7.lit * Z + 4.lit
    
    val calcResult = function[Calc[Double]].apply(Map("x" -> 1, "y" -> -1, "z" -> 0.2))
    println(s"Calculation result: $calcResult")
    
    val stringRepr = function[Print].print()
    println(s"String representation: $stringRepr")
  }
}
