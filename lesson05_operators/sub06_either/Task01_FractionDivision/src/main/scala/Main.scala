object Main {
  def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
    val (pNum, pDen) = p
    val (qNum, qDen) = q

    def isProper(num: Int, den: Int): Boolean = den != 0 && math.abs(num) < math.abs(den)

    if (!isProper(pNum, pDen) || !isProper(qNum, qDen))
      Left("Invalid input")
    else if (qNum == 0)
      Left("Zero divisor")
    else {
      val num = pNum * qDen
      val den = pDen * qNum

      if (den == 0)
        Left("Zero divisor")
      else {
        val gcd = BigInt(num).gcd(den).toInt
        val simpNum = num / gcd
        val simpDen = den / gcd

        if (math.abs(simpNum) < math.abs(simpDen))
          Right((simpNum, simpDen))
        else
          Left("Improper result")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val testCases = List(
      ((1, 10), (2, 10)) -> Right((1, 2)),
      ((1, 2), (0, 1))    -> Left("Zero divisor"),
      ((3, 2), (1, 2))    -> Left("Improper result"),
      ((1, 0), (1, 2))    -> Left("Invalid input"),
      ((-1, 3), (2, 3))   -> Right((-1, 2)),
      ((2, 5), (3, 5))    -> Right((2, 3))
    )

    println("Тестирование деления дробей")
    println("-------------------------")

    testCases.foreach { case ((p, q), expected) =>
      val result = divide(p)(q)
      println(s"${p._1}/${p._2} ÷ ${q._1}/${q._2} = $result")
      println(s"Ожидаемый результат: $expected")
      println(s"Тест ${if (result == expected) "пройден" else "не пройден"}")
      println()
    }
  }
}