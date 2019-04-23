package tv.codely.scala_intro_examples.lesson_07_generics.exercise_solutions.juanpablo_lopez

class BookScannerToPDF extends DocumentScanner[Book,PDF]{
  def scanner(doc:Book):PDF = new PDF()
}
