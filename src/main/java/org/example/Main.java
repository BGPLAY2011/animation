package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

class Hero extends JPanel {
    private BufferedImage spriteSheet;
    private BufferedImage currentFrame;
    int x = 7;
    int y = 7;
    int stepx = 75;
    int stepy = 80;

    Hero() {
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/2d.png"));
            currentFrame = spriteSheet.getSubimage(x, y, 100, 129);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(70, 90));
    }
    public void moveRight(){
        x +=stepx;
        if (x>735){
            x = 7;
        }
        repaint();
    }
    public void moveDown() {
        y +=stepy;
        if (y>637){
            y = 7;
        }
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentFrame = spriteSheet.getSubimage(x, y+stepy*4, 100, 129);
        g.drawImage(currentFrame, 0, 0, 735 , 637, null);
    }
}
class UI extends JFrame implements MouseListener {
    Hero hero = new Hero();
    public UI() {
        setLayout(null);
        setPreferredSize(new Dimension(400, 400));
        hero.setBounds(0, 0, 400, 400);
        add(hero);
        pack();
        addMouseListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        hero.moveRight();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
