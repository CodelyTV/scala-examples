import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try
import scala.util.control.NonFatal

import tv.codely.scala_intro_examples.lesson_11_futures._
import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker._

/** **********************************
 * 🚨 Error Handling
 * *********************************/

// fallbackTo

def readFromCache = Future.failed(new RuntimeException("Not found in cache"))
def readFromSourceOfTruth = Future.successful("🐒 value from source of truth")

val videoTitle = readFromCache fallbackTo readFromSourceOfTruth

// /!\ fallbackTo parameter not passed by name

val fridge = new BrokenFridge

// Play replacing the fridge by the standard one
// val fridge = new InMemoryFridge

val sandwichFuture = for {
  cheeseOption <- fridge.takeCheese() recover { case NonFatal(e) => print(e.getMessage); None }
  breadOption <- fridge.takeBread() recover { case NonFatal(e) => print(e.getMessage); None }
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
