package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles

import scala.concurrent.Future

trait Fryer[IngredientType, FriedIngredientType] {
  def fry(ingredientType: IngredientType): Future[FriedIngredientType]
}
