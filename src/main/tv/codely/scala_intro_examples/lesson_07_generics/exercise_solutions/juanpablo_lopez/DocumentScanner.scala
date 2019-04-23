package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.juanpablo_lopez

trait DocumentScanner[DocumentType, FileType] {
  def scanner(doc: DocumentType):FileType
}
