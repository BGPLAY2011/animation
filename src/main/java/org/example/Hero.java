package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hero {
    private BufferedImage spriteSheet;
    private int frameX = 7;
    private int frameY = 7;
    private final int frameWidth = 60;
    private final int frameHeight = 75;
    private int stepX = 74;

    public int posX = 100;
    public int posY = 100;

    public Hero() {
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/2d.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveUp() {
        frameY = 482;
        posY -= 10;
        frameX = (frameX - stepX < 0) ? spriteSheet.getWidth() - frameWidth : frameX - stepX;
    }

    public void moveDown() {
        frameY = 322;
        posY += 10;
        frameX = (frameX + stepX > spriteSheet.getWidth() - frameWidth) ? 7 : frameX + stepX;
    }

    public void moveLeft() {
        frameY = 402;
        posX -= 10;
        frameX = (frameX - stepX < 0) ? spriteSheet.getWidth() - frameWidth : frameX - stepX;
    }

    public void moveRight() {
        frameY = 562;
        posX += 10;
        frameX = (frameX + stepX > spriteSheet.getWidth() - frameWidth) ? 7 : frameX + stepX;
    }

    public void draw(Graphics g) {
        if (spriteSheet != null) {
            BufferedImage frame = spriteSheet.getSubimage(frameX, frameY, frameWidth, frameHeight);
            g.drawImage(frame, posX, posY, null);
        }
    }
}
