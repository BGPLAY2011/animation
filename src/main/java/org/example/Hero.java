package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hero extends JPanel {
    private BufferedImage spriteSheet;
    private BufferedImage currentFrame;
    int x = 7;
    int y = 7;
    int stepx = 74;
    int stepy = 80;
    int frameWidth = 60;
    int frameHeight = 75;
    public Hero() {
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/2d.png"));
            currentFrame = spriteSheet.getSubimage(x, y, frameWidth, frameHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveRight() {
        y = 562;
        int maxX = spriteSheet.getWidth() - frameWidth;
        x = (x + stepx > maxX) ? 7 : x + stepx;
        repaint();
        System.out.println("RIGHT: " + x + " " + y);
    }

    public void moveDown() {
        y = 322;
        int maxX = spriteSheet.getWidth() - frameHeight;
        x = (x + stepx > maxX) ? 7 : x + stepx;
        repaint();
        System.out.println("DOWN: " + x + " " + y);
    }

    public void moveUp() {
        y = 482;
        x = (x - stepx < 0) ? spriteSheet.getWidth() - frameWidth : x - stepx;
        repaint();
        System.out.println("UP: " + x + " " + y);
    }

    public void moveLeft() {
        y = 402;
        x = (x - stepx < 0) ? spriteSheet.getWidth() - frameWidth : x - stepx;
        repaint();
        System.out.println("LEFT: " + x + " " + y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (spriteSheet != null) {
            currentFrame = spriteSheet.getSubimage(x, y, frameWidth, frameHeight);

            // Центрирование по окну
            int centerX = (getWidth() - frameWidth) / 2;
            int centerY = (getHeight() - frameHeight) / 2;

            g.drawImage(currentFrame, centerX, centerY, frameWidth, frameHeight, null);
        }
    }
}
