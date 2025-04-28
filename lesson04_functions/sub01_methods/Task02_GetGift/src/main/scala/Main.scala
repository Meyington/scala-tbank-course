import scala.io.StdIn

object Main extends App {

  val getGift = () => {
    println("The gift is received")
    StdIn.readLine().toInt
  }

  def sendGift(currentAmount: Int, gift: => Int): Int = {
    if (currentAmount >= 500)
      currentAmount + gift
    else
      currentAmount
  }

  val accountAmounts = List(100, 200, 500, 300, 700)

  val newAmounts = accountAmounts.map(amount => sendGift(amount, getGift()))
  println(newAmounts)
}
