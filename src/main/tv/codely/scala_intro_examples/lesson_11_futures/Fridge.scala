package tv.codely.scala_intro_examples.lesson_11_futures

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bread, Cheese}

import scala.concurrent.Future

trait Fridge {
  def takeBread(): Future[Option[Bread]]

  def takeCheese(): Future[Option[Cheese]]
}
