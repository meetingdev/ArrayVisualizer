package utils;

import java.awt.*;

public class Mark {
    int position;
    Color color;
    public Mark(int position, Color color){
        this.position = position;
        this.color = color;
    }
    public Mark(int position){
        this.position = position;
        this.color = Color.RED;
    }
    public int getPosition(){
        return this.position;
    }
    public Color getColor(){
        return this.color;
    }
    public void setPosition(int pos){
        this.position = pos;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
