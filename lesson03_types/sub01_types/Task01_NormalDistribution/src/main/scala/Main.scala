import scala.math.{Pi, exp, sqrt, pow}

object Main {
  def main(args: Array[String]): Unit = {
    val mu: Double = 10.2
    val sigma: Double = 32.3
    val x: Double = 23.1

    def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
      val coefficient = 1 / (sigma * sqrt(2 * Pi))
      val exponent = -pow(x - mu, 2) / (2 * pow(sigma, 2))
      coefficient * exp(exponent)
    }

    println(f"Значение нормального распределения: ${normalDistribution(mu, sigma, x)}%.6f")
  }
}
