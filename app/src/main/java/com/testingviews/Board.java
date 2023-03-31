package com.testingviews;
import java.util.Random;
public class Board {

int playerIndex=-1;
ColoredTile[][]boneyards;
ColoredTile[][]stacks;
Player [] players;

void FillBoard(){
    int i=0;
    for(int x=0; x<7; x++) {
        for (int y = x; y < 7; y++) {
            boneyards[0][i] = new ColoredTile('B', x, y);
            boneyards[1][i] = new ColoredTile('W', x, y);
            i++;
        }
    }
}

void ShuffleTiles(){
    Random rand = new Random();

    for(int b=0;b<2;b++) {
        for (int tile = 0; tile < 28; tile++) {

            int randIndex = rand.nextInt(boneyards[b].length);
            //store ColoredTile at random index in temp
            ColoredTile temp = boneyards[b][randIndex];
            //set random index in boneyard to ColoredTile at index tile
            boneyards[b][randIndex] = boneyards[b][tile];
            //set ColoredTile in boneyard at tile index to temp
            boneyards[b][tile] = temp;
        }
    }

}

int DrawForFirst(){
    int lastTile = boneyards[0].length;
    while(boneyards[0][lastTile].getSum() == boneyards[1][lastTile].getSum()){
        //tie, must reshuffle
        ShuffleTiles();
    }

    if(boneyards[0][lastTile].getSum() > boneyards[1][lastTile].getSum()){
        //human has larger tile to start and thus goes first
        return 0;
    }
    else{
        //computer has larger tile to start and thus goes first
        return 1;
    }

}

boolean DealHand(){
    int lastTile = boneyards[0].length-1;
    ColoredTile [][]hands = new ColoredTile[2][6];
    return false;
}

final boolean FindValidMove(int player){
    for(int y=0; y<2; y++){
        for(int i=0;i<6;i++){
            for(int stile =0; stile<6; stile++){
                if(players[player].getTile(i).getSum()<0){
                    //end of hand reached
                    break;
                }
                if (IsValid(player, i, y, stile)) {
                    return true;
                }
            }
        }
    }

    return false;
}

final boolean IsValid(int player, int ptile, int stack, int stile){

    if(players[player].getTile(ptile).getSum()<0){
        //player selected a tile that is now out of bounds denoted by sum of -2
        return false;
    }

    if(players[player].getTile(ptile).getSum() > stacks[stack][stile].getSum()){
        //player's selected tile is greater than selected stack's tile
        return true;
    }

    if(players[player].getTile(ptile).IsDouble() && !(stacks[stack][stile].IsDouble())){
        //player's selected tile is double and stack's tile is not
        return true;
    }
    return false;
}

void PlayTile(int player, int ptile, int stack, int stile){
    stacks[stack][stile] = players[player].getTile(ptile);
    players[player].ClearTile(ptile);
}
}
