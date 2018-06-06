object Local {
  def fromEmail(email: String): Local = {
    Local(email.substring(0, email.indexOf("@")))
  }
}

final case class Local(local: String)

object Domain {
  def fromEmail(email: String): Domain = {
    Domain(email.substring(email.indexOf("@") + 1))
  }
}

final case class Domain(domain: String)

object Email {

  private val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"""

  def apply(email: String): Option[Email] = {
    if (email.matches(emailRegex)) {
      Some(Email(Local.fromEmail(email), Domain.fromEmail(email)))
    } else {
      None
    }
  }
}

final case class Email(local: Local, domain: Domain)

Email("lala@app.com")
Email("notanemail.com")
