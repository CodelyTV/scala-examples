import java.util.UUID

import tv.codely.scala_intro_examples.lesson_11_futures._
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.Try
import scala.util.control.NonFatal

/** **********************************
  * 🚀 Basic async ops
  * *********************************/

def cutRafaHair(): Unit = simulate("💂‍️ Cut Rafa's hair", 30 seconds)

def cutJaviHair(): Unit = simulate("🧔 Cut Javi's hair", 5 seconds)

def cutRafaHairAsync(): Future[Unit] = Future(cutRafaHair())

def cutJaviHairAsync(): Future[Unit] = Future(cutJaviHair())

// Blocks the current thread

cutRafaHair()
cutJaviHair()

print("👋 After sync calls 🕋")

// Executes each asynchronous operation in a different thread

val rafaFuture = cutRafaHairAsync()
val javiFuture = cutJaviHairAsync()

print("👋 After async calls 🔮")

// Waits until the future completes

Await.result(rafaFuture, 5 minutes)
Await.result(javiFuture, 5 minutes)

print("👋 After async calls ✋")

// Checkout jvisualvm with longer execution times

/** **********************************
  * 🛠 Useful named constructors
  * *********************************/

final case class User(id: UUID, name: String)
val randomUser = User(UUID.randomUUID(), "lerele")

// We're just instantiating a Future[User] in order to match with a signature.
// We're not executing anything asynchronously. Actually, we're avoiding context switching :)
// Useful if we're coupled to the Future type in our repositories interfaces, but we've an in memory implementation.
Future.successful(randomUser) // Future[User]
Future.failed[User](new RuntimeException("Not found in cache")) // Future[User]
//Future(throw new RuntimeException("222Not found in cache")) // Future[User]

Future.unit // Future[Unit]

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

/** **********************************
  * 🚨 Error Handling
  * *********************************/

// fallbackTo

def readFromCache = Future.failed(new RuntimeException("Not found in cache"))
def readFromSourceOfTruth = Future("lerele")

val videoTitle = readFromCache fallbackTo readFromSourceOfTruth

// /!\ fallbackTo parameter not passed by name

val sandwichFuture = for {
  cheeseOption <- fridge.takeCheese() recover { case NonFatal(e)  => print(e.getMessage); None }
  breadOption <- fridge.takeBread() recover { case NonFatal(e)  => print(e.getMessage); None }
} yield Sandwich(Seq(breadOption, cheeseOption))

sandwichFuture.failed.foreach {
  case NonFatal(e) => print(s"🚨 Exception <${e.getMessage}> while making a Sandwich.")
}

// Future as an asynchronous implementation of Try

def readFromCacheTry: Try[String] = Try(throw new RuntimeException("Not found in cache"))
def readFromSourceOfTruthTry: Try[String] = Try("lerele")

val videoTitleTry = readFromCacheTry.failed.flatMap(_ => readFromSourceOfTruthTry)

// Functional Error Handling: https://github.com/47deg/functional-error-handling/blob/master/deck/README.md
// Prefer monadic structures instead of throwing exceptions: Option / Either / Try

/** **********************************
  * 🕋 Blocking & Execution Context
  * *********************************/

// Blocking operations
import scala.concurrent.blocking

blocking {
  simulate("Some blocking operation", 1 second)
}

// Useful when the threads are left idle waiting for a resource. More information:
// https://www.cakesolutions.net/teamblogs/demystifying-the-blocking-construct-in-scala-futures
// https://www.beyondthelines.net/computing/scala-future-and-execution-context/

