package de.bananaburst.kingofqueensquiz.uitils;

import android.graphics.Bitmap;

/**
 * Created by Julia on 03.01.2015.
 */
public class Question {
    private String mQuestion;
    private String mRightAnswer;
    private String mWrongAnswerFirst;
    private String mWrongAnswerSecond;
    private String mWrongAnswerThird;
    private Bitmap mBitmap;

    public Question(String _question, String _rightAnswer, String _wrongAnswerFirst, String _wrongAnswerSecond, String _wrongAnswerThird) {
        initQuestion(_question, _rightAnswer, _wrongAnswerFirst, _wrongAnswerSecond, _wrongAnswerThird, null);
    }

    public Question(String _question, String _rightAnswer, String _wrongAnswerFirst, String _wrongAnswerSecond, String _wrongAnswerThird, Bitmap _bitmap) {
        initQuestion(_question, _rightAnswer, _wrongAnswerFirst, _wrongAnswerSecond, _wrongAnswerThird, _bitmap);
    }

    public void initQuestion(String _question, String _rightAnswer, String
            _wrongAnswerFirst, String _wrongAnswerSecond, String _wrongAnswerThird, Bitmap _bitmap) {
        mQuestion = _question;
        mRightAnswer = _rightAnswer;
        mWrongAnswerFirst = _wrongAnswerFirst;
        mWrongAnswerSecond = _wrongAnswerSecond;
        mWrongAnswerThird = _wrongAnswerThird;
        mBitmap = _bitmap;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public String getWrongAnswerThird() {
        return mWrongAnswerThird;
    }

    public String getWrongAnswerSecond() {
        return mWrongAnswerSecond;
    }

    public String getWrongAnswerFirst() {
        return mWrongAnswerFirst;
    }

    public String getRightAnswer() {
        return mRightAnswer;
    }

    public String getQuestion() {
        return mQuestion;
    }
}
