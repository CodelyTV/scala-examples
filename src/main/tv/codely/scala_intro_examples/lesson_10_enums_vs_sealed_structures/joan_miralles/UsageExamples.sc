import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.joan_miralles.{Furralleros, IngestibleEnumType, JustInCase, NotSoFurralleros}

// Direct instantiation
val furralleros = IngestibleEnumType.Furralleros

// Instantiate from DB stored value
val fromDbValue = IngestibleEnumType.withName("NotSoFurralleros")

// Instantiate from DB stored id
val fromDbId = IngestibleEnumType(2)

// Get all possible values
IngestibleEnumType.values foreach println

/** **********************************
  * Simple sealed structures example
  * *********************************/

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.joan_miralles._

// Try removing one of the cases! That's the power of sealed classes and traits (structures)
def isHealthyFood(ingestible: IngestibleSealedType): Boolean = ingestible match {
    case Furralleros => false
    case NotSoFurralleros => false
    case JustInCase => true
}

isHealthyFood(JustInCase)

val thingsToIngest = Seq[IngestibleSealedType](NotSoFurralleros, JustInCase, Furralleros)

thingsToIngest.sorted

thingsToIngest.map {
    case IngestibleSealedType(_, maxCalories, _) if maxCalories >= 5000 => "Unhealthy!!! Don't eat them!"
    case other: IngestibleSealedType => "Healthy! You can eat a lot of them!"
}
