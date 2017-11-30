package tv.codely.scala_intro_examples.lesson_11_futures

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bread, Cheese}
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker.benchmark

import scala.concurrent.Future

final class BrokenFridge extends Fridge {
  def takeBread(): Future[Option[Bread]] = benchmark(
    taskName = "🍞 Take the bread",
    task = Future.failed(throw new RuntimeException("Error while taking the bread from the fridge."))
  )

  def takeCheese(): Future[Option[Cheese]] = benchmark(
    taskName = "🧀 Take the cheese",
    task = Future.successful(Option(Cheese()))
  )
}
