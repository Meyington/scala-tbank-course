object Main {
  def main(args: Array[String]): Unit = {
    val tokenDeleter = new TokenDeleter()
    val toLowerConvertor = new ToLowerConvertor()
    val shortener = new Shortener()

    val sampleInput = "This is a Wonderful Test!"

    val step1 = tokenDeleter.process(sampleInput)
    val step2 = toLowerConvertor.process(step1)
    val step3 = shortener.process(step2)

    println(step3)
    
    println("\nДругие примеры:")

    val testString = "HELLO, World: Test; LONG String That Needs Processing"
    println("Оригинал: " + testString)
    println("Без знаков препинания: " + tokenDeleter.process(testString))
    println("В нижнем регистре: " + toLowerConvertor.process(testString))
    println("Укороченный: " + shortener.process(testString))

    val processed = toLowerConvertor.process(shortener.process(tokenDeleter.process(testString)))
    println("\nРезультат полной обработки: " + processed)
  }
}

trait StringProcessor {
  def process(input: String): String
}

class TokenDeleter extends StringProcessor {
  override def process(input: String): String = input.replaceAll("[,:;]", "")
}

class ToLowerConvertor extends StringProcessor {
  override def process(input: String): String = input.toLowerCase
}

class Shortener extends StringProcessor {
  override def process(input: String): String =
    if (input.length > 20) s"${input.take(20)}..." else input
}