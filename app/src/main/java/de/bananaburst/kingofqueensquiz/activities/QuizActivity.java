package de.bananaburst.kingofqueensquiz.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import de.bananaburst.kingofqueensquiz.R;


public class QuizActivity extends ActionBarActivity {
    private Button mAnswerButtonA;
    private Button mAnswerButtonB;
    private Button mAnswerButtonC;
    private Button mAnswerButtonD;

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
    }

    public void startNewQuestion(){

    }
}
