/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableDrawingStrategy;

/**
 *
 * @author Everetas.PC
 */
public interface TableDrawingStrategy {
    
    public boolean elementType(int Line, int Column);

    public void Draw();
    
}
