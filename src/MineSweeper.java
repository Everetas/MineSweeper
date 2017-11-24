/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Everetas.PC
 */

public class MineSweeper {
    
    private static Table table = new Table();
    private static int turn = 1;
    private static boolean GameOver = false;
    
    public static void main(String[] args) {
        StartGame(table);
    }
    
    public static void StartGame(Table table) {
        while(!GameOver) {
            System.out.print(turn + " turn");
            table.showGameTable();
            GameOver = table.setLineAndColumn();
            if(!GameOver) {
                table.openNumberTips();
                GameOver = table.gameWin();
            }
            turn++;
            System.out.println();
        }
        if(table.gameWin()) {
            System.out.println("You won!!! " + turn + " turns used");
        } else {
            System.out.println("Mine!!!");
        }
        table.showMines();
    }
}
