package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.juanpablo_lopez

object EdibleTypeSealed {
  def unapply(arg: EdibleTypeSealed): Option[(CaloriesRange, FillingCapacity)] =
    Some((arg.caloriesRange, arg.minFillingCapacity))
}

sealed abstract class EdibleTypeSealed(
                                        val caloriesRange: CaloriesRange,
                                        val minFillingCapacity: FillingCapacity
                                      ) extends Ordered[EdibleTypeSealed] {
  override def compare(that: EdibleTypeSealed):Int =
    this.minFillingCapacity.value - that.minFillingCapacity.value
}

case object Furralleros extends EdibleTypeSealed(caloriesRange = CaloriesRange(5000,10000), minFillingCapacity=FillingCapacity(90))
case object NotSoFurralleros extends EdibleTypeSealed(caloriesRange = CaloriesRange(1000,5000), minFillingCapacity=FillingCapacity(50))
case object JustInCase extends EdibleTypeSealed(caloriesRange = CaloriesRange(0,1000), minFillingCapacity=FillingCapacity(0))
