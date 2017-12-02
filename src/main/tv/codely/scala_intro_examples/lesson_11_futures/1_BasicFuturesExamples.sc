import java.util.UUID

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker._

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
