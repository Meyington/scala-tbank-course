object Config {
  val name = "Hello, "
}

import Config.{name => prefix}

object Main {
  def greeting(name: String): Unit = {
    println(prefix + name)
  }

  def main(args: Array[String]): Unit = {
    val name = "Oleg"
    greeting(name)
  }
}