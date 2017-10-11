package tv.codely.scala_intro_examples.lesson_05_ifs_for

import scala.concurrent.Future

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients._

final class Fridge {
  def takeBread(): Future[Option[Bread]] = Future.successful(Option(Bread()))

  def takeCheese(): Future[Option[Cheese]] = Future.successful(Option(Cheese()))

  def takeHam(): Future[Option[Ham]] = Future.successful(Option(Ham()))

  def takeEgg(): Future[Option[Egg]] = Future.successful(Option(Egg()))

  def takeBacon(): Future[Option[Bacon]] = Future.successful(Option(Bacon()))
}
