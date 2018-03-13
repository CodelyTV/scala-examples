package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral.enumerate_solution

import java.util.UUID

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral.enumerate_solution.FoodCategory.FoodCategory
import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral.{GenericFood, PicoteriaProduct}


sealed abstract class Food(override val id: UUID, val category: FoodCategory)
  extends PicoteriaProduct with GenericFood {

  //  FIXME: I don't have fucking idea of how to access the attribute forcefulness
  //  from the category attribute. HELP!!! 😭
  val forcefulness: Int = 1

  val fatLevel: String = category match {
    case FoodCategory.Furralleros => "Epic"
    case FoodCategory.NotSoFurralleros => "Normal"
    case _ => "Meh"
  }

}

case class DonutFest(override val id: UUID) extends Food(id, category = FoodCategory.Furralleros)

case class Donut(override val id: UUID) extends Food(id, category = FoodCategory.NotSoFurralleros)

case class Salad(override val id: UUID) extends Food(id, category = FoodCategory.JustInCase)

