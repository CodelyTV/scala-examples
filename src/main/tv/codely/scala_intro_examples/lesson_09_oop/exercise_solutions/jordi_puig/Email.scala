package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.jordi_puig

object Email {

  val emailRegex = raw"""(\w+)@([\w\.]+)"""

  def apply(email: String): Email = {
    require(validate(email),"Invalid email format")
    Email(Local.fromEmail(email),Domain.fromEmail(email))
  }

  private def validate(email: String): Boolean = email.matches(emailRegex)
}

final case class Email(local: Local, domain: Domain) {
  override def toString: String = s"${local.value}@${domain.value}"
}

object Local {
  def fromEmail(email: String): Local = Local(email.substring(0, email.indexOf("@")))
}


final case class Local(value: String)

object Domain {
  def fromEmail(email: String): Domain = Domain(email.substring(email.indexOf("@") + 1))
}

final case class Domain(value: String)