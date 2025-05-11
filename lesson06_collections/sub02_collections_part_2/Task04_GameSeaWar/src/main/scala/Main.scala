object Naval {
  type Point = (Int, Int)
  type Field = Vector[Vector[Boolean]]
  type Ship = List[Point]
  type Fleet = Map[String, Ship]
  type Game = (Field, Fleet)
}

object Lesson {
  val field: Naval.Field = Vector.fill(10)(Vector.fill(10)(false))
}

object Main extends App {
  import Naval._

  def checkIsVertical(ship: Ship, isVertical: Boolean = true): Boolean = {
    if (ship.isEmpty) false
    else {
      val firstX = ship.head._1
      val firstY = ship.head._2
      if (isVertical) ship.forall(_._1 == firstX)
      else ship.forall(_._2 == firstY)
    }
  }

  def isVertical: PartialFunction[Ship, Boolean] = {
    case ship if ship.nonEmpty => ship.map(_._1).distinct.size == 1
  }

  def shipArea(ship: Ship): List[Point] = {
    ship.flatMap { case (x, y) =>
      for {
        dx <- -1 to 1
        dy <- -1 to 1
        nx = x + dx
        ny = y + dy
        if nx >= 0 && nx < 10 && ny >= 0 && ny < 10
      } yield (nx, ny)
    }.distinct
  }

  def isInField(point: Point, field: Field): Boolean = {
    val (x, y) = point
    x >= 0 && x < field.size && y >= 0 && y < field.head.size
  }

  def validateShip(ship: Ship): Boolean = {
    ship.nonEmpty &&
      ship.length <= 4 &&
      (checkIsVertical(ship) || checkIsVertical(ship, isVertical = false))
  }

  def validatePosition(ship: Ship, field: Field): Boolean = {
    ship.forall(isInField(_, field)) &&
      shipArea(ship).forall { case (x, y) => !field(x)(y) }
  }

  def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
    fleet + (name -> ship)
  }

  def markUsedCells(field: Field, ship: Ship): Field = {
    ship.foldLeft(field) { (currentField, point) =>
      val (x, y) = point
      currentField.updated(x, currentField(x).updated(y, true))
    }
  }

  def tryAddShip(game: Game, name: String, ship: Ship): Game = {
    val (field, fleet) = game
    if (validateShip(ship) && validatePosition(ship, field)) {
      val newFleet = enrichFleet(fleet, name, ship)
      val newField = markUsedCells(field, ship)
      (newField, newFleet)
    } else {
      game
    }
  }

  val zeroGame: Game = (Lesson.field, Map())

  val g1 = tryAddShip(zeroGame, "MillenniumFalcon", List((2, 5), (3, 5), (4, 5), (5, 5)))
  assert(
    g1 == (
      Vector(
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false)
      ),
      Map("MillenniumFalcon" -> List((2, 5), (3, 5), (4, 5), (5, 5)))
    )
  )

  val g2 = tryAddShip(g1, "Varyag", List((9, 9)))
  assert(
    g2 == (
      Vector(
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, true, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, false),
        Vector(false, false, false, false, false, false, false, false, false, true)
      ),
      Map(
        "MillenniumFalcon" -> List((2, 5), (3, 5), (4, 5), (5, 5)),
        "Varyag" -> List((9, 9))
      )
    )
  )

  println("Все тесты прошли успешно!")
}