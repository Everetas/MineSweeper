/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStarter;

import java.io.IOException;

/**
 *
 * @author Everetas.PC
 */
public class StartGame {
    
    public Game createConcoleGame() throws IOException {
            return new ConsoleGame();
    }
}
