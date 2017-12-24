package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles

abstract class Ingredient()

object Ingredients {
  final case class Egg() extends Ingredient
  final case class Bacon() extends Ingredient
  final case class FriedBacon(bacon: Bacon) extends Ingredient
  final case class FriedEgg(egg: Egg) extends Ingredient
}
