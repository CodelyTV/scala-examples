package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.joan_miralles

object IngestibleSealedType {
  def unapply(arg: IngestibleSealedType): Option[(Int, Int, Int)] = Some((arg.minCalories, arg.maxCalories, arg.minimumContundence))
}

sealed abstract class IngestibleSealedType(val minCalories: Int, val maxCalories: Int, val minimumContundence: Int) extends Ordered[IngestibleSealedType] {
  override def compare(that: IngestibleSealedType): Int = this.minimumContundence - that.minimumContundence
}

case object Furralleros extends IngestibleSealedType(minCalories = 5000, maxCalories = 10000, minimumContundence = 90)

case object NotSoFurralleros extends IngestibleSealedType(minCalories = 1000, maxCalories = 5000, minimumContundence = 50)

case object JustInCase extends IngestibleSealedType(minCalories = 0, maxCalories = 1000, minimumContundence = 0)
