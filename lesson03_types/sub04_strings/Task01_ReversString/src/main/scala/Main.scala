import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]): Unit = {
    val Array(startIndex, endIndex) = readLine().split(" ").map(_.toInt)
    val word: String = readLine()
    println(word.take(startIndex) + word.slice(startIndex, endIndex + 1).reverse + word.drop(endIndex + 1))
  }
}