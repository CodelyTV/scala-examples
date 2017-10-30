def print(
  value: String,
  printer: String => Unit
): Unit = printer(value)


def printlnPrinter(value: String): Unit = println(value)
val printlnPrinterVal = (value: String) => println(value)

print("Javi es el peor", printlnPrinter)
print("Javi es el peor", printlnPrinterVal)
print("Javi es el peor", (value: String) => println(value))

def sum(a: Int)(b: Int): Int = a + b

def add1(b: Int) = sum(1)(b)
def add2(b: Int) = sum(2)(b)
def add3(b: Int) = sum(3)(b)

val add4 = sum(4)(_)

add2(5)
add4(6)

def printZurra(printer: String => Unit)(value: String): Unit = printer(value)

def printStd(value: String): Unit = printZurra(printlnPrinter)(value)

printStd("De nada")




