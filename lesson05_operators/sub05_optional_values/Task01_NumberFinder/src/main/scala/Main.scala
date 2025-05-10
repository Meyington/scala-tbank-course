object Main {
  def foo(list: List[Int]): Int = {
    list.find(x => x % 3 == 0).map(_ * 2).getOrElse(0)
  }

  def main(args: Array[String]): Unit = {
    val testCases = List(
      List(1, 2, 3, 4, 5, 6) -> 6,
      List(1, 4, 5, 7) -> 0,
      List(6, 9, 12) -> 12,
      List(-3, 0, 3) -> -6,
      List() -> 0
    )

    println("Тестирование функции foo")
    println("-----------------------")

    testCases.foreach { case (input, expected) =>
      val result = foo(input)
      println(s"Вход: ${input.mkString("[", ", ", "]")}")
      println(s"Ожидаемый результат: $expected")
      println(s"Фактический результат: $result")
      println(s"Тест ${if (result == expected) "пройден" else "не пройден"}")
      println()
    }
  }
}