class Waiter(val name: String, private var order: List[String] = Nil) {
  println(s"My name $name")
  
  def giveMe(dish: String): Waiter = {
    order = order :+ dish
    this
  }
  
  def complete(): List[String] = order
  
  def completeFormatted(): String = {
    s"Order: ${order.mkString(",")}"
  }
}

object Main extends App {
  val waiter = new Waiter("иван")
  val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()
  println(s"Order: ${positions.mkString(",")}")

  val positions2 = new Waiter("петр")
    .giveMe("салат")
    .giveMe("суп")
    .completeFormatted()
  println(positions2)
}