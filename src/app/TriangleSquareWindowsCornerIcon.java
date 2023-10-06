package app;


import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jonathan Simon
 * Date: Oct 5, 2004
 * Time: 6:03:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleSquareWindowsCornerIcon implements Icon {

    //RGB values discovered using ZoomIn
    private static final Color THREE_D_EFFECT = new Color(255, 255, 255);
    private static final Color SQUARE_LEFT = new Color(184, 180, 163);
    private static final Color SQUARE_TOP_RIGHT = new Color(184, 180, 161);
    private static final Color SQUARE_BOTTOM_RIGHT = new Color(184, 181, 161);

    //Dimensions
    private static final int WIDTH = 12;
    private static final int HEIGHT = 12;



    @Override
    public int getIconHeight() {
        return WIDTH;
    }

    @Override
    public int getIconWidth() {
        return HEIGHT;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        //Layout a row and column "grid"
        int fila1 = 0;
        int col1 = 0;
        int dif1 = 4;
        int difcolum1 = 4;

        int fila2 = fila1 + dif1;
        int col2 = col1 + difcolum1;
        int dif3 = fila2 + dif1;
        int dofcolum3 = col2 + difcolum1;


        //Draw the white squares first, so the gray squares will overlap
        draw3dSquare(g, col1+1, dif3+1);

        draw3dSquare(g, col2+1, fila2+1);
        draw3dSquare(g, col2+1, dif3+1);

        draw3dSquare(g, dofcolum3+1, fila1+1);
        draw3dSquare(g, dofcolum3+1, fila2+1);
        draw3dSquare(g, dofcolum3+1, dif3+1);

        //draw the gray squares overlapping the white background squares
        drawSquare(g, col1, dif3);

        drawSquare(g, col2, fila2);
        drawSquare(g, col2, dif3);

        drawSquare(g, dofcolum3, fila1);
        drawSquare(g, dofcolum3, fila2);
        drawSquare(g, dofcolum3, dif3);

    }

    private void draw3dSquare(Graphics g, int x, int y){
        Color oldColor = g.getColor(); //cache the old color
        g.setColor(THREE_D_EFFECT); //set the white color
        g.fillRect(x,y,2,2); //draw the square
        g.setColor(oldColor); //reset the old color
    }


    private void drawSquare(Graphics g, int x, int y){
        Color oldColor = g.getColor();
        g.setColor(SQUARE_LEFT);
        g.drawLine(x,y, x,y+1);
        g.setColor(SQUARE_TOP_RIGHT);
        g.drawLine(x+1,y, x+1,y);
        g.setColor(SQUARE_BOTTOM_RIGHT);
        g.drawLine(x+1,y+1, x+1,y+1);
        g.setColor(oldColor);
    }

}
