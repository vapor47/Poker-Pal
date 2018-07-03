package com.josephpark.pokerpal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EVQuizActivity extends AppCompatActivity {

    private QuestionLibrary QL = new QuestionLibrary();

    private TextView scoreView;
    private TextView questionView;
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private Button buttonChoice4;

    private String answer;
    private int score = 0;
    private int questionNum = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evquiz);

        scoreView = findViewById(R.id.score);
        questionView = findViewById(R.id.questionText);
        buttonChoice1 = findViewById(R.id.choice1);
        buttonChoice2 = findViewById(R.id.choice2);
        buttonChoice3 = findViewById(R.id.choice3);
        buttonChoice4 = findViewById(R.id.choice4);

        updateQuestion();
    }

    public void answerChoiceClicked(View view){
        Button btn = (Button)view;
        if(btn.getText() == answer){
            score += 1;
            updateScore(score);
            //TODO: show notification that answer is correct
        } else{
            //TODO: notify that answer is wrong (and highlight/give correct answer)
        }
        updateQuestion();
    }

    private void updateQuestion(){
        questionView.setText(QL.getQuestion(questionNum));

        buttonChoice1.setText(QL.getChoice1(questionNum));
        buttonChoice2.setText(QL.getChoice2(questionNum));
        buttonChoice3.setText(QL.getChoice3(questionNum));
        buttonChoice4.setText(QL.getChoice4(questionNum));

        answer = QL.getCorrectAnswer(questionNum);
        if(questionNum < QL.getNumQuestions() - 1)
            questionNum++;
    }

    private void updateScore(int points){
        scoreView.setText(""+score);
    }
}
//TODO: add 'end quiz' button on top righht to exit early
//TODO: randomize questions
//TODO: end of quiz recap screen
//TODO:
