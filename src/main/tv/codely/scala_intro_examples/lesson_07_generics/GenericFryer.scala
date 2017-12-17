package tv.codely.scala_intro_examples.lesson_07_generics

import scala.concurrent.Future

trait GenericFryer[IngredientType, FriedIngredientType] {
  def fry(ingredientType: IngredientType): Future[FriedIngredientType]
}
