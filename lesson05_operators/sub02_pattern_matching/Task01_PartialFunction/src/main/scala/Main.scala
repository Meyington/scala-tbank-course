object Main {
  val log: PartialFunction[Double, Double] = {
    case x if x > 0 => Math.log(x)
  }

  def main(args: Array[String]): Unit = {
    println("Демонстрация работы функции log")

    val numbers = List(1.0, math.E, 10.0, 0.5)
    numbers.foreach { x =>
      println(s"log($x) = ${log(x)}")
    }

    println("\nПроверка для неположительных чисел:")
    List(0.0, -1.0, -math.E).foreach { x =>
      if (log.isDefinedAt(x)) {
        println(s"log($x) = ${log(x)}")
      } else {
        println(s"log($x) не определён")
      }
    }
  }
}