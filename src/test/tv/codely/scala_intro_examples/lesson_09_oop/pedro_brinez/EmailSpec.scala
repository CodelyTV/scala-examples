package tv.codely.scala_intro_examples.lesson_09_oop.pedro_brinez

import org.scalatest.{Matchers, WordSpec}

final class EmailSpec extends WordSpec with Matchers{
  "Email" should {
    "Throw exception if email is empty" in {
      assertThrows[IllegalArgumentException] {
        Email("")
      }
    }
    "Throw exception if email isn't valid" in {
      assertThrows[IllegalArgumentException] {
        Email("wrong email")
      }
    }
    "Provide an email instance" in {
      val email = Email("pedrobrinez@codely.tv")
      email shouldBe a [Email]
    }
  }
}
