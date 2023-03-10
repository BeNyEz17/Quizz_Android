package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Niveau2Activity extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNO;
    private RadioGroup radioGroup;
    private RadioButton rps1, rps2,rps3,rps4;
    private Button nxtQuestion;

    int totalQuestions;
    int qCounter = 0;
    int score;


    ColorStateList dfRbcolor;
    boolean answered;

    private QuestionModel currentquestion;

    private List<QuestionModel> questionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau2);
        questionsList = new ArrayList<>();
        tvQuestion = findViewById(R.id.question);
        tvScore = findViewById(R.id.score);
        tvQuestionNO = findViewById(R.id.QuestionNO);


        radioGroup = findViewById(R.id.radioGroup);
        rps1 = findViewById(R.id.rps1);
        rps2 = findViewById(R.id.rps2);
        rps3 = findViewById(R.id.rps3);
        rps4 = findViewById(R.id.rps4);
        nxtQuestion = findViewById(R.id.nxtQuestion);

        dfRbcolor = rps1.getTextColors();


        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();

        nxtQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false){
                    if(rps1.isChecked() || rps2.isChecked() || rps3.isChecked() || rps4.isChecked()){
                        checkAnswer();
                    }else {
                        Toast.makeText(Niveau2Activity.this, "s'il vous plait choissisez une reponse", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });



    }

    private void checkAnswer() {
        answered = true;
        RadioButton rpsSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rpsSelected)+1;
        if(answerNo == currentquestion.getCorrectANSNo()){
            score++;
            tvScore.setText("Score: "+score);
        }
        rps1.setTextColor(Color.RED);
        rps2.setTextColor(Color.RED);
        rps3.setTextColor(Color.RED);
        rps4.setTextColor(Color.RED);
        switch(currentquestion.getCorrectANSNo()){
            case 1:
                rps1.setTextColor(Color.BLUE);
                break;
            case 2:
                rps2.setTextColor(Color.BLUE);
                break;
            case 3:
                rps3.setTextColor(Color.BLUE);
                break;
            case 4:
                rps4.setTextColor(Color.BLUE);
                break;

        }
        if(qCounter < totalQuestions){
            nxtQuestion.setText("Suivant");
        }else {
            nxtQuestion.setText("Fin");
        }

    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rps1.setTextColor(dfRbcolor);
        rps2.setTextColor(dfRbcolor);
        rps3.setTextColor(dfRbcolor);
        rps4.setTextColor(dfRbcolor);

        if(qCounter < totalQuestions){
            currentquestion = questionsList.get(qCounter);
            tvQuestion.setText(currentquestion.getQuestion());
            rps1.setText(currentquestion.getReponse1());
            rps2.setText(currentquestion.getReponse2());
            rps3.setText(currentquestion.getReponse3());
            rps4.setText(currentquestion.getReponse4());


            qCounter++;
            nxtQuestion.setText("Repondre");
            tvQuestionNO.setText("Question: "+qCounter+"/"+totalQuestions);
            answered = false;
        }else {
            if (qCounter == qCounter) {

                Intent intent = new Intent(getApplicationContext(), ToisiemeActivity.class);
                intent.putExtra("score_count", score);
                startActivity(intent);

            } else {
                qCounter++;
                showNextQuestion();
            }
            finish();
        }
    }

    private void addQuestions() {
        questionsList.add(new QuestionModel("Le Youtuber Francais avec le plus d'abonnés ?", "Michou", "kevin Tran", "NortonLeZOZO", "Squeezie", 4));
        questionsList.add(new QuestionModel("Qui a inventé l'avion ?", "Tchoupi", "Les frères Wright", "Les frères Fly", "Tony Stark", 2));
        questionsList.add(new QuestionModel("Quel acte de la vie courante occupe environ 6 mois de notre vie ?", "Ecoute les femmes", "Attendre au feu rouge", "Passer le balai", "Regarder la télévision", 2));
        questionsList.add(new QuestionModel("Quel est le muscle le plus puissant du corps humain ?", "La langue", "les jambes", "Le grand dorsal", "Le grand fessier", 4));
        questionsList.add(new QuestionModel("La taille maximale jamais atteinte par un homme à ce jour est de :", "2, 76 mètres", "2,32 mètres", "1,50 mètres", "3,02 mètres", 1));

    }
}