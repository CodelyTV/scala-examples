package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.jordi_puig

object EatableThingsEnumType extends Enumeration {
  type EatableThingsType = Value
  private val poisoningThreshold = 7000

  protected case class Val(minCalories: Int, maxCalories: Int, minHeartyLevel: Int) extends super.Val {
    val isPoisoning: Boolean = this.maxCalories > EatableThingsEnumType.poisoningThreshold
  }

  val Furralleros = Val(minCalories = 5000, maxCalories = 10000, minHeartyLevel = 90)
  val NotSoFurralleros = Val(minCalories = 1000, maxCalories = 5000, minHeartyLevel = 50)
  val JustInCase = Val(minCalories = 0, maxCalories = 1000, minHeartyLevel = 0)

  def isPoisoning2(eatableThingsEnumType: EatableThingsEnumType.Val): Boolean = eatableThingsEnumType.maxCalories > poisoningThreshold
}
