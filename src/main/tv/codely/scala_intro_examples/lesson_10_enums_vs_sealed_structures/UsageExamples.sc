/** ******************
  * Simple Enum usage
  * *******************/

import java.util.UUID

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.VideoType

// Direct instantiation
val screencast = VideoType.Screencast

// Instantiate from DB stored value
val fromDbValue = VideoType.withName("Screencast")

// Instantiate from DB stored id
val fromDbId = VideoType(1)

// Pass it to other methods
case class Video(
  id: String,
  videoType: VideoType.Value
)

// Behaviour in the type
VideoType.canBeLong(fromDbValue)

// Get all possible values
VideoType.values foreach println

/** ******************
  * Complex Enum usage
  * *******************/

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.WeekDay

val monday = WeekDay.Monday

monday.isWorkingDay

// Import the Type Alias in order to avoid specifying the WeekDay.Value type as the expected type
import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.WeekDay._

case class Week(days: Seq[WeekDay])

val spanishWeek = Week(WeekDay.values.toSeq)

// Enum main contra: Type erasure. More info: https://issues.scala-lang.org/browse/SI-3815
// How to overcome type erasure: https://medium.com/@sinisalouc/overcoming-type-erasure-in-scala-8f2422070d20

/** **********************************
  * Simple sealed structures example
  * *********************************/

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.{RafaSad, RafaState, RafaWithNotTooMuchHair, RafaWithTooMuchHair}

// Try removing one of the cases! That's the power of sealed classes and traits (structures)
def isEvenPossible(state: RafaState): Boolean = state match {
  case RafaWithTooMuchHair    => true
  case RafaWithNotTooMuchHair => true
  case RafaSad                => false
}

/** **********************************
  * Complex sealed structures example
  * *********************************/

import tv.codely.scala_intro_examples.lesson_10_enums_vs_sealed_structures.{DomainError, NotEnoughDiskSpace, TooMuchCpuLoad, UserWithoutPermissions}

val someErrors = Seq[DomainError](
  NotEnoughDiskSpace,
  UserWithoutPermissions(UUID.randomUUID(), "haircut"),
  TooMuchCpuLoad
)

someErrors.sorted

someErrors.map {
  case DomainError(priority, _, _) if priority < 100 =>
    "Non critical"
  case other: DomainError                            =>
    s"/!\\ Critical /!\\: ${other.priority}"
}

VideoType.values
