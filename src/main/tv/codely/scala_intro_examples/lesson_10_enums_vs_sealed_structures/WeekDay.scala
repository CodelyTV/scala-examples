package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures

object WeekDay extends Enumeration {
  type WeekDay = Value // Type alias in order to avoid having to point to WeekDay.Value

  protected case class Val(order: Int, isWorkingDay: Boolean) extends super.Val

  val Monday    = Val(order = 1, isWorkingDay = true)
  val Tuesday   = Val(order = 2, isWorkingDay = true)
  val Wednesday = Val(order = 3, isWorkingDay = true)
  val Thursday  = Val(order = 4, isWorkingDay = true)
  val Friday    = Val(order = 5, isWorkingDay = true)
  val Saturday  = Val(order = 6, isWorkingDay = false)
  val Sunday    = Val(order = 7, isWorkingDay = false)
}
