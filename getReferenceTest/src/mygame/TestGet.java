/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author GAMEOVER
 */
public class TestGet {
    
    private String message;
    
    public TestGet(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void showMessage(){
        System.out.println(message);
    }
    
}
