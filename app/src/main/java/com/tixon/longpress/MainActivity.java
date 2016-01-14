package com.tixon.longpress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pressArea;
    boolean longPressed = false;
    boolean isNewMessage = true;

    long timeStart, timeEnd;
    long timePauseStart, timePauseEnd;

    long criticalDot, criticalMessage;

    Node root = new Node(null);

    private void createRussianTree() {
        root.setLeft(new Node("Е"));
        root.setRight(new Node("Т"));
        Node l1, r1, l1l2, l1r2, r1l2, r1r2;
        Node l1l2l3, l1l2r3, l1r2l3, l1r2r3, r1l2l3, r1l2r3, r1r2l3, r1r2r3;
        /*Node l1l2l3l4, l1l2l3r4, l1l2r3l4, l1l2r3r4, l1r2l3l4, l1r2l3r4, l1r2r3l4, l1r2r3r4,
                r1l2l3l4, r1l2l3r4, r1l2r3l4, r1l2r3r4, r1r2l3l4, r1r2l3r4, r1r2r3l4, r1r2r3r4;*/
        l1 = root.getLeft();
        r1 = root.getRight();
        l1.setLeft(new Node("И"));
        l1.setRight(new Node("А"));

        r1.setLeft(new Node("Н"));
        r1.setRight(new Node("М"));

        l1l2 = l1.getLeft();
        l1r2 = l1.getRight();
        r1l2 = r1.getLeft();
        r1r2 = r1.getRight();

        l1l2l3 = new Node("С");
        l1l2r3 = new Node("У");
        l1r2l3 = new Node("Р");
        l1r2r3 = new Node("В");
        r1l2l3 = new Node("Д");
        r1l2r3 = new Node("К");
        r1r2l3 = new Node("Г");
        r1r2r3 = new Node("О");

        l1l2.setLeft(l1l2l3);
        l1l2.setRight(l1l2r3);
        l1r2.setLeft(l1r2l3);
        l1r2.setRight(l1r2r3);
        r1l2.setLeft(r1l2l3);
        r1l2.setRight(r1l2r3);
        r1r2.setLeft(r1r2l3);
        r1r2.setRight(r1r2r3);

        l1l2l3.setLeft(new Node("Х"));
        l1l2l3.setRight(new Node("Ж"));
        l1l2r3.setLeft(new Node("Ф"));
        l1l2r3.setRight(new Node("Ю"));
        l1r2l3.setLeft(new Node("Л"));
        l1r2l3.setRight(new Node("Я"));
        l1r2r3.setLeft(new Node("П"));
        l1r2r3.setRight(new Node("Й"));
        r1l2l3.setLeft(new Node("Б"));
        r1l2l3.setRight(new Node("Ь"));
        r1l2r3.setLeft(new Node("Ц"));
        r1l2r3.setRight(new Node("Ы"));
        r1r2l3.setLeft(new Node("З"));
        r1r2l3.setRight(new Node("Щ"));
        r1r2r3.setLeft(new Node("Ч"));
        r1r2r3.setRight(new Node("Ш"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeStart = 0;
        timeEnd = 0;

        criticalDot = 200;
        criticalMessage = 300;

        pressArea = (Button) findViewById(R.id.pressAreaCodeInterpreter);

        pressArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("myLogs", "down");
                    timeStart = System.currentTimeMillis();
                    timePauseEnd = timeStart;

                    isNewMessage = timePauseEnd - timePauseStart >= criticalMessage;
                    Log.d("myLogs", "isNewMessage = " + isNewMessage);
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("myLogs", "up");
                    timeEnd = System.currentTimeMillis();
                    timePauseStart = timeEnd;
                    longPressed = timeEnd - timeStart >= 200;
                    Log.d("myLogs", "longPressed = " + (longPressed ? "DASH" : "DOT"));
                }
                return false;
            }
        });
    }
}
