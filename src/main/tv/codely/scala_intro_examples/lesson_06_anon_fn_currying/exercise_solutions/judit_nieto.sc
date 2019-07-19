// 1a versión

class Logger(prefix:String){

  def printLogger(message: String) = println(s"$prefix - $message")
}


def testingLogger() = {
  var logger = new Logger("MyTest")

  logger.printLogger("Start logging")

  val result = 42

  logger.printLogger(s"La respuesta a todo es $result")
}


testingLogger()


// 2a versión - currying


def functionCurried(head: String)(message: String) = println(s"$head - $message")

def curryPrinter(message: String) = functionCurried("Cabecera ")(message)

curryPrinter("y empezamos!")
