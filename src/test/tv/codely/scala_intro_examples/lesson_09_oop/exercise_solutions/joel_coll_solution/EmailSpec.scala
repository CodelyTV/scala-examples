package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joel_coll_solution

import org.scalatest.{Matchers, WordSpec}

final class EmailSpec extends WordSpec with Matchers {
  private val localEmail     = "local"
  private val domainEmail    = "domain.com"
  private val badDomainEmail = "domaincom"
  private val email          = localEmail + '@' + domainEmail
  private val badEmail       = localEmail + '@' + badDomainEmail

  "Email" should {
    "return an instance when pass local and domain params" in {
      val emailInstance = Email(local = localEmail, domain = domainEmail)
      emailInstance.email shouldBe email
    }
    "return an instance when pass and email" in {
      val emailInstance = Email(emailStr = email)
      emailInstance.email shouldBe email
    }
    "throw an exception when pass a bad email" in {
      intercept[IllegalArgumentException] {
        Email(emailStr = badEmail)
      }
    }
  }
}
