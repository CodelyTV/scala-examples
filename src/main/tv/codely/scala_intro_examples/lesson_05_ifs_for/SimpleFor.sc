val lele = if ("Codely mola".isInstanceOf[String]) 3 else 7

var total = 0
for (value <- 1 to 10) {
  total = total + value
  println(value)
}

(1 to 10).foreach(value2 => {
  println(value2)
})

(1 to 10).foreach(println(_))

(1 to 10).foreach(println)

(1 to 10) foreach println

(1 to 10).sum
