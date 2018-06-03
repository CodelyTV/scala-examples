trait Logger[A] {
  def log(a: A)
}

class SimpleLogger extends Logger[String] {
  override def log(text: String): Unit = println(s"SimpleLogger logs: $text")
}

class ComplexLogger extends Logger[Any] {
  override def log(text: Any): Unit = println(s"ComplexLogger logs: ${text.toString}")
}

val simpleLogger = new SimpleLogger()
simpleLogger.log("This works great")

val complexLogger = new ComplexLogger()
complexLogger.log(complexLogger)

