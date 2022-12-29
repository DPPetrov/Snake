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

    private final int snakeX[] = new int[GAME_UNITS];
    private final int snakeY[] = new int[GAME_UNITS];

    int bodyParts = 6;
    int miceEaten = 0;
    int mouseCoordinateX;
    int mouseCoorinateY;
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

        newMouse();
        moving = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics graphics) {

        graphics.setColor(Color.green);
        graphics.fillOval(mouseCoordinateX, mouseCoorinateY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) {

            if (i == 0) {
                graphics.setColor(Color.green);
                graphics.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
            }else {
                graphics.setColor(new Color(45, 180, 0));
                graphics.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
            }
        }

    }

    private void newMouse() {

        mouseCoordinateX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        mouseCoorinateY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    protected void move() {

        for (int i = bodyParts; i > 0; i--) {

            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeX[i - 1];

        }

        switch (direction) {

            case 'U':
                snakeY[0] = snakeY[0] - UNIT_SIZE;
                break;

            case 'D':
                snakeY[0] = snakeY[0] + UNIT_SIZE;
                break;

            case 'L':
                snakeX[0] = snakeX[0] - UNIT_SIZE;
                break;

            case 'R':
                snakeX[0] = snakeX[0] + UNIT_SIZE;
                break;
        }

    }

    private void checkForMouse() {


    }

    private void checkForCollisions() {

    }

    protected void gameOver(Graphics graphics) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (moving){
            move();
            checkForMouse();
            checkForCollisions();
        }else{
            repaint();
        }
    }

    protected class MyKeyAdapter extends KeyAdapter implements snake.MyKeyAdapter {

        @Override
        public void KeyPressed(KeyEvent event) {


        }
    }
}
