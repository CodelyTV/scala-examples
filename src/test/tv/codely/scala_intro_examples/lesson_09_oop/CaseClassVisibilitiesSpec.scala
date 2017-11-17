package tv.codely.scala_intro_examples.lesson_09_oop

import org.scalatest.{Matchers, WordSpec}

final class CaseClassVisibilitiesSpec extends WordSpec with Matchers {
  private val randomText = "some text"
  private val caseClass  = CaseClass(attributeInConstruct = randomText)

  "Case Class" should {
    "generate a public getter for the attributes defined in the constructor" in {
      caseClass.attributeInConstruct shouldBe randomText
    }
    "not compile if we try to access private attributes defined in the constructor" in {
      "caseClass.privateAttributeInConstruct" shouldNot compile
    }
    "set as public the attributes defined in the class body by default" in {
      val bodyAttributeValue = "public body attribute value"

      caseClass.attributeInBody shouldBe bodyAttributeValue
    }
    "not compile if we try to access private attributes defined in the body" in {
      "caseClass.privateAttributeInBody" shouldNot compile
    }
  }
}
