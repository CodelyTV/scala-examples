import java.util.{Calendar, Date}


def clock(calendar: Calendar) = calendar.getTime

def myLogger(clock: => Date)
            (printer: String => Unit)
            (scope: String)
            (level: String)
            (message: String)
: Unit = printer(s"$clock - $scope - $level - $message")

def myAppLogger(level: String)(message: String): Unit =
  myLogger(clock(Calendar.getInstance()))(println)("My App")(level)(message)

val debugLogger = myAppLogger("DEBUG")(_)
val errorLogger = myAppLogger("ERROR")(_)
val infoLogger = myAppLogger("INFO")(_)

debugLogger("Start example")
infoLogger("Login random info")
errorLogger("Some error message at the end")
