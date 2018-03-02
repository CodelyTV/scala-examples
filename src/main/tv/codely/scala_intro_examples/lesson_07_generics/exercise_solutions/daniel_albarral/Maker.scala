package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.daniel_albarral

import scala.concurrent.Future

trait Maker[T] {

  def make(): Future[T]

}
