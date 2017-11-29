package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures

sealed trait RafaState

case object RafaWithTooMuchHair extends RafaState
case object RafaWithNotTooMuchHair extends RafaState
case object RafaSad extends RafaState
