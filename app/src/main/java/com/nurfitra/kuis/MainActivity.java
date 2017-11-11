package com.nurfitra.kuis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextQuestion;
    TextView mTextScore;
    TextView mTextInfo;
    TextView mTextFScore;
    Button mBtnSubmit;
    RadioGroup optionGroup;
    RadioButton optionA, optionB,optionC,optionD;
    List<QuizModel> quizModelList = new ArrayList<>();
    int no = 0;
    int soal = 1;
    int score =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextQuestion = (TextView) findViewById(R.id.mTextQuestion);
        mTextScore = (TextView) findViewById(R.id.mTextScore);
        mTextInfo = (TextView) findViewById(R.id.mTextInfo);
        mBtnSubmit = (Button) findViewById(R.id.mBtnSubmit);
        optionGroup = (RadioGroup) findViewById(R.id.optionGroup);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);
        prepareData();
        setData();

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(no<quizModelList.size()) {
                    checkAnswer();
                    no++;
                    soal++;
                }
                if(no<quizModelList.size()) {
                    setData();
                }
            }
        });
    }

    //digunakan untuk menset soal
    void prepareData(){
        setQuestion("Binatang yang bisa hidup di air dan di darat disebut?", "Amfibi", "Mamalia", "Herbifora", "Melata", "A");
        setQuestion("Tari kecak adalah tari yang berasal dari daerah?", "Sumatra", "Jawa Barat", "Bali", "Maluku", "C");
        setQuestion("Jumlah huruf abjad adalah?", "Dua puluh satu", "Dua puluh enam", "Tiga puluh enam", "Tiga puluh satu", "B");
        setQuestion("Alat pernafasan belalang adalah?", "Trakea", "Insang", "Paru-paru", "Hidung", "A");
        setQuestion("Spongebob Squarepants tinggal di daerah?", "Bikini Bottom", "Bikini Top", "Krusty Krab", "Meikarta", "A");
        setQuestion("Gunung tertinggi di dunia adalah?", "Fuji", "Jayawijaya", "Everest", "Merapi", "C");
        setQuestion("Patung Sphinx kebanyakan terdapat di negara?", "Mesir", "Arab", "Mexico", "Brazil", "A");
        setQuestion("Rumput yang tumbuh paling cepat adalah?", "Kaktus", "Bambu", "Singkong", "Mangga", "B");
        setQuestion("Burung tercepat di dunia adalah?", "Elang", "Falcon", "Splash", "Sonic", "B");
        setQuestion("Indra manusia yang digunakan untuk mengecap adalah?", "Mulut", "Tangan", "Hidung", "Lidah", "D");
    }

    void setData(){
        mTextScore.setText("Score : "+score);
        mTextInfo.setText("Soal : "+soal+"/"+quizModelList.size());
        mTextQuestion.setText(quizModelList.get(no).getQuestion());
        optionA.setText(quizModelList.get(no).getOptionA());
        optionB.setText(quizModelList.get(no).getOptionB());
        optionC.setText(quizModelList.get(no).getOptionC());
        optionD.setText(quizModelList.get(no).getOptionD());

    }

    void checkAnswer(){
        int index =0;
        switch (quizModelList.get(no).getAnswer()){
            case "A":
                index =0;
                break;
            case "B":
                index =1;
                break;
            case "C":
                index =2;
                break;
            case "D":
                index =3;
                break;
            default:index=0; break;
        }

        int selectedAnsewer = optionGroup.indexOfChild(findViewById(optionGroup.getCheckedRadioButtonId()));
        if(index == selectedAnsewer){
            score = score + 10;
            mTextScore.setText("Score : "+score);
        }

        if(no == quizModelList.size()-1)
        {
            setContentView(R.layout.final_score);
        }
    }


    //fungsi untuk mengeset soal ke model yang kemudian akan dimasukan ke modellist
    void setQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer){
        QuizModel quizModel = new QuizModel(question, optionA, optionB, optionC, optionD, answer);
        quizModelList.add(quizModel);
    }






}
