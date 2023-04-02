package com.eaggle.Quiz.helpers

import com.eaggle.Quiz.model.Answer
import com.eaggle.Quiz.model.Question
import com.eaggle.Quiz.model.Test

val question1 = Question("Какая планета является 4 от солнца?").apply {
    val answer1 = Answer(
        "Юпитер", false
    )
    val answer2 = Answer(
        "Земля", false
    )
    val answer3 = Answer(
        "Марс", true
    )
    this.answers.add(answer1)
    this.answers.add(answer2)
    this.answers.add(answer3)
}

val question2 = Question("(5*6+7-10)*2-5").apply {
    val answer1 = Answer(
        "49", true
    )
    val answer2 = Answer(
        "52", false
    )
    val answer3 = Answer(
        "37", false
    )
    this.answers.add(answer1)
    this.answers.add(answer2)
    this.answers.add(answer3)
}

val question3 = Question("Начало 1 мировой войны?").apply {
    val answer1 = Answer(
        "1914", true
    )
    val answer2 = Answer(
        "1812", false
    )
    val answer3 = Answer(
        "1941", false
    )
    this.answers.add(answer1)
    this.answers.add(answer2)
    this.answers.add(answer3)
}

val testExample = Test().apply {
    this.listQuestions.add(question1)
    this.listQuestions.add(question2)
    this.listQuestions.add(question3)
}