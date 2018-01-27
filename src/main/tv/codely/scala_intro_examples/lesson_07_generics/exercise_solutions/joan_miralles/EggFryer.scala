package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles

import tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.joan_miralles.Ingredients.{Egg, FriedEgg}

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

class EggFryer(implicit ec: ExecutionContext) extends Fryer[Egg, FriedEgg] {
  private val minFryTime = 6.second

  override def fry(egg: Egg) = Future {
    Thread.sleep(minFryTime.toMillis)

    FriedEgg(egg)
  }

}
