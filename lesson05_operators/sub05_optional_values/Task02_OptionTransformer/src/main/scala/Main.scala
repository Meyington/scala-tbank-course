object Main {
  def bar(n: Int): Option[Int] = {
    if (n % 2 == 0) Some(n / 2 + 1) else None
  }

  def transform(x: Option[Int]): Option[Int] = {
    x.flatMap(bar)
  }

  def main(args: Array[String]): Unit = {
    val testCases = List(
      Some(10) -> Some(6),  // 10 / 2 + 1 = 6
      None -> None,
      Some(5) -> None,      // 5 - нечётное, bar возвращает None
      Some(0) -> Some(1)    // 0 / 2 + 1 = 1
    )

    println("Тестирование трансформации Option")
    println("-------------------------------")

    testCases.foreach { case (input, expected) =>
      val result = transform(input)
      println(s"Вход: $input")
      println(s"Ожидаемый результат: $expected")
      println(s"Фактический результат: $result")
      println(s"Тест ${if (result == expected) "пройден" else "не пройден"}")
      println()
    }
  }
}