package tv.codely.scala_intro_examples.lesson_11_futures

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bread, Cheese}
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker.benchmark

import scala.concurrent.Future

final class InMemoryFridge extends Fridge {
  def takeBread(): Future[Option[Bread]] = benchmark("🍞 Take the bread", Future.successful(Option(Bread())))

  def takeCheese(): Future[Option[Cheese]] = benchmark("🧀 Take the cheese", Future.successful(Option(Cheese())))
}
