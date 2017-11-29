package tv.codely.scala_intro_examples.lesson_09_oop

import org.scalatest.{Matchers, WordSpec}

/**
  * In order to check all the capabilities that a case class have, just:
  * * Compile it with: `scalac`
  * * Inspect it with: `javap -private`
  *
  * You also have the option of running `scalac CaseClass.scala -print` in order to see the compiled version.
  */
final class CaseClassCapabilitiesSpec extends WordSpec with Matchers {
  private val randomText = "some text"
  private val caseClass  = CaseClass(attributeInConstruct = randomText)

  "Case Class" should {
    "provide an apply method in the companion object in order to construct new instances" in {
      "CaseClass(attributeInConstruct = randomText)" should compile
    }
    "provide a copy method making it easier for us to deal with immutability" in {
      val differentInstance = caseClass.copy(attributeInConstruct = "some different text")

      differentInstance.attributeInBody shouldBe differentInstance.attributeInBody
    }
    "provide an unapply method making it easier deconstructing in pattern matching" in {
      val differentInstance = CaseClass.unapply(caseClass)

      differentInstance shouldBe a[Option[_]]
    }
    "provide an implemented toString method displaying all the attribtue values" in {
      caseClass.toString shouldBe "CaseClass(some text,Some default value)"
    }
  }
}
