package tv.codely.scala_intro_examples.lesson_09_oop

import scala.util.Random

object NumberWithCompanionObject {
  def apply(value: String): NumberWithCompanionObject = NumberWithCompanionObject(value = value.toInt)

  def random: NumberWithCompanionObject = NumberWithCompanionObject(value = Random.nextInt())
}

final case class NumberWithCompanionObject(value: Int) {
  val plusOne: NumberWithCompanionObject = copy(value = value + 1)
}
