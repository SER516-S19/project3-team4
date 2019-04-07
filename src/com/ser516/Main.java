package com.ser516;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        QuizDAO quizDAO = JSONParser.parseFile("check.json");
        System.out.println(quizDAO.getQuizName());
        System.out.println(quizDAO.getQuestionList());

        List<QuizDAO> quizDAOList = JSONParser.parseDirectory(".");
        System.out.println(quizDAOList.get(0).getQuizName());
        System.out.println(quizDAOList.get(0).getQuestionList());
    }
}
