/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
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
    private Node playerNode;
    private Node creepNode;
    private Node towerNode;

    public void attachOnNode(NodesEnum nodeChoice, Spatial mySpatial) {
        switch (nodeChoice) {
            case CreepNode:
                creepNode.attachChild(mySpatial);
                break;

            case PlayerNode:
                playerNode.attachChild(mySpatial);
                break;

            case TowerNode:
                towerNode.attachChild(mySpatial);
                break;
        }
    }

    public void addControl(NodesEnum nodeChoice, Control myControl) {

        switch (nodeChoice) {
            case CreepNode:
                creepNode.addControl(myControl);
                break;

            case PlayerNode:
                playerNode.addControl(myControl);
                break;

            case TowerNode:
                towerNode.addControl(myControl);
                break;
        }
    }
    

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
        // Nodes creation
        playerNode = new Node("playerNode");
        creepNode = new Node("creepNode");
        towerNode = new Node("towerNode");

        // Nodes attach to rootNode
        simpleApp.getRootNode().attachChild(creepNode);
        simpleApp.getRootNode().attachChild(playerNode);
        simpleApp.getRootNode().attachChild(towerNode);
       
        setUserData();
    }
    
    // Stop to show control in scene
    public void removeControl(Control control){
        simpleApp.getRootNode().removeControl(control);
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
