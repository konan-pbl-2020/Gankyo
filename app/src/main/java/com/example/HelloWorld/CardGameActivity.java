package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class CardGameActivity extends AppCompatActivity {

    int card[] = {0,0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
    int score[] = {0,0};
    int player = 0;
    int omote[] =  {-1,-1};

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
        ImageButton card7 = (ImageButton)findViewById(R.id.card7);
        ImageButton card8 = (ImageButton)findViewById(R.id.card8);
        ImageButton card9 = (ImageButton)findViewById(R.id.card9);
        ImageButton card10 = (ImageButton)findViewById(R.id.card10);
        ImageButton card11 = (ImageButton)findViewById(R.id.card11);
        ImageButton card12 = (ImageButton)findViewById(R.id.card12);
        Button next =(Button)findViewById(R.id.next_card);


        int i, cnt =0;


        for(i=0; i < 10; i++){
        }
        shafful();
        System.out.println(Arrays.toString(card)); //シャッフル後の配列をLogcatに表示

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card1 = (ImageButton)findViewById(R.id.card1);
                if(omote[0] < 0) {
                    omote[0]=1;
                    switch (card[1 - 1]) {
                        case 0:
                            card1.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card1.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card1.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card1.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card1.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card1.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=1)){
                    omote[1]=1;
                    switch (card[1 - 1]) {
                        case 0:
                            card1.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card1.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card1.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card1.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card1.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card1.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card2 = (ImageButton)findViewById(R.id.card2);
                if(omote[0] < 0) {
                    switch (card[2 - 1]) {
                        case 0:
                            card2.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card2.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card2.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card2.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card2.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card2.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    omote[0]=2;
                }else if((omote[1] < 0)&&(omote[0]!=2)){
                    omote[1]=2;
                    switch (card[2 - 1]) {
                        case 0:
                            card2.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card2.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card2.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card2.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card2.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card2.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card3 = (ImageButton)findViewById(R.id.card3);
                if(omote[0] < 0) {
                    switch (card[3 - 1]) {
                        case 0:
                            card3.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card3.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card3.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card3.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card3.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card3.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    omote[0]=3;
                }else if((omote[1] < 0)&&(omote[0]!=3)){
                    omote[1]=3;
                    switch (card[3 - 1]) {
                        case 0:
                            card3.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card3.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card3.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card3.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card3.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card3.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card4 = (ImageButton)findViewById(R.id.card4);
                if(omote[0] < 0) {
                    omote[0]=4;
                    switch (card[4 - 1]) {
                        case 0:
                            card4.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card4.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card4.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card4.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card4.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card4.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=4)){
                    omote[1]=4;
                    switch (card[4 - 1]) {
                        case 0:
                            card4.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card4.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card4.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card4.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card4.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card4.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card5 = (ImageButton)findViewById(R.id.card5);
                if(omote[0] < 0) {
                    omote[0]=5;
                    switch (card[5 - 1]) {
                        case 0:
                            card5.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card5.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card5.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card5.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card5.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card5.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=5)){
                    omote[1]=5;
                    switch (card[5 - 1]) {
                        case 0:
                            card5.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card5.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card5.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card5.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card5.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card5.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card6 = (ImageButton)findViewById(R.id.card6);
                if(omote[0] < 0) {
                    omote[0]=6;
                    switch (card[6 - 1]) {
                        case 0:
                            card6.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card6.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card6.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card6.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card6.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card6.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=6)){
                    omote[1]=6;
                    switch (card[6 - 1]) {
                        case 0:
                            card6.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card6.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card6.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card6.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card6.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card6.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card7 = (ImageButton)findViewById(R.id.card7);
                if(omote[0] < 0) {
                    omote[0]=7;
                    switch (card[7 - 1]) {
                        case 0:
                            card7.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card7.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card7.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card7.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card7.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card7.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=7)){
                    omote[1]=7;
                    switch (card[7 - 1]) {
                        case 0:
                            card7.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card7.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card7.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card7.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card7.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card7.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card8 = (ImageButton)findViewById(R.id.card8);
                if(omote[0] < 0) {
                    omote[0]=8;
                    switch (card[8 - 1]) {
                        case 0:
                            card8.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card8.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card8.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card8.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card8.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card8.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=8)){
                    omote[1]=8;
                    switch (card[8 - 1]) {
                        case 0:
                            card8.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card8.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card8.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card8.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card8.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card8.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card9 = (ImageButton)findViewById(R.id.card9);
                if(omote[0] < 0) {
                    omote[0]=9;
                    switch (card[9 - 1]) {
                        case 0:
                            card9.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card9.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card9.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card9.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card9.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card9.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=9)){
                    omote[1]=9;
                    switch (card[9 - 1]) {
                        case 0:
                            card9.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card9.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card9.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card9.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card9.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card9.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card10 = (ImageButton)findViewById(R.id.card10);
                if(omote[0] < 0) {
                    omote[0]=10;
                    switch (card[10 - 1]) {
                        case 0:
                            card10.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card10.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card10.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card10.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card10.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card10.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=10)){
                    omote[1]=10;
                    switch (card[10 - 1]) {
                        case 0:
                            card10.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card10.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card10.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card10.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card10.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card10.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card11 = (ImageButton)findViewById(R.id.card11);
                if(omote[0] < 0) {
                    omote[0]=11;
                    switch (card[11 - 1]) {
                        case 0:
                            card11.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card11.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card11.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card11.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card11.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card11.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=11)){
                    omote[1]=11;
                    switch (card[11 - 1]) {
                        case 0:
                            card11.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card11.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card11.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card11.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card11.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card11.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });
        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton card12 = (ImageButton)findViewById(R.id.card12);
                if(omote[0] < 0) {
                    omote[0]=12;
                    switch (card[12 - 1]) {
                        case 0:
                            card12.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card12.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card12.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card12.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card12.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card12.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                }else if((omote[1] < 0)&&(omote[0]!=12)){
                    omote[1]=12;
                    switch (card[12 - 1]) {
                        case 0:
                            card12.setImageResource(R.drawable.c_apple);
                            break;
                        case 1:
                            card12.setImageResource(R.drawable.c_carrot);
                            break;
                        case 2:
                            card12.setImageResource(R.drawable.c_grape);
                            break;
                        case 3:
                            card12.setImageResource(R.drawable.c_kyuri);
                            break;
                        case 4:
                            card12.setImageResource(R.drawable.c_gattai);
                            break;
                        case 5:
                            card12.setImageResource(R.drawable.c_ringorou);
                            break;
                        default:
                            break;

                    }
                    Button next =(Button)findViewById(R.id.next_card);
                    next.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card[omote[0]-1] == card[omote[1]-1]) {
                    score[player%2]++;
                    delete(omote[0]);
                    delete(omote[1]);
                    if(player%2==0){
                        TextView A =(TextView)findViewById(R.id.scoreA);
                        A.setText(String.valueOf(score[player%2]));
                    }else{
                        TextView B =(TextView)findViewById(R.id.scoreB);
                        B.setText(String.valueOf(score[player%2]));
                    }
                }else{
                    player++;
                    ImageView backA =(ImageView)findViewById(R.id.backcolorA);
                    ImageView backB =(ImageView)findViewById(R.id.backcolorB);
                    if(backA.getVisibility() != View.VISIBLE){
                        backA.setVisibility(View.VISIBLE);
                        backB.setVisibility(View.INVISIBLE);
                    }else{
                        backA.setVisibility(View.INVISIBLE);
                        backB.setVisibility(View.VISIBLE);
                    }
                    reset(omote[0]);
                    reset(omote[1]);
                }
                omote[0] = -1;
                omote[1] = -1;
                Button next =(Button)findViewById(R.id.next_card);
                next.setVisibility(View.INVISIBLE);
            }
        });


    }



    private void shafful() {
        Random rnd = new Random();
        for (int i = 10+2; i > 1; i--) {
            int index = rnd.nextInt(i);
            int tmp = card[index];
            card[index] = card[i-1];
            card[i-1] = tmp;
        }

//        Random sha = new Random();
//        int aa = sha.nextInt(12)+1;
//        return aa;
    }

    private void reset(int a){
        switch(a){
            case 1:
                ImageButton card1 = (ImageButton)findViewById(R.id.card1);
                card1.setImageResource(R.drawable.c_card);
                break;
            case 2:
                ImageButton card2 = (ImageButton)findViewById(R.id.card2);
                card2.setImageResource(R.drawable.c_card);
                break;
            case 3:
                ImageButton card3 = (ImageButton)findViewById(R.id.card3);
                card3.setImageResource(R.drawable.c_card);
                break;
            case 4:
                ImageButton card4 = (ImageButton)findViewById(R.id.card4);
                card4.setImageResource(R.drawable.c_card);
                break;
            case 5:
                ImageButton card5 = (ImageButton)findViewById(R.id.card5);
                card5.setImageResource(R.drawable.c_card);
                break;
            case 6:
                ImageButton card6 = (ImageButton)findViewById(R.id.card6);
                card6.setImageResource(R.drawable.c_card);
                break;
            case 7:
                ImageButton card7 = (ImageButton)findViewById(R.id.card7);
                card7.setImageResource(R.drawable.c_card);
                break;
            case 8:
                ImageButton card8 = (ImageButton)findViewById(R.id.card8);
                card8.setImageResource(R.drawable.c_card);
                break;
            case 9:
                ImageButton card9 = (ImageButton)findViewById(R.id.card9);
                card9.setImageResource(R.drawable.c_card);
                break;
            case 10:
                ImageButton card10 = (ImageButton)findViewById(R.id.card10);
                card10.setImageResource(R.drawable.c_card);
                break;
            case 11:
                ImageButton card11 = (ImageButton)findViewById(R.id.card11);
                card11.setImageResource(R.drawable.c_card);
                break;
            case 12:
                ImageButton card12 = (ImageButton)findViewById(R.id.card12);
                card12.setImageResource(R.drawable.c_card);
                break;
            default:
                break;
        }
    }

    private void delete(int x){
        switch(x){
            case 1:
                ImageButton card1 = (ImageButton)findViewById(R.id.card1);
                card1.setVisibility(View.INVISIBLE);
                break;
            case 2:
                ImageButton card2 = (ImageButton)findViewById(R.id.card2);
                card2.setVisibility(View.INVISIBLE);
                break;
            case 3:
                ImageButton card3 = (ImageButton)findViewById(R.id.card3);
                card3.setVisibility(View.INVISIBLE);
                break;
            case 4:
                ImageButton card4 = (ImageButton)findViewById(R.id.card4);
                card4.setVisibility(View.INVISIBLE);
                break;
            case 5:
                ImageButton card5 = (ImageButton)findViewById(R.id.card5);
                card5.setVisibility(View.INVISIBLE);
                break;
            case 6:
                ImageButton card6 = (ImageButton)findViewById(R.id.card6);
                card6.setVisibility(View.INVISIBLE);
                break;
            case 7:
                ImageButton card7 = (ImageButton)findViewById(R.id.card7);
                card7.setVisibility(View.INVISIBLE);
                break;
            case 8:
                ImageButton card8 = (ImageButton)findViewById(R.id.card8);
                card8.setVisibility(View.INVISIBLE);
                break;
            case 9:
                ImageButton card9 = (ImageButton)findViewById(R.id.card9);
                card9.setVisibility(View.INVISIBLE);
                break;
            case 10:
                ImageButton card10 = (ImageButton)findViewById(R.id.card10);
                card10.setVisibility(View.INVISIBLE);
                break;
            case 11:
                ImageButton card11 = (ImageButton)findViewById(R.id.card11);
                card11.setVisibility(View.INVISIBLE);
                break;
            case 12:
                ImageButton card12 = (ImageButton)findViewById(R.id.card12);
                card12.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
    }


}