sealed class FoodMadeInPicoteria(
  val minCalories: Int,
  val maxCalories: Int,
  val minContundencia: Int) {

  def clientState(): String = {
    if (calculateClientHappiness() > 0)
    "feliz"
    else
    "infeliz"
  }

  private def calculateClientHappiness() : Int =
  (maxCalories - minCalories) * minContundencia

}

case object Furralleros extends FoodMadeInPicoteria(
  minCalories = 5000,
  maxCalories = 10000,
  minContundencia = 90
)

case object NotSoFurralleros extends FoodMadeInPicoteria(
  minCalories = 1000,
  maxCalories = 5000,
  minContundencia = 50
)

case object JustInCase extends FoodMadeInPicoteria(
  minCalories = 0,
  maxCalories = 1000,
  minContundencia = 0
)

def clientIsHappy(foodMadeInPicoteria: FoodMadeInPicoteria): Unit = foodMadeInPicoteria match {
  case Furralleros      => println(s"gordo pero ${foodMadeInPicoteria.clientState()}")
  case NotSoFurralleros => println(s"medio gordo pero ${foodMadeInPicoteria.clientState()}")
  case JustInCase       => println(s"flaco pero ${foodMadeInPicoteria.clientState()}")
}

clientIsHappy(Furralleros)
clientIsHappy(NotSoFurralleros)
clientIsHappy(JustInCase)
