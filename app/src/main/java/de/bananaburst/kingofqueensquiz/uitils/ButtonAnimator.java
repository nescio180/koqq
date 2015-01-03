package de.bananaburst.kingofqueensquiz.uitils;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.widget.Button;

import de.bananaburst.kingofqueensquiz.R;

/**
 * Created by Wohnzimmer on 03.01.2015.
 */
public class ButtonAnimator implements Animator.AnimatorListener {
    private Button mAnswerButtonA;
    private Button mAnswerButtonB;
    private Button mAnswerButtonC;
    private Button mAnswerButtonD;
    private Button mRightButton;
    private Button mWrongButton;

    private AnimatorSet buttonAnimatorA;
    private AnimatorSet buttonAnimatorB;
    private AnimatorSet buttonAnimatorC;
    private AnimatorSet buttonAnimatorD;
    private AnimatorSet buttonAnimatorRed;
    private AnimatorSet buttonAnimatorBlink;
    private AnimatorSet buttonAnimatorWait;

    private ChoiceListener mChoiceListener;
    private Callback mCallback;
    private boolean mWin;

    public ButtonAnimator(Button a, Button b, Button c, Button d, Context context, Callback callback, ChoiceListener choiceListener) {
        mAnswerButtonA = a;
        mAnswerButtonB = b;
        mAnswerButtonC = c;
        mAnswerButtonD = d;

        mCallback = callback;
        mChoiceListener = choiceListener;

        buttonAnimatorA = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_alpha_to_twenty);
        buttonAnimatorA.setTarget(mAnswerButtonA);
        buttonAnimatorA.addListener(this);

        buttonAnimatorB = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_alpha_to_twenty);
        buttonAnimatorB.setTarget(mAnswerButtonB);
        buttonAnimatorB.addListener(this);

        buttonAnimatorC = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_alpha_to_twenty);
        buttonAnimatorC.setTarget(mAnswerButtonC);
        buttonAnimatorC.addListener(this);

        buttonAnimatorD = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_alpha_to_twenty);
        buttonAnimatorD.setTarget(mAnswerButtonD);
        buttonAnimatorD.addListener(this);

        buttonAnimatorBlink = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_alpha_blink);
        buttonAnimatorBlink.addListener(this);

        buttonAnimatorRed = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_red);
        buttonAnimatorRed.addListener(this);

        buttonAnimatorWait = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.animator_wait_half_second);
        buttonAnimatorWait.addListener(this);
    }

    public void animateRoundEnd(Button rightButton, Button wrongButton, boolean win) {
        mRightButton = rightButton;
        mWrongButton = wrongButton;
        mWin = win;
        fadeOutAllButtons();
    }

    public void fadeOutAllButtons() {
        buttonAnimatorA.start();
        buttonAnimatorB.start();
        buttonAnimatorC.start();
        buttonAnimatorD.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        if (animation == buttonAnimatorA) {
            mChoiceListener.deselectAll();
            buttonAnimatorBlink.setTarget(mRightButton);
            buttonAnimatorBlink.start();
            if (!mWin) {
                mChoiceListener.setBackgroundRed(mWrongButton);
                buttonAnimatorRed.setTarget(mWrongButton);
                buttonAnimatorRed.start();
            }
        } else if (animation == buttonAnimatorBlink) {
            mCallback.onAnimationDone();
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
    }

    public interface Callback {
        public void onAnimationDone();
    }
}
