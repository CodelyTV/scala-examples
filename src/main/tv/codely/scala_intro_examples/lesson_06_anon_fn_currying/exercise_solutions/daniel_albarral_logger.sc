import com.github.nscala_time.time.Imports._


def myLogger(clock: => DateTime)
            (printer: String => Unit)
            (scope: String)
            (level: String)
            (message: String)
: Unit = printer(s"$clock - $scope - $level - $message")

def myAppLogger(level: String)(message: String): Unit =
  myLogger(DateTime.now)(println)("My App")(level)(message)

val debugLogger = myAppLogger("DEBUG")(_)
val errorLogger = myAppLogger("ERROR")(_)
val infoLogger = myAppLogger("INFO")(_)

debugLogger("Start example")
infoLogger("Login random info")
errorLogger("Some error message at the end")
