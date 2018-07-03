package com.josephpark.pokerpal;

public class QuestionLibrary {

    private String EVQuestions [] = {
            "filler question",
            "question number 2"
    };

    private String EVChoices [][] = {
            {"a","b","correct answer","d"},
            {"wrong","yes","nope","not this one either"}
    };

    private String EVAnswers [] = {
            "correct answer",
            "yes"
    };

    public int getNumQuestions(){
        return EVQuestions.length;
    }

    public String getQuestion(int x){
        String question = EVQuestions[x];
        return question;
    }

    public String getChoice1(int x) {
        return EVChoices[x][0];
    }
    public String getChoice2(int x) {
        return EVChoices[x][1];
    }
    public String getChoice3(int x) {
        return EVChoices[x][2];
    }
    public String getChoice4(int x) {
        return EVChoices[x][3];
    }

    public String getCorrectAnswer(int x){
        return EVAnswers[x];
    }
}
