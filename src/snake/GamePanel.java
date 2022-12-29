package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;

    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    int bodyPArts = 6;
    int applesEaten = 0;
    int appleCoordinateX;
    int appleCoorinateY;
    char direction = 'R';
    boolean moving = false;
    Timer timer;
    Random random;

    GamePanel() {

    }

    public void startGame() {

    }

    public void paintComponent(Graphics g) {

    }

    public void draw(Graphics graphics) {

    }

    public void move() {

    }

    public void checkForMouse() {

    }

    public void checkForCollisions() {

    }

    public void gameOver(Graphics graphics) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class MyKeyAdapter extends KeyAdapter implements snake.MyKeyAdapter {

        @Override
        public void KeyPressed(KeyEvent event) {


        }
    }
}
