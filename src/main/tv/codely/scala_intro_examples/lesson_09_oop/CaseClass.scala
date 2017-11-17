package tv.codely.scala_intro_examples.lesson_09_oop

final case class CaseClass(
    attributeInConstruct: String,
    private val privateAttributeInConstruct: String = "Some default value"
) {
  val attributeInBody                = "public body attribute value"
  private val privateAttributeInBody = "private body attribute value"
}
