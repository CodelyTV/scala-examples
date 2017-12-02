import scala.concurrent.duration._

import tv.codely.scala_intro_examples.lesson_11_futures.Benchmarker._

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

