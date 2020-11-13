package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Werewolf extends AppCompatActivity {
    int peopleNum = 3; //人数
    int[] position = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //役職セット用配列。配布直後の並び
    int[] positionTrue = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //怪盗による並び替え後の真の役職
    int[] positionView = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //会議時に役職見る用の配列。配布前の並び
    int[] voteCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //投票数カウント
    int[] execute = {'\0', '\0', '\0', '\0', '\0'}; //処刑する人の格納配列。最大５人
    int heiwa = 0;
    int wolfNum = 1, divinerNum = 1, thiefNum = 0, teruNum = 0, villagerNum = 3; //各役職の数
    public static final int WOLF = 0, DIVINER = 1, THIEF = 2, TERU = 3, VILLAGER = 4; //define
    public static final int WOLFWIN = 0, TERUWIN = 1, VILLAGERWIN = 2, HEIWA = 3; //define
    int n = 0; //プレイヤー番号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setScreenMain();
    }

    void setScreenMain(){ //最初の画面
        setContentView(R.layout.activity_werewolf);
        //各ID取得
        final TextView number = findViewById(R.id.number);
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
        //各役職の数によって画像をセット
        if(position[0] == WOLF) img1.setImageResource(R.drawable.wolf);
        else if(position[0] == DIVINER) img1.setImageResource(R.drawable.diviner);
        else if(position[0] == THIEF) img1.setImageResource(R.drawable.thief);
        else if(position[0] == TERU) img1.setImageResource(R.drawable.teruteru);
        else img1.setImageResource(R.drawable.villager);
        if(position[1] == WOLF) img2.setImageResource(R.drawable.wolf);
        else if(position[1] == DIVINER) img2.setImageResource(R.drawable.diviner);
        else if(position[1] == THIEF) img2.setImageResource(R.drawable.thief);
        else if(position[1] == TERU) img2.setImageResource(R.drawable.teruteru);
        else img2.setImageResource(R.drawable.villager);
        if(position[2] == WOLF) img3.setImageResource(R.drawable.wolf);
        else if(position[2] == DIVINER) img3.setImageResource(R.drawable.diviner);
        else if(position[2] == THIEF) img3.setImageResource(R.drawable.thief);
        else if(position[2] == TERU) img3.setImageResource(R.drawable.teruteru);
        else img3.setImageResource(R.drawable.villager);
        if(position[3] == WOLF) img4.setImageResource(R.drawable.wolf);
        else if(position[3] == DIVINER) img4.setImageResource(R.drawable.diviner);
        else if(position[3] == THIEF) img4.setImageResource(R.drawable.thief);
        else if(position[3] == TERU) img4.setImageResource(R.drawable.teruteru);
        else img4.setImageResource(R.drawable.villager);
        if(position[4] == WOLF) img5.setImageResource(R.drawable.wolf);
        else if(position[4] == DIVINER) img5.setImageResource(R.drawable.diviner);
        else if(position[4] == THIEF) img5.setImageResource(R.drawable.thief);
        else if(position[4] == TERU) img5.setImageResource(R.drawable.teruteru);
        else img5.setImageResource(R.drawable.villager);
        if(peopleNum<4) img6.setVisibility(INVISIBLE);
        if(position[5] == WOLF) img6.setImageResource(R.drawable.wolf);
        else if(position[5] == DIVINER) img6.setImageResource(R.drawable.diviner);
        else if(position[5] == THIEF) img6.setImageResource(R.drawable.thief);
        else if(position[5] == TERU) img6.setImageResource(R.drawable.teruteru);
        else img6.setImageResource(R.drawable.villager);
        if(peopleNum<5) img7.setVisibility(INVISIBLE);
        if(position[6] == WOLF) img7.setImageResource(R.drawable.wolf);
        else if(position[6] == DIVINER) img7.setImageResource(R.drawable.diviner);
        else if(position[6] == THIEF) img7.setImageResource(R.drawable.thief);
        else if(position[6] == TERU) img7.setImageResource(R.drawable.teruteru);
        else img7.setImageResource(R.drawable.villager);
        if(peopleNum<6) img8.setVisibility(INVISIBLE);
        if(position[7] == WOLF) img8.setImageResource(R.drawable.wolf);
        else if(position[7] == DIVINER) img8.setImageResource(R.drawable.diviner);
        else if(position[7] == THIEF) img8.setImageResource(R.drawable.thief);
        else if(position[7] == TERU) img8.setImageResource(R.drawable.teruteru);
        else img8.setImageResource(R.drawable.villager);
        if(peopleNum<7) img9.setVisibility(INVISIBLE);
        if(position[8] == WOLF) img9.setImageResource(R.drawable.wolf);
        else if(position[8] == DIVINER) img9.setImageResource(R.drawable.diviner);
        else if(position[8] == THIEF) img9.setImageResource(R.drawable.thief);
        else if(position[8] == TERU) img9.setImageResource(R.drawable.teruteru);
        else img9.setImageResource(R.drawable.villager);
        if(peopleNum<8) img10.setVisibility(INVISIBLE);
        if(position[9] == WOLF) img10.setImageResource(R.drawable.wolf);
        else if(position[9] == DIVINER) img10.setImageResource(R.drawable.diviner);
        else if(position[9] == THIEF) img10.setImageResource(R.drawable.thief);
        else if(position[9] == TERU) img10.setImageResource(R.drawable.teruteru);
        else img10.setImageResource(R.drawable.villager);
        if(peopleNum<9) img11.setVisibility(INVISIBLE);
        if(position[10] == WOLF) img11.setImageResource(R.drawable.wolf);
        else if(position[10] == DIVINER) img11.setImageResource(R.drawable.diviner);
        else if(position[10] == THIEF) img11.setImageResource(R.drawable.thief);
        else if(position[10] == TERU) img11.setImageResource(R.drawable.teruteru);
        else img11.setImageResource(R.drawable.villager);
        if(peopleNum<10) img12.setVisibility(INVISIBLE);
        if(position[11] == WOLF) img12.setImageResource(R.drawable.wolf);
        else if(position[11] == DIVINER) img12.setImageResource(R.drawable.diviner);
        else if(position[11] == THIEF) img12.setImageResource(R.drawable.thief);
        else if(position[11] == TERU) img12.setImageResource(R.drawable.teruteru);
        else img12.setImageResource(R.drawable.villager);

        Button back = (Button)findViewById(R.id.back); //トップメニューに戻るボタン
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Werewolf.this,MainActivity.class);
                startActivity(intent);
            }
        });

        final Button up = (Button)findViewById(R.id.up);
        final Button down = (Button)findViewById(R.id.down);
        up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //プレイ人数増加
                peopleNum++;
                if(peopleNum==10) up.setEnabled(false);
                if(peopleNum==4) down.setEnabled(true);
                String pn = String.valueOf(peopleNum);
                number.setText(pn);
                if(peopleNum==4){ img6.setVisibility(VISIBLE); } //画像追加表示
                if(peopleNum==5){ img7.setVisibility(VISIBLE); }
                if(peopleNum==6){ img8.setVisibility(VISIBLE); }
                if(peopleNum==7){ img9.setVisibility(VISIBLE); }
                if(peopleNum==8){ img10.setVisibility(VISIBLE); }
                if(peopleNum==9){ img11.setVisibility(VISIBLE); }
                if(peopleNum==10){ img12.setVisibility(VISIBLE); }
                villagerNum = (peopleNum+2)-wolfNum-divinerNum-thiefNum-teruNum;
            }
        });
        down.setEnabled(false);
        down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //プレイ人数減少
                peopleNum--;
                if(peopleNum==3) down.setEnabled(false);
                if(peopleNum==9) up.setEnabled(true);
                String pn = String.valueOf(peopleNum);
                number.setText(pn);
                if(peopleNum==3){ img6.setVisibility(INVISIBLE); } //画像非表示
                if(peopleNum==4){ img7.setVisibility(INVISIBLE); }
                if(peopleNum==5){ img8.setVisibility(INVISIBLE); }
                if(peopleNum==6){ img9.setVisibility(INVISIBLE); }
                if(peopleNum==7){ img10.setVisibility(INVISIBLE); }
                if(peopleNum==8){ img11.setVisibility(INVISIBLE); }
                if(peopleNum==9){ img12.setVisibility(INVISIBLE); }
                villagerNum = (peopleNum+2)-wolfNum-divinerNum-thiefNum-teruNum;
            }
        });

        positionConfig.setOnClickListener(new View.OnClickListener() { //人数設定画面を開く
            public void onClick(View view) { setScreenConfig();
            }
        }); //人数設定画面を開く

        start.setOnClickListener(new View.OnClickListener() { //配役シャッフル＆イントロを開く
            public void onClick(View view) { //ゲームスタート
                //役職シャッフル
                Random rnd = new Random();
                for (int i = peopleNum+2; i > 1; i--) {
                    int index = rnd.nextInt(i);
                    int tmp = position[index];
                    position[index] = position[i-1];
                    positionTrue[index] = position[i-1];
                    position[i-1] = tmp;
                    positionTrue[i-1] = tmp;
                }
                System.out.println(Arrays.toString(position)); //シャッフル後の配列をLogcatに表示

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
                        setScreenConfirmation(); //プレイヤー確認画面を開く
                    }
                });
            }
        });
    }


    void setScreenConfig(){ //役職設定
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

        final Button upw = (Button)findViewById(R.id.upWolf);
        final Button downw = (Button)findViewById(R.id.downWolf);
        final Button upd = (Button)findViewById(R.id.upDiviner);
        final Button downd = (Button)findViewById(R.id.downDiviner);
        final Button upth = (Button)findViewById(R.id.upThief);
        final Button downth = (Button)findViewById(R.id.downThief);
        final Button upte = (Button)findViewById(R.id.upTeru);
        final Button downte = (Button)findViewById(R.id.downTeru);

        downw.setEnabled(false);
        upw.setOnClickListener(new View.OnClickListener() { //狼の数増加
            public void onClick(View view) {
                wolfNum++;
                villagerNum--;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String wn = String.valueOf(wolfNum);
                wNumber.setText(wn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        downw.setOnClickListener(new View.OnClickListener() {  //狼の数減少
            public void onClick(View view) {
                wolfNum--;
                villagerNum++;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String wn = String.valueOf(wolfNum);
                wNumber.setText(wn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        upd.setOnClickListener(new View.OnClickListener() { //占い師の数増加
            public void onClick(View view) {
                divinerNum++;
                villagerNum--;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String dn = String.valueOf(divinerNum);
                dNumber.setText(dn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        downd.setOnClickListener(new View.OnClickListener() { //占い師の数減少
            public void onClick(View view) {
                divinerNum--;
                villagerNum++;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String dn = String.valueOf(divinerNum);
                dNumber.setText(dn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        downth.setEnabled(false);
        upth.setOnClickListener(new View.OnClickListener() { //怪盗の数増加
            public void onClick(View view) {
                thiefNum++;
                villagerNum--;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String thn = String.valueOf(thiefNum);
                thNumber.setText(thn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        downth.setOnClickListener(new View.OnClickListener() { //怪盗の数減少
            public void onClick(View view) {
                thiefNum--;
                villagerNum++;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String thn = String.valueOf(thiefNum);
                thNumber.setText(thn);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        downte.setEnabled(false);
        upte.setOnClickListener(new View.OnClickListener() { //てるてるの数増加
            public void onClick(View view) {
                teruNum++;
                villagerNum--;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String ten = String.valueOf(teruNum);
                teNumber.setText(ten);
                changeVillagerNum(vNumber, villagerNum);
            }
        });
        downte.setOnClickListener(new View.OnClickListener() { //てるてるの数減少
            public void onClick(View view) {
                teruNum--;
                villagerNum++;
                buttonJudge(upw, downw, upd, downd, upth, downth, upte, downte);
                String ten = String.valueOf(teruNum);
                teNumber.setText(ten);
                changeVillagerNum(vNumber, villagerNum);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) { //設定完了。最初の画面に戻る
                setArray(peopleNum, wolfNum, divinerNum, thiefNum, teruNum); //各役職の数を配列に反映
                setScreenMain();
                final TextView number = findViewById(R.id.number);
                String pn = String.valueOf(peopleNum);
                number.setText(pn);
            }
        });
    }

    void buttonJudge(Button upw, Button downw, Button upd, Button downd, Button upth, Button downth, Button upte, Button downte){
        if(wolfNum==(peopleNum+2)-divinerNum-thiefNum-teruNum-1) upw.setEnabled(false);
        if(wolfNum==(peopleNum+2)-divinerNum-thiefNum-teruNum-1-1) upw.setEnabled(true);
        if(wolfNum==1) downw.setEnabled(false);
        if(wolfNum==2) downw.setEnabled(true);
        if(divinerNum==(peopleNum+2)-wolfNum-thiefNum-teruNum-1) upd.setEnabled(false);
        if(divinerNum==(peopleNum+2)-wolfNum-thiefNum-teruNum-1-1) upd.setEnabled(true);
        if(divinerNum==0) downd.setEnabled(false);
        if(divinerNum==1) downd.setEnabled(true);
        if(thiefNum==1){
            upth.setEnabled(false);
            downth.setEnabled(true);
            if(thiefNum==(peopleNum+2)-wolfNum-divinerNum-teruNum-1) upth.setEnabled(false);
        }
        if(thiefNum==0){
            downth.setEnabled(false);
            upth.setEnabled(true);
            if(thiefNum==(peopleNum+2)-wolfNum-divinerNum-teruNum-1) upth.setEnabled(false);
        }
        if(teruNum==1){
            upte.setEnabled(false);
            downte.setEnabled(true);
            if(teruNum==(peopleNum+2)-wolfNum-divinerNum-thiefNum-1) upte.setEnabled(false);
        }
        else if(teruNum==0){
            upte.setEnabled(true);
            downte.setEnabled(false);
            if(teruNum==(peopleNum+2)-wolfNum-divinerNum-thiefNum-1) upte.setEnabled(false);
        }
    }

    void changeVillagerNum(TextView vNumber,int villagerNum){ //変更後の村人数表示
        String vn = String.valueOf(villagerNum);
        vNumber.setText(vn);
    }

    void setArray(int pn, int wn, int dn, int thn, int ten){ //各役職の数を配列に反映
        int i = 0;
        while (i<wn){
            position[i] = WOLF;
            positionView[i] = WOLF;
            i++;
        }
        while (i<wn+dn){
            if(dn==0) break;
            position[i] = DIVINER;
            positionView[i] = DIVINER;
            i++;
        }
        while (i<wn+dn+thn){
            if(thn==0) break;
            position[i] = THIEF;
            positionView[i] = THIEF;
            i++;
        }
        while (i<wn+dn+thn+ten){
            if(ten==0) break;
            position[i] = TERU;
            positionView[i] = TERU;
            i++;
        }
        while (i<pn+2){
            position[i] = VILLAGER;
            positionView[i] = VILLAGER;
            i++;
        }
        System.out.println(Arrays.toString(position)); //シャッフル前の配列をLogcatに表示
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
        TextView pnt = (TextView) findViewById(R.id.pnText); //プレイヤーxに端末を渡してください
        pnt.setText(player);
        pnt.setTextColor(Color.rgb(220, 220, 220));
        TextView pnt2 = (TextView) findViewById(R.id.pnText2); //プレイヤーxですか？
        pnt2.setText(player);
        pnt2.setTextColor(Color.rgb(220, 220, 220));

        Button yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //役職確認画面を開く
                position();
            }
        });
    }

    void position(){ //役職確認画面
        setContentView(R.layout.activity_werewolf_position);
        TextView text10 = (TextView) findViewById(R.id.textView10); //あなたの役職は…
        text10.setTextColor(Color.rgb(220, 220, 220));
        TextView poN = (TextView) findViewById(R.id.positionName); //役職名
        poN.setTextColor(Color.rgb(220, 220, 220));
        final ImageView positionImage = findViewById(R.id.imageView14); //役職画像
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

        Button confirm = (Button) findViewById(R.id.confirmationButton); //OKボタン
        confirm.setOnClickListener(new View.OnClickListener() { //役職説明画面を開く
            public void onClick(View v) { //各役職の夜行動へ
                if (position[n] == WOLF) wolf();
                else if (position[n] == DIVINER) diviner();
                else if (position[n] == THIEF) thief();
                else if (position[n] == TERU) teru();
                else villager();
            }
        });
    }

    void wolf(){ //狼の夜行動
        setContentView(R.layout.activity_werewolf_wolf);
        TextView text11 = (TextView) findViewById(R.id.textView11);
        text11.setTextColor(Color.rgb(220, 220, 220));
        TextView text12 = (TextView) findViewById(R.id.textView12);
        text12.setTextColor(Color.rgb(220, 220, 220));
        TextView text13 = (TextView) findViewById(R.id.textView13);
        text13.setTextColor(Color.rgb(220, 220, 220));

        Button checkM = (Button) findViewById(R.id.checkMember);
        checkM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int i = 0;
                int member = 0; //仲間確認用変数
                while(i<peopleNum){
                    if(position[i]==WOLF) member++;
                    i++;
                }
                if(member==1){
                    setContentView(R.layout.activity_werewolf_wolf_nomember);
                    TextView text14 = (TextView) findViewById(R.id.textView14); //仲間はいませんでした。
                    text14.setTextColor(Color.rgb(220, 220, 220));
                    Button noMem = (Button) findViewById(R.id.noMember);
                    noMem.setOnClickListener(new View.OnClickListener() { //OKボタン
                        public void onClick(View v) {
                            n++;
                            if(n<peopleNum) setScreenConfirmation(); //次の人の処理
                            else morning(); //夜終わり
                        }
                    });
                }else{
                    setContentView(R.layout.activity_werewolf_wolf_member);
                    TextView text15 = (TextView) findViewById(R.id.textView15); //仲間は…
                    text15.setTextColor(Color.rgb(220, 220, 220));
                    TextView text16 = (TextView) findViewById(R.id.textView16); //仲間をお間違えなきよう…
                    text16.setTextColor(Color.rgb(220, 220, 220));
                    //仲間表示テキストID取得
                    TextView mem1 = (TextView) findViewById(R.id.member1);
                    mem1.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem2 = (TextView) findViewById(R.id.member2);
                    mem2.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem3 = (TextView) findViewById(R.id.member3);
                    mem3.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem4 = (TextView) findViewById(R.id.member4);
                    mem4.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem5 = (TextView) findViewById(R.id.member5);
                    mem5.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem6 = (TextView) findViewById(R.id.member6);
                    mem6.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem7 = (TextView) findViewById(R.id.member7);
                    mem7.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem8 = (TextView) findViewById(R.id.member8);
                    mem8.setTextColor(Color.rgb(220, 220, 220));
                    TextView mem9 = (TextView) findViewById(R.id.member9);
                    mem9.setTextColor(Color.rgb(220, 220, 220));
                    if(member<=2) mem2.setVisibility(INVISIBLE);
                    if(member<=3) mem3.setVisibility(INVISIBLE);
                    if(member<=4) mem4.setVisibility(INVISIBLE);
                    if(member<=5) mem5.setVisibility(INVISIBLE);
                    if(member<=6) mem6.setVisibility(INVISIBLE);
                    if(member<=7) mem7.setVisibility(INVISIBLE);
                    if(member<=8) mem8.setVisibility(INVISIBLE);
                    if(member<=9) mem9.setVisibility(INVISIBLE);
                    //仲間表示
                    int z=0, y=0, x=0, w=0, u=0, t=0, s=0, r=0, q=0;
                    String m1, m2, m3, m4, m5, m6, m7, m8, m9;
                    for(z=y; z<peopleNum; z++){
                        if(position[z]==WOLF && z>y && z!=n && member>=9) {
                            m9 = String.valueOf(z+1);
                            mem9.setText("プレイヤー" + m9);
                            break;
                        }
                        for(y=x; y<peopleNum; y++){
                            if(position[y]==WOLF && y>x && y!=n && member>=8) {
                                m8 = String.valueOf(y+1);
                                mem8.setText("プレイヤー" + m8);
                                break;
                            }
                            for(x=w; x<peopleNum; x++) {
                                if(position[x]==WOLF && x>w && x!=n && member>=7) {
                                    m7 = String.valueOf(x+1);
                                    mem7.setText("プレイヤー" + m7);
                                    break;
                                }
                                for (w=u; w<peopleNum; w++) {
                                    if(position[w]==WOLF && w>u && w!=n && member>=6) {
                                        m6 = String.valueOf(w+1);
                                        mem6.setText("プレイヤー" + m6);
                                        break;
                                    }
                                    for (u=t; u<peopleNum; u++) {
                                        if(position[u]==WOLF && u>t && u!=n && member>=5) {
                                            m5 = String.valueOf(u+1);
                                            mem5.setText("プレイヤー" + m5);
                                            break;
                                        }
                                        for (t=s; t<peopleNum; t++) {
                                            if(position[t]==WOLF && t>s && t!=n && member>=4) {
                                                m4 = String.valueOf(t+1);
                                                mem4.setText("プレイヤー" + m4);
                                                break;
                                            }
                                            for (s=r; s<peopleNum; s++) {
                                                if(position[s]==WOLF && s>r && s!=n && member>=3) {
                                                    m3 = String.valueOf(s+1);
                                                    mem3.setText("プレイヤー" + m3);
                                                    break;
                                                }
                                                for (r=q; r<peopleNum; r++) {
                                                    if(position[r]==WOLF && r>q && r!=n && member>=2) {
                                                        m2 = String.valueOf(r+1);
                                                        mem2.setText("プレイヤー" + m2);
                                                        break;
                                                    }
                                                    for (q=0; q<peopleNum; q++) {
                                                        if (position[q]==WOLF && q!=n) {
                                                            m1 = String.valueOf(q+1);
                                                            mem1.setText("プレイヤー" + m1);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Button okMem = (Button) findViewById(R.id.okMember);
                    okMem.setOnClickListener(new View.OnClickListener() { //OKボタン
                        public void onClick(View v) {
                            n++;
                            if(n<peopleNum) setScreenConfirmation(); //次の人の処理
                            else morning(); //夜終わり
                        }
                    });
                }
            }
        });
    }

    void diviner(){ //占い師の夜行動
        setContentView(R.layout.activity_werewolf_diviner);
        TextView divt1 = (TextView) findViewById(R.id.divText1);
        divt1.setTextColor(Color.rgb(220, 220, 220));
        TextView divt2 = (TextView) findViewById(R.id.divText2);
        divt2.setTextColor(Color.rgb(220, 220, 220));
        TextView divt3 = (TextView) findViewById(R.id.divText3);
        divt3.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton divine1 = (RadioButton) findViewById(R.id.divine1);
        divine1.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton divine2 = (RadioButton) findViewById(R.id.divine2);
        divine2.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton divine3 = (RadioButton) findViewById(R.id.divine3);
        divine3.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<4) divine3.setVisibility(INVISIBLE);
        final RadioButton divine4 = (RadioButton) findViewById(R.id.divine4);
        divine4.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<5) divine4.setVisibility(INVISIBLE);
        final RadioButton divine5 = (RadioButton) findViewById(R.id.divine5);
        divine5.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<6) divine5.setVisibility(INVISIBLE);
        final RadioButton divine6 = (RadioButton) findViewById(R.id.divine6);
        divine6.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<7) divine6.setVisibility(INVISIBLE);
        final RadioButton divine7 = (RadioButton) findViewById(R.id.divine7);
        divine7.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<8) divine7.setVisibility(INVISIBLE);
        final RadioButton divine8 = (RadioButton) findViewById(R.id.divine8);
        divine8.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<9) divine8.setVisibility(INVISIBLE);
        final RadioButton divine9 = (RadioButton) findViewById(R.id.divine9);
        divine9.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<10) divine9.setVisibility(INVISIBLE);
        int z=0, y=0, x=0, w=0, u=0, t=0, s=0, r=0, q=0;
        String m1="1", m2="1", m3="1", m4="1", m5="1", m6="1", m7="1", m8="1", m9="1";
        for(z=y; z<peopleNum; z++){
            if(z>y && z!=n) {
                m9 = String.valueOf(z+1);
                divine9.setText("プレイヤー" + m9);
                break;
            }
            for(y=x; y<peopleNum; y++){
                if(y>x && y!=n) {
                    m8 = String.valueOf(y+1);
                    divine8.setText("プレイヤー" + m8);
                    break;
                }
                for(x=w; x<peopleNum; x++) {
                    if(x>w && x!=n) {
                        m7 = String.valueOf(x+1);
                        divine7.setText("プレイヤー" + m7);
                        break;
                    }
                    for (w=u; w<peopleNum; w++) {
                        if(w>u && w!=n) {
                            m6 = String.valueOf(w+1);
                            divine6.setText("プレイヤー" + m6);
                            break;
                        }
                        for (u=t; u<peopleNum; u++) {
                            if(u>t && u!=n) {
                                m5 = String.valueOf(u+1);
                                divine5.setText("プレイヤー" + m5);
                                break;
                            }
                            for (t=s; t<peopleNum; t++) {
                                if(t>s && t!=n) {
                                    m4 = String.valueOf(t+1);
                                    divine4.setText("プレイヤー" + m4);
                                    break;
                                }
                                for (s=r; s<peopleNum; s++) {
                                    if(s>r && s!=n) {
                                        m3 = String.valueOf(s+1);
                                        divine3.setText("プレイヤー" + m3);
                                        break;
                                    }
                                    for (r=q; r<peopleNum; r++) {
                                        if(r>q && r!=n) {
                                            m2 = String.valueOf(r+1);
                                            divine2.setText("プレイヤー" + m2);
                                            break;
                                        }
                                        for (q=0; q<peopleNum; q++) {
                                            if (q!=n) {
                                                m1 = String.valueOf(q+1);
                                                divine1.setText("プレイヤー" + m1);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        final Button divine = (Button) findViewById(R.id.divine);
        divine.setEnabled(false);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.divinerSelect);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                divine.setEnabled(true);
            }
        });
        final String finalM1 = m1;
        final String finalM2 = m2;
        final String finalM3 = m3;
        final String finalM4 = m4;
        final String finalM5 = m5;
        final String finalM6 = m6;
        final String finalM7 = m7;
        final String finalM8 = m8;
        final String finalM9 = m9;
        divine.setOnClickListener(new View.OnClickListener() { //OKボタン
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.divinerSelect);
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton) findViewById(checkedId);
                String text = selected.getText().toString();
                String text1 = divine1.getText().toString();
                String text2 = divine2.getText().toString();
                String text3 = divine3.getText().toString();
                String text4 = divine4.getText().toString();
                String text5 = divine5.getText().toString();
                String text6 = divine6.getText().toString();
                String text7 = divine7.getText().toString();
                String text8 = divine8.getText().toString();
                String text9 = divine9.getText().toString();
                if(text.equals(text1)) divinePosition(finalM1);
                else if(text.equals(text2)) divinePosition(finalM2);
                else if(text.equals(text3)) divinePosition(finalM3);
                else if(text.equals(text4)) divinePosition(finalM4);
                else if(text.equals(text5)) divinePosition(finalM5);
                else if(text.equals(text6)) divinePosition(finalM6);
                else if(text.equals(text7)) divinePosition(finalM7);
                else if(text.equals(text8)) divinePosition(finalM8);
                else if(text.equals(text9)) divinePosition(finalM9);
            }
        });
        Button left = (Button) findViewById(R.id.leftCard);
        left.setOnClickListener(new View.OnClickListener() { //残り２枚を見る
            public void onClick(View v) {
                setContentView(R.layout.activity_werewolf_diviner_left);
                TextView left1 = (TextView) findViewById(R.id.leftText); //残り２枚は…
                left1.setTextColor(Color.rgb(220, 220, 220));
                TextView leftC1 = (TextView) findViewById(R.id.leftPosition); //残り役職その１
                leftC1.setTextColor(Color.rgb(220, 220, 220));
                if(position[peopleNum] == WOLF) leftC1.setText("人狼");
                else if(position[peopleNum] == DIVINER) leftC1.setText("占い師");
                else if(position[peopleNum] == THIEF) leftC1.setText("怪盗");
                else if(position[peopleNum] == TERU) leftC1.setText("てるてる");
                else leftC1.setText("村人");
                TextView leftC2 = (TextView) findViewById(R.id.leftPosition2); //残り役職その２
                leftC2.setTextColor(Color.rgb(220, 220, 220));
                if(position[peopleNum+1] == WOLF) leftC2.setText("人狼");
                else if(position[peopleNum+1] == DIVINER) leftC2.setText("占い師");
                else if(position[peopleNum+1] == THIEF) leftC2.setText("怪盗");
                else if(position[peopleNum+1] == TERU) leftC2.setText("てるてる");
                else leftC2.setText("村人");
                ImageView leftImage1 = (ImageView) findViewById(R.id.leftCardImage); //残り役職イメージその１
                if(position[peopleNum] == WOLF) leftImage1.setImageResource(R.drawable.wolf);
                else if(position[peopleNum] == DIVINER) leftImage1.setImageResource(R.drawable.diviner);
                else if(position[peopleNum] == THIEF) leftImage1.setImageResource(R.drawable.thief);
                else if(position[peopleNum] == TERU) leftImage1.setImageResource(R.drawable.teruteru);
                else leftImage1.setImageResource(R.drawable.villager);
                ImageView leftImage2 = (ImageView) findViewById(R.id.leftCardImage2); //残り役職イメージその２
                if(position[peopleNum+1] == WOLF) leftImage2.setImageResource(R.drawable.wolf);
                else if(position[peopleNum+1] == DIVINER) leftImage2.setImageResource(R.drawable.diviner);
                else if(position[peopleNum+1] == THIEF) leftImage2.setImageResource(R.drawable.thief);
                else if(position[peopleNum+1] == TERU) leftImage2.setImageResource(R.drawable.teruteru);
                else leftImage2.setImageResource(R.drawable.villager);
                Button leftOK = (Button) findViewById(R.id.leftCardOK);
                leftOK.setOnClickListener(new View.OnClickListener() { //OKボタン
                    public void onClick(View v) {
                        n++;
                        if (n < peopleNum) setScreenConfirmation(); //次の人の処理
                        else morning(); //夜終わり
                    }
                });
            }
        });
    }

    void thief(){ //怪盗の夜行動
        setContentView(R.layout.activity_werewolf_thief);
        TextView thieft = (TextView) findViewById(R.id.textView19);
        thieft.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton change1 = (RadioButton) findViewById(R.id.change1);
        change1.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton change2 = (RadioButton) findViewById(R.id.change2);
        change2.setTextColor(Color.rgb(220, 220, 220));
        final RadioButton change3 = (RadioButton) findViewById(R.id.change3);
        change3.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<4) change3.setVisibility(INVISIBLE);
        final RadioButton change4 = (RadioButton) findViewById(R.id.change4);
        change4.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<5) change4.setVisibility(INVISIBLE);
        final RadioButton change5 = (RadioButton) findViewById(R.id.change5);
        change5.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<6) change5.setVisibility(INVISIBLE);
        final RadioButton change6 = (RadioButton) findViewById(R.id.change6);
        change6.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<7) change6.setVisibility(INVISIBLE);
        final RadioButton change7 = (RadioButton) findViewById(R.id.change7);
        change7.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<8) change7.setVisibility(INVISIBLE);
        final RadioButton change8 = (RadioButton) findViewById(R.id.change8);
        change8.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<9) change8.setVisibility(INVISIBLE);
        final RadioButton change9 = (RadioButton) findViewById(R.id.change9);
        change9.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<10) change9.setVisibility(INVISIBLE);
        int z=0, y=0, x=0, w=0, u=0, t=0, s=0, r=0, q=0;
        String m1="1", m2="1", m3="1", m4="1", m5="1", m6="1", m7="1", m8="1", m9="1";
        for(z=y; z<peopleNum; z++){
            if(z>y && z!=n) {
                m9 = String.valueOf(z+1);
                change9.setText("プレイヤー" + m9);
                break;
            }
            for(y=x; y<peopleNum; y++){
                if(y>x && y!=n) {
                    m8 = String.valueOf(y+1);
                    change8.setText("プレイヤー" + m8);
                    break;
                }
                for(x=w; x<peopleNum; x++) {
                    if(x>w && x!=n) {
                        m7 = String.valueOf(x+1);
                        change7.setText("プレイヤー" + m7);
                        break;
                    }
                    for (w=u; w<peopleNum; w++) {
                        if(w>u && w!=n) {
                            m6 = String.valueOf(w+1);
                            change6.setText("プレイヤー" + m6);
                            break;
                        }
                        for (u=t; u<peopleNum; u++) {
                            if(u>t && u!=n) {
                                m5 = String.valueOf(u+1);
                                change5.setText("プレイヤー" + m5);
                                break;
                            }
                            for (t=s; t<peopleNum; t++) {
                                if(t>s && t!=n) {
                                    m4 = String.valueOf(t+1);
                                    change4.setText("プレイヤー" + m4);
                                    break;
                                }
                                for (s=r; s<peopleNum; s++) {
                                    if(s>r && s!=n) {
                                        m3 = String.valueOf(s+1);
                                        change3.setText("プレイヤー" + m3);
                                        break;
                                    }
                                    for (r=q; r<peopleNum; r++) {
                                        if(r>q && r!=n) {
                                            m2 = String.valueOf(r+1);
                                            change2.setText("プレイヤー" + m2);
                                            break;
                                        }
                                        for (q=0; q<peopleNum; q++) {
                                            if (q!=n) {
                                                m1 = String.valueOf(q+1);
                                                change1.setText("プレイヤー" + m1);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        final Button change = (Button) findViewById(R.id.change);
        change.setEnabled(false);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.thiefSelect);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                change.setEnabled(true);
            }
        });
        Button noChange = (Button) findViewById(R.id.noChange);
        final String finalM1 = m1;
        final String finalM2 = m2;
        final String finalM3 = m3;
        final String finalM4 = m4;
        final String finalM5 = m5;
        final String finalM6 = m6;
        final String finalM7 = m7;
        final String finalM8 = m8;
        final String finalM9 = m9;
        change.setOnClickListener(new View.OnClickListener() { //交換ボタン
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.thiefSelect);
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton) findViewById(checkedId);
                String text = selected.getText().toString();
                String text1 = change1.getText().toString();
                String text2 = change2.getText().toString();
                String text3 = change3.getText().toString();
                String text4 = change4.getText().toString();
                String text5 = change5.getText().toString();
                String text6 = change6.getText().toString();
                String text7 = change7.getText().toString();
                String text8 = change8.getText().toString();
                String text9 = change9.getText().toString();
                if(text.equals(text1)) changePosition(finalM1);
                else if(text.equals(text2)) changePosition(finalM2);
                else if(text.equals(text3)) changePosition(finalM3);
                else if(text.equals(text4)) changePosition(finalM4);
                else if(text.equals(text5)) changePosition(finalM5);
                else if(text.equals(text6)) changePosition(finalM6);
                else if(text.equals(text7)) changePosition(finalM7);
                else if(text.equals(text8)) changePosition(finalM8);
                else if(text.equals(text9)) changePosition(finalM9);
            }
        });
        noChange.setOnClickListener(new View.OnClickListener() { //交換しないボタン
            public void onClick(View v) {
                setContentView(R.layout.activity_werewolf_thief_not_changed);
                TextView text = (TextView) findViewById(R.id.noChangeText);
                text.setTextColor(Color.rgb(220, 220, 220));
                Button okNoChange = (Button) findViewById(R.id.noChangeOK);
                okNoChange.setOnClickListener(new View.OnClickListener() { //OKボタン
                    public void onClick(View v) {
                        n++;
                        if (n < peopleNum) setScreenConfirmation(); //次の人の処理
                        else morning(); //夜終わり
                    }
                });
            }
        });
    }

    void teru(){ //てるてるの夜行動
        setContentView(R.layout.activity_werewolf_teru);
        final TextView terut1 = (TextView) findViewById(R.id.teruText1);
        terut1.setTextColor(Color.rgb(220, 220, 220));
        final TextView terut2 = (TextView) findViewById(R.id.teruText2);
        terut2.setTextColor(Color.rgb(220, 220, 220));
        final TextView terut3 = (TextView) findViewById(R.id.teruText3);
        terut3.setTextColor(Color.rgb(220, 220, 220));
        Button okTeru = (Button) findViewById(R.id.teruOK);
        okTeru.setOnClickListener(new View.OnClickListener() { //OKボタン
            int c = 0;
            public void onClick(View v) {
                if(c==0){
                    terut1.setText("あなたは処刑願望に目覚めた。");
                    terut2.setVisibility(INVISIBLE);
                    terut3.setVisibility(INVISIBLE);
                    c++;
                }else{
                    terut1.setText("てるてるはどの陣営にも属さず、");
                    terut2.setVisibility(VISIBLE);
                    terut3.setVisibility(VISIBLE);
                    c = 0;
                    n++;
                    if (n < peopleNum) setScreenConfirmation(); //次の人の処理
                    else morning(); //夜終わり
                }
            }
        });
    }

    void villager(){ //村人の夜行動
        setContentView(R.layout.activity_werewolf_villager);
        final TextView vilt1 = (TextView) findViewById(R.id.vilText1);
        vilt1.setTextColor(Color.rgb(220, 220, 220));
        final TextView vilt2 = (TextView) findViewById(R.id.vilText2);
        vilt2.setTextColor(Color.rgb(220, 220, 220));
        final TextView vilt3 = (TextView) findViewById(R.id.vilText3);
        vilt3.setTextColor(Color.rgb(220, 220, 220));
        Button okVil = (Button) findViewById(R.id.vilOK);
        okVil.setOnClickListener(new View.OnClickListener() { //OKボタン
            int c = 0;
            public void onClick(View v) {
                if(c==0){
                    vilt1.setText("あなたは何もせず夜を過ごした。");
                    vilt2.setVisibility(INVISIBLE);
                    vilt3.setVisibility(INVISIBLE);
                    c++;
                }else{
                    vilt1.setText("村人はただの一般人だ。");
                    vilt2.setVisibility(VISIBLE);
                    vilt3.setVisibility(VISIBLE);
                    c = 0;
                    n++;
                    if (n < peopleNum) setScreenConfirmation(); //次の人の処理
                    else morning(); //夜終わり
                }
            }
        });
    }

    void divinePosition(String m){ //占い処理
        setContentView(R.layout.activity_werewolf_diviner_divined);
        TextView divedT = (TextView) findViewById(R.id.divedText);
        divedT.setTextColor(Color.rgb(220, 220, 220));
        TextView divedT2 = (TextView) findViewById(R.id.divedText2);
        divedT2.setTextColor(Color.rgb(220, 220, 220));
        TextView divedT3 = (TextView) findViewById(R.id.divedText3);
        divedT3.setTextColor(Color.rgb(220, 220, 220));
        TextView divedPn = (TextView) findViewById(R.id.divedPn);
        divedPn.setTextColor(Color.rgb(220, 220, 220));
        divedPn.setText(m);
        TextView divedPosition = (TextView) findViewById(R.id.divPosition);
        divedPosition.setTextColor(Color.rgb(220, 220, 220));
        if(position[Integer.parseInt(m)-1] == WOLF) divedPosition.setText("人狼");
        else if(position[Integer.parseInt(m)-1] == DIVINER) divedPosition.setText("占い師");
        else if(position[Integer.parseInt(m)-1] == THIEF) divedPosition.setText("怪盗");
        else if(position[Integer.parseInt(m)-1] == TERU) divedPosition.setText("てるてる");
        else divedPosition.setText("村人");
        ImageView divIm = (ImageView) findViewById(R.id.divedImage);
        if(position[Integer.parseInt(m)-1] == WOLF) divIm.setImageResource(R.drawable.wolf);
        else if(position[Integer.parseInt(m)-1] == DIVINER) divIm.setImageResource(R.drawable.diviner);
        else if(position[Integer.parseInt(m)-1] == THIEF) divIm.setImageResource(R.drawable.thief);
        else if(position[Integer.parseInt(m)-1] == TERU) divIm.setImageResource(R.drawable.teruteru);
        else divIm.setImageResource(R.drawable.villager);
        Button okDiv = (Button) findViewById(R.id.divineOK);
        okDiv.setOnClickListener(new View.OnClickListener() { //OKボタン
            public void onClick(View v) {
                n++;
                if(n<peopleNum) setScreenConfirmation(); //次の人の処理
                else morning(); //夜終わり
            }
        });
    }

    void changePosition(String m){ //怪盗の交換処理
        int tmp = positionTrue[Integer.parseInt(m)-1];
        positionTrue[Integer.parseInt(m)-1] = positionTrue[n];
        positionTrue[n] = tmp;
        setContentView(R.layout.activity_werewolf_thief_changed);
        TextView changedT = (TextView) findViewById(R.id.chText);
        changedT.setTextColor(Color.rgb(220, 220, 220));
        TextView changedT2 = (TextView) findViewById(R.id.chText2);
        changedT2.setTextColor(Color.rgb(220, 220, 220));
        TextView changedT3 = (TextView) findViewById(R.id.chText3);
        changedT3.setTextColor(Color.rgb(220, 220, 220));
        TextView changedT4 = (TextView) findViewById(R.id.chText4);
        changedT4.setTextColor(Color.rgb(220, 220, 220));
        TextView changedT5 = (TextView) findViewById(R.id.chText5);
        changedT5.setTextColor(Color.rgb(220, 220, 220));
        TextView changedPn = (TextView) findViewById(R.id.chPn);
        changedPn.setTextColor(Color.rgb(220, 220, 220));
        changedPn.setText(m);
        TextView changedPosition = (TextView) findViewById(R.id.chPosition);
        changedPosition.setTextColor(Color.rgb(220, 220, 220));
        if(position[Integer.parseInt(m)-1] == WOLF) changedPosition.setText("人狼");
        else if(position[Integer.parseInt(m)-1] == DIVINER) changedPosition.setText("占い師");
        else if(position[Integer.parseInt(m)-1] == TERU) changedPosition.setText("てるてる");
        else changedPosition.setText("村人");
        ImageView changedIm = (ImageView) findViewById(R.id.chImage);
        if(position[Integer.parseInt(m)-1] == WOLF) changedIm.setImageResource(R.drawable.wolf);
        else if(position[Integer.parseInt(m)-1] == DIVINER) changedIm.setImageResource(R.drawable.diviner);
        else if(position[Integer.parseInt(m)-1] == TERU) changedIm.setImageResource(R.drawable.teruteru);
        else changedIm.setImageResource(R.drawable.villager);
        Button okCh = (Button) findViewById(R.id.changeOK);
        okCh.setOnClickListener(new View.OnClickListener() { //OKボタン
            public void onClick(View v) {
                n++;
                if(n<peopleNum) setScreenConfirmation(); //次の人の処理
                else morning(); //夜終わり
            }
        });
    }

    void morning(){ //朝になりました
        setContentView(R.layout.activity_werewolf_morning);
        Button discStart = (Button) findViewById(R.id.morningButton);
        discStart.setOnClickListener(new View.OnClickListener() { //役職説明画面を開く
            public void onClick(View v) {
                //ディスカッション画面に移動
                setContentView(R.layout.activity_werewolf_discussion);
                final ImageView image1 = findViewById(R.id.img);
                final ImageView image2 = findViewById(R.id.img2);
                final ImageView image3 = findViewById(R.id.img3);
                final ImageView image4 = findViewById(R.id.img4);
                final ImageView image5 = findViewById(R.id.img5);
                final ImageView image6 = findViewById(R.id.img6);
                final ImageView image7 = findViewById(R.id.img7);
                final ImageView image8 = findViewById(R.id.img8);
                final ImageView image9 = findViewById(R.id.img9);
                final ImageView image10 = findViewById(R.id.img10);
                final ImageView image11 = findViewById(R.id.img11);
                final ImageView image12 = findViewById(R.id.img12);
                //各役職の数によって画像をセット
                if(positionView[0] == WOLF) image1.setImageResource(R.drawable.wolf);
                else if(positionView[0] == DIVINER) image1.setImageResource(R.drawable.diviner);
                else if(positionView[0] == THIEF) image1.setImageResource(R.drawable.thief);
                else if(positionView[0] == TERU) image1.setImageResource(R.drawable.teruteru);
                else image1.setImageResource(R.drawable.villager);
                if(positionView[1] == WOLF) image2.setImageResource(R.drawable.wolf);
                else if(positionView[1] == DIVINER) image2.setImageResource(R.drawable.diviner);
                else if(positionView[1] == THIEF) image2.setImageResource(R.drawable.thief);
                else if(positionView[1] == TERU) image2.setImageResource(R.drawable.teruteru);
                else image2.setImageResource(R.drawable.villager);
                if(positionView[2] == WOLF) image3.setImageResource(R.drawable.wolf);
                else if(positionView[2] == DIVINER) image3.setImageResource(R.drawable.diviner);
                else if(positionView[2] == THIEF) image3.setImageResource(R.drawable.thief);
                else if(positionView[2] == TERU) image3.setImageResource(R.drawable.teruteru);
                else image3.setImageResource(R.drawable.villager);
                if(positionView[3] == WOLF) image4.setImageResource(R.drawable.wolf);
                else if(positionView[3] == DIVINER) image4.setImageResource(R.drawable.diviner);
                else if(positionView[3] == THIEF) image4.setImageResource(R.drawable.thief);
                else if(positionView[3] == TERU) image4.setImageResource(R.drawable.teruteru);
                else image4.setImageResource(R.drawable.villager);
                if(positionView[4] == WOLF) image5.setImageResource(R.drawable.wolf);
                else if(positionView[4] == DIVINER) image5.setImageResource(R.drawable.diviner);
                else if(positionView[4] == THIEF) image5.setImageResource(R.drawable.thief);
                else if(positionView[4] == TERU) image5.setImageResource(R.drawable.teruteru);
                else image5.setImageResource(R.drawable.villager);
                if(peopleNum<4) image6.setVisibility(INVISIBLE);
                if(positionView[5] == WOLF) image6.setImageResource(R.drawable.wolf);
                else if(positionView[5] == DIVINER) image6.setImageResource(R.drawable.diviner);
                else if(positionView[5] == THIEF) image6.setImageResource(R.drawable.thief);
                else if(positionView[5] == TERU) image6.setImageResource(R.drawable.teruteru);
                else image6.setImageResource(R.drawable.villager);
                if(peopleNum<5) image7.setVisibility(INVISIBLE);
                if(positionView[6] == WOLF) image7.setImageResource(R.drawable.wolf);
                else if(positionView[6] == DIVINER) image7.setImageResource(R.drawable.diviner);
                else if(positionView[6] == THIEF) image7.setImageResource(R.drawable.thief);
                else if(positionView[6] == TERU) image7.setImageResource(R.drawable.teruteru);
                else image7.setImageResource(R.drawable.villager);
                if(peopleNum<6) image8.setVisibility(INVISIBLE);
                if(positionView[7] == WOLF) image8.setImageResource(R.drawable.wolf);
                else if(positionView[7] == DIVINER) image8.setImageResource(R.drawable.diviner);
                else if(positionView[7] == THIEF) image8.setImageResource(R.drawable.thief);
                else if(positionView[7] == TERU) image8.setImageResource(R.drawable.teruteru);
                else image8.setImageResource(R.drawable.villager);
                if(peopleNum<7) image9.setVisibility(INVISIBLE);
                if(positionView[8] == WOLF) image9.setImageResource(R.drawable.wolf);
                else if(positionView[8] == DIVINER) image9.setImageResource(R.drawable.diviner);
                else if(positionView[8] == THIEF) image9.setImageResource(R.drawable.thief);
                else if(positionView[8] == TERU) image9.setImageResource(R.drawable.teruteru);
                else image9.setImageResource(R.drawable.villager);
                if(peopleNum<8) image10.setVisibility(INVISIBLE);
                if(positionView[9] == WOLF) image10.setImageResource(R.drawable.wolf);
                else if(positionView[9] == DIVINER) image10.setImageResource(R.drawable.diviner);
                else if(positionView[9] == THIEF) image10.setImageResource(R.drawable.thief);
                else if(positionView[9] == TERU) image10.setImageResource(R.drawable.teruteru);
                else image10.setImageResource(R.drawable.villager);
                if(peopleNum<9) image11.setVisibility(INVISIBLE);
                if(positionView[10] == WOLF) image11.setImageResource(R.drawable.wolf);
                else if(positionView[10] == DIVINER) image11.setImageResource(R.drawable.diviner);
                else if(positionView[10] == THIEF) image11.setImageResource(R.drawable.thief);
                else if(positionView[10] == TERU) image11.setImageResource(R.drawable.teruteru);
                else image11.setImageResource(R.drawable.villager);
                if(peopleNum<10) image12.setVisibility(INVISIBLE);
                if(positionView[11] == WOLF) image12.setImageResource(R.drawable.wolf);
                else if(positionView[11] == DIVINER) image12.setImageResource(R.drawable.diviner);
                else if(positionView[11] == THIEF) image12.setImageResource(R.drawable.thief);
                else if(positionView[11] == TERU) image12.setImageResource(R.drawable.teruteru);
                else image12.setImageResource(R.drawable.villager);
                Button voteSelect = (Button) findViewById(R.id.vote);
                voteSelect.setOnClickListener(new View.OnClickListener() { //投票ボタン
                    public void onClick(View v) {
                        n = 0;
                        voteSelect(); //投票先選択
                    }
                });
                Button specify = (Button) findViewById(R.id.specify);
                specify.setOnClickListener(new View.OnClickListener() { //指定ボタン
                    public void onClick(View v) {
                        setContentView(R.layout.activity_werewolf_specify);
                        specify(); //投票先選択
                    }
                });
            }
        });
    }

    void voteSelect() { //投票先選択
        setContentView(R.layout.activity_werewolf_confirmation);

        ConstraintLayout backGround = (ConstraintLayout)findViewById(R.id.bg);
        backGround.setBackgroundColor(Color.rgb(247, 247, 247));

        String player = String.valueOf(n+1);
        TextView pnt = (TextView) findViewById(R.id.pnText); //プレイヤーxに端末を渡してください
        pnt.setText(player);
        TextView pnt2 = (TextView) findViewById(R.id.pnText2); //プレイヤーxですか？
        pnt2.setText(player);

        Button yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //投票画面を開く
                setContentView(R.layout.activity_werewolf_vote);
                TextView pNumber = (TextView) findViewById(R.id.player);
                pNumber.setText(String.valueOf(n+1));
                final RadioButton heiwa = (RadioButton) findViewById(R.id.heiwa);
                final RadioButton vote1 = (RadioButton) findViewById(R.id.vote1);
                final RadioButton vote2 = (RadioButton) findViewById(R.id.vote2);
                final RadioButton vote3 = (RadioButton) findViewById(R.id.vote3);
                if (peopleNum < 4) vote3.setVisibility(INVISIBLE);
                final RadioButton vote4 = (RadioButton) findViewById(R.id.vote4);
                if (peopleNum < 5) vote4.setVisibility(INVISIBLE);
                final RadioButton vote5 = (RadioButton) findViewById(R.id.vote5);
                if (peopleNum < 6) vote5.setVisibility(INVISIBLE);
                final RadioButton vote6 = (RadioButton) findViewById(R.id.vote6);
                if (peopleNum < 7) vote6.setVisibility(INVISIBLE);
                final RadioButton vote7 = (RadioButton) findViewById(R.id.vote7);
                if (peopleNum < 8) vote7.setVisibility(INVISIBLE);
                final RadioButton vote8 = (RadioButton) findViewById(R.id.vote8);
                if (peopleNum < 9) vote8.setVisibility(INVISIBLE);
                final RadioButton vote9 = (RadioButton) findViewById(R.id.vote9);
                if (peopleNum < 10) vote9.setVisibility(INVISIBLE);
                int z = 0, y = 0, x = 0, w = 0, u = 0, t = 0, s = 0, r = 0, q = 0;
                String m1 = "1", m2 = "1", m3 = "1", m4 = "1", m5 = "1", m6 = "1", m7 = "1", m8 = "1", m9 = "1";
                for (z = y; z < peopleNum; z++) {
                    if (z > y && z != n) {
                        m9 = String.valueOf(z + 1);
                        vote9.setText("プレイヤー" + m9);
                        break;
                    }
                    for (y = x; y < peopleNum; y++) {
                        if (y > x && y != n) {
                            m8 = String.valueOf(y + 1);
                            vote8.setText("プレイヤー" + m8);
                            break;
                        }
                        for (x = w; x < peopleNum; x++) {
                            if (x > w && x != n) {
                                m7 = String.valueOf(x + 1);
                                vote7.setText("プレイヤー" + m7);
                                break;
                            }
                            for (w = u; w < peopleNum; w++) {
                                if (w > u && w != n) {
                                    m6 = String.valueOf(w + 1);
                                    vote6.setText("プレイヤー" + m6);
                                    break;
                                }
                                for (u = t; u < peopleNum; u++) {
                                    if (u > t && u != n) {
                                        m5 = String.valueOf(u + 1);
                                        vote5.setText("プレイヤー" + m5);
                                        break;
                                    }
                                    for (t = s; t < peopleNum; t++) {
                                        if (t > s && t != n) {
                                            m4 = String.valueOf(t + 1);
                                            vote4.setText("プレイヤー" + m4);
                                            break;
                                        }
                                        for (s = r; s < peopleNum; s++) {
                                            if (s > r && s != n) {
                                                m3 = String.valueOf(s + 1);
                                                vote3.setText("プレイヤー" + m3);
                                                break;
                                            }
                                            for (r = q; r < peopleNum; r++) {
                                                if (r > q && r != n) {
                                                    m2 = String.valueOf(r + 1);
                                                    vote2.setText("プレイヤー" + m2);
                                                    break;
                                                }
                                                for (q = 0; q < peopleNum; q++) {
                                                    if (q != n) {
                                                        m1 = String.valueOf(q + 1);
                                                        vote1.setText("プレイヤー" + m1);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                final Button vote = (Button) findViewById(R.id.voteOK);
                vote.setEnabled(false);
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.voteSelect);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        vote.setEnabled(true);
                    }
                });
                final String finalM1 = m1;
                final String finalM2 = m2;
                final String finalM3 = m3;
                final String finalM4 = m4;
                final String finalM5 = m5;
                final String finalM6 = m6;
                final String finalM7 = m7;
                final String finalM8 = m8;
                final String finalM9 = m9;
                vote.setOnClickListener(new View.OnClickListener() { //OKボタン
                    public void onClick(View v) {
                        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.voteSelect);
                        int checkedId = radioGroup.getCheckedRadioButtonId();
                        RadioButton selected = (RadioButton) findViewById(checkedId);
                        String text = selected.getText().toString();
                        String heiwaTxt = heiwa.getText().toString();
                        String text1 = vote1.getText().toString();
                        String text2 = vote2.getText().toString();
                        String text3 = vote3.getText().toString();
                        String text4 = vote4.getText().toString();
                        String text5 = vote5.getText().toString();
                        String text6 = vote6.getText().toString();
                        String text7 = vote7.getText().toString();
                        String text8 = vote8.getText().toString();
                        String text9 = vote9.getText().toString();
                        if (text.equals(text1)) vote(finalM1, radioGroup);
                        else if (text.equals(text2)) vote(finalM2, radioGroup);
                        else if (text.equals(text3)) vote(finalM3, radioGroup);
                        else if (text.equals(text4)) vote(finalM4, radioGroup);
                        else if (text.equals(text5)) vote(finalM5, radioGroup);
                        else if (text.equals(text6)) vote(finalM6, radioGroup);
                        else if (text.equals(text7)) vote(finalM7, radioGroup);
                        else if (text.equals(text8)) vote(finalM8, radioGroup);
                        else if (text.equals(text9)) vote(finalM9, radioGroup);
                        else if(text.equals(heiwaTxt)) heiwa(radioGroup);
                    }
                });
            }
        });
    }

    void specify() { //吊先指定
        final RadioButton spHeiwa = (RadioButton) findViewById(R.id.spHeiwa);
        final RadioButton sp1 = (RadioButton) findViewById(R.id.sp1);
        final RadioButton sp2 = (RadioButton) findViewById(R.id.sp2);
        final RadioButton sp3 = (RadioButton) findViewById(R.id.sp3);
        if (peopleNum < 3) sp3.setVisibility(INVISIBLE);
        final RadioButton sp4 = (RadioButton) findViewById(R.id.sp4);
        if (peopleNum < 4) sp4.setVisibility(INVISIBLE);
        final RadioButton sp5 = (RadioButton) findViewById(R.id.sp5);
        if (peopleNum < 5) sp5.setVisibility(INVISIBLE);
        final RadioButton sp6 = (RadioButton) findViewById(R.id.sp6);
        if (peopleNum < 6) sp6.setVisibility(INVISIBLE);
        final RadioButton sp7 = (RadioButton) findViewById(R.id.sp7);
        if (peopleNum < 7) sp7.setVisibility(INVISIBLE);
        final RadioButton sp8 = (RadioButton) findViewById(R.id.sp8);
        if (peopleNum < 8) sp8.setVisibility(INVISIBLE);
        final RadioButton sp9 = (RadioButton) findViewById(R.id.sp9);
        if (peopleNum < 9) sp9.setVisibility(INVISIBLE);
        final RadioButton sp10 = (RadioButton) findViewById(R.id.sp10);
        if (peopleNum < 10) sp10.setVisibility(INVISIBLE);
        final Button spOk = (Button) findViewById(R.id.spOK);
        spOk.setEnabled(false);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.spSelect);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                spOk.setEnabled(true);
            }
        });
        spOk.setOnClickListener(new View.OnClickListener() { //OKボタン
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.spSelect);
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton) findViewById(checkedId);
                String text = selected.getText().toString();
                if (text.equals(sp1.getText().toString())) voteCount[0] = 1;
                else if (text.equals(sp2.getText().toString())) voteCount[1] = 1;
                else if (text.equals(sp3.getText().toString())) voteCount[2] = 1;
                else if (text.equals(sp4.getText().toString())) voteCount[3] = 1;
                else if (text.equals(sp5.getText().toString())) voteCount[4] = 1;
                else if (text.equals(sp6.getText().toString())) voteCount[5] = 1;
                else if (text.equals(sp7.getText().toString())) voteCount[6] = 1;
                else if (text.equals(sp8.getText().toString())) voteCount[7] = 1;
                else if (text.equals(sp9.getText().toString())) voteCount[8] = 1;
                else if (text.equals(sp10.getText().toString())) voteCount[9] = 1;
                else if(text.equals(spHeiwa.getText().toString())) heiwa = peopleNum;
                execute();
            }
        });
    }

    void heiwa(RadioGroup g){
        g.clearCheck();
        heiwa++;
        n++;
        if(n<peopleNum) voteSelect();
        else execute();
    }

    void vote(String m, RadioGroup g){ //投票処理
        g.clearCheck();
        voteCount[Integer.parseInt(m)-1]++;
        n++;
        if(n<peopleNum) voteSelect();
        else execute();
    }

    void execute(){
        setContentView(R.layout.activity_werewolf_execution);
        int max = 0;
        int frag = WOLFWIN;
        for(int i=0; i<peopleNum; i++) if(voteCount[i]>max) max = voteCount[i]; //投票の最大得票数を抜き出す
        for(int i=0, j=0; i<peopleNum; i++){
            if(voteCount[i]==max){ //村の勝利条件判定
                execute[j]=i;
                if(positionTrue[execute[j]]==WOLF) frag = VILLAGERWIN;
                j++;
            }
        }
        for(int i=0; i<peopleNum; i++){ //てるてるの勝利条件判定
            if(voteCount[i]==max && positionTrue[i]==TERU) frag = TERUWIN;
        }
        TextView exeTe = (TextView) findViewById(R.id.exeText); //処刑されたのは…
        if(heiwa==peopleNum){ //全員平和祈願・平和指定の平和村判定
            exeTe.setText("この村は平和村だ。");
            frag = HEIWA;
        }
        for(int i=1, t=0; i<peopleNum; i++){ //得票数１ずつの平和村判定
            if(voteCount[i]==voteCount[i-1]) t++;
            if(t==peopleNum-1){
                exeTe.setText("この村は平和村だ。");
                frag = HEIWA;
            }
        }
        TextView exeP1 = (TextView) findViewById(R.id.exePn1); //処刑される人を表示
        String p1 = String.valueOf(execute[0]+1);
        exeP1.setText("プレイヤー"+p1);
        if(frag==HEIWA) exeP1.setVisibility(INVISIBLE);
        TextView exeP2 = (TextView) findViewById(R.id.exePn2);
        String p2 = String.valueOf(execute[1]+1);
        exeP2.setText("プレイヤー"+p2);
        if(execute[1]=='\0' || frag==HEIWA) exeP2.setVisibility(INVISIBLE);
        TextView exeP3 = (TextView) findViewById(R.id.exePn3);
        String p3 = String.valueOf(execute[2]+1);
        exeP3.setText("プレイヤー"+p3);
        if(execute[2]=='\0' || frag==HEIWA) exeP3.setVisibility(INVISIBLE);
        TextView exeP4 = (TextView) findViewById(R.id.exePn4);
        String p4 = String.valueOf(execute[3]+1);
        exeP4.setText("プレイヤー"+p4);
        if(execute[3]=='\0' || frag==HEIWA) exeP4.setVisibility(INVISIBLE);
        TextView exeP5 = (TextView) findViewById(R.id.exePn5);
        String p5 = String.valueOf(execute[4]+1);
        exeP5.setText("プレイヤー"+p5);
        if(execute[4]=='\0' || frag==HEIWA) exeP5.setVisibility(INVISIBLE);
        if(frag == HEIWA){ //平和村の勝敗判定
            for(int i=0; i<peopleNum; i++){
                if(positionTrue[i]==WOLF){
                    frag = WOLFWIN;
                    break;
                }
                frag = VILLAGERWIN;
            }
        }
        Button executeOK = (Button) findViewById(R.id.exeOK);
        final int finalFrag = frag;
        final int finalMax = max;
        executeOK.setOnClickListener(new View.OnClickListener() { //OKボタン
            public void onClick(View v) {
                result(finalFrag, finalMax);
            }
        });
    }

    void result(int frag, int max){
        setContentView(R.layout.activity_werewolf_result);
        TextView resultTxt = (TextView) findViewById(R.id.resultText);
        if(frag==WOLFWIN) resultTxt.setText("🐺人狼の勝利🐺");
        if(frag==TERUWIN) resultTxt.setText("😊てるてるの勝利😊");
        if(frag==VILLAGERWIN) resultTxt.setText("👤村人の勝利👤");

        TextView p4txt = (TextView) findViewById(R.id.player4);
        if(peopleNum<4) p4txt.setVisibility(INVISIBLE);
        TextView p5txt = (TextView) findViewById(R.id.player5);
        if(peopleNum<5) p5txt.setVisibility(INVISIBLE);
        TextView p6txt = (TextView) findViewById(R.id.player6);
        if(peopleNum<6) p6txt.setVisibility(INVISIBLE);
        TextView p7txt = (TextView) findViewById(R.id.player7);
        if(peopleNum<7) p7txt.setVisibility(INVISIBLE);
        TextView p8txt = (TextView) findViewById(R.id.player8);
        if(peopleNum<8) p8txt.setVisibility(INVISIBLE);
        TextView p9txt = (TextView) findViewById(R.id.player9);
        if(peopleNum<9) p9txt.setVisibility(INVISIBLE);
        TextView p10txt = (TextView) findViewById(R.id.player10);
        if(peopleNum<10) p10txt.setVisibility(INVISIBLE);

        TextView p1before = (TextView) findViewById(R.id.player1PositionBefore);
        if(position[0]==WOLF) p1before.setText("人狼→");
        else if(position[0]==DIVINER) p1before.setText("占い師→");
        else if(position[0]==THIEF) p1before.setText("怪盗→");
        else if(position[0]==TERU) p1before.setText("てるてる→");
        else p1before.setText("村人→");
        TextView p2before = (TextView) findViewById(R.id.player2PositionBefore);
        if(position[1]==WOLF) p2before.setText("人狼→");
        else if(position[1]==DIVINER) p2before.setText("占い師→");
        else if(position[1]==THIEF) p2before.setText("怪盗→");
        else if(position[1]==TERU) p2before.setText("てるてる→");
        else p2before.setText("村人→");
        TextView p3before = (TextView) findViewById(R.id.player3PositionBefore);
        if(position[2]==WOLF) p3before.setText("人狼→");
        else if(position[2]==DIVINER) p3before.setText("占い師→");
        else if(position[2]==THIEF) p3before.setText("怪盗→");
        else if(position[2]==TERU) p3before.setText("てるてる→");
        else p3before.setText("村人→");
        TextView p4before = (TextView) findViewById(R.id.player4PositionBefore);
        if(position[3]==WOLF) p4before.setText("人狼→");
        else if(position[3]==DIVINER) p4before.setText("占い師→");
        else if(position[3]==THIEF) p4before.setText("怪盗→");
        else if(position[3]==TERU) p4before.setText("てるてる→");
        else p4before.setText("村人→");
        if(peopleNum<4) p4before.setVisibility(INVISIBLE);
        TextView p5before = (TextView) findViewById(R.id.player5PositionBefore);
        if(position[4]==WOLF) p5before.setText("人狼→");
        else if(position[4]==DIVINER) p5before.setText("占い師→");
        else if(position[4]==THIEF) p5before.setText("怪盗→");
        else if(position[4]==TERU) p5before.setText("てるてる→");
        else p5before.setText("村人→");
        if(peopleNum<5) p5before.setVisibility(INVISIBLE);
        TextView p6before = (TextView) findViewById(R.id.player6PositionBefore);
        if(position[5]==WOLF) p6before.setText("人狼→");
        else if(position[5]==DIVINER) p6before.setText("占い師→");
        else if(position[5]==THIEF) p6before.setText("怪盗→");
        else if(position[5]==TERU) p6before.setText("てるてる→");
        else p6before.setText("村人→");
        if(peopleNum<6) p6before.setVisibility(INVISIBLE);
        TextView p7before = (TextView) findViewById(R.id.player7PositionBefore);
        if(position[6]==WOLF) p7before.setText("人狼→");
        else if(position[6]==DIVINER) p7before.setText("占い師→");
        else if(position[6]==THIEF) p7before.setText("怪盗→");
        else if(position[6]==TERU) p7before.setText("てるてる→");
        else p7before.setText("村人→");
        if(peopleNum<7) p7before.setVisibility(INVISIBLE);
        TextView p8before = (TextView) findViewById(R.id.player8PositionBefore);
        if(position[7]==WOLF) p8before.setText("人狼→");
        else if(position[7]==DIVINER) p8before.setText("占い師→");
        else if(position[7]==THIEF) p8before.setText("怪盗→");
        else if(position[7]==TERU) p8before.setText("てるてる→");
        else p8before.setText("村人→");
        if(peopleNum<8) p8before.setVisibility(INVISIBLE);
        TextView p9before = (TextView) findViewById(R.id.player9PositionBefore);
        if(position[8]==WOLF) p9before.setText("人狼→");
        else if(position[8]==DIVINER) p9before.setText("占い師→");
        else if(position[8]==THIEF) p9before.setText("怪盗→");
        else if(position[8]==TERU) p9before.setText("てるてる→");
        else p9before.setText("村人→");
        if(peopleNum<9) p9before.setVisibility(INVISIBLE);
        TextView p10before = (TextView) findViewById(R.id.player10PositionBefore);
        if(position[9]==WOLF) p10before.setText("人狼→");
        else if(position[9]==DIVINER) p10before.setText("占い師→");
        else if(position[9]==THIEF) p10before.setText("怪盗→");
        else if(position[9]==TERU) p10before.setText("てるてる→");
        else p10before.setText("村人→");
        if(peopleNum<10) p10before.setVisibility(INVISIBLE);

        TextView p1after = (TextView) findViewById(R.id.player1PositionAfter);
        if(positionTrue[0]==WOLF) p1after.setText("人狼");
        else if(positionTrue[0]==DIVINER) p1after.setText("占い師");
        else if(positionTrue[0]==THIEF) p1after.setText("怪盗");
        else if(positionTrue[0]==TERU) p1after.setText("てるてる");
        else p1after.setText("村人");
        TextView p2after = (TextView) findViewById(R.id.player2PositionAfter);
        if(positionTrue[1]==WOLF) p2after.setText("人狼");
        else if(positionTrue[1]==DIVINER) p2after.setText("占い師");
        else if(positionTrue[1]==THIEF) p2after.setText("怪盗");
        else if(positionTrue[1]==TERU) p2after.setText("てるてる");
        else p2after.setText("村人");
        TextView p3after = (TextView) findViewById(R.id.player3PositionAfter);
        if(positionTrue[2]==WOLF) p3after.setText("人狼");
        else if(positionTrue[2]==DIVINER) p3after.setText("占い師");
        else if(positionTrue[2]==THIEF) p3after.setText("怪盗");
        else if(positionTrue[2]==TERU) p3after.setText("てるてる");
        else p3after.setText("村人");
        TextView p4after = (TextView) findViewById(R.id.player4PositionAfter);
        if(positionTrue[3]==WOLF) p4after.setText("人狼");
        else if(positionTrue[3]==DIVINER) p4after.setText("占い師");
        else if(positionTrue[3]==THIEF) p4after.setText("怪盗");
        else if(positionTrue[3]==TERU) p4after.setText("てるてる");
        else p4after.setText("村人");
        if(peopleNum<4) p4after.setVisibility(INVISIBLE);
        TextView p5after = (TextView) findViewById(R.id.player5PositionAfter);
        if(positionTrue[4]==WOLF) p5after.setText("人狼");
        else if(positionTrue[4]==DIVINER) p5after.setText("占い師");
        else if(positionTrue[4]==THIEF) p5after.setText("怪盗");
        else if(positionTrue[4]==TERU) p5after.setText("てるてる");
        else p5after.setText("村人");
        if(peopleNum<5) p5after.setVisibility(INVISIBLE);
        TextView p6after = (TextView) findViewById(R.id.player6PositionAfter);
        if(positionTrue[5]==WOLF) p6after.setText("人狼");
        else if(positionTrue[5]==DIVINER) p6after.setText("占い師");
        else if(positionTrue[5]==THIEF) p6after.setText("怪盗");
        else if(positionTrue[5]==TERU) p6after.setText("てるてる");
        else p6after.setText("村人");
        if(peopleNum<6) p6after.setVisibility(INVISIBLE);
        TextView p7after = (TextView) findViewById(R.id.player7PositionAfter);
        if(positionTrue[6]==WOLF) p7after.setText("人狼");
        else if(positionTrue[6]==DIVINER) p7after.setText("占い師");
        else if(positionTrue[6]==THIEF) p7after.setText("怪盗");
        else if(positionTrue[6]==TERU) p7after.setText("てるてる");
        else p7after.setText("村人");
        if(peopleNum<7) p7after.setVisibility(INVISIBLE);
        TextView p8after = (TextView) findViewById(R.id.player8PositionAfter);
        if(positionTrue[7]==WOLF) p8after.setText("人狼");
        else if(positionTrue[7]==DIVINER) p8after.setText("占い師");
        else if(positionTrue[7]==THIEF) p8after.setText("怪盗");
        else if(positionTrue[7]==TERU) p8after.setText("てるてる");
        else p8after.setText("村人");
        if(peopleNum<8) p8after.setVisibility(INVISIBLE);
        TextView p9after = (TextView) findViewById(R.id.player9PositionAfter);
        if(positionTrue[8]==WOLF) p9after.setText("人狼");
        else if(positionTrue[8]==DIVINER) p9after.setText("占い師");
        else if(positionTrue[8]==THIEF) p9after.setText("怪盗");
        else if(positionTrue[8]==TERU) p9after.setText("てるてる");
        else p9after.setText("村人");
        if(peopleNum<9) p9after.setVisibility(INVISIBLE);
        TextView p10after = (TextView) findViewById(R.id.player10PositionAfter);
        if(positionTrue[9]==WOLF) p10after.setText("人狼");
        else if(positionTrue[9]==DIVINER) p10after.setText("占い師");
        else if(positionTrue[9]==THIEF) p10after.setText("怪盗");
        else if(positionTrue[9]==TERU) p10after.setText("てるてる");
        else p10after.setText("村人");
        if(peopleNum<10) p10after.setVisibility(INVISIBLE);

        TextView p1judge = (TextView) findViewById(R.id.player1judge);
        if(voteCount[0]==max && heiwa!=peopleNum) p1judge.setVisibility(VISIBLE);
        else p1judge.setVisibility(INVISIBLE);
        TextView p2judge = (TextView) findViewById(R.id.player2judge);
        if(voteCount[1]==max && heiwa!=peopleNum) p2judge.setVisibility(VISIBLE);
        else p2judge.setVisibility(INVISIBLE);
        TextView p3judge = (TextView) findViewById(R.id.player3judge);
        if(voteCount[2]==max && heiwa!=peopleNum) p3judge.setVisibility(VISIBLE);
        else p3judge.setVisibility(INVISIBLE);
        TextView p4judge = (TextView) findViewById(R.id.player4judge);
        if(voteCount[3]==max && heiwa!=peopleNum) p4judge.setVisibility(VISIBLE);
        else p4judge.setVisibility(INVISIBLE);
        TextView p5judge = (TextView) findViewById(R.id.player5judge);
        if(voteCount[4]==max && heiwa!=peopleNum) p5judge.setVisibility(VISIBLE);
        else p5judge.setVisibility(INVISIBLE);
        TextView p6judge = (TextView) findViewById(R.id.player6judge);
        if(voteCount[5]==max && heiwa!=peopleNum) p6judge.setVisibility(VISIBLE);
        else p6judge.setVisibility(INVISIBLE);
        TextView p7judge = (TextView) findViewById(R.id.player7judge);
        if(voteCount[6]==max && heiwa!=peopleNum) p7judge.setVisibility(VISIBLE);
        else p7judge.setVisibility(INVISIBLE);
        TextView p8judge = (TextView) findViewById(R.id.player8judge);
        if(voteCount[7]==max && heiwa!=peopleNum) p8judge.setVisibility(VISIBLE);
        else p8judge.setVisibility(INVISIBLE);
        TextView p9judge = (TextView) findViewById(R.id.player9judge);
        if(voteCount[8]==max && heiwa!=peopleNum) p9judge.setVisibility(VISIBLE);
        else p9judge.setVisibility(INVISIBLE);
        TextView p10judge = (TextView) findViewById(R.id.player10judge);
        if(voteCount[9]==max && heiwa!=peopleNum) p10judge.setVisibility(VISIBLE);
        else p10judge.setVisibility(INVISIBLE);

        Button top = (Button) findViewById(R.id.backToTop); //トップメニューに戻る
        top.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Werewolf.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button config = (Button) findViewById(R.id.backToConfig); //ゲーム設定画面に戻る
        config.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                peopleNum = 3;
                for(int i=0; i<12; i++) {
                    if(i==0){
                        position[i] = 0;
                        positionTrue[i] = 0;
                        positionView[i] = 0;
                    }else if(i==1){
                        position[i] = 1;
                        positionTrue[i] = 1;
                        positionView[i] = 1;
                    }else{
                        position[i] = 4;
                        positionTrue[i] = 4;
                        positionView[i] = 4;
                    }
                }
                for(int i=0; i<10; i++) voteCount[i] = 0;
                for(int i=0; i<5; i++) execute[i] = '\0';
                wolfNum = 1;
                divinerNum = 1;
                thiefNum = 0;
                teruNum = 0;
                villagerNum = 3;
                n=0;
                heiwa = 0;
                setScreenMain();
            }
        });
        Button again = (Button) findViewById(R.id.again); //もう一度同じ設定で遊ぶ(スタートと同じ処理)
        again.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                n=0;
                for(int i=0; i<10; i++) voteCount[i] = 0;
                for(int i=0; i<5; i++) execute[i] = '\0';
                heiwa = 0;
                //役職シャッフル
                Random rnd = new Random();
                for (int i = peopleNum+2; i > 1; i--) {
                    int index = rnd.nextInt(i);
                    int tmp = position[index];
                    position[index] = position[i-1];
                    positionTrue[index] = position[i-1];
                    position[i-1] = tmp;
                    positionTrue[i-1] = tmp;
                }
                System.out.println(Arrays.toString(position)); //シャッフル後の配列をLogcatに表示

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
                        setScreenConfirmation(); //プレイヤー確認画面を開く
                    }
                });
            }
        });
    }
}


/*注意事項
例外処理してないので
怪盗で交換先選択せずに交換ボタンを押さないように
占い師で占い先選択せずにOKボタンを押さないように
例外処理してないので投票先選択せずにOKボタンを押さないように*/