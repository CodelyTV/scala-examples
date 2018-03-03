package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.daniel_albarral


object Email {

//  FIXME: Improve email validator, the actual one is not covering almost nothing.
//  The regex in this comment is the actual one that should validate the mail
//  but for some reason I was not able to make it match with a correct email
//  (the regex is "working" at regex101.com
//  "^(\\w+(?:[-+.']\\w+)*)@(\\w+(?:[-.]\\w+)*\\.\\w+(:?[-.]\\w+)*)$".r

  private val emailValidationRegex = "(.*)@(.*)".r

  def fromString(value: String): Option[Email] =
    value match {
     case emailValidationRegex(local, domain) => Some(Email(local, domain))
     case _ => None
     }

}

case class Email(local: String, domain: String)
