package com.example.celticsongsapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpJig, mpBagpipe;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btnJig);
        button2 = (Button) findViewById(R.id.btnBagpipes);
        button1.setOnClickListener(bJig);
        button2.setOnClickListener(bBagpipes);
        mpJig = new MediaPlayer();
        mpJig = MediaPlayer.create(this, R.raw.jig);
        mpBagpipe = new MediaPlayer();
        mpBagpipe = MediaPlayer.create(this, R.raw.bagpipes);
        playing = 0;

    }
    Button.OnClickListener bJig = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpJig.start();
                    playing = 1;
                    button1.setText("Pause Irish Jig");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpJig.pause();
                    playing = 0;
                    button1.setText("Play Irish Jig");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
    Button.OnClickListener bBagpipes = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpBagpipe.start();
                    playing = 1;
                    button2.setText("Pause Bagpipe Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpBagpipe.pause();
                    playing = 0;
                    button2.setText("Play Bagpipe Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
}
