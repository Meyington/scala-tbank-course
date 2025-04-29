object Main {

  def middle[T](data: Iterable[T]): T = {
    val mid = data.slice(data.size / 2, (data.size / 2) + 1).head
    mid
  }

  def main(args: Array[String]): Unit = {
    require(middle("Scala") == 'a')
    require(middle(Seq(1, 7, 5, 9)) == 5)
  }
}
