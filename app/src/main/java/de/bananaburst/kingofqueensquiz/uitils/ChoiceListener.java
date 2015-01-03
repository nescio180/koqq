package de.bananaburst.kingofqueensquiz.uitils;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Julia on 03.01.2015.
 */
public class ChoiceListener implements View.OnClickListener {
    ArrayList<Button> mButtons = new ArrayList<Button>();
    ClickCallback mCallback;

    public ChoiceListener(ClickCallback _callback, Button... _buttons) {
        mCallback = _callback;

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

    public interface ClickCallback {
        public void onClick(View _view);
    }
}
