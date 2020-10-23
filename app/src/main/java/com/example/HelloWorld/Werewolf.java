package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Werewolf extends AppCompatActivity {
    int peopleNum = 3; //人数
    int[] position = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
    int wolfNum = 1, divinerNum = 1, thiefNum = 0, teruNum = 0, villagerNum = 3; //役職の数
    public static final int WOLF = 0, DIVINER = 1, THIEF = 2, TERU = 3, VILLAGER = 4;
    int n = 0; //役職確認時人数カウント用変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setScreenMain();
    }

    void setScreenMain(){
        setContentView(R.layout.activity_werewolf);
        final TextView number = findViewById(R.id.number);
        Button up = (Button)findViewById(R.id.up);
        Button down = (Button)findViewById(R.id.down);
        Button positionConfig = (Button)findViewById(R.id.position);
        Button start = (Button)findViewById(R.id.start);
        final ImageView img1 = findViewById(R.id.imageView);
        final ImageView img2 = findViewById(R.id.imageView2);
        final ImageView img3 = findViewById(R.id.imageView3);
        final ImageView img4 = findViewById(R.id.imageView4);
        final ImageView img5 = findViewById(R.id.imageView5);
        final ImageView img6 = findViewById(R.id.imageView6);
        final ImageView img7 = findViewById(R.id.imageView7);
        final ImageView img8 = findViewById(R.id.imageView8);
        final ImageView img9 = findViewById(R.id.imageView9);
        final ImageView img10 = findViewById(R.id.imageView10);
        final ImageView img11 = findViewById(R.id.imageView11);
        final ImageView img12 = findViewById(R.id.imageView12);

        //画像セット
        if(position[0] == WOLF) img1.setImageResource(R.drawable.wolf);
        else if(position[0] == DIVINER) img1.setImageResource(R.drawable.diviner);
        else if(position[0] == THIEF) img1.setImageResource(R.drawable.thief);
        else if(position[0] == TERU) img1.setImageResource(R.drawable.teruteru);
        else if(position[0] == VILLAGER) img1.setImageResource(R.drawable.villager);
        if(position[1] == WOLF) img2.setImageResource(R.drawable.wolf);
        else if(position[1] == DIVINER) img2.setImageResource(R.drawable.diviner);
        else if(position[1] == THIEF) img2.setImageResource(R.drawable.thief);
        else if(position[1] == TERU) img2.setImageResource(R.drawable.teruteru);
        else if(position[1] == VILLAGER) img2.setImageResource(R.drawable.villager);
        if(position[2] == WOLF) img3.setImageResource(R.drawable.wolf);
        else if(position[2] == DIVINER) img3.setImageResource(R.drawable.diviner);
        else if(position[2] == THIEF) img3.setImageResource(R.drawable.thief);
        else if(position[2] == TERU) img3.setImageResource(R.drawable.teruteru);
        else if(position[2] == VILLAGER) img3.setImageResource(R.drawable.villager);
        if(position[3] == WOLF) img4.setImageResource(R.drawable.wolf);
        else if(position[3] == DIVINER) img4.setImageResource(R.drawable.diviner);
        else if(position[3] == THIEF) img4.setImageResource(R.drawable.thief);
        else if(position[3] == TERU) img4.setImageResource(R.drawable.teruteru);
        else if(position[3] == VILLAGER) img4.setImageResource(R.drawable.villager);
        if(position[4] == WOLF) img5.setImageResource(R.drawable.wolf);
        else if(position[4] == DIVINER) img5.setImageResource(R.drawable.diviner);
        else if(position[4] == THIEF) img5.setImageResource(R.drawable.thief);
        else if(position[4] == TERU) img5.setImageResource(R.drawable.teruteru);
        else if(position[4] == VILLAGER) img5.setImageResource(R.drawable.villager);
        if(peopleNum<4) img6.setVisibility(View.INVISIBLE);
        if(position[5] == WOLF) img6.setImageResource(R.drawable.wolf);
        else if(position[5] == DIVINER) img6.setImageResource(R.drawable.diviner);
        else if(position[5] == THIEF) img6.setImageResource(R.drawable.thief);
        else if(position[5] == TERU) img6.setImageResource(R.drawable.teruteru);
        else if(position[5] == VILLAGER) img6.setImageResource(R.drawable.villager);
        if(peopleNum<5) img7.setVisibility(View.INVISIBLE);
        if(position[6] == WOLF) img7.setImageResource(R.drawable.wolf);
        else if(position[6] == DIVINER) img7.setImageResource(R.drawable.diviner);
        else if(position[6] == THIEF) img7.setImageResource(R.drawable.thief);
        else if(position[6] == TERU) img7.setImageResource(R.drawable.teruteru);
        else if(position[6] == VILLAGER) img7.setImageResource(R.drawable.villager);
        if(peopleNum<6) img8.setVisibility(View.INVISIBLE);
        if(position[7] == WOLF) img8.setImageResource(R.drawable.wolf);
        else if(position[7] == DIVINER) img8.setImageResource(R.drawable.diviner);
        else if(position[7] == THIEF) img8.setImageResource(R.drawable.thief);
        else if(position[7] == TERU) img8.setImageResource(R.drawable.teruteru);
        else if(position[7] == VILLAGER) img8.setImageResource(R.drawable.villager);
        if(peopleNum<7) img9.setVisibility(View.INVISIBLE);
        if(position[8] == WOLF) img9.setImageResource(R.drawable.wolf);
        else if(position[8] == DIVINER) img9.setImageResource(R.drawable.diviner);
        else if(position[8] == THIEF) img9.setImageResource(R.drawable.thief);
        else if(position[8] == TERU) img9.setImageResource(R.drawable.teruteru);
        else if(position[8] == VILLAGER) img9.setImageResource(R.drawable.villager);
        if(peopleNum<8) img10.setVisibility(View.INVISIBLE);
        if(position[9] == WOLF) img10.setImageResource(R.drawable.wolf);
        else if(position[9] == DIVINER) img10.setImageResource(R.drawable.diviner);
        else if(position[9] == THIEF) img10.setImageResource(R.drawable.thief);
        else if(position[9] == TERU) img10.setImageResource(R.drawable.teruteru);
        else if(position[9] == VILLAGER) img10.setImageResource(R.drawable.villager);
        if(peopleNum<9) img11.setVisibility(View.INVISIBLE);
        if(position[10] == WOLF) img11.setImageResource(R.drawable.wolf);
        else if(position[10] == DIVINER) img11.setImageResource(R.drawable.diviner);
        else if(position[10] == THIEF) img11.setImageResource(R.drawable.thief);
        else if(position[10] == TERU) img11.setImageResource(R.drawable.teruteru);
        else if(position[10] == VILLAGER) img11.setImageResource(R.drawable.villager);
        if(peopleNum<10) img12.setVisibility(View.INVISIBLE);
        if(position[11] == WOLF) img12.setImageResource(R.drawable.wolf);
        else if(position[11] == DIVINER) img12.setImageResource(R.drawable.diviner);
        else if(position[11] == THIEF) img12.setImageResource(R.drawable.thief);
        else if(position[11] == TERU) img12.setImageResource(R.drawable.teruteru);
        else if(position[11] == VILLAGER) img12.setImageResource(R.drawable.villager);

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Werewolf.this,MainActivity.class);
                startActivity(intent);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //プレイ人数増加
                if(peopleNum < 10) {
                    peopleNum++;
                    String pn = String.valueOf(peopleNum);
                    number.setText(pn);
                    if(peopleNum==4){ img6.setVisibility(View.VISIBLE); } //画像追加表示
                    if(peopleNum==5){ img7.setVisibility(View.VISIBLE); }
                    if(peopleNum==6){ img8.setVisibility(View.VISIBLE); }
                    if(peopleNum==7){ img9.setVisibility(View.VISIBLE); }
                    if(peopleNum==8){ img10.setVisibility(View.VISIBLE); }
                    if(peopleNum==9){ img11.setVisibility(View.VISIBLE); }
                    if(peopleNum==10){ img12.setVisibility(View.VISIBLE); }
                    villagerNum = (peopleNum+2)-wolfNum-divinerNum-thiefNum-teruNum;
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //プレイ人数減少
                if(peopleNum > 3) {
                    peopleNum--;
                    String pn = String.valueOf(peopleNum);
                    number.setText(pn);
                    if(peopleNum==3){ img6.setVisibility(View.INVISIBLE); } //画像非表示
                    if(peopleNum==4){ img7.setVisibility(View.INVISIBLE); }
                    if(peopleNum==5){ img8.setVisibility(View.INVISIBLE); }
                    if(peopleNum==6){ img9.setVisibility(View.INVISIBLE); }
                    if(peopleNum==7){ img10.setVisibility(View.INVISIBLE); }
                    if(peopleNum==8){ img11.setVisibility(View.INVISIBLE); }
                    if(peopleNum==9){ img12.setVisibility(View.INVISIBLE); }
                    villagerNum = (peopleNum+2)-wolfNum-divinerNum-thiefNum-teruNum;
                }
            }
        });

        positionConfig.setOnClickListener(new View.OnClickListener() { //人数設定画面を開く
            public void onClick(View view) { setScreenConfig();
            }
        }); //人数設定画面を開く

        start.setOnClickListener(new View.OnClickListener() { //配役シャッフル＆イントロを開く
            public void onClick(View view) {
                //役職シャッフル
                Random rnd = new Random();
                for (int i = peopleNum+2; i > 1; i--) {
                    int index = rnd.nextInt(i);
                    // 要素入れ替え(swap)
                    int tmp = position[index];
                    position[index] = position[i-1];
                    position[i-1] = tmp;
                }
                System.out.println(Arrays.toString(position));

                setContentView(R.layout.activity_werewolf_intro); //夜行動開始アナウンス
                TextView textV6 = (TextView)findViewById(R.id.textView6);
                textV6.setTextColor(Color.rgb(220, 220, 220));
                TextView textV7 = (TextView)findViewById(R.id.textView7);
                textV7.setTextColor(Color.rgb(220, 220, 220));
                TextView textV8 = (TextView)findViewById(R.id.textView8);
                textV8.setTextColor(Color.rgb(220, 220, 220));
                Button next = (Button)findViewById(R.id.next);
                next.setOnClickListener(new View.OnClickListener() { //プレイヤー確認画面を開く
                    public void onClick(View view) {
                        setScreenConfirmation();
                    }
                });
            }
        });
    }


    void setScreenConfig(){ //設定画面
        setContentView(R.layout.activity_werewolf_position_config);
        Button ok = (Button)findViewById(R.id.ok);
        final TextView pNumber = findViewById(R.id.player);
        String pn = String.valueOf(peopleNum);
        pNumber.setText(pn);
        final TextView vNumber = findViewById(R.id.villagerNum);

        changeVillagerNum(vNumber, villagerNum); //村人の数表示
        final TextView wNumber = findViewById(R.id.wolfNum); //狼の数表示
        String wn = String.valueOf(wolfNum);
        wNumber.setText(wn);
        final TextView dNumber = findViewById(R.id.divinerNum); //占い師の数表示
        String dn = String.valueOf(divinerNum);
        dNumber.setText(dn);
        final TextView thNumber = findViewById(R.id.thiefNum); //怪盗の数表示
        String thn = String.valueOf(thiefNum);
        thNumber.setText(thn);
        final TextView teNumber = findViewById(R.id.teruNum); //てるてるの数表示
        String ten = String.valueOf(teruNum);
        teNumber.setText(ten);

        Button upw = (Button)findViewById(R.id.upWolf); //狼の数増加
        upw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(wolfNum < (peopleNum+2)-divinerNum-thiefNum-teruNum-1){
                    wolfNum++;
                    villagerNum--;
                }
                String wn = String.valueOf(wolfNum);
                wNumber.setText(wn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        Button downw = (Button)findViewById(R.id.downWolf); //狼の数減少
        downw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(wolfNum > 1){
                    wolfNum--;
                    villagerNum++;
                }
                String wn = String.valueOf(wolfNum);
                wNumber.setText(wn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        Button upd = (Button)findViewById(R.id.upDiviner); //占い師の数増加
        upd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(divinerNum < (peopleNum+2)-wolfNum-thiefNum-teruNum-1){
                    divinerNum++;
                    villagerNum--;
                }
                String dn = String.valueOf(divinerNum);
                dNumber.setText(dn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        Button downd = (Button)findViewById(R.id.downDiviner); //占い師の数減少
        downd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(divinerNum > 0){
                    divinerNum--;
                    villagerNum++;
                }
                String dn = String.valueOf(divinerNum);
                dNumber.setText(dn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        Button upth = (Button)findViewById(R.id.upThief); //怪盗の数増加
        upth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(thiefNum < (peopleNum+2)-wolfNum-divinerNum-teruNum-1){
                    thiefNum++;
                    villagerNum--;
                }
                String thn = String.valueOf(thiefNum);
                thNumber.setText(thn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        Button downth = (Button)findViewById(R.id.downThief); //怪盗の数減少
        downth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(thiefNum > 0){
                    thiefNum--;
                    villagerNum++;
                }
                String thn = String.valueOf(thiefNum);
                thNumber.setText(thn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        Button upte = (Button)findViewById(R.id.upTeru); //てるてるの数増加
        upte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(teruNum < (peopleNum+2)-wolfNum-divinerNum-thiefNum-1){
                    teruNum++;
                    villagerNum--;
                }
                String ten = String.valueOf(teruNum);
                teNumber.setText(ten);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        Button downte = (Button)findViewById(R.id.downTeru); //てるてるの数減少
        downte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(teruNum > 0){
                    teruNum--;
                    villagerNum++;
                }
                String ten = String.valueOf(teruNum);
                teNumber.setText(ten);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //設定完了。元の画面に戻る
                setArray(peopleNum, wolfNum, divinerNum, thiefNum, teruNum);
                setScreenMain();
                final TextView number = findViewById(R.id.number);
                String pn = String.valueOf(peopleNum);
                number.setText(pn);
            }
        });
    }

    void changeVillagerNum(TextView vNumber,int villagerNum){ //変更後の村人数表示
        String vn = String.valueOf(villagerNum);
        vNumber.setText(vn);
    }

    void setArray(int pn, int wn, int dn, int thn, int ten){
        int i = 0;
        while (i<wn){
            position[i] = WOLF;
            i++;
        }
        while (i<wn+dn){
            if(dn==0) break;
            position[i] = DIVINER;
            i++;
        }
        while (i<wn+dn+thn){
            if(thn==0) break;
            position[i] = THIEF;
            i++;
        }
        while (i<wn+dn+thn+ten){
            if(ten==0) break;
            position[i] = TERU;
            i++;
        }
        while (i<pn+2){
            position[i] = VILLAGER;
            i++;
        }
        System.out.println(Arrays.toString(position));
    }

    void setScreenConfirmation(){ //プレイヤー確認画面
        setContentView(R.layout.activity_werewolf_confirmation);

        TextView text = (TextView)findViewById(R.id.text);
        text.setTextColor(Color.rgb(220, 220, 220));
        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setTextColor(Color.rgb(220, 220, 220));
        TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setTextColor(Color.rgb(220, 220, 220));
        TextView text4 = (TextView)findViewById(R.id.text4);
        text4.setTextColor(Color.rgb(220, 220, 220));
        TextView text5 = (TextView)findViewById(R.id.text5);
        text5.setTextColor(Color.rgb(220, 220, 220));

        String player = String.valueOf(n+1);
        TextView pnt = (TextView) findViewById(R.id.pnText);
        pnt.setText(player);
        pnt.setTextColor(Color.rgb(220, 220, 220));
        TextView pnt2 = (TextView) findViewById(R.id.pnText2);
        pnt2.setText(player);
        pnt2.setTextColor(Color.rgb(220, 220, 220));

        Button yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //役職確認画面を開く
                position();
            }
        });
        //if(j<peopleNum) setScreenConfirmation(j);
    }

    void position(){ //役職確認画面
        setContentView(R.layout.activity_werewolf_position);
        TextView text10 = (TextView) findViewById(R.id.textView10);
        text10.setTextColor(Color.rgb(220, 220, 220));
        TextView poN = (TextView) findViewById(R.id.positionName);
        poN.setTextColor(Color.rgb(220, 220, 220));
        final ImageView positionImage = findViewById(R.id.imageView14);
        if(position[n] == WOLF){
            poN.setText("人狼");
            positionImage.setImageResource(R.drawable.wolf);
        }else if(position[n] == DIVINER){
            poN.setText("占い師");
            positionImage.setImageResource(R.drawable.diviner);
        }else if(position[n] == THIEF){
            poN.setText("怪盗");
            positionImage.setImageResource(R.drawable.thief);
        }else if(position[n] == TERU){
            poN.setText("てるてる");
            positionImage.setImageResource(R.drawable.teruteru);
        }else{
            poN.setText("村人");
            positionImage.setImageResource(R.drawable.villager);
        }

        Button confirm = (Button) findViewById(R.id.confirmationButton);
        confirm.setOnClickListener(new View.OnClickListener() { //役職説明画面を開く
            public void onClick(View v) {
                if (position[n] == WOLF) wolf();
                else if (position[n] == DIVINER) diviner();
                else if (position[n] == THIEF) thief();
                else if (position[n] == TERU) teru();
                else villager();
            }
        });
    }

    void wolf(){
        setContentView(R.layout.activity_werewolf_wolf);
        //狼の夜行動ここにプログラム
        n++;
        if(n<peopleNum) setScreenConfirmation();
        else morning();
    }

    void diviner(){
        setContentView(R.layout.activity_werewolf_diviner);
        //占い師の夜行動ここにプログラム
        n++;
        if(n<peopleNum) setScreenConfirmation();
        else morning();
    }

    void thief(){
        setContentView(R.layout.activity_werewolf_thief);
        //怪盗の夜行動ここにプログラム
        n++;
        if(n<peopleNum) setScreenConfirmation();
        else morning();
    }

    void teru(){
        setContentView(R.layout.activity_werewolf_teru);
        //てるてるの夜行動ここにプログラム
        n++;
        if(n<peopleNum) setScreenConfirmation();
        else morning();
    }

    void villager(){
        setContentView(R.layout.activity_werewolf_villager);
        //村人の夜行動ここにプログラム
        n++;
        if(n<peopleNum) setScreenConfirmation();
        else morning();
    }

    void morning(){
        setContentView(R.layout.activity_werewolf_morning);
        Button discStart = (Button) findViewById(R.id.morningButton);
        discStart.setOnClickListener(new View.OnClickListener() { //役職説明画面を開く
            public void onClick(View v) {
                //ディスカッション画面に移動
            }
        });
    }
}