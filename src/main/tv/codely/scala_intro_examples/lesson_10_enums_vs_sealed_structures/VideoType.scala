package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures

object VideoType extends Enumeration {
  val Screencast, Interview = Value

  def canBeLong(videoType: VideoType.Value): Boolean = videoType != Screencast
}
