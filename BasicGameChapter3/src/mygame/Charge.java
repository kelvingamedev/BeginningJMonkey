/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author GAMEOVER
 */
public class Charge {
    public int minDamage;
    public int maxDamage;
    public int numOfBullets;
    
    // Future improvements: extend CreepControl, create acessors / use setUserData and getUserData
    // and finally use this class in TowerControl. Ask also for a geometry of bullet.
    
    public Charge(int minDamage, int maxDamage, int numOfBullets){
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numOfBullets = numOfBullets;
    }
}
