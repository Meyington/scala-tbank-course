case class Pair[T <% Ordered[T]](first: T, second: T) {
  def smaller: T = if (first < second) first else second
}

object Main extends App {
  val intPair = Pair(8, 11)
  println(intPair.smaller)

  val stringPair = Pair("apple", "banana")
  println(stringPair.smaller)

  require(Pair(8, 11).smaller == 8)
  require(Pair("z", "a").smaller == "a")
  require(Pair(BigInt(100), BigInt(50)).smaller == BigInt(50))
}