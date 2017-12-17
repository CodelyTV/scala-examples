//Logger

def log(prefix: String)(level: String, value: String): Unit = println("[" + prefix + "]" + level + value)

def my_log(level: String, message: String): Unit = log("MISOLUCION")(level, message)

def debug = (message: String) => my_log("[DEBUG]", message)
def info = (message: String) => my_log("[INFO]", message)
def warn = (message: String) => my_log("[WARNING]", message)
def error = (message: String) => my_log("[ERROR]", message)

debug("I'm a debug message")
info("I'm an info message")
warn("I'm a warn message")
error("I'm an error message")
