object Main {

  def service1: Either[String, Double] = Right(42.0)
  def service2(res1: Double): Either[String, Int] = Right((res1 / 2).toInt)
  def service3: String = "processed"
  def service4(res1: Double, res2: Int, res3: String): Either[String, String] =
    Right(s"Result: $res1 processed as $res2 with $res3")

  def result: Either[String, String] = {
    for {
      res1 <- service1
      res2 <- service2(res1)
      res3 = service3
      res4 <- service4(res1, res2, res3)
    } yield res4
  }

  def main(args: Array[String]): Unit = {
    result match {
      case Right(value) => println(s"Success: $value")
      case Left(error) => println(s"Error: $error")
    }
  }
}