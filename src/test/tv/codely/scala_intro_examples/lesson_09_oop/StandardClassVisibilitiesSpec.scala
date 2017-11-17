package tv.codely.scala_intro_examples.lesson_09_oop

import org.scalatest.{Matchers, WordSpec}

final class StandardClassVisibilitiesSpec extends WordSpec with Matchers {
  private val randomText    = "some text"
  private val standardClass = new StandardClassVisibilities(attributeInConstruct = randomText)

  "Standard Class" should {
    "set as public the attributes defined in the constructor by default" in {
      standardClass.attributeInConstruct shouldBe randomText
    }
    "not compile if we try to access private attributes defined in the constructor" in {
      "standardClass.privateAttributeInConstruct" shouldNot compile
    }
    "set as public the attributes defined in the class body by default" in {
      val bodyAttributeValue = "public body attribute value"

      standardClass.attributeInBody shouldBe bodyAttributeValue
    }
    "not compile if we try to access private attributes defined in the body" in {
      "standardClass.privateAttributeInBody" shouldNot compile
    }
  }
}
