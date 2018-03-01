package tv.codely.scala_intro_examples.lesson_05_ifs_for

import scala.concurrent.Future

trait Maker[T] {

  def make(): Future[T]

}
