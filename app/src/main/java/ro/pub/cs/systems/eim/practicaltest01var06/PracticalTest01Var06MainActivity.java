package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Random;

import ro.pub.cs.systems.eim.practicaltest01var06.Constants;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    EditText text1;
    EditText text2;
    EditText text3;
    CheckBox checkBox;
    CheckBox checkBox1;
    CheckBox checkBox2;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        text1 = findViewById(R.id.first_edit_text);
        text2 = findViewById(R.id.second_edit_text);
        text3 = findViewById(R.id.third_edit_text);
        checkBox = findViewById(R.id.checkbox);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        play = findViewById(R.id.play);
        play.setOnClickListener(playButtonClickListener);

    }
    private playButtonClickListener playButtonClickListener = new playButtonClickListener();
    private class playButtonClickListener implements View.OnClickListener {
        Random random = new Random();
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.play:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                    int score = Integer.parseInt(text1.getText().toString())+Integer.parseInt(text2.getText().toString())+Integer.parseInt(text3.getText().toString());

                    if(checkBox.isChecked()==false&&checkBox1.isChecked()==false&&checkBox2.isChecked()==false){
                        text1.setText(String.valueOf(random.nextInt(4)));
                        text2.setText(String.valueOf(random.nextInt(4)));
                        text3.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,100);
                            startActivity(intent);
                        }

                    }
                    else if(checkBox.isChecked()==false&&checkBox1.isChecked()==false&&checkBox2.isChecked()==true) {
                        text1.setText(String.valueOf(random.nextInt(4)));
                        text2.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra("Gained",50);
                            startActivity(intent);
                        }
                    }
                    else if(checkBox1.isChecked()==false&&checkBox2.isChecked()==false&&checkBox.isChecked() == true){
                        text3.setText(String.valueOf(random.nextInt(4)));
                        text2.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,50);
                            startActivity(intent);
                        }
                    }
                    else if(checkBox.isChecked()==false&&checkBox2.isChecked()==false&&checkBox1.isChecked() == true){
                        text1.setText(String.valueOf(random.nextInt(4)));
                        text3.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,50);
                            startActivity(intent);
                        }
                    }
                    else if(checkBox.isChecked()==false&&checkBox1.isChecked()==true&&checkBox2.isChecked()==true){
                        text1.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,10);
                            startActivity(intent);
                        }
                    }

                    else if(checkBox.isChecked()==true&&checkBox1.isChecked()==false&&checkBox2.isChecked()==true){
                        text2.setText(String.valueOf(random.nextInt(3)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,10);
                            startActivity(intent);
                        }
                    }

                    else if(checkBox.isChecked()==true&&checkBox1.isChecked()==true&&checkBox2.isChecked()==false){
                        text3.setText(String.valueOf(random.nextInt(4)));
                        if(text1.getText().equals(text2.getText())&& text1.getText().equals(text3.getText())){
                            intent.putExtra(Constants.Gained,10);
                            startActivity(intent);
                        }
                    }

            }
        }
    }

}