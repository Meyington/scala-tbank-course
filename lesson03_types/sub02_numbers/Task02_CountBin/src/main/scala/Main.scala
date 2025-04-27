import scala.io.StdIn.readInt

object Main {
  def main(args: Array[String]): Unit = {
    val number: Int = readInt()

    def countBin(num: Int): Int = {
      val binary = num.toBinaryString
      var res: Int = 0
      for (letter <- binary) {
        if (letter == '1') {
          res += 1
        }
      }
      res
    }

    println(countBin(number))
  }
}