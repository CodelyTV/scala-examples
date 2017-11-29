package tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures

import java.util.UUID

object DomainError {
  def unapply(arg: DomainError): Option[(Int, String, Map[String, Any])] =
    Some((arg.priority, arg.mnemonic, arg.context))
}

sealed abstract class DomainError(
  val priority: Int,
  val mnemonic: String,
  val context: Map[String, Any] = Map.empty
) extends Ordered[DomainError] {
  override def compare(that: DomainError): Int = this.priority - that.priority
}

case object TooMuchCpuLoad extends DomainError(priority = 0, mnemonic = "too_much_cpu_load")

case object NotEnoughDiskSpace extends DomainError(priority = 1, mnemonic = "not_enough_disk_space")

final case class UserWithoutPermissions(userId: UUID, action: String) extends DomainError(
  priority = 100,
  mnemonic = "user_without_permissions",
  context = Map("user_id" -> userId.toString, "action" -> action)
)
