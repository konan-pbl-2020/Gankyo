package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.Random;

public class CardGameActivity extends AppCompatActivity {

    int card[] = {0,0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_game);

        ImageButton card1 = (ImageButton)findViewById(R.id.card1);
        ImageButton card2 = (ImageButton)findViewById(R.id.card2);
        ImageButton card3 = (ImageButton)findViewById(R.id.card3);
        ImageButton card4 = (ImageButton)findViewById(R.id.card4);
        ImageButton card5 = (ImageButton)findViewById(R.id.card5);
        ImageButton card6 = (ImageButton)findViewById(R.id.card6);
        int i, cnt =0;


        for(i=0; i < 12; i++){
        }
        shafful();
        System.out.println(Arrays.toString(card)); //シャッフル後の配列をLogcatに表示

    }

    private void shafful() {
        Random rnd = new Random();
        for (int i = 12+2; i > 1; i--) {
            int index = rnd.nextInt(i);
            int tmp = card[index];
            card[index] = card[i-1];
            card[i-1] = tmp;
        }

//        Random sha = new Random();
//        int aa = sha.nextInt(12)+1;
//        return aa;
    }


}