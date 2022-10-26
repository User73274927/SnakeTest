package com.swing.snake_game;

import java.awt.*;

public class QuestionField extends SnakeField {
    private final Question[] quiz = new Question[5];
    private final EndField end_field = new EndField();
    private int quiz_num = 0;

    public QuestionField() {
        super();
        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = new Question();
        }
        quiz[0].setQuestion("Какая Столица кореи?");
        quiz[0].setVar("Пусан", false);
        quiz[0].setVar("Сеул", true);
        quiz[0].setVar("Инчон", false);

        quiz[1].setQuestion("Поэтическое название Кореи (Как у Японии)?");
        quiz[1].setVar("Страна утренней свежести", true);
        quiz[1].setVar("Страна тысячи погод", false);
        quiz[1].setVar("Страна восходящего солнца", false);

        quiz[2].setQuestion("Традиционная одежда корейцев?");
        quiz[2].setVar("Ханбок", true);
        quiz[2].setVar("Комоно", false);
        quiz[2].setVar("Ханьфу", false);

        quiz[3].setQuestion("Как называется корейский алфавит?");
        quiz[3].setVar("Хирагана", false);
        quiz[3].setVar("Катакана", false);
        quiz[3].setVar("Хангыль", true);

        quiz[4].setQuestion("Вам понравилась викторина?");
        quiz[4].setVar("Да", true);
        quiz[4].setVar("Нет", true);
        startTimer();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        quiz[quiz_num].drawVars(g2);
    }

    @Override
    public void Die() {
        if (isDied()) {
            stopTimer();
            setVisible(false);
            end_field.setResults(snake.body.size() - 1, quiz.length - 1);
            end_field.perform();
        }
    }

    @Override
    public void Eat() {
        for (Apple apple : quiz[quiz_num].getVars()) {
            if (isAppleEat(apple)) {
                if (quiz[quiz_num].checkAns(apple)) {
                    snake.addBody();
                }
                if (quiz_num < quiz.length - 1) {
                    quiz_num++;
                } else {
                    stopTimer();
                    setVisible(false);
                    end_field.setResults(snake.body.size() - 2, quiz.length - 1);
                    end_field.perform();
                }
                break;
            }
        }
    }

    public EndField getEnd_field() {
        return end_field;
    }

}