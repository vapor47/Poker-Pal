package com.josephpark.pokerpal;

public class QuestionLibrary {

    public String subject;
    public String subjQuestions[], subjChoices[][], subjAnswers[];

    QuestionLibrary(String subject){
        switch (subject){
            case "EV":
                subjQuestions = EVQuestions;
                subjChoices = EVChoices;
                subjAnswers = EVAnswers;
                break;
            case "Counting Outs":
                subjQuestions = OutsQuestions;
                subjChoices = OutsChoices;
                subjAnswers = OutsAnswers;
                break;
        }
    }

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

    private String OutsQuestions [] = {
            "Hero: 8♦J♥\n" +
                    "Villain: K♦A♦\n" +
                    "Board: 5♣Q♦K♥A♥\n\n" +
                    "How many outs does Hero have?",
            "Hero: 3♣3♦\n" +
                    "Villain: A♣J♣\n" +
                    "Board: J♦8♦2♥A♠\n\n" +
                    "How many outs does Hero have?",
            "Hero: K♠9♠\n" +
                    "Villain: J♠J♥\n" +
                    "Board: 4♥8♥6♦A♣\n\n" +
                    "How many outs does Hero have?",
            "Hero: 5♣7♣\n" +
                    "Villain: K♦J♦\n" +
                    "Board: J♥6♥9♥2♦\n\n" +
                    "How many outs does Hero have?",
            "Hero: A♦J♠\n" +
                    "Villain: 7♠8♠\n" +
                    "Board: 7♥5♥2♣4♣\n\n" +
                    "How many outs does Hero have?"
    };

    private String OutsChoices [][] = {
            {"3","4","8","9"},
            {"x","x","2","x"},
            {"x","x","3","x"},
            {"4","x","x","x"},
            {"x","x","10","x"}
    };

    private String OutsAnswers [] = {
            "4",
            "2",
            "3",
            "4",
            "10"
    };

    public int getNumQuestions(){
        return subjQuestions.length;
    }
    public String getQuestion(int x){
        return subjQuestions[x];
    }
    public String getChoice1(int x) {
        return subjChoices[x][0];
    }
    public String getChoice2(int x) {
        return subjChoices[x][1];
    }
    public String getChoice3(int x) {
        return subjChoices[x][2];
    }
    public String getChoice4(int x) {
        return subjChoices[x][3];
    }
    public String getCorrectAnswer(int x){
        return subjAnswers[x];
    }
}
