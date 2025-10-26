/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;



import java.io.Serializable;

/**
 *
 * @author husse
 */
public abstract class Record implements Serializable{
    
        public abstract String getSearchKey();
        
    
    public abstract String lineRepresentation();
    
}
