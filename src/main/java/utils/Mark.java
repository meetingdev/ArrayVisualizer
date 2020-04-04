package utils;

import java.awt.*;

public class Mark {
    /*static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;*/
    public static int TYPE_UNDEFINED = -1;
    public static int TYPE_WHITE = 0;
    public static int TYPE_MARK = 1;
    public static int TYPE_END = 2;

    int position;
    Color color;
    boolean isAdditional = false;
    //public Mark(int position, Color color, int type){


    public Mark(int position, Color color, boolean isAdditional){
        this.position = position;
        this.color = color;
        this.isAdditional = isAdditional;
    }
    public Mark(int position){
        this.position = position;
        this.color = Color.RED;
        this.isAdditional = false;
    }
    public int getPosition(){
        return this.position;
    }
    public Color getColor(){
        return this.color;
    }
    public boolean isAdditional(){
        return this.isAdditional;
    }
    public void setPosition(int pos){
        this.position = pos;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
