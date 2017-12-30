package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joan_miralles_solution

import java.security.InvalidParameterException

import org.scalatest.{Matchers, WordSpec}

class EmailTest extends WordSpec with Matchers {

  private val validEmail = "some@email.com"
  private val anotherValidEmail = "a@e.t"
  private val invalidEmail = "some.email.com"
  private val anotherInvalidEmail = "some@email"

  "Email Class" should {
    "provide an apply method in the companion object in order to construct new Email from complete string" in {
      "Email(completeEmail = validEmail)" should compile
    }

    "return a new Email instance given a complete email" in {
      val email = Email(validEmail)
      assert(email.isInstanceOf[Email])
      email.local shouldBe "some"
      email.domain shouldBe "email.com"
    }

    "return a new Email instance given a complete email (2)" in {
      val email = Email(anotherValidEmail)
      assert(email.isInstanceOf[Email])
      email.local shouldBe "a"
      email.domain shouldBe "e.t"
    }

    "throws an Exception given an invalid email" in {
      assertThrows[InvalidParameterException] {
        Email(invalidEmail)
      }
    }

    "throws an Exception given an invalid email (2)" in {
      assertThrows[InvalidParameterException] {
        Email(anotherInvalidEmail)
      }
    }
  }

}
