package tv.codely.scala_intro_examples.lesson_05_ifs_for

abstract class Ingredient()

object Ingredients {
  final case class Bread() extends Ingredient
  final case class Cheese() extends Ingredient
  final case class Ham() extends Ingredient
  final case class Egg() extends Ingredient
  final case class Bacon() extends Ingredient
  final case class FriedBacon(bacon: Bacon) extends Ingredient
  final case class FriedEgg(egg: Egg) extends Ingredient
}
