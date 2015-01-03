package de.bananaburst.kingofqueensquiz.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import de.bananaburst.kingofqueensquiz.R;
import de.bananaburst.kingofqueensquiz.uitils.ChoiceListener;
import de.bananaburst.kingofqueensquiz.uitils.DataBase;
import de.bananaburst.kingofqueensquiz.uitils.Question;


public class QuizActivity extends ActionBarActivity implements ChoiceListener.ClickCallback {
    private Button mAnswerButtonA;
    private Button mAnswerButtonB;
    private Button mAnswerButtonC;
    private Button mAnswerButtonD;
    private Button mRightButton;

    private DataBase mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        mAnswerButtonA = (Button) findViewById(R.id.button_answer_a);
        mAnswerButtonB = (Button) findViewById(R.id.button_answer_b);
        mAnswerButtonC = (Button) findViewById(R.id.button_answer_c);
        mAnswerButtonD = (Button) findViewById(R.id.button_answer_d);

        ChoiceListener mChoiceListener = new ChoiceListener(this,
                new Button[]{mAnswerButtonA, mAnswerButtonB, mAnswerButtonC, mAnswerButtonD});

        mDataBase = new DataBase();

        startNewQuestion();
    }

    public void startNewQuestion() {
        Question newQuestion = mDataBase.getRandomQuestion();
    }

    @Override
    public void onClick(View _view) {
        if (_view == mRightButton) {
        }
    }
}
