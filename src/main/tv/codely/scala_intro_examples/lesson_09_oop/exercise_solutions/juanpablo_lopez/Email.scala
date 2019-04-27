package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.juanpablo_lopez

object Email{
  val emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

  def apply(emailString: String): Email = {
    if (emailString.matches(emailPattern)) {
      val local = Local.from_email(emailString)
      val domain = Domain.from_email(emailString)
      return Email(local, domain)
    }
    throw new IllegalArgumentException("Incorrect email format, please check it")
  }
}

final case class Email(local: Local, domain:Domain)

object Local {
  def from_email(emailString:String): Local = {
    Local(emailString.split("@")(0))
  }
}

final case class Local(value:String)

object Domain {
  def from_email(emailString:String): Domain = {
    Domain(emailString.split("@")(1))
  }
}

final case class Domain(value:String)
