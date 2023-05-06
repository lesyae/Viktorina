package com.example.viktorina;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    public static List<QuestionsList> pravilaQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Как по — другому называют игровую зависимость:",
            "лудомания", "лудогория", "лудофилия", "игральная зависимость",
            "лудомания", "");

        final QuestionsList question2 = new QuestionsList("Лудомания:",
                "патологическая склонность отыграться", "патологическая склонность к азартным играм ",
                "оба варианта верны", "нет верного ответа",
                "патологическая склонность к азартным играм ", "");


        final QuestionsList question3 = new QuestionsList("Игровая зависимость:",
                "предполагаемая форма физической зависимости", "предполагаемая форма психологической зависимости ",
                "оба варианта верны", "нет верного ответа",
                "оба варианта верны ", "");


        final QuestionsList question4 = new QuestionsList("С чем ряд учёных сравнивает игровую зависимость:",
                "с алкоголем", "с наркотиками",
                "оба варианта верны ", "нет верного ответа",
                "оба варианта верны ", "");


        final QuestionsList question5 = new QuestionsList("Существует несколько факторов, влияющих на развитие игровой зависимости:",
                "несформированная или неустойчивая психика", "отсутствие навыков самоконтроля",
                "оба варианта верны ", "нет верного ответа",
                "оба варианта верны ", "");

        final QuestionsList question6 = new QuestionsList("Существует несколько факторов, влияющих на развитие игровой зависимости:",
                "желание компенсировать нереализованные жизненные потребности", "неудовлетворённость реальной жизнью",
                "оба варианта верны ", "нет верного ответа",
                "оба варианта верны ", "");


        final QuestionsList question7 = new QuestionsList("«Ошибкам мышления», которые формируют иррациональные установки игроманов:",
                "стратегические", "тактические",
                "оба варианта верны ", "нет верного ответа",
                "оба варианта верны ", "");


        final QuestionsList question8 = new QuestionsList(". К стратегическим ошибкам мышления относятся следующие внутренние убеждения:",
                "уверенность в победе", "замещение мыслей о контроле над собственным будущим фантазиями о выигрышe",
                "оба варианта верны", "нет верного ответа",
                "замещение мыслей о контроле над собственным будущим фантазиями о выигрышe", "");


        final QuestionsList question9 = new QuestionsList(". К тактическим ошибкам мышления относятся:",
                "вера в выигрышный, фартовый день", "установка на то, что обязательно должен наступить переломный момент в игре",
                "оба варианта верны ", "игральная зависимость",
                "оба варианта верны","");


        final QuestionsList question10 = new QuestionsList(". К тактическим ошибкам мышления относятся:",
                "восприятие денег во время игры как фишек или цифр на дисплее",
                "представление о том, что возможно вернуть долги только с помощью игры, то есть отыграть",
                "все варианты верны +", "нет верного ответа",
                "все варианты верны ", "");



        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }
    public static List<QuestionsList>getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "pravila" : return pravilaQuestions();
        }
        return null;
    }

}
