package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.juanpablo_lopez

object FillingCapacity{
  def apply(value: Int): FillingCapacity = {

    if (value < 0 || value > 100) {
      throw new IllegalArgumentException("Value has to be between 0 to 100")
    }
    new FillingCapacity(value)
  }
}
case class FillingCapacity(value:Int)
