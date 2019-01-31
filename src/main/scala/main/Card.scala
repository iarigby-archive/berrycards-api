package main

/**
  * minimal unit that will be studied
  * @param question question
  * @param answer answer
  * @param question_type type of a question (eg definition, theorem)
  * @param proficiency how well user knows the information on card
  */
case class Card(question: String, answer: String, question_type: Type = Type(), mastery: Int = 0) {

}