class A(val value: String)

case class B(override val value: String) extends A(value)

object FunctionPrint {
  def apply[T <: A](prefix: String): FunctionPrint[T] = new FunctionPrint[T](prefix)
}

class FunctionPrint[-T <: A](prefix: String) {
  def apply(t: T): Unit = println(prefix + " " + t.value)
}

object Main {
  def main(args: Array[String]): Unit = {
    val objB = B("It is a B.value")
    val objA = new A("It is a A.value")

    val printA = FunctionPrint[A]("A-value:")
    val printB = FunctionPrint[B]("B-value:")

    def methodPrint(f: FunctionPrint[B], obj: B): Unit = {
      f(obj)
    }

    // Тестовые вызовы
    methodPrint(printB, objB)  // Выведет: B-value: It is a B.value
    methodPrint(printA, objB)  // Выведет: A-value: It is a B.value
  }
}