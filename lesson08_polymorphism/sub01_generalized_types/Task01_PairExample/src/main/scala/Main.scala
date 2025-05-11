case class ImmutablePair[T, S](first: T, second: S) {
  def swap: ImmutablePair[S, T] = ImmutablePair(second, first)
}

object Main extends App {
  val nameAndAge = ImmutablePair("Oleg", 30)
  val ageAndName = nameAndAge.swap

  println(s"Original: $nameAndAge")
  println(s"Swapped: $ageAndName")

  require(ageAndName.first == 30)
  require(ageAndName.second == "Oleg")
}