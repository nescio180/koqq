package de.bananaburst.kingofqueensquiz.uitils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import de.bananaburst.kingofqueensquiz.R;

/**
 * Created by Julia on 03.01.2015.
 */
public class ChoiceListener implements View.OnClickListener {
    private ArrayList<Button> mButtons = new ArrayList<Button>();
    private ClickCallback mCallback;
    private Drawable mGreenBackground;
    private Drawable mRedBackground;

    public ChoiceListener(ClickCallback _callback, Context context, Button... _buttons) {
        mCallback = _callback;

        mGreenBackground = context.getResources().getDrawable(R.drawable.koq_background_selector);
        mRedBackground = context.getResources().getDrawable(R.drawable.koq_background_red);

        for (Button b : _buttons) {
            mButtons.add(b);
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View _button) {
        select(_button);
        if (mCallback != null) {
            mCallback.onClick(_button);
        }
    }

    private void select(View _button) {
        for (Button b : mButtons) {
            if (b == _button) {
                b.setSelected(true);
            } else {
                b.setSelected(false);
            }
        }
    }

    public void deselectAll() {
        for (Button b : mButtons) {
            b.setSelected(false);
        }
    }

    public void resetAlpha() {
        for (Button b : mButtons) {
            b.setAlpha(1.0f);
        }
    }

    public void resetColor() {
        for (Button b : mButtons) {
            b.setBackgroundResource(R.drawable.koq_background_selector);
        }
    }

    public void setBackgroundRed(Button b) {
        b.setBackgroundResource(R.drawable.koq_background_red);
    }

    public void activateButtons(boolean active) {
        for (Button b : mButtons) {
            b.setClickable(active);
        }
    }

    public void invalidateAll() {
        for (Button b : mButtons) {
            b.invalidate();
        }
    }

    public interface ClickCallback {
        public void onClick(View _view);
    }
}
