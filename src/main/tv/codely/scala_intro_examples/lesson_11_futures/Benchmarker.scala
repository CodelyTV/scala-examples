package tv.codely.scala_intro_examples.lesson_11_futures

import org.joda.time.DateTime

import scala.concurrent.duration.Duration

object Benchmarker {
  def print(something: String): Unit = {
    val threadName = Thread.currentThread().getName
    val now = DateTime.now
    val minute = s"${now.minuteOfHour().get()}:${now.secondOfMinute().get()}"
    println(s"[$threadName] [$minute] $something")
  }

  def benchmark[T](taskName: String, task: => T): T = {
    print(s"🏁 Starting to $taskName")
    val result = task
    print(s"🔚 Finishing to $taskName")
    result
  }

  def simulate(taskName: String, during: Duration): Unit = benchmark(taskName, Thread.sleep(during.toMillis))
}
