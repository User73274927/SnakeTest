package com.swing.snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeField extends JPanel implements KeyListener {
    final static int dots = 25;
    final static int dot_size = Window.W_WIDTH / dots;

    protected static Snake snake = new Snake();
    private final Timer start = new Timer(200, e -> repaint());
    private Apple apple;

    public SnakeField() {
        setLayout(null);
        setSize(Window.W_WIDTH, Window.W_HEIGHT);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        snake.move();
        snake.drawSnake(g2);
        Die();
        Eat();
    }

    protected boolean isAppleEat(Apple apple) {
        return (snake.body.get(0).x == apple.getX() &&
                snake.body.get(0).y == apple.getY());
    }

    protected boolean isDied() {
        for (int i = 1; i < snake.body.size(); i++)
            if (snake.body.get(0).x == snake.body.get(i).x &&
                    snake.body.get(0).y == snake.body.get(i).y) {
                return true;
            }
        return false;
    }

    protected void Die() {
        if (isDied()) {
            System.out.println("You lose!");
            stopTimer();
        }
    }

    protected void Eat() {
        if (isAppleEat(apple)) {
            apple = new Apple();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                snake.setDirection(Snake.D_UP);
            }
            case KeyEvent.VK_S -> {
                snake.setDirection(Snake.D_DOWN);
            }
            case KeyEvent.VK_A -> {
                snake.setDirection(Snake.D_LEFT);
            }
            case KeyEvent.VK_D -> {
                snake.setDirection(Snake.D_RIGHT);
            }
        }
    }

    public static int getSnakeX() {
        return snake.getSnakeX();
    }

    public static int getSnakeY() {
        return snake.getSnakeY();
    }

    public void startTimer() {
        start.start();
    }

    public void stopTimer() {
        start.stop();
    }
}