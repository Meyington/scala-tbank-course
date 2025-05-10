import scala.io.StdIn
import scala.math.BigInt

object Main {
  def main(args: Array[String]): Unit = {
    val n = readLine().toInt
    for (i: BigInt <-BigInt(1) to n-1; j: BigInt <- BigInt(1) to n-1;
         if i.gcd(j) == 1) {println(f"$i $j")
    }
  }
}