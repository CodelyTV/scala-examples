package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral.sealed_solution


sealed abstract class FoodCategory(val caloriesRange: Range,
                                   val forcefulness: Int)

case object Furralleros extends FoodCategory(
  caloriesRange = Range(5000, 10000),
  forcefulness = 90
)

case object NotSoFurralleros extends FoodCategory(
  caloriesRange = Range(1000, 5000),
  forcefulness = 50
)

case object JustInCase extends FoodCategory(
  caloriesRange = Range(0, 1000),
  forcefulness = 0
)
