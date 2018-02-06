import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.exercise_solutions.jordi_puig._

// Why is this a Val
val furralleros = EatableThingsEnumType.Furralleros

// And this is a Value ?
val fromDbValue = EatableThingsEnumType.withName("NotSoFurralleros")

val fromDbId = EatableThingsEnumType(2)

EatableThingsEnumType.values foreach println

furralleros.maxCalories

// fromDbValue.maxCalories -> is not working

furralleros.isPoisoning

EatableThingsEnumType.isPoisoning2(furralleros)

val furrallerosSealed = Furralleros

furrallerosSealed.hasChocolate

furrallerosSealed.isPoisoning

val cookiesSealed = JustInCase(hasChocolate = true)

cookiesSealed.hasChocolate

cookiesSealed.isPoisoning

def isSoHearty(eatableThing: EatableThingsSealedType): Boolean = eatableThing match {
  case Furralleros    => true
  case _ => false
}

isSoHearty(Furralleros)

isSoHearty(NotSoFurralleros)

val eatableThings = Seq[EatableThingsSealedType](
  Furralleros,
  NotSoFurralleros,
  JustInCase(hasChocolate = true)
)

eatableThings.sorted

eatableThings.map {
  case EatableThingsSealedType(_,_,minHeartyLevel) if minHeartyLevel < 50 =>
    "Still hungry!!"
  case other: EatableThingsSealedType =>
    "Satiated!"
}

