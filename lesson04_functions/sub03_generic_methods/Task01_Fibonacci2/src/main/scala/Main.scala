import scala.annotation.tailrec
import scala.io.StdIn

object Main {
  @tailrec
  def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
    if (n == 0) f1
    else if (n == currentNumber) f2
    else fibs(n, currentNumber + 1, f2, f1 + f2)
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    println(fibs(n))
  }
}
