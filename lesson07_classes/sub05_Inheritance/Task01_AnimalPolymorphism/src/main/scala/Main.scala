trait Animal {
  val sound: String
  def voice: Unit = println(s"voice: $sound")
}

class Cat extends Animal {
  override val sound: String = "Meow!"
}

class Dog extends Animal {
  override val sound: String = "Woof!"
}

class Fish extends Animal {
  override val sound: String = ""
  override def voice: Unit = println("Fishes are silent!")
}

object Main extends App {
  val animals: Seq[Animal] = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice)
}