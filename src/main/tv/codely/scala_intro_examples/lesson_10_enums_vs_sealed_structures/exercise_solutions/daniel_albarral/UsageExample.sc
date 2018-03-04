/**
  * This doesn't work with IntelIJ WS for reasons that
  * I don't understand.
  * --> Run it in a repel ! <--
  * If some one have some idea of what's happening
  * any help is welcome.
  */

import java.util.UUID

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral._

def printerExample(hint: String,
                   orders: Seq[GenericFood]): Unit = {
  println("################")
  println(s"#####$hint#####")
  println("################")
  println("* Original data set")
  println(orders)
  println("* FatLevel with the order of the original")
  println(orders map (_.getFatLevel))
  println("* Data set ordered by forcefulness of the orders")
  println(orders sorted)
  println("* FatLevel with the order of the sorted")
  println((orders sorted) map (_.getFatLevel))
}

val sealedFood = Seq[sealed_solution.Food](
  sealed_solution.DonutFest(UUID.randomUUID()),
  sealed_solution.Salad(UUID.randomUUID()),
  sealed_solution.Donut(UUID.randomUUID())
)

val enumFood = Seq(
  enumerate_solution.DonutFest(UUID.randomUUID()),
  enumerate_solution.Salad(UUID.randomUUID()),
  enumerate_solution.Donut(UUID.randomUUID())
)

printerExample("Sealed", sealedFood)
printerExample("Enum", enumFood)
