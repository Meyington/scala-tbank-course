import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode.HALF_UP

object Main {
  def main(args: Array[String]): Unit = {
    val weight: BigDecimal = BigDecimal(90.0)
    val potatoWaterRatio: BigDecimal = BigDecimal(0.9)
    val crispsWaterRatio: BigDecimal = BigDecimal(0.1)

    def crispsWeight(weight: BigDecimal, potatoWaterRatio: BigDecimal, crispsWaterRatio: BigDecimal): BigDecimal = {
      (weight * (BigDecimal(1) - potatoWaterRatio) / (BigDecimal(1) - crispsWaterRatio)).setScale(5, HALF_UP)
    }

    val result = crispsWeight(weight, potatoWaterRatio, crispsWaterRatio)
    println(result)
  }
}