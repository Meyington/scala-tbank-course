import scala.util.matching.Regex

object UserInfoExtractor {
  def main(args: Array[String]): Unit = {
    val input1 = List("oleg", "oleg@email.com", "7bdaf0a1be3", "a8af118b1a2")
    val input2 = List("oleg oleg@email.com", "7bdaf0a1be3", "28d74b7a3fe")
    val input3 = List("invalid-data", "wrong@format")

    println(extractUserInfo(input1))
    println(extractUserInfo(input2))
    println(extractUserInfo(input3))
  }

  def extractUserInfo(input: List[String]): String = {
    val NamePattern: Regex = "([a-zA-Z]+)".r
    val EmailPattern: Regex = "(\\w+)@(\\w+\\.\\w+)".r
    val CombinedPattern: Regex = "([a-zA-Z]+) (\\w+@\\w+\\.\\w+)".r

    input match {
      case Nil => "invalid"
      case NamePattern(name) :: EmailPattern(_, domain) :: _ =>
        s"$name $domain"
      case CombinedPattern(name, email) :: _ =>
        email.split("@") match {
          case Array(_, domain) => s"$name $domain"
          case _ => "invalid"
        }
      case _ => "invalid"
    }
  }
}