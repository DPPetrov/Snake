package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 75;

    private final int[] snakeX = new int[GAME_UNITS];
    private final int[] snakeY = new int[GAME_UNITS];

    int bodyParts = 6;
    int miceEaten = 0;
    int mouseCoordinateX;
    int mouseCoordinatesY;
    char direction = 'R';
    boolean isMoving = false;
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

    public void startGame() {

        newMouse();
        isMoving = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics graphics) {

        if (isMoving) {
            graphics.setColor(Color.green);
            graphics.fillOval(mouseCoordinateX, mouseCoordinatesY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {

                if (i == 0) {
                    graphics.setColor(Color.green);
                    graphics.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    graphics.setColor(new Color(45, 180, 0));
                    graphics.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            graphics.setColor(Color.red);
            graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: " + miceEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + miceEaten)) / 2, graphics.getFont().getSize());

        }else{
            gameOver(graphics);
        }
    }


    public void newMouse() {

        mouseCoordinateX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        mouseCoordinatesY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    protected void move() {

        for (int i = bodyParts; i > 0; i--) {

            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];

        }

        switch (direction) {
            case 'U' -> snakeY[0] = snakeY[0] - UNIT_SIZE;
            case 'D' -> snakeY[0] = snakeY[0] + UNIT_SIZE;
            case 'L' -> snakeX[0] = snakeX[0] - UNIT_SIZE;
            case 'R' -> snakeX[0] = snakeX[0] + UNIT_SIZE;
        }

    }

    public void checkForMouse() {

        if((snakeX[0] == mouseCoordinateX) && (snakeY[0] == mouseCoordinatesY)) {
            bodyParts++;
            miceEaten++;
            newMouse();
        }

    }

    public void checkCollisions() {
        //checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])) {
                isMoving = false;
                break;
            }
        }
        //check if head touches left border
        if (snakeX[0] < 0) {
            isMoving = false;
        }
        //check if head touches right border
        if (snakeX[0] > SCREEN_WIDTH) {
            isMoving = false;
        }
        //check if head touches top border
        if (snakeY[0] < 0) {
            isMoving = false;
        }
        //check if head touches bottom border
        if (snakeY[0] > SCREEN_HEIGHT) {
            isMoving = false;
        }

        if (!isMoving) {
            timer.stop();
        }
    }

    public void gameOver(Graphics graphics) {

        graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: " + miceEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + miceEaten)) / 2, graphics.getFont().getSize());
        //Game Over text
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (isMoving) {
            move();
            checkForMouse();
            checkCollisions();
        } else {
            repaint();
        }
    }

    protected class MyKeyAdapter extends KeyAdapter implements snake.MyKeyAdapter {

        @Override
        public void KeyPressed(KeyEvent event) {

            switch (event.getKeyCode()) {

                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;

                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }


        }
    }
}
