package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 75;

    private final int x[] = new int[GAME_UNITS];
    private final int y[] = new int[GAME_UNITS];

    int bodyParts = 6;
    int applesEaten = 0;
    int appleCoordinateX;
    int appleCoorinateY;
    char direction = 'R';
    boolean moving = false;
    Timer timer;
    Random random;

    GamePanel() {

        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    private void startGame() {

    }

    public void paintComponent(Graphics g) {

    }

    private void draw(Graphics graphics) {

    }

    private void newMouse() {

    }

    protected void move() {

    }

    private void checkForMouse() {

    }

    private void checkForCollisions() {

    }

    protected void gameOver(Graphics graphics) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    protected class MyKeyAdapter extends KeyAdapter implements snake.MyKeyAdapter {

        @Override
        public void KeyPressed(KeyEvent event) {


        }
    }
}
