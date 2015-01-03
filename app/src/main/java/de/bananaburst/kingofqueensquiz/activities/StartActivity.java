package de.bananaburst.kingofqueensquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import de.bananaburst.kingofqueensquiz.R;


public class StartActivity extends ActionBarActivity implements View.OnClickListener {
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        mStartButton = (Button) findViewById(R.id.btn_start);
        mStartButton.setOnClickListener(this);
    }

    public void startGame() {
        Intent gameIntent = new Intent(StartActivity.this, QuizActivity.class);
        startActivity(gameIntent);
        finish();
    }

    @Override
    public void onClick(View _view) {
        if (_view == mStartButton) {
            mStartButton.setSelected(true);
            startGame();
        }
    }
}
