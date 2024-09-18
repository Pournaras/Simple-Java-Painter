package frame_package;

import java.awt.*;

public class ColorPoint {

    private Color color;
    private int x, y;
    private int size;


    ColorPoint(int x, int y, Color color, int size){
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }

    public Color getColor(){
        return color;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getSize(){
        return size;
    }
}
