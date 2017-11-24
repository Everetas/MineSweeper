/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Everetas.PC
 */

public class Table {
    
    private final Scanner input = new Scanner(System.in);
    private final Random random = new Random();
    private final int[][] Mines;
    private final char[][] GameTable;
    private int Line, Column;
    
    public Table () {
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
        GameTable = new char[][] {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
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
        return random.nextInt(Mines.length - 1) + 1;
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
    
    public void showGameTable() {
        System.out.println("\n");
        System.out.println("Lines");
        for(Line = Mines.length -1; Line >= 0; Line--) {
            System.out.print(Line);
            for(Column = 0; Column <= Mines.length - 1; Column++) {
                    System.out.print("\t" + GameTable[Line][Column]);
            }
            System.out.println();
        }
        System.out.print("Columns");
        for(Column = 0; Column <= Mines.length - 1; Column++) {
                System.out.print(Column + "\t");
        }
        System.out.println();
    }
    
    public void showMines() {
        for(int i = 0; i <= Mines.length - 1; i++)
            for(int j = 0; j <= Mines.length - 1; j++)
                if(Mines[i][j] == -1)
                    GameTable[i][j]='*';
        showGameTable();
    }
    
    public boolean setLineAndColumn() {
            do {
                inputFromNumKeyboard();
                if(((Line <= Mines.length - 1 && Line >= 0) && (Column <= Mines.length - 1 && Column >= 0)))
                    if(GameTable[Line][Column] != '-')
                        System.out.println("This field is already chosen");
                if(Line < 0 || Line > Mines.length - 1 || Column < 0 || Column > Mines.length - 1)
                    System.out.println("Choose a number between 0 and " + (Mines.length - 1));
            } while((Line < 0 || Line > Mines.length - 1 || Column < 0 || Column > Mines.length - 1) || (GameTable[Line][Column] != '-'));
            
            if(mineOrNot(Line, Column) == -1) {
                return true;
            } else return false;
    }
    
    private void inputFromNumKeyboard() {
        System.out.print("Line: ");
        Line = inputInt();
        System.out.print("Column: ");
        Column = inputInt();
    }
    
    private int inputInt() {
        return input.nextInt();
    }
    
    private int mineOrNot(int Line, int Column) {
        return Mines[Line][Column];
    }
    
    public void openNumberTips(){
        for(int i = -1; i <= 1; i++)
            for(int j = -1; j <= 1; j++){
                if(Line == 0 && i == -1)
                    i = 0;
                if(Line == Mines.length - 1 && i == 1)
                    break;
                if(Column == 0 && j == -1)
                    j = 0;
                if(Column == Mines.length - 1 && j == 1)
                    break;
                if(Mines[Line+i][Column+j] != -1)
                     GameTable[Line+i][Column+j] = Character.forDigit(Mines[Line+i][Column+j], 10);
            }
    }
    
    public boolean gameWin() {
        int minesCalc = 0;
        for(int l = 0; l <= Mines.length - 1; l++)
            for(int c = 0; c <= Mines.length - 1; c++)
                if(GameTable[l][c]=='-')
                    minesCalc++;
        if(minesCalc == Mines.length) {
            return true;
        } else return false;
    }
}