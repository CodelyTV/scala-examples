class MyLogger(prefix: String) {

  def printLog(prefix: String)(content: String): Unit = println(s"[$prefix] $content")

  def log(content: String): Unit = printLog(this.prefix)(content)
}

val myLogger = new MyLogger("PBR")

myLogger.log("Este es mi logger!!")

