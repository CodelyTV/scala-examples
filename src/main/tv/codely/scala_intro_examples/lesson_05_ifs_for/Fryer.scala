package tv.codely.scala_intro_examples.lesson_05_ifs_for

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bacon, FriedBacon}

final class Fryer(implicit ec: ExecutionContext) {
  private val minFryTime = 1.second

  def fry(bacon: Bacon): Future[FriedBacon] = Future {
    Thread.sleep(minFryTime.toMillis)

    FriedBacon(bacon)
  }
}
