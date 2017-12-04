
import GameStarter.Game;
import GameStarter.StartGame;

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
   
    public static void main(String[] args) throws Exception {
        StartGame startGame = new StartGame();
        Game game = startGame.createConcoleGame();
        game.run();
    }
}
