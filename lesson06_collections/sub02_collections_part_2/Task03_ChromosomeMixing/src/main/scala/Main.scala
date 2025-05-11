object Lesson {
  def points1: List[Int] = List(1, 3)
  def chr1_1: List[Char] = "xxxxx".toList
  def chr2_1: List[Char] = "yyyyy".toList

  def points2: List[Int] = List(2, 4, 5)
  def chr1_2: List[Char] = "aaaaaaa".toList
  def chr2_2: List[Char] = "ddddddd".toList
}

object Main {
  def performCrossover(points: List[Int], chr1: List[Char], chr2: List[Char]): (List[Char], List[Char]) = {
    val sortedPoints = points.sorted
    var c1 = chr1
    var c2 = chr2

    for (point <- sortedPoints) {
      val (head1, tail1) = c1.splitAt(point)
      val (head2, tail2) = c2.splitAt(point)
      c1 = head1 ++ tail2
      c2 = head2 ++ tail1
    }

    (c1, c2)
  }

  def main(args: Array[String]): Unit = {
    val (res1_1, res1_2) = performCrossover(Lesson.points1, Lesson.chr1_1, Lesson.chr2_1)
    println("Test 1:")
    println(res1_1.mkString)  // должно быть "xyyxx"
    println(res1_2.mkString)  // должно быть "yxxyy"
    println()

    val (res2_1, res2_2) = performCrossover(Lesson.points2, Lesson.chr1_2, Lesson.chr2_2)
    println("Test 2:")
    println(res2_1.mkString)  // должно быть "aaddadd"
    println(res2_2.mkString)  // должно быть "ddaadaa"
  }
}