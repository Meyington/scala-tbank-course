object Main {
  def main(args: Array[String]): Unit = {
    val numbers = Stream
      .continually(scala.io.StdIn.readLine())
      .takeWhile(_ != "END")
      .map(_.toInt)
      .toList

    val result = numbers
      .zipWithIndex
      .collect { case (value, idx) if idx % 2 == 1 => value * 2 }
      .sum

    println(result)
  }
}