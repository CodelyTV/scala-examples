package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles

import tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles.Ingredients.{Bacon, FriedBacon}

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

final class BaconFryer(implicit ec: ExecutionContext) extends GenericFryer[Bacon, FriedBacon] {
  private val minFryTime = 1.second

  override def fry(bacon: Bacon): Future[FriedBacon] = Future {
    Thread.sleep(minFryTime.toMillis)

    FriedBacon(bacon)
  }
}
