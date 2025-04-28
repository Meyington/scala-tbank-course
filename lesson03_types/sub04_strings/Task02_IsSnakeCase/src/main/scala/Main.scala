import scala.io.StdIn.readLine

object Main {
  def main(args: Array[String]): Unit = {
    val word: String = readLine()

    def isSnakeCase(word: String): Boolean = {
      word.matches("^[a-z]+(_[a-z]+)*$")
    }

    println(isSnakeCase(word))
  }
}
