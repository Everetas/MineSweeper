/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeper;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Everetas.PC
 */
public class Input {
    
    private final Scanner input = new Scanner(System.in);
    private int Line, Column;
    
    public Input() throws IOException {
        readPlayerInput();
    }
    
    private void readPlayerInput() throws IOException {
        try {
            System.out.print("Line: ");
            Line = input.nextInt();
            System.out.print("Column: ");
            Column = input.nextInt();
        } catch(Exception e) {
            Line = -1;
            Column = -1;
        }
    }

    public int getLine() {
        return Line;
    }

    public int getColumn() {
        return Column;
    }
    
    
}
