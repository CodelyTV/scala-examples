package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joan_miralles_solution

import org.scalatest.{Matchers, WordSpec}

class EmailTest extends WordSpec with Matchers {

  "Email Class" should {
    "provide an apply method in the companion object in order to construct new Email from complete string" in {
      Email(completeEmail = "some@email.com")
    }

    "return a new Email instance given a complete email" in {
      val validEmail = "some@email.com"
      val email = Email(validEmail)
      email.local.value shouldBe "some"
      email.domain.value shouldBe "email.com"
    }

    "throws an Exception given email address string which doesn't contain a valid TLD" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "a@e.t"
        Email(invalidEmail)
      }
    }

    "throws an Exception given email address string which doesn't contain any character before @ character" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "@email.com"
        Email(invalidEmail)
      }
    }

    "throws an Exception given email address string which doesn't contain @ character" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "some.email.com"
        Email(invalidEmail)
      }
    }

    "throws an Exception given email address string which doesn't contain . character" in {
      assertThrows[IllegalArgumentException] {
        val invalidEmail = "some@email"
        Email(invalidEmail)
      }
    }
  }
}
