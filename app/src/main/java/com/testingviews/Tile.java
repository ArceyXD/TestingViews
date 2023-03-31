package com.testingviews;

public class Tile {
    int left;
    int right;

    public final int getLeft(){
        return left;
    }

    public final int getRight(){
        return right;
    }

    public final int getSum(){
        return left+right;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    boolean IsDouble(){
        if(getLeft()==getRight()){
            return true;
        }

        else{
            return false;
        }
    }

    public Tile(){
        setLeft(0);
        setRight(0);
    }

    public Tile(int left, int right){
        setLeft(left);
        setRight(right);
    }
}
