//*******************************************************************
//
//   File: CafeWall.java         
//
//   Author: maximilian           
//
//   Class: CafeWall
// 
//  
//   --------------------
//  
//   This program recreates the "Cafe Wall" illusion using given points
//   on a predetermined drawing panel in Java.
//
//*******************************************************************
import java.awt.*;
public class CafeWall {
    final static int MORTAR = 2;
    final static int WIDTH = 650;
    final static int HEIGHT = 400;
    // set up panel and graphics objects
    static DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
    static Graphics2D g = panel.getGraphics();
    public static void main(String[] args) {
        // Change from Color.GRAY to change background color.
        panel.setBackground(Color.GRAY);
        drawRow(0, 2, 4, 20);
        drawRow(50, 70, 5, 30);
        drawGrid(10, 339, 4, 25, 0);
        drawGrid(250, 335, 3, 25, 10);
        drawGrid(425, 378, 5, 20, 10);
        drawGrid(400, 131, 2, 35, 35);
    }
    // Draw a row of squares, the total number of squares is pairs * 2
    // (x, y) is the top-left corner of the first box
    public static void drawRow(int x, int y, int pairs, int size) {
            for(int squares = 0; squares < pairs; squares++){
    
    //draws black squares in the row
            g.setColor(Color.BLACK);
            g.fillRect(x + (2 * squares * size), y, size, size);
    
    //draws blue Xs in the black squares
            g.setColor(Color.blue);
            g.drawLine(x + (2 * squares * size), y, x + size +(2 * squares * size), y + size);
            g.drawLine(x + (2 * squares * size), y + size, x + size + (2 * squares * size), y);
    
    //draws white squares in the row
            g.setColor(Color.WHITE);
            g.fillRect(x + (2 * squares * size + size) , y, size, size);
        }
    }//end of drawRow method

    // Draw a grid of 2 * pairs rows
    public static void drawGrid(int x, int y, int pairs, int size, int offset){
                for (int i = 0; i < pairs * 2; i++) {
                    drawRow(x + offset * (i % 2), y - (size * i) - (MORTAR * i), pairs, size);
                }
    }//end of drawGrid method
}
