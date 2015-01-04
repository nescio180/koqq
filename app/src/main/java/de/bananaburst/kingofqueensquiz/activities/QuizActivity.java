package de.bananaburst.kingofqueensquiz.activities;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import de.bananaburst.kingofqueensquiz.R;
import de.bananaburst.kingofqueensquiz.uitils.ButtonAnimator;
import de.bananaburst.kingofqueensquiz.uitils.ChoiceListener;
import de.bananaburst.kingofqueensquiz.uitils.DataBase;
import de.bananaburst.kingofqueensquiz.uitils.Question;


public class QuizActivity extends ActionBarActivity implements ChoiceListener.ClickCallback, ButtonAnimator.Callback {
    private Button mAnswerButtonA;
    private Button mAnswerButtonB;
    private Button mAnswerButtonC;
    private Button mAnswerButtonD;
    private Button mRightButton;
    private RelativeLayout mLayoutMain;
    private TextView mQuizText;
    private ImageView mQuizImage;

    private ArrayList<Button> mButtonList = new ArrayList<>();

    private DataBase mDataBase;
    private ChoiceListener mChoiceListener;

    private ButtonAnimator mButtonAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        mLayoutMain = (RelativeLayout) findViewById(R.id.layout_main);

        mQuizText = (TextView) findViewById(R.id.quiz_text);
        mQuizImage= (ImageView) findViewById(R.id.quiz_image);

        mAnswerButtonA = (Button) findViewById(R.id.button_answer_a);
        mAnswerButtonB = (Button) findViewById(R.id.button_answer_b);
        mAnswerButtonC = (Button) findViewById(R.id.button_answer_c);
        mAnswerButtonD = (Button) findViewById(R.id.button_answer_d);

        mButtonList.add(mAnswerButtonA);
        mButtonList.add(mAnswerButtonB);
        mButtonList.add(mAnswerButtonC);
        mButtonList.add(mAnswerButtonD);

        mChoiceListener = new ChoiceListener(this, this,
                new Button[]{mAnswerButtonA, mAnswerButtonB, mAnswerButtonC, mAnswerButtonD});

        mDataBase = new DataBase();
        mButtonAnimator = new ButtonAnimator(mAnswerButtonA, mAnswerButtonB, mAnswerButtonC,
                mAnswerButtonD, this, this, mChoiceListener);

        startNewQuestion();
    }

    public void startNewQuestion() {
        mChoiceListener.resetColor();
        mChoiceListener.activateButtons(true);
        mChoiceListener.deselectAll();
        mChoiceListener.resetAlpha();
        mChoiceListener.invalidateAll();
        mLayoutMain.invalidate();

        Question newQuestion = mDataBase.getNextQuestion();

        mQuizText.setText(newQuestion.getQuestion());

        Collections.shuffle(mButtonList);
        mButtonList.get(0).setText(newQuestion.getRightAnswer());
        mRightButton = mButtonList.get(0);
        mButtonList.get(1).setText(newQuestion.getWrongAnswerFirst());
        mButtonList.get(2).setText(newQuestion.getWrongAnswerSecond());
        mButtonList.get(3).setText(newQuestion.getWrongAnswerThird());
    }

    @Override
    public void onClick(View _view) {
        mChoiceListener.activateButtons(false);
        mButtonAnimator.animateRoundEnd(mRightButton, (Button) _view, _view == mRightButton);
    }

    @Override
    public void onAnimationDone() {
        mButtonAnimator.animateImageAndText(mQuizImage);
        startNewQuestion();
    }
}
