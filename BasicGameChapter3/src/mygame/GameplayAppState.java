/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.control.Control;

/**
 *
 * @author GAMEOVER
 */
public class GameplayAppState extends AbstractAppState {

    private SimpleApplication simpleApp;
    private int playerHealth;
    private int level;
    private int score;
    private float budget;
    private boolean lastGameWon;

    

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public float getBudget() {
        return budget;
    }

    public boolean lastGameWon() {
        return lastGameWon;
    }

    public void decreaseHealth() {
        if (playerHealth > 0) {
            playerHealth--;
        }
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.simpleApp = (SimpleApplication) app;   
        setUserData();
    }


    @Override
    public void update(float tpf) {
    }

    @Override
    public void cleanup() {
        simpleApp.getRootNode().detachAllChildren();
    }
    
    private void setUserData(){
        playerHealth = 10;
        budget = 120;
        lastGameWon = false;
        level = 1;
        score = 0;      
    }
    
    public void scoreForPlayerKill(){
        score += 10;
        budget += 10;
    }
}
