object Main {
  case class Pet(name: String, says: String)

  def determinePetKind(pet: Pet): String = pet match {
    case Pet(_, "meow" | "nya") => "cat"
    case Pet("Rex", _) => "dog"
    case Pet(_, says) if says.contains('0') || says.contains('1') => "robot"
    case _ => "unknown"
  }

  def main(args: Array[String]): Unit = {
    val testPets = List(
      Pet("Whiskers", "meow") -> "cat",
      Pet("Mittens", "nya") -> "cat",
      Pet("Rex", "woof") -> "dog",
      Pet("Beeper", "b1010") -> "robot",
      Pet("Fluffy", "purr") -> "unknown",
      Pet("Rex", "meow") -> "unknown"
    )
  }
}