package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.jordi_puig

import org.scalatest.{Matchers, WordSpec}

class EmailSpec extends WordSpec with Matchers {
  "Email" should {
    "create an Email instance given a valid email" in {
      val email = Email("staff@codely.tv")
      email.toString shouldBe "staff@codely.tv"
      email.local.value shouldBe "staff"
      email.domain.value shouldBe "codely.tv"
    }
    "throw an IllegalArgumentException given an email without local" in {
      assertThrows[IllegalArgumentException] {
        Email("@codely.tv")
      }
    }
    "throw an IllegalArgumentException given an email without domain" in {
      assertThrows[IllegalArgumentException] {
        Email("staff")
      }
    }
    "throw an IllegalArgumentException given an email without @" in {
      assertThrows[IllegalArgumentException] {
        Email("staffcodely.tv")
      }
    }
  }
}