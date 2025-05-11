trait Vect extends Any {
  type Item
  def length: Int
  def get(index: Int): Item
  def set(index: Int, item: Item): Vect.Aux[Item]
}

object Vect {
  type Aux[I] = Vect { type Item = I }
}

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length = 64
  def get(index: Int): Boolean = (values & (1L << index)) != 0L
  def set(index: Int, item: Boolean): Vect.Aux[Boolean] =
    if (item) BoolVect64(values | (1L << index))
    else BoolVect64(values & ~(1L << index))
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length = 8
  def get(index: Int): Boolean = ((values & 0xFF) & (1 << index)) != 0
  def set(index: Int, item: Boolean): Vect.Aux[Boolean] = {
    val mask = 1 << index
    val newValue = if (item) (values | mask).toByte else (values & ~mask).toByte
    BoolVect8(newValue)
  }
}

def toList(vect: Vect): List[vect.Item] =
  List.tabulate(vect.length)(vect.get)

object Main {
  def main(args: Array[String]): Unit = {
    println("Testing BoolVect8:")
    val v8 = BoolVect8(1)
    println(v8.toList)

    println("\nTesting BoolVect64:")
    val v64 = BoolVect64(1L << 10)
    println(v64.get(10))
    println(v64.set(10, false).get(10))
  }
}