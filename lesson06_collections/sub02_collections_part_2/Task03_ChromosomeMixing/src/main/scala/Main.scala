object Main {
  def main(args: Array[String]): Unit = {
    val points: List[Int] = Lesson.points.sorted
    var chr1: List[Char] = Lesson.chr1
    var chr2: List[Char] = Lesson.chr2

    for (point <- points) {
      val (head1, tail1) = chr1.splitAt(point)
      val (head2, tail2) = chr2.splitAt(point)
      chr1 = head1 ++ tail2
      chr2 = head2 ++ tail1
    }

    println(chr1.mkString)
    println(chr2.mkString)
  }
}