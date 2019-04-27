package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.juanpa_lopez

import org.scalatest.{Matchers, WordSpec}
import tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.juanpablo_lopez.Email

/**
  * In order to check all the capabilities that a case class have, just:
  * * Compile it with: `scalac`
  * * Inspect it with: `javap -private`
  *
  * You also have the option of running `scalac CaseClass.scala -print` in order to see the compiled version.
  */
final class EmailSpec extends WordSpec with Matchers {

  "Email Class" should {
    "provide an apply method in the companion object in order to construct new Email instances from string" in {
      Email(emailString="soport@codely.tv")
    }

    "returns a new Email instance given a valid email" in {
      val validEmail = "some@email.com"
      val email = Email(validEmail)
      email.local.value shouldBe "some"
      email.domain.value shouldBe "email.com"
    }

    "throws an IllegalArgumentException given a not valid email address" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "a@e.t"
        Email(invalidEmail)
      }

    }

    "throws an IllegalArgumentException given a email address with invalid domain" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "support@codely.t"
        Email(invalidEmail)
      }

    }

    "throws an IllegalArgumentException given a email address with invalid domain ending" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "support@codely"
        Email(invalidEmail)
      }

    }
  }
}
