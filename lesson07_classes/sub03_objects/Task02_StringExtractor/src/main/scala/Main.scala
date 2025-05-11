object FacedString {
  def apply(input: String): String = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = {
    val prefix = "*_*"
    val suffix = "*_*"

    if (arg.startsWith(prefix) && arg.endsWith(suffix) && arg.length > prefix.length + suffix.length) {
      Some(arg.drop(prefix.length).dropRight(suffix.length))
    } else {
      None
    }
  }
}

object Main extends App {
  import scala.io.StdIn

  val input = StdIn.readLine()

  input match {
    case FacedString(original) => println(original)
    case _ => println("Could not recognize string")
  }

  def testFacedString(str: String): Unit = str match {
    case FacedString(inner) => println(s"Recognized: '$inner'")
    case _ => println(s"Not recognized: '$str'")
  }

  println("\nTest cases:")
  testFacedString("*_*hello*_*")      // Recognized: 'hello'
  testFacedString("*_*test*_*")       // Recognized: 'test'
  testFacedString("*_*only prefix")   // Not recognized
  testFacedString("only suffix*_*")   // Not recognized
  testFacedString("*_*")              // Not recognized (edge case)
  testFacedString("plain string")     // Not recognized
}