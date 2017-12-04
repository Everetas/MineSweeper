/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStarter;

import MineSweeper.GameLogic;
import MineSweeper.GameRenderer;
import MineSweeper.Input;
import MineSweeper.Mines;
import MineSweeper.PlayerTable;

/**
 *
 * @author Everetas.PC
 */
public class ConsoleGame implements Game {
    
    private int turn = 1;
    private boolean gameOver = false;
    
    public void run() throws Exception {
        Input input;
        Mines mines = new Mines();
        PlayerTable playerTable = new PlayerTable(mines);
        GameLogic gameLogic = new GameLogic(mines, playerTable);
        GameRenderer gameRenderer = new GameRenderer(mines, playerTable);
        
        while(!gameOver) {
            System.out.print(turn + " turn");
            gameRenderer.showGameTable();
            do {
                input = new Input();
            } while(!gameLogic.checkInput(input.getLine(), input.getColumn()));
            gameOver = gameLogic.gameLost(input.getLine(), input.getColumn());
            if(!gameOver) {
                playerTable.setNumberTipsOnGameTable(input.getLine(), input.getColumn());
                gameOver = gameLogic.gameWin();
            }
            turn++;
            System.out.println();
        }
        if(gameLogic.gameWin()) {
            System.out.print("You won!!! " + turn + " turns used");
        } else {
            System.out.print("Mine!!!");
        }
        playerTable.setMinesOnGameTable();
        gameRenderer.showGameTable();
        System.exit(0);
    }
    
}
