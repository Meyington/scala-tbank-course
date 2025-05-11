class Person(val name: String)

class Student(name: String, val course: Int) extends Person(name)

class Pair[+T](val first: T, val second: T) {
  def replaceFirst[R >: T](newValue: R): Pair[R] = new Pair(newValue, second)
}

def printNames(pair: Pair[Person]): Unit = {
  println("1: " + pair.first.name + "  2: " + pair.second.name)
}

object Main {
  def main(args: Array[String]): Unit = {
    val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
    printNames(pair.replaceFirst(new Person("Oliver")))
  }
}