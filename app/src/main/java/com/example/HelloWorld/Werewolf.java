package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

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

public class Werewolf extends AppCompatActivity {
    int peopleNum = 3; //人数
    int[] position = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //役職セット用配列。配布直後の並び
    int[] positionTrue = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //怪盗による並び替え後の真の役職
    int[] positionView = {0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}; //会議時に役職見る用の配列。配布前の並び
    int wolfNum = 1, divinerNum = 1, thiefNum = 0, teruNum = 0, villagerNum = 3; //各役職の数
    public static final int WOLF = 0, DIVINER = 1, THIEF = 2, TERU = 3, VILLAGER = 4; //define
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
        //各役職の数によって画像をセット
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

        Button back = (Button)findViewById(R.id.back); //トップメニューに戻るボタン
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
                if(thiefNum < 1){
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
                if(teruNum < 1){
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
            public void onClick(View view) { //設定完了。最初の画面に戻る
                setArray(peopleNum, wolfNum, divinerNum, thiefNum, teruNum); //各役職の数を配列に反映
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
        //if(j<peopleNum) setScreenConfirmation(j);
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
                    if(member<=2) mem2.setVisibility(View.INVISIBLE);
                    if(member<=3) mem3.setVisibility(View.INVISIBLE);
                    if(member<=4) mem4.setVisibility(View.INVISIBLE);
                    if(member<=5) mem5.setVisibility(View.INVISIBLE);
                    if(member<=6) mem6.setVisibility(View.INVISIBLE);
                    if(member<=7) mem7.setVisibility(View.INVISIBLE);
                    if(member<=8) mem8.setVisibility(View.INVISIBLE);
                    if(member<=9) mem9.setVisibility(View.INVISIBLE);
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
        if(peopleNum<4) divine3.setVisibility(View.INVISIBLE);
        final RadioButton divine4 = (RadioButton) findViewById(R.id.divine4);
        divine4.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<5) divine4.setVisibility(View.INVISIBLE);
        final RadioButton divine5 = (RadioButton) findViewById(R.id.divine5);
        divine5.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<6) divine5.setVisibility(View.INVISIBLE);
        final RadioButton divine6 = (RadioButton) findViewById(R.id.divine6);
        divine6.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<7) divine6.setVisibility(View.INVISIBLE);
        final RadioButton divine7 = (RadioButton) findViewById(R.id.divine7);
        divine7.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<8) divine7.setVisibility(View.INVISIBLE);
        final RadioButton divine8 = (RadioButton) findViewById(R.id.divine8);
        divine8.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<9) divine8.setVisibility(View.INVISIBLE);
        final RadioButton divine9 = (RadioButton) findViewById(R.id.divine9);
        divine9.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<10) divine9.setVisibility(View.INVISIBLE);
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
                if (checkedId == -1) {
                    //例外処理してないので占い師で占い先選択せずにOKボタンを押さないように
                }
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
        if(peopleNum<4) change3.setVisibility(View.INVISIBLE);
        final RadioButton change4 = (RadioButton) findViewById(R.id.change4);
        change4.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<5) change4.setVisibility(View.INVISIBLE);
        final RadioButton change5 = (RadioButton) findViewById(R.id.change5);
        change5.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<6) change5.setVisibility(View.INVISIBLE);
        final RadioButton change6 = (RadioButton) findViewById(R.id.change6);
        change6.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<7) change6.setVisibility(View.INVISIBLE);
        final RadioButton change7 = (RadioButton) findViewById(R.id.change7);
        change7.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<8) change7.setVisibility(View.INVISIBLE);
        final RadioButton change8 = (RadioButton) findViewById(R.id.change8);
        change8.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<9) change8.setVisibility(View.INVISIBLE);
        final RadioButton change9 = (RadioButton) findViewById(R.id.change9);
        change9.setTextColor(Color.rgb(220, 220, 220));
        if(peopleNum<10) change9.setVisibility(View.INVISIBLE);
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
                if (checkedId == -1) {
                    //例外処理してないので怪盗で交換先選択せずに交換ボタンを押さないように
                }
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
                    terut2.setVisibility(View.INVISIBLE);
                    terut3.setVisibility(View.INVISIBLE);
                    c++;
                }else{
                    terut1.setText("てるてるはどの陣営にも属さず、");
                    terut2.setVisibility(View.VISIBLE);
                    terut3.setVisibility(View.VISIBLE);
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
                    vilt2.setVisibility(View.INVISIBLE);
                    vilt3.setVisibility(View.INVISIBLE);
                    c++;
                }else{
                    vilt1.setText("村人はただの一般人だ。");
                    vilt2.setVisibility(View.VISIBLE);
                    vilt3.setVisibility(View.VISIBLE);
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
            }
        });
    }
}


/*注意事項
例外処理してないので
怪盗で交換先選択せずに交換ボタンを押さないように
占い師で占い先選択せずにOKボタンを押さないように*/