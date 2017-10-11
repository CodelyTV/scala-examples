package tv.codely.scala_intro_examples

import org.scalatest._
import org.scalatest.Matchers._

final class ScalaIntroExamplesTest extends WordSpec with GivenWhenThen {
  "ScalaIntroExamples" should {
    "greet" in {
      Given("a ScalaIntroExamples")

      val scalaIntroExamples = new ScalaIntroExamples

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = scalaIntroExamples.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
