object Main {
  def swap3(tuple: (Int, Int, Int)): (Int, Int, Int) = tuple match {
    case (x, y, z) => (z, y, x)
  }

  def main(args: Array[String]): Unit = {
    val testCases = List(
      (1, 2, 3) -> (3, 2, 1),
      (10, 20, 30) -> (30, 20, 10),
      (-1, 0, 1) -> (1, 0, -1),
      (100, 200, 300) -> (300, 200, 100)
    )

    println("Тестирование функции swap3")
    println("-----------------------")

    testCases.foreach { case (input, expected) =>
      val result = swap3(input)
      println(s"Вход: $input")
      println(s"Ожидаемый результат: $expected")
      println(s"Фактический результат: $result")
      println(s"Тест ${if (result == expected) "пройден" else "не пройден"}")
      println()
    }
  }
}