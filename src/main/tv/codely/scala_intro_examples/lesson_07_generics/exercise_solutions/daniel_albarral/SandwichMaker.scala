package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.daniel_albarral

import tv.codely.scala_intro_examples.lesson_05_ifs_for.{Fridge, Fryer, Sandwich}

import scala.concurrent.{ExecutionContext, Future}

final class SandwichMaker(private val fridge: Fridge, private val fryer: Fryer)(implicit ec: ExecutionContext)
  extends Maker[Sandwich] {

  def make(): Future[Sandwich] = {
    val breadOptionFuture = fridge.takeBread()
    val cheeseOptionFuture = fridge.takeCheese()
    val hamOptionFuture = fridge.takeHam()
    val eggOptionFuture = fridge.takeEgg()
    val baconOptionFuture = fridge.takeBacon()

    breadOptionFuture.flatMap { breadOption =>
      cheeseOptionFuture.flatMap { cheeseOption =>
        hamOptionFuture.flatMap { hamOption =>
          eggOptionFuture.flatMap { eggOption =>
            baconOptionFuture.map { baconOption =>
              Sandwich(Seq(breadOption, cheeseOption, hamOption, eggOption, baconOption))
            }
          }
        }
      }
    }
  }
}
