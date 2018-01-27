//Logger

def logWithPrefix(prefix: String)(level: String)(message: String): Unit = println(s"[$prefix] $level $message")

def mySolutionLog(level: String)(message: String): Unit = logWithPrefix("MY_SOLUTION")(level)(message)

def debug(message: String): Unit = mySolutionLog(level = "[DEBUG]")(message)
def info(message: String): Unit = mySolutionLog(level = "[INFO]")(message)
def warn(message: String): Unit = mySolutionLog(level = "[WARNING]")(message)
def error(message: String): Unit = mySolutionLog(level = "[ERROR]")(message)

debug("I'm a debug message")
info("I'm an info message")
warn("I'm a warn message")
error("I'm an error message")
