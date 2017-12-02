package tv.codely.scala_intro_examples.lesson_11_futures

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredient
import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.Bread

import scala.reflect.ClassTag

object Sandwich {
  def apply[T: ClassTag](allIngredients: Seq[Option[Ingredient]]): Sandwich = {
    val availableIngredients = allIngredients.flatten

    Sandwich(availableIngredients)
  }
}

final case class Sandwich(ingredients: Seq[Ingredient]) {
  require(ingredients.exists(isBread), "👮‍🍞 Bread is mandatory to make a Sandwich")

  private def isBread(ingredient: Ingredient) = ingredient.getClass == Bread.getClass
}
