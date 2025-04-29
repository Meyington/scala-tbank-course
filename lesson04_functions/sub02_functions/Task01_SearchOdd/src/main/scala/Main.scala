object LessonData {
  def searchInArray(cond: Int => Boolean, array: List[Int]): List[Int] = {
    array.filter(cond)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val searchOdd: List[Int] => List[Int] = (list: List[Int]) => LessonData.searchInArray(_ % 2 == 1, list)

    println(searchOdd(List(8, 11, 12)))
  }
}