class Point(val x: Double, val y: Double, val z: Double)

object Point {
  def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)

  def average(points: List[Point]): Point = points match {
    case Nil => Point(0, 0, 0)
    case _ =>
      val size = points.size.toDouble
      val (sumX, sumY, sumZ) = points.foldLeft((0.0, 0.0, 0.0)) {
        case ((accX, accY, accZ), point) =>
          (accX + point.x, accY + point.y, accZ + point.z)
      }
      Point(sumX / size, sumY / size, sumZ / size)
  }

  def show(point: Point): String = f"${point.x}%.1f ${point.y}%.1f ${point.z}%.1f"

  def show(point: Point, precision: Int): String = {
    val format = s"%.${precision}f"
    s"${format.format(point.x)} ${format.format(point.y)} ${format.format(point.z)}"
  }
}

object Main extends App {
  val points1 = List(Point(1, 2.5, 4), Point(4, 3.5, 6))
  println(Point.show(Point.average(points1)))

  val points2 = List(Point(1, 2, 3), Point(4, 5, 6), Point(7, 8, 9))
  println(Point.show(Point.average(points2)))

  println(Point.show(Point.average(Nil)))
}