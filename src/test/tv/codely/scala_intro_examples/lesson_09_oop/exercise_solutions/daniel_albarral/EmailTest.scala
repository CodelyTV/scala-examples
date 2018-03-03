package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.daniel_albarral

import org.scalatest.{Matchers, WordSpec}


final class EmailTest extends WordSpec with Matchers {

  "Email.fromString with a valid email" should {
    "return instance of Some(Email)" in {
      val validEmail = "local@domain.com"
      Email.fromString(validEmail) shouldBe Some(Email("local", "domain.com"))
    }
  }

  "Email.fromString with a invalid email" should {
    "return None" in {
      val validEmail = "localdomain.com"
      Email.fromString(validEmail) shouldBe None
    }
  }

}
