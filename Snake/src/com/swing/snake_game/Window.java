package com.swing.snake_game;

import javax.swing.*;

public class Window {
    final static int W_WIDTH = 500;
    final static int W_HEIGHT = 500;

    private final JFrame frame = new JFrame("Snake");
    private final QuestionField field = new QuestionField();

    public void launch() {
        frame.setBounds(200, 200, W_WIDTH, W_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.getContentPane().add(field.getEnd_field());
        frame.getContentPane().add(field);
        frame.addKeyListener(field);
    }


    public static void main(String[] args) {
        Window window = new Window();
        window.launch();
    }

}