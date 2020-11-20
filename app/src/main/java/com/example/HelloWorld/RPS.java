package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class RPS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_p_s);
        final ImageView image = findViewById(R.id.img);
        image.setImageResource(R.drawable.saisyo);
        final ImageView image2 = findViewById(R.id.img2);
        image2.setImageResource(R.drawable.jyanken2);
        image2.setMaxWidth(280);
        image2.setMaxHeight(260);
        final TextView text = findViewById(R.id.text);
        text.setVisibility(INVISIBLE);
        final TextView subtext = findViewById(R.id.subtext);
        subtext.setVisibility(INVISIBLE);
        final ImageButton rockButton = (ImageButton)findViewById(R.id.rockButton);
        final ImageButton scissorsButton = (ImageButton)findViewById(R.id.scissorsButton);
        final ImageButton paperButton = (ImageButton)findViewById(R.id.paperButton);
        final ImageView opponentImage = (ImageView) findViewById(R.id.opponent);
        opponentImage.setImageResource(R.drawable.bot_hand_rock);
        final Button ok = (Button) findViewById(R.id.okButton);
        ok.setVisibility(INVISIBLE);
        ok.setEnabled(false);
        Button back = (Button)findViewById(R.id.back);

        //opponentHand 1  "rock"
        //opponentHand 2  "scissors"
        //opponentHand 3  "paper"

        rockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                rockButton.setEnabled(false);
                scissorsButton.setVisibility(INVISIBLE);
                scissorsButton.setEnabled(false);
                paperButton.setVisibility(INVISIBLE);
                paperButton.setEnabled(false);
                ok.setVisibility(VISIBLE);
                ok.setEnabled(true);
                int opponentHand = decideOpponentHand();
                decideGame(1, opponentHand, subtext, image2);
                text.setText("ぽん");
                image.setImageResource(R.drawable.jyankenbutton);
                if(opponentHand == 1) opponentImage.setImageResource(R.drawable.bot_hand_rock);
                else if(opponentHand == 2) opponentImage.setImageResource(R.drawable.bot_hand_scissors);
                else opponentImage.setImageResource(R.drawable.bot_hand_paper);
            }
        });
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                rockButton.setVisibility(INVISIBLE);
                rockButton.setEnabled(false);
                scissorsButton.setEnabled(false);
                paperButton.setVisibility(INVISIBLE);
                paperButton.setEnabled(false);
                ok.setVisibility(VISIBLE);
                ok.setEnabled(true);
                int opponentHand = decideOpponentHand();
                decideGame(2, opponentHand, subtext, image2);
                text.setText("ぽん");
                image.setImageResource(R.drawable.jyankenbutton);
                if(opponentHand == 1) opponentImage.setImageResource(R.drawable.bot_hand_rock);
                else if(opponentHand == 2) opponentImage.setImageResource(R.drawable.bot_hand_scissors);
                else opponentImage.setImageResource(R.drawable.bot_hand_paper);
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                rockButton.setVisibility(INVISIBLE);
                rockButton.setEnabled(false);
                scissorsButton.setVisibility(INVISIBLE);
                scissorsButton.setEnabled(false);
                paperButton.setEnabled(false);
                ok.setVisibility(VISIBLE);
                ok.setEnabled(true);
                int opponentHand = decideOpponentHand();
                decideGame(3, opponentHand, subtext, image2);
                text.setText("ぽん");
                image.setImageResource(R.drawable.jyankenbutton);
                if(opponentHand == 1) opponentImage.setImageResource(R.drawable.bot_hand_rock);
                else if(opponentHand == 2) opponentImage.setImageResource(R.drawable.bot_hand_scissors);
                else opponentImage.setImageResource(R.drawable.bot_hand_paper);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ok.setVisibility(INVISIBLE);
                ok.setEnabled(false);
                rockButton.setVisibility(VISIBLE);
                rockButton.setEnabled(true);
                scissorsButton.setVisibility(VISIBLE);
                scissorsButton.setEnabled(true);
                paperButton.setVisibility(VISIBLE);
                paperButton.setEnabled(true);
                text.setText("最初はグー");
                image.setImageResource(R.drawable.saisyo);
                subtext.setText("じゃんけん");
                image2.setImageResource(R.drawable.jyanken);
                opponentImage.setImageResource(R.drawable.bot_hand_rock);
                subtext.setTextColor(Color.rgb(255, 0, 0));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RPS.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    int decideOpponentHand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }

    void decideGame(int playerHand, int opponentHand, TextView subtext, ImageView image2) {
        String decision;
        if(playerHand == opponentHand){
            decision = "あいこ";
            subtext.setTextColor(Color.rgb(0, 0, 0));
            image2.setImageResource(R.drawable.aiko);
        }
        else if((playerHand == 3 && opponentHand == 1) || (playerHand+1 == opponentHand)){
            decision = "勝ち";
            subtext.setTextColor(Color.rgb(255, 0, 0));
            image2.setImageResource(R.drawable.win);
        }
        else{
            decision = "負け";
            subtext.setTextColor(Color.rgb(0, 0, 255));
            image2.setImageResource(R.drawable.lose);
        }
        subtext.setText(decision);
    }
}