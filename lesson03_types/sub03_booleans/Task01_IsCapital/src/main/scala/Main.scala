import scala.io.StdIn.{readLine, readInt}

object Main {
  def main(args: Array[String]): Unit = {
    val word: String = readLine()
    val pos: Int = readInt()

    def isCapital(word: String, pos: Int): Boolean = {
      if (pos >= 0 && pos < word.length) {
        val char = word.charAt(pos)
        char >= 'A' && char <= 'Z'
      } else {
        false
      }
    }

    println(isCapital(word, pos))
  }
}