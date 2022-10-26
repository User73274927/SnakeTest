package com.swing.snake_game;

import javax.swing.*;
import java.awt.*;

class EndField extends JPanel {
    private final Font font = new Font("", Font.PLAIN, 25);
    private int a, b;

    public EndField() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setVisible(false);
        setSize(Window.W_WIDTH, Window.W_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        String text = "Вы набрали: " + a + " из " + b;
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        int x = Window.W_WIDTH - text.length() * 25;
        int y = Window.W_HEIGHT / 2 - 25;
        g2.drawString(text, x, y);
    }

    public void perform() {
        setVisible(true);
    }

    public void setResults(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
