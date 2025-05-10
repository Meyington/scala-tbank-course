import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    try {
      val k = scala.io.StdIn.readInt()
      val elements = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

      if (k < 1 || k > elements.length) {
        println("Error: k is out of bounds")
      } else {
        val result = kOrder(elements, k)
        println(result)
      }
    } catch {
      case _: NumberFormatException => println("Error: Invalid input format")
      case e: Exception => println(s"Error: ${e.getMessage}")
    }
  }

  def kOrder(list: List[Int], k: Int): Int = {
    require(k >= 1 && k <= list.length, "k must be between 1 and list length")

    val rnd = new Random

    def quickSelect(xs: List[Int], k: Int): Int = {
      val pivot = xs(rnd.nextInt(xs.length))
      val (less, equal, greater) = xs.foldLeft((List.empty[Int], List.empty[Int], List.empty[Int])) {
        case ((l, e, g), x) =>
          if (x < pivot) (x :: l, e, g)
          else if (x > pivot) (l, e, x :: g)
          else (l, x :: e, g)
      }

      if (k <= less.length) quickSelect(less, k)
      else if (k <= less.length + equal.length) pivot
      else quickSelect(greater, k - less.length - equal.length)
    }

    quickSelect(list, k)
  }
}