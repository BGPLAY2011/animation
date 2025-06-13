package org.example;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI extends JFrame implements KeyListener {
    Hero hero = new Hero();
    private AudioPlayer audioPlayer;

    public UI() {
        setTitle("Keyboard Hero Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        add(hero);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Запускаем музыку из ресурсов
        audioPlayer = new AudioPlayer("/music.wav"); // Путь к файлу в ресурсах
        audioPlayer.play();

        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W -> hero.moveUp();
            case KeyEvent.VK_A -> hero.moveLeft();
            case KeyEvent.VK_D -> hero.moveRight();
            case KeyEvent.VK_S -> hero.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    // Добавь остановку звука при закрытии окна
    @Override
    public void dispose() {
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
        super.dispose();
    }
}
