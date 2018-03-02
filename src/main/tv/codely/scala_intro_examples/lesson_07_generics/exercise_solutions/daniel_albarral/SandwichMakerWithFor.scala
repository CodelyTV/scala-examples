package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.daniel_albarral

import tv.codely.scala_intro_examples.lesson_05_ifs_for.{Fridge, Fryer, Sandwich}

import scala.concurrent.{ExecutionContext, Future}

final class SandwichMakerWithFor(private val fridge: Fridge, private val fryer: Fryer)(implicit ec: ExecutionContext)
  extends Maker[Sandwich] {

  def make(): Future[Sandwich] =
    for {
      breadOption  <- fridge.takeBread()
      cheeseOption <- fridge.takeCheese()
      hamOption    <- fridge.takeHam()
      eggOption    <- fridge.takeEgg()
      baconOption  <- fridge.takeBacon()
    } yield Sandwich(Seq(breadOption, cheeseOption, hamOption, eggOption, baconOption))

}
