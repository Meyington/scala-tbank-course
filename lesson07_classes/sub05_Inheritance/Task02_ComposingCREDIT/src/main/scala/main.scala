trait AbstractBank {
  def a: Char
  def b: Char
  def c: Char
  def d: Char
  def e: Char
  def f: Char
  def issueCredit: Unit
}

trait BankA extends AbstractBank {
  override val b: Char = 'T'
  override val d: Char = 'R'
  override val f: Char = 'I'
}

trait BankB extends AbstractBank {
  override val a: Char = 'E'
  override val f: Char = 'D'
}

trait BankC extends AbstractBank {
  override val b: Char = 'C'
  override val d: Char = 'D'
}

trait BankD extends AbstractBank {
  override val b: Char = 'C'
  override val c: Char = 'R'
  override val d: Char = 'E'
}

trait BankE extends AbstractBank {
  override val b: Char = 'C'
  override val a: Char = 'I'
  override val e: Char = 'T'
}

class CreditBank extends BankA with BankB with BankC with BankD with BankE {
  override def issueCredit: Unit = {
    println(s"$b$c$d$f$a$e")
  }
}

object Main extends App {
  val bank = new CreditBank
  bank.issueCredit
}