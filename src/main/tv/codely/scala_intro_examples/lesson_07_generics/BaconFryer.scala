package tv.codely.scala_intro_examples.lesson_07_generics

import tv.codely.scala_intro_examples.lesson_05_ifs_for.Ingredients.{Bacon, FriedBacon}

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

final class BaconFryer(implicit ec: ExecutionContext) extends GenericFryer[Bacon, FriedBacon] {
  private val minFryTime = 1.second

  override def fry(bacon: Bacon): Future[FriedBacon] = Future {
    Thread.sleep(minFryTime.toMillis)

    FriedBacon(bacon)
  }
}
