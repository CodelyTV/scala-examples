package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joan_miralles

object Email {
  val validEmailTest = raw"^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$$"

  def apply(completeEmail: String): Email = {
    if (!completeEmail.matches(validEmailTest)) {
      throw new IllegalArgumentException(s"$completeEmail is not a valid e-mail")
    }
    Email(Local.fromEmail(completeEmail), Domain.fromEmail(completeEmail))
  }
}

final case class Email(local: Local = Local("soporte"), domain: Domain = Domain("codely.tv"))

object Local {
  def fromEmail(email: String): Local = Local(email.substring(0, email.indexOf("@")))
}

final case class Local(value: String)

object Domain {
  def fromEmail(email: String): Domain = {
    Domain(email.substring(email.indexOf("@") + 1))
  }
}

final case class Domain(value: String)
