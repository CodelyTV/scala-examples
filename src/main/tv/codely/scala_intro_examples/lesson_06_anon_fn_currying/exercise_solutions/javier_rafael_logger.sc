def log(name: String)(text: String) : Unit = println(name + ": " + text)
def log4Javi(text: String) : Unit = log("Javi is logging")(text)

log4Javi("Long live the Queen!!!")
