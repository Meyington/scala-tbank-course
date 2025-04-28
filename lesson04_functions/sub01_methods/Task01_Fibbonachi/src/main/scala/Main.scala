import scala.io.StdIn.readLine
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) : Unit = {
    val number: Int = readLine().toInt

    def fibs(n: Int): Int = {
      @tailrec
      def loop(n: Int, a: Int, b: Int): Int = {
        if (n == 0) a
        else loop(n - 1, b, a + b)
      }
      loop(n, 0, 1)
    }

    println(fibs(number))
  }
}
