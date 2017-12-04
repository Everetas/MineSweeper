/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import MineSweeper.GameLogic;
import org.junit.Test;
import MineSweeper.Mines;
import MineSweeper.PlayerTable;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Everetas.PC
 */
public class GameTests {
    
    private final char[][] TestPlayerTable;
    private final Mines mines;
    private final PlayerTable playerTable;
    private final GameLogic gameLogic;
    
    public GameTests() {
        TestPlayerTable = new char[][] {
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
        mines = new Mines();
        playerTable = new PlayerTable(mines);
        gameLogic = new GameLogic(mines, playerTable);
    }

    @Test
    public void playerTable() {
        Assert.assertArrayEquals(playerTable.getGameTable(), TestPlayerTable);
    }
    
    @Test
    public void minesDropped() {
        int minesDropped = 0;
        for(int i = 0; i < mines.getMines().length; i++) {
            for(int j = 0; j < mines.getMines().length; j++) {
                if(mines.mineOrNot(i, j) == -1) {
                    minesDropped++;
                }
            }
        }
        assertEquals(mines.getMines().length, minesDropped);
    }
    
    @Test
    public void inputTest() {
        int input1 = (int) (Math.random() * 10);
        int input2 = (int) (Math.random() * 10);
        assertEquals(true, gameLogic.checkInput(input1, input2));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
