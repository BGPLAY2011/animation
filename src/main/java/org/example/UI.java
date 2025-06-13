package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements KeyListener {
    private final Hero hero = new Hero();
    private final GamePanel gamePanel = new GamePanel(hero);
    private final AudioPlayer audioPlayer;

    public UI() {
        setTitle("Hero Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Настройка кнопки настроек с масштабированной иконкой
        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/settings.png"));
        Image scaled = rawIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);

        JButton settingsButton = new JButton(icon);
        settingsButton.setPreferredSize(new Dimension(40, 40));
        settingsButton.setFocusable(false); // чтобы не отнимать фокус
        settingsButton.addActionListener(e -> openSettingsDialog());

        // Панель для кнопки
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(settingsButton);

        add(topPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        // Фокус и управление
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(this);
        gamePanel.requestFocusInWindow();

        // Музыка
        audioPlayer = new AudioPlayer("/music.wav");
        audioPlayer.play();

        setVisible(true);
    }

    private void openSettingsDialog() {
        JDialog dialog = new JDialog(this, "Настройки", true);
        dialog.setLayout(new FlowLayout());

        JButton pauseBtn = new JButton("Пауза");
        pauseBtn.addActionListener(e -> audioPlayer.stop());

        JButton playBtn = new JButton("Включить");
        playBtn.addActionListener(e -> audioPlayer.play());

        dialog.add(playBtn);
        dialog.add(pauseBtn);

        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(this);

        // Вернуть фокус к игровому полю после закрытия окна
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                gamePanel.requestFocusInWindow();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                gamePanel.requestFocusInWindow();
            }
        });

        dialog.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> hero.moveUp();
            case KeyEvent.VK_S -> hero.moveDown();
            case KeyEvent.VK_A -> hero.moveLeft();
            case KeyEvent.VK_D -> hero.moveRight();
        }
        gamePanel.repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void dispose() {
        if (audioPlayer != null) audioPlayer.stop();
        super.dispose();
    }
}
