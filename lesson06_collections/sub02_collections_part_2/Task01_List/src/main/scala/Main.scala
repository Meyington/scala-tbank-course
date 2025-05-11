object Main {
  def main(args: Array[String]): Unit = {
    val list = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)

    list
      .takeWhile(_ < 100)
      .filter(_ % 4 == 0)
      .map(_ / 4)
      .dropRight(1)
      .foreach(println)
  }
}