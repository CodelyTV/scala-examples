package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral.enumerate_solution

object FoodCategory extends Enumeration {

  type FoodCategory = Value

  protected case class Val(caloriesRange: Range,
                           forcefulness: Int) extends super.Val

  val Furralleros = Val(
    caloriesRange = Range(5000, 10000),
    forcefulness = 90
  )
  val NotSoFurralleros = Val(
    caloriesRange = Range(1000, 5000),
    forcefulness = 50
  )
  val JustInCase = Val(
    caloriesRange = Range(0, 1000),
    forcefulness = 0
  )

}
