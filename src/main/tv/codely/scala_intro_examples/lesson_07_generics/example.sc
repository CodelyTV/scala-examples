val intSeq = Seq(1, 2, 3)
val stringSeq = Seq("uno", "dos", "tres ")

case class UserId(value: String)
case class User(id: UserId)

trait Repository[AggregateIdType, AggregateType] {
  def save(aggregate: AggregateType): Unit

  def search(id: AggregateIdType): AggregateType
}

class FakeUserRepository extends Repository[UserId, User] {
  def save(aggregate: User): Unit = ()

  def search(id: UserId): User = User(id)
}

