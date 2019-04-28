package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.juanpablo_lopez

object EdibleTypeEnum extends Enumeration {
  type EdibleTypeEnum = Value

  protected case class Val(caloriesRange: CaloriesRange, minFillingCapacity: FillingCapacity) extends super.Val

  val Furralleros = Val(caloriesRange = CaloriesRange(5000,10000), minFillingCapacity = FillingCapacity(90))
  val NotSoFurralleros = Val(caloriesRange = CaloriesRange(1000,5000), minFillingCapacity = FillingCapacity(50))
  val JustInCase = Val(caloriesRange = CaloriesRange(0,1000), minFillingCapacity = FillingCapacity(0))
}
