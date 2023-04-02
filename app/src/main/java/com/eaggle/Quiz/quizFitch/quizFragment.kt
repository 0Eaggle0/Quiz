package com.eaggle.Quiz.quizFitch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmen_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val welcomeLabel = view.findViewById<TextView>(R.id.wellcome_label)
        welcomeLabel.text = getString(R.string.quiz_welcome_label, data_manager.userName)

        displayQuestion(data_manager.test.listQuestions[index])

        val buttonAnswer = view.findViewById<Button>(R.id.next_button)
        buttonAnswer.setOnClickListener {
            index += 1
            if (index < data_manager.test.listQuestions.size){
                displayQuestion(data_manager.test.listQuestions[index])
            }
        }
    }

    private fun displayQuestion(currentQuestion: Question){
        val textQuestion = view?.findViewById<TextView>(R.id.quast)
        textQuestion?.text = currentQuestion.text

        val variant1 = view?.findViewById<RadioButton>(R.id.var1)
        val variant2 = view?.findViewById<RadioButton>(R.id.var2)
        val variant3 = view?.findViewById<RadioButton>(R.id.var3)

        variant1?.text = currentQuestion.answers[0].text
        variant2?.text = currentQuestion.answers[1].text
        variant3?.text = currentQuestion.answers[2].text
    }
}