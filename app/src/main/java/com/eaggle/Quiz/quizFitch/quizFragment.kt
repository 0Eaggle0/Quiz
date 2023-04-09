package com.eaggle.Quiz.quizFitch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eaggle.Quiz.R
import com.eaggle.Quiz.helpers.DataManager
import com.eaggle.Quiz.model.Question
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class quizFragment: Fragment() {
    @Inject
    lateinit var data_manager: DataManager
    private var index = 0
    private var variant1: RadioButton? = null
    private var variant2: RadioButton? = null
    private var variant3: RadioButton? = null
    private var buttonAnswer: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmen_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        variant1 = view.findViewById(R.id.var1)
        variant1?.setOnClickListener {
            buttonAnswer?.isEnabled = true
        }
        variant2 = view.findViewById(R.id.var2)
        variant2?.setOnClickListener {
            buttonAnswer?.isEnabled = true
        }
        variant3 = view.findViewById(R.id.var3)
        variant3?.setOnClickListener {
            buttonAnswer?.isEnabled = true
        }

        val welcomeLabel = view.findViewById<TextView>(R.id.wellcome_label)
        welcomeLabel.text = getString(R.string.quiz_welcome_label, data_manager.userName)

        displayQuestion(data_manager.test.listQuestions[index])

        buttonAnswer = view.findViewById<Button>(R.id.next_button)
        buttonAnswer?.isEnabled = false
        buttonAnswer?.setOnClickListener {
            val currentQuestion = data_manager.test.listQuestions[index]
            val index2 = currentQuestion.answers.indexOfFirst {currentAnswer ->
                currentAnswer.isCorrect
            }
            if (index2 == 0){
                if (variant1?.isChecked == true){
                    data_manager.test.score += 100
                }
            }
            else if (index2 == 1){
                if (variant2?.isChecked == true){
                    data_manager.test.score += 100
                }
            }
            else if (index2 == 2){
                if (variant3?.isChecked == true){
                    data_manager.test.score += 100
                }
            }

            index += 1
            if (index < data_manager.test.listQuestions.size){
                displayQuestion(data_manager.test.listQuestions[index])
            }
            else {
                findNavController().navigate(R.id.resultsFragment)
            }
        }
    }

    private fun displayQuestion(currentQuestion: Question){
        val textQuestion = view?.findViewById<TextView>(R.id.quast)
        textQuestion?.text = currentQuestion.text

        buttonAnswer?.isEnabled = false
        variant1?.isChecked = false
        variant2?.isChecked = false
        variant3?.isChecked = false

        variant1?.text = currentQuestion.answers[0].text
        variant2?.text = currentQuestion.answers[1].text
        variant3?.text = currentQuestion.answers[2].text
    }
}