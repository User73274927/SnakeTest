package com.swing.snake_game;

import java.awt.*;
import java.util.Random;

public class Apple {
    private final static int size = SnakeField.dot_size;
    private final Rectangle apple;
    private Font font = new Font("Serif", Font.PLAIN, (int)(SnakeField.dot_size * 0.75));
    private String text = "";

    public Apple() {
        Random random = new Random();
        apple = new Rectangle();

        int x = random.nextInt(0, (SnakeField.dots - 1)) * SnakeField.dot_size;
        int y = random.nextInt(0, (SnakeField.dots - 1)) * SnakeField.dot_size;
        apple.setBounds(x, y, size, size);
    }

    public Apple(String text) {
        this();
        this.text = text;
    }

    public void drawApple(Graphics2D g) {
        g.setColor(Color.RED);
        g.fill(apple);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.draw(apple);
        g.drawString(text,
                getX() + (int)(SnakeField.dot_size * 0.35),
                getY() + (int)(SnakeField.dot_size * 0.8)
        );
    }

    public String getText() {
        return text;
    }

    public int getX() {
        return apple.x;
    }

    public int getY() {
        return apple.y;
    }

}