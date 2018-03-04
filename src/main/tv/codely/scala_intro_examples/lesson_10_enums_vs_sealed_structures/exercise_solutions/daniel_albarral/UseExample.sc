import java.util.UUID

/**
  * Sealed Example
  */

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral._

val food = Seq(
  DonutFest(UUID.randomUUID()),
  Salad(UUID.randomUUID()),
  Donut(UUID.randomUUID())
)

food map (x => x.getFatLevel)
