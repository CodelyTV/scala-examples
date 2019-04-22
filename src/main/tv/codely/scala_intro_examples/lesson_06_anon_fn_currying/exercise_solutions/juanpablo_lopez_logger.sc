import java.time

time.Instant.now()

def loggerBase(user:String)(process:String)(level:String)(message:String):Unit =
  println(s"${time.Instant.now()} - $user - $process - $level - $message")


def loggerProcess(level:String)(message:String):Unit =
  loggerBase("juanpa")("myProcess")(level)(message)

def loggerDebug(message:String):Unit =
  loggerProcess("[DEBUG]")(message)

def loggerInfo(message:String):Unit =
  loggerProcess("[INFO]")(message)

def loggerWarning(message:String):Unit =
  loggerProcess("[WARNING]")(message)

def loggerError(message:String):Unit =
  loggerProcess("[ERROR]")(message)

def loggerCritical(message:String):Unit =
  loggerProcess("[CRITICAL]")(message)


loggerDebug("This is a debug message")
loggerInfo("This is an info message")
loggerWarning("This is a warning message")
loggerError("This is a error message")
loggerCritical("This is a critical message")

