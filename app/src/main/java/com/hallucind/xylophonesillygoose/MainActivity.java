package com.hallucind.xylophonesillygoose;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final int RED = 0;
    private final int ORANGE = 1;
    private final int YELLOW = 2;
    private final int GREEN = 3;
    private final int BLUE = 4;

    private final int YOU = 0;
    private final int ARE = 1;
    private final int A = 2;
    private final int SILLY = 3;
    private final int GOOSE = 4;

    private int currentWord;

    private SoundPool soundPool;
    private int[] you;
    private int[] are;
    private int[] a;
    private int[] silly;
    private int[] goose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWord = YOU;
        soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);

        you = new int[5];
        you[RED] = soundPool.load(this, R.raw.you1, 1);
        you[ORANGE] = soundPool.load(this, R.raw.you2, 1);
        you[YELLOW] = soundPool.load(this, R.raw.you3, 1);
        you[GREEN] = soundPool.load(this, R.raw.you4, 1);
        you[BLUE] = soundPool.load(this, R.raw.you5, 1);

        are = new int[5];
        are[RED] = soundPool.load(this, R.raw.are1, 1);
        are[ORANGE] = soundPool.load(this, R.raw.are2, 1);
        are[YELLOW] = soundPool.load(this, R.raw.are3, 1);
        are[GREEN] = soundPool.load(this, R.raw.are4, 1);
        are[BLUE] = soundPool.load(this, R.raw.are5, 1);

        a = new int[5];
        a[RED] = soundPool.load(this, R.raw.a1, 1);
        a[ORANGE] = soundPool.load(this, R.raw.a2, 1);
        a[YELLOW] = soundPool.load(this, R.raw.a3, 1);
        a[GREEN] = soundPool.load(this, R.raw.a4, 1);
        a[BLUE] = soundPool.load(this, R.raw.a5, 1);

        silly = new int[5];
        silly[RED] = soundPool.load(this, R.raw.silly1, 1);
        silly[ORANGE] = soundPool.load(this, R.raw.silly2, 1);
        silly[YELLOW] = soundPool.load(this, R.raw.silly3, 1);
        silly[GREEN] = soundPool.load(this, R.raw.silly4, 1);
        silly[BLUE] = soundPool.load(this, R.raw.silly5, 1);

        goose = new int[5];
        goose[RED] = soundPool.load(this, R.raw.goose1, 1);
        goose[ORANGE] = soundPool.load(this, R.raw.goose2, 1);
        goose[YELLOW] = soundPool.load(this, R.raw.goose3, 1);
        goose[GREEN] = soundPool.load(this, R.raw.goose4, 1);
        goose[BLUE] = soundPool.load(this, R.raw.goose5, 1);

        View redBtn = findViewById(R.id.red_btn);
        View orangeBtn = findViewById(R.id.orange_btn);
        View yellowBtn = findViewById(R.id.yellow_btn);
        View greenBtn = findViewById(R.id.green_btn);
        View blueBtn = findViewById(R.id.blue_btn);

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(RED);
                setNextWord();
            }
        });

        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(ORANGE);
                setNextWord();
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(YELLOW);
                setNextWord();
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(GREEN);
                setNextWord();
            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(BLUE);
                setNextWord();
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        adView.loadAd(adRequest);
    }

    private void playSound(int tone) {
        switch (currentWord) {
            case YOU:
                soundPool.play(you[tone], 1, 1, 0, 0, 1);
                break;

            case ARE:
                soundPool.play(are[tone], 1, 1, 0, 0, 1);
                break;

            case A:
                soundPool.play(a[tone], 1, 1, 0, 0, 1);
                break;

            case SILLY:
                soundPool.play(silly[tone], 1, 1, 0, 0, 1);
                break;

            case GOOSE:
                soundPool.play(goose[tone], 1, 1, 0, 0, 1);
                break;
        }
    }

    private void setNextWord() {
        currentWord++;
        if (currentWord >= 5) {
            currentWord = 0;
        }
    }
}