package utils;

import java.awt.*;

public class Mark {
    /*static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;*/
    public static int TYPE_DEFAULT = 0;
    public static int TYPE_ADDITIONAL = 1;
    public static int TYPE_SORTED = 2;

    private int position;
    private int type;
    private Color color;
    //boolean isAdditional = false;
    //public Mark(int position, Color color, int type){


    public Mark(int position, Color color, int type){
        this.position = position;
        this.color = color;
        this.type = type;
    }
    public Mark(int position){
        this.position = position;
        this.color = Color.RED;
        this.type = 0;
    }
    public int getPosition(){
        return this.position;
    }
    public Color getColor(){
        return this.color;
    }
    /*public boolean isAdditional(){
        return this.isAdditional;
    }*/
    public boolean isDefault(){
        return this.type == Mark.TYPE_DEFAULT;
    }
    public int getType(){
        return this.type;
    }
    public void setPosition(int pos){
        this.position = pos;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
