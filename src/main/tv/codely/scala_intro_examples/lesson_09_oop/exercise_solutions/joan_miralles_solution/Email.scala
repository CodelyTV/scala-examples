package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joan_miralles_solution

import java.security.InvalidParameterException

object Email {
  def apply(completeEmail: String): Email = {
    val atIndex = completeEmail.indexOf("@")
    if (completeEmail.isEmpty || !completeEmail.contains("@") || !completeEmail.substring(completeEmail.indexOf("@")).contains(".")) {
      throw new InvalidParameterException(s"$completeEmail is not a valid e-mail")
    }
    Email(completeEmail.substring(0, atIndex), completeEmail.substring(atIndex + 1, completeEmail.length))
  }
}

final case class Email(local: String = "soporte", domain: String = "codely.tv") {

  private val email = s"$local@$domain"

  def getEmail: String = {
    email
  }

}
