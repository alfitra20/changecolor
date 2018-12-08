package fi.oulu.tol.esde14.sobree;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    // Declare variable
    private TextView textView;
    private RelativeLayout buttonLayout;
    private Boolean startup = true;
    private int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the variable
        textView = findViewById(R.id.textView);
        // Set default color
        textView.setBackgroundColor(Color.RED);
        Button buttonW = findViewById(R.id.buttonW);
        Button buttonB = findViewById(R.id.buttonB);
        Button buttonR = findViewById(R.id.buttonR);
        Button buttonY = findViewById(R.id.buttonY);
        Button buttonG = findViewById(R.id.buttonG);
        buttonLayout = findViewById(R.id.layoutButton);

        // Set according to current State
        setState(savedInstanceState);

        // Changing the color to White using onClickListener for button W
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.WHITE;
                textView.setBackgroundColor(color);
                buttonLayout.setVisibility(View.INVISIBLE);
            }
        });

        // Changing the color to Black using onClickListener for button W
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.BLACK;
                textView.setBackgroundColor(color);
                buttonLayout.setVisibility(View.INVISIBLE);

            }
        });

        // Changing the color to Red using onClickListener for button W
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.RED;
                textView.setBackgroundColor(color);
                buttonLayout.setVisibility(View.INVISIBLE);
            }
        });

        // Changing the color to Yellow using onClickListener for button W
        buttonY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.YELLOW;
                textView.setBackgroundColor(color);
                buttonLayout.setVisibility(View.INVISIBLE);
            }
        });

        // Changing the color to Green using onClickListener for button W
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = Color.GREEN;
                textView.setBackgroundColor(color);
                buttonLayout.setVisibility(View.INVISIBLE);
            }
        });

        // Hide the button using textView onClickListener
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(startup){
                    startup = false;
                } else {
                    textView.setText("");
                }
                if(buttonLayout.isShown()){
                    buttonLayout.setVisibility(View.INVISIBLE);
                } else {
                    buttonLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Check", "saveInstance called");
        outState.putBoolean(getString(R.string.visibility), buttonLayout.isShown());
        outState.putInt(getString(R.string.color), color);
        super.onSaveInstanceState(outState);
    }

    private void setState(Bundle saved){
        // This will be executed only when the app change orientation
        // ** not from startup **
        try {
            boolean visible = (saved.getBoolean(getString(R.string.visibility)));
            Log.d("Check-visibility", String.valueOf(visible));
            if (visible) {
                buttonLayout.setVisibility(View.VISIBLE);
            } else {
                buttonLayout.setVisibility(View.INVISIBLE);
            }
            if(saved.getInt(getString(R.string.color)) != -1){
                Log.d("Check-color", String.valueOf(color));
                textView.setBackgroundColor(saved.getInt(getString(R.string.color)));
            }
        } catch (NullPointerException e){
            Log.d("Check-state", "null");
        }
    }
}
