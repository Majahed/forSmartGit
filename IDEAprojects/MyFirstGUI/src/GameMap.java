import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javafx.scene.input.KeyCode.O;

public class GameMap extends JPanel{

    private final int CELL_COUNT = 5;
    private final int FIELD_SIZE = 500;
    private final int CELL_SIZE = FIELD_SIZE/CELL_COUNT;
    final static char PLAYER_DOT = 'X', AI_DOT = 'O', EMPTY_DOT = '*';
    int[][] mapCellStatus;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for (int i = 0; i < CELL_COUNT; i++) {
            g.drawLine(0,i*CELL_SIZE,FIELD_SIZE,i*CELL_SIZE);
        }
        for (int i = 0; i < CELL_COUNT; i++) {
            g.drawLine(i*CELL_SIZE,0,i*CELL_SIZE,FIELD_SIZE);
        }
        g.drawRect(0,0,FIELD_SIZE-1,FIELD_SIZE-1);

        Color myColor = new Color(236,214,157);
        setBackground(myColor);
    }

//int[][] mapCellStatus = new int[CELL_COUNT][CELL_COUNT];

    static void initField() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                mapCellStatus[i][j] = EMPTY_DOT;
            }
        }
    }

    public GameMap() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON1){
                    int x=e.getX()/CELL_SIZE, y=e.getY()/CELL_SIZE;
                    System.out.println(x+" / "+y);
                    mapCellStatus[x][y] = 1;

                    getGraphics().setColor(Color.RED);
                    getGraphics().fillOval(x*CELL_SIZE+20,y*CELL_SIZE+20,CELL_SIZE-40,CELL_SIZE-40);

//                    repaint();
                }
            }
        });
    }
}