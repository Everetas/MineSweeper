/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeper;

/**
 *
 * @author Everetas.PC
 */
public class Mines {
    
    private final int[][] Mines;
    private int Line, Column;
    
    public Mines () {
        Mines = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        dropMines();
        fillNumberTips();
    }
    
    private void dropMines() {
        boolean Dropped;
        for(int i = 0; i <= Mines.length - 1; i++){
            do {
                Line = randomNumber();
                Column = randomNumber();
                if(Mines[Line][Column] == -1) {
                    Dropped = true;
                } else Dropped = false;
            } while(Dropped);
            Mines[Line][Column] = -1;
        }
    }
    
    private int randomNumber() {
        return (int) (Math.random() * Mines.length);
    }
    
    private void fillNumberTips(){
        for(int l = 0; l <= Mines.length - 1; l++)
            for(int c = 0; c <= Mines.length - 1; c++) 
                for(int i = -1; i <= 1; i++)
                    for(int j = -1; j <= 1; j++) {
                        if(l == 0 && i == -1)
                            i = 0;
                        if(l == Mines.length - 1 && i == 1)
                            break;
                        if(c == 0 && j == -1)
                            j = 0;
                        if(c == Mines.length - 1 && j == 1)
                            break;
                        if(Mines[l][c] != -1)
                            if(Mines[l+i][c+j] == -1)
                                Mines[l][c]++;
                    }
    }

    public int mineOrNot(int Line, int Column) {
        return Mines[Line][Column];
    }
    
    public int[][] getMines() {
        return Mines;
    }
    
    public int getTips(int Line, int Column) {
        if(mineOrNot(Line, Column) != -1)
            return Mines[Line][Column];
        return -1;
    }
}
