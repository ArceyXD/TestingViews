package com.testingviews;

public class ColoredTile extends Tile{
    char color;

    public final char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public ColoredTile(){
        setLeft(-1);
        setRight(-1);
        setColor('$');
    }

    public ColoredTile(char color, int left, int right){
        setLeft(left);
        setRight(right);
        setColor(color);
    }
}
