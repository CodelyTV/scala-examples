object FoodMadeInPicoteria extends Enumeration {

  type FoodMadeInPicoteria = Value

  case class Val(minCalories: Int,
                            maxCalories: Int,
                            minContundencia: Int) extends super.Val {

    def clientState(): String = {
      if (calculateClientHappiness() > 0)
        "feliz"
      else
        "infeliz"
    }

    private def calculateClientHappiness() : Int =
      (maxCalories - minCalories) * minContundencia
  }

  val Furralleros = Val(minCalories = 5000,
                         maxCalories = 10000,
                         minContundencia = 90)

  val NotSoFurralleros = Val(minCalories = 1000,
                              maxCalories = 50000,
                              minContundencia = 50)

  val JustInCase = Val(minCalories = 0,
                        maxCalories = 1000,
                        minContundencia = 0)

}


def clientIsHappy(foodMadeInPicoteria: FoodMadeInPicoteria.Val): Unit = foodMadeInPicoteria match {
  case FoodMadeInPicoteria.Furralleros      => println(s"gordo pero ${foodMadeInPicoteria.clientState()}")
  case FoodMadeInPicoteria.NotSoFurralleros => println(s"medio gordo pero ${foodMadeInPicoteria.clientState()}")
  case FoodMadeInPicoteria.JustInCase       => println(s"flaco pero ${foodMadeInPicoteria.clientState()}")
}

clientIsHappy(FoodMadeInPicoteria.Furralleros)
clientIsHappy(FoodMadeInPicoteria.NotSoFurralleros)
clientIsHappy(FoodMadeInPicoteria.JustInCase)
