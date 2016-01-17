package com.tixon.longpress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button pressArea;
    TextView textViewLetter;
    boolean longPressed = false;
    boolean isNewMessage = true;

    long timeStart, timeEnd;
    long timePauseStart, timePauseEnd;

    long criticalDot, criticalMessage;

    StringBuilder code = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeStart = 0;
        timeEnd = 0;

        criticalDot = 200;
        criticalMessage = 300;

        pressArea = (Button) findViewById(R.id.pressAreaCodeInterpreter);
        textViewLetter = (TextView) findViewById(R.id.textViewLetter);

        pressArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("myLogs", "down");
                    timeStart = System.currentTimeMillis();
                    timePauseEnd = timeStart;

                    isNewMessage = timePauseEnd - timePauseStart >= criticalMessage;
                    Log.d("myLogs", "isNewMessage = " + isNewMessage);

                    if(isNewMessage) {
                        textViewLetter.setText(MorseParser.parse(code.toString(),
                                getResources().getStringArray(R.array.russian_codes),
                                getResources().getStringArray(R.array.russian_symbols)));
                        code = new StringBuilder();
                    }
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("myLogs", "up");
                    timeEnd = System.currentTimeMillis();
                    timePauseStart = timeEnd;
                    longPressed = timeEnd - timeStart >= 200;
                    Log.d("myLogs", "longPressed = " + (longPressed ? "DASH" : "DOT"));

                    if(longPressed) {
                        code.append("_");
                    } else {
                        code.append(".");
                    }
                }
                return false;
            }
        });
    }
}
