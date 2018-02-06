package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.jordi_puig

object EatableThingsSealedType {
  val poisoningThreshold = 7000
  def unapply(arg: EatableThingsSealedType): Option[(Int, Int, Int)] =
    Some((arg.minCalories, arg.maxCalories, arg.minHeartyLevel))
}

sealed abstract class EatableThingsSealedType(
                                            val minCalories: Int,
                                            val maxCalories: Int,
                                            val minHeartyLevel: Int,
                                            val hasChocolate: Boolean = false
                                          ) extends Ordered[EatableThingsSealedType] {
  override def compare(that: EatableThingsSealedType): Int = this.minHeartyLevel - that.minHeartyLevel
  def isPoisoning: Boolean = this.maxCalories > EatableThingsSealedType.poisoningThreshold
}

case object Furralleros extends EatableThingsSealedType(minCalories = 5000, maxCalories = 10000, minHeartyLevel = 90)

case object NotSoFurralleros extends EatableThingsSealedType(minCalories = 1000, maxCalories = 5000, minHeartyLevel = 50)

final case class JustInCase(override val hasChocolate: Boolean) extends EatableThingsSealedType(minCalories = 0, maxCalories = 1000, minHeartyLevel = 0)

