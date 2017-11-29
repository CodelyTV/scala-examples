import java.util.UUID

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

def log(something: String): Unit = {
  val threadName = Thread.currentThread().getName
  println(s"[$threadName] $something")
}

/** **********************************
  * Basic async ops
  * *********************************/

def simulate(task: String, during: Duration): Unit = {
  log(s"Starting to $task")
  Thread.sleep(during.toMillis)
  log(s"Finishing to $task")
}

def cutRafaHair(): Unit = simulate("cut Rafa's hair", 5 seconds)

def cutJaviHair(): Unit = simulate("cut Javi's hair", 1 seconds)

def cutRafaHairAsync(): Future[Unit] = Future(cutRafaHair())

def cutJaviHairAsync(): Future[Unit] = Future(cutJaviHair())

// Blocks the current thread

cutRafaHair()
cutJaviHair()

// Executes each asynchronous operation in a different thread

val rafaFuture = cutRafaHairAsync()
val javiFuture = cutJaviHairAsync()

// Waits until the future completes

Await.result(rafaFuture, 5 minutes)
Await.result(javiFuture, 5 minutes)

// Checkout jvisualvm with longer execution times

// ToDo: Deal with future results asynchronously (map, flatMap, for - SandwichMaker)

// What about exceptions?

val suspiciousFuture = Future(throw new RuntimeException)

// Await.result(suspiciousFuture, 5 minutes) // BUM!

// ToDo: How to deal with future failures (recover, recoverWith, transform)
suspiciousFuture

/** **********************************
  * Useful named constructors
  * *********************************/

final case class User(id: UUID, name: String)
val randomUser = User(UUID.randomUUID(), "lerele")

// We're just instantiating a Future[User] in order to match with a signature.
// We're not executing anything asynchronously. Actually, we're avoiding context switching :)
// Useful if we're coupled to the Future type in our repositories interfaces, but we've an in memory implementation.
Future.successful(randomUser) // Future[User]

Future.unit // Future[Unit]

// ToDo: Different ExecutionContexts

// ToDo: How to deal with _blocking_ operations
