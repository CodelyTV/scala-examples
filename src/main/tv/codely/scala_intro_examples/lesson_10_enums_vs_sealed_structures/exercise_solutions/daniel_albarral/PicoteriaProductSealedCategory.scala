package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.daniel_albarral

import java.util.UUID


trait PicoteriaProduct {
  val id: UUID
}

sealed abstract class Food(override val id: UUID, category: Category)
  extends PicoteriaProduct {

  def getFatLevel: String = category match {
    case Furralleros => "Epic"
    case NotSoFurralleros => "Normal"
    case _ => "Meh"
  }

}

case class DonutFest(override val id: UUID) extends Food(id, category = Furralleros)

case class Donut(override val id: UUID) extends Food(id, category = NotSoFurralleros)

case class Salad(override val id: UUID) extends Food(id, category = JustInCase)
