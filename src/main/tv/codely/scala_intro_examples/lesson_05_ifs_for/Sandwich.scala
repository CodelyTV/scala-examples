package tv.codely.scala_intro_examples.lesson_05_ifs_for

import scala.reflect.ClassTag

object Sandwich {
  def apply[T: ClassTag](allIngredients: Seq[Option[Ingredient]]): Sandwich = {
    val availableIngredients = allIngredients.flatten

    Sandwich(availableIngredients)
  }
}

final case class Sandwich(ingredients: Seq[Ingredient])
