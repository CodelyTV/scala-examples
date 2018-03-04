package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral

sealed abstract class Category(caloriesRange: Range,
                               forcefulness: Int)

case object Furralleros extends Category(
  caloriesRange = Range(5000, 10000),
  forcefulness = 90
)

case object NotSoFurralleros extends Category(
  caloriesRange = Range(1000, 5000),
  forcefulness = 50
)

case object JustInCase extends Category(
  caloriesRange = Range(0, 1000),
  forcefulness = 0
)
