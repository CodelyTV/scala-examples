package tv.codely.scala_intro_examples.lesson_09_oop.exercise_solutions.joel_coll_solution

object Email {
  def apply(emailStr: String): Email = {
    if ("""(?=[^\s]+)(?=(\w+)@([\w\.]+\.[\w]+))""".r.findFirstIn(emailStr).isEmpty)
      throw new IllegalArgumentException

    val temp = emailStr.split('@')
    Email(temp(0), temp(1))
  }
}

final case class Email(local: String, domain: String) {
  val email: String = local + "@" + domain
}
