package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    private static final String SCORE = "SCORE";
    Button OK;
    EditText scor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(SCORE)) {
            int score = intent.getIntExtra(SCORE, 0);
            scor.setText(String.valueOf(score));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(SCORE, scor.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(SCORE)){
            scor.setText(savedInstanceState.getString(SCORE));
        } else {
            scor.setText(String.valueOf('*'));

    }
}}