package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.joan_miralles

object IngestibleEnumType extends Enumeration {
  type IngestibleType = Value

  protected case class Val(minCalories: Int, maxCalories: Int, minimumContundence: Int) extends super.Val

  val Furralleros = Val(minCalories = 5000, maxCalories = 10000, minimumContundence = 90)
  val NotSoFurralleros = Val(minCalories = 1000, maxCalories = 5000, minimumContundence = 50)
  val JustInCase = Val(minCalories = 0, maxCalories = 1000, minimumContundence = 0)

}
