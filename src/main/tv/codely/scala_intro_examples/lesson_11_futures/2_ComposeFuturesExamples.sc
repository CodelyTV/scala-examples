import tv.codely.scala_intro_examples.lesson_11_futures._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/** **********************************
  * 🔗 Compose futures
  * *********************************/

// Executing futures sequentially
val fridge = new InMemoryFridge

// map & flatMap
val sandwichFutureMap = fridge.takeBread().flatMap { breadOption =>
  fridge.takeCheese().map { cheeseOption =>
    Sandwich(Seq(breadOption, cheeseOption))
  }
}

// for syntactic sugar to the nesting hell rescue!
val sandwichFutureFor = for {
  breadOption <- fridge.takeBread()
  cheeseOption <- fridge.takeCheese()
} yield Sandwich(Seq(breadOption, cheeseOption))

// After executing it, try to replace the used fridge by one which delays the takeBread action!
//val fridge = new InDelayedMemoryFridge

val intFutureList = List.fill(100)(Future.successful(1))

// Sequence
val intListFuture = Future.sequence(intFutureList)

// Traverse
val doubledIntListFuture = Future.traverse(intFutureList)(intFuture => intFuture.map(_ + 1))

// FoldLeft
val sumFuture = Future.reduceLeft(intFutureList)(_ + _)
