package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Hero hero;

    public GamePanel(Hero hero) {
        this.hero = hero;
        setBackground(Color.LIGHT_GRAY); // фон сцены
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        hero.draw(g);
    }
}
