package com.swing.snake_game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int x, y;
    private final int speed = SnakeField.dot_size;
    private int direction = D_RIGHT;
    List<Rectangle> body = new ArrayList<>();

    final static int D_UP = 0;
    final static int D_DOWN = 1;
    final static int D_LEFT = 3;
    final static int D_RIGHT = 4;

    public Snake() {
        x = SnakeField.dot_size * 13;
        y = SnakeField.dot_size * 13;
        body.add(new Rectangle(x, y, SnakeField.dot_size, SnakeField.dot_size));
        body.get(0).setLocation(x, y);
    }

    public void drawSnake(Graphics2D g) {
        setSnakeLocation();
        for (Rectangle b : body) {
            g.setColor(Color.GREEN);
            g.fill(b);
            g.setColor(Color.BLACK);
            g.draw(b);
        }
    }
    private void setSnakeLocation() {
        int x = this.x, y = this.y, p_x, p_y;
        for (Rectangle r : body) {
            p_x = r.x;
            p_y = r.y;
            r.setLocation(x, y);
            x = p_x;
            y = p_y;
        }
    }

    public void move() {
        switch (direction) {
            case D_UP -> moveUp();
            case D_DOWN -> moveDown();
            case D_LEFT -> moveLeft();
            case D_RIGHT -> moveRight();
        }

    }

    public void addBody() {
        body.add(new Rectangle(x, y, SnakeField.dot_size, SnakeField.dot_size));
    }

    public void setDirection(int direction) {
        if (Math.abs(this.direction - direction) != 1)
            this.direction = direction;
    }

    public int getSnakeX() {
        return body.get(0).x;
    }

    public int getSnakeY() {
        return body.get(0).y;
    }

    public void moveUp() {
        if (y <= 0)
            y = Window.W_HEIGHT;
        else y -= speed;
    }

    public void moveDown() {
        if (y >= Window.W_HEIGHT)
            y = 0;
        else y += speed;
    }

    public void moveLeft() {
        if (x <= 0)
            x = Window.W_WIDTH + SnakeField.dot_size;
        else x -= speed;
    }

    public void moveRight() {
        if (x >= Window.W_WIDTH - SnakeField.dot_size)
            x = 0;
        else x += speed;
    }
}