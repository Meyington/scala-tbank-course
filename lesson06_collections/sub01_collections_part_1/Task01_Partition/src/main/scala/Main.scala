object Main {
  def main(args: Array[String]): Unit = {
    val input = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
    val (zeros, ones) = input.partition(_ == 0)
    println(zeros.mkString(","))
    println(ones.mkString(","))
  }
}