import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.juanpablo_lopez._
// Direct instantiation
val furralleros = EdibleTypeEnum.Furralleros

// Instantiate from DB stored value
val fromDbValue = EdibleTypeEnum.withName("NotSoFurralleros")

// Instantiate from DB stored id
val fromDbId = EdibleTypeEnum(1)

// Get all possible values
EdibleTypeEnum.values foreach println

/** **********************************
  * Simple sealed structures example
  * *********************************/

def wouldItFillMe(edible: EdibleTypeSealed): Boolean = edible match {
  case Furralleros => true
  case NotSoFurralleros => false
  case JustInCase => false
}


wouldItFillMe(Furralleros)

val thingsToOrder = Seq[EdibleTypeSealed](NotSoFurralleros, JustInCase, Furralleros)

thingsToOrder.sorted
