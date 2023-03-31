package com.testingviews;

public class Player {
    int score;
    int winningRounds;
    ColoredTile[] hand;

    public final int getScore() {
        return score;
    }

    public final int getWinningRounds() {
        return winningRounds;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWinningRounds(int winningRounds) {
        this.winningRounds = winningRounds;
    }

    public void SetHand(ColoredTile[] hand) {
        for(int tile=0; tile<6; tile++){
            if(hand[tile].getSum()==-2){
                break;
            }
            else{
                this.hand[tile] = hand[tile];
            }
        }
    }

    public void ClearHand(){
        for(int tile=0; tile<6; tile++){
            this.hand[tile].setLeft(-1);
            this.hand[tile].setRight(-1);
        }
    }

    public void ClearTile(int t){
        this.hand[t] = new ColoredTile(this.hand[t].getColor(),-1,-1);

        for(int tile=t; tile<6; tile++){
            ColoredTile temp = this.hand[tile+1];
            this.hand[tile+1]=this.hand[tile];
            this.hand[tile] = temp;
        }
    }

    public final ColoredTile getTile(int tile){
        return this.hand[tile];
    }

    public void ClearScore(){
        setScore(0);
    }

    public void ClearWinningRounds(){
        setWinningRounds(0);
    }

    public Player(){
        setScore(0);
        setWinningRounds(0);
    }
    public Player(int score, int winningRounds){
        setScore(score);
        setWinningRounds(winningRounds);
    }
}
