object Main {
  case class Jar(name: String, value: Int, price: Double)

  val discount: PartialFunction[Jar, String] = {
    case Jar(name, value, price) if value >= 5 && value <= 10 =>
      f"$name ${price * 0.05}%.2f"
    case Jar(name, value, price) if value > 10 =>
      f"$name ${price * 0.10}%.2f"
  }

  def main(args: Array[String]): Unit = {
    val jars = List(
      Jar("Морской синий 6л", 6, 3000.0),
      Jar("Огненно-красный 12л", 12, 5000.0),
      Jar("Зеленый 1л", 1, 500.0),
      Jar("Желтый 8л", 8, 2000.0),
      Jar("Черный 15л", 15, 4500.0)
    )

    println("Банки краски:")
    jars.foreach { jar =>
      println(f"${jar.name}%20s | ${jar.value}%2d л | ${jar.price}%7.2f руб")
    }

    println("\nСкидки:")
    val discounts = jars.collect(discount)
    discounts.foreach(println)

    println("\nИтого скидки:")
    discounts.foreach { d =>
      val parts = d.split(" ")
      val name = parts.init.mkString(" ")
      val discountValue = parts.last.toDouble
      println(f"$name%20s: $discountValue%6.2f руб")
    }
  }
}