package com.eaggle.Quiz.model

class Question(val text: String) {
    val answers: MutableList<Answer> = mutableListOf()
}