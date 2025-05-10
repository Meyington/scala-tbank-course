object Main {
  def flatten(options: List[Option[Int]]): List[Int] = {
    options.collect { case Some(x) => x }
  }

  def main(args: Array[String]): Unit = {
    val testCases = List(
      List(Some(1), None, Some(2), Some(3), None) -> List(1, 2, 3),
      List(None, None, None) -> List(),
      List() -> List(),
      List(Some(10), Some(20)) -> List(10, 20),
      List(None, Some(0), None) -> List(0)
    )

    println("Тестирование функции flatten")
    println("-------------------------")

    testCases.foreach { case (input, expected) =>
      val result = flatten(input)

      println(s"Вход: $input")
      println(s"Результат flatten: $result")
      println(s"Ожидаемый результат: $expected")

      println(s"Тест ${if (result) "пройден" else "не пройден"}")
      println()
    }
  }
}