package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    EditText scor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.Gained)) {
            String score = intent.getStringExtra(Constants.Gained);
            scor.setText(String.valueOf(score));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.Gained, scor.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.Gained)) {
            scor.setText(savedInstanceState.getString(Constants.Gained));
        } else {
            scor.setText(String.valueOf('*'));

        }

    }
}