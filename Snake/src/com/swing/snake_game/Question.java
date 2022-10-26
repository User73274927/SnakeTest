package com.swing.snake_game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private final List<Apple> vars = new ArrayList<>();
    private final List<String> vars_text = new ArrayList<>();
    private final List<Boolean> vars_bool = new ArrayList<>();
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public Question() {

    }

    public void drawVars(Graphics2D g) {
        int x = SnakeField.dot_size * 2, y = SnakeField.dot_size * 2;
        int counter = 1;

        for (Apple apple : vars) {
            apple.drawApple(g);
        }

        g.drawString(question, x, y);
        y += SnakeField.dot_size;

        for (String text : vars_text) {
            g.drawString(counter + ") " + text, x, y);
            y += SnakeField.dot_size;
            counter++;
        }
    }

    Apple createAnswer(String text) {
        Apple apple = new Apple(text);

        Loop:
        while (true) {
            if (SnakeField.getSnakeX() == apple.getX() || SnakeField.getSnakeY() == apple.getY()) {
                apple = new Apple(text);
                continue;
            }

            for (Apple ans : vars) {
                if (apple.getX() == ans.getX() && apple.getY() == ans.getY()) {
                    apple = new Apple(text);
                    continue Loop;
                }
            }
            break;
        }
        return apple;
    }

    boolean checkAns(Apple answer) {
        return (vars_bool.get(Integer.parseInt(answer.getText()) - 1));
    }

    public void setVar(String ans, boolean isRight) {
        vars_text.add(ans);
        vars.add(createAnswer("" + vars_text.size()));
        vars_bool.add(isRight);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Apple> getVars() {
        return vars;
    }
}
