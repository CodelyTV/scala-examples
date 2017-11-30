package tv.codely.scala_intro_examples.lesson_11_futures

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bread, Cheese}
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker.benchmark

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

final class InDelayedMemoryFridge(implicit ec: ExecutionContext) extends Fridge {

  def takeBread(): Future[Option[Bread]] = benchmark(
    taskName = "🍞 Take the bread",
    task = Future{
      delay()
      Option(Bread())
    }
  )

  def takeCheese(): Future[Option[Cheese]] = benchmark("🧀 Take the cheese", Future.successful(Option(Cheese())))

  private def delay(): Unit = Thread.sleep(5.seconds.toMillis)
}
