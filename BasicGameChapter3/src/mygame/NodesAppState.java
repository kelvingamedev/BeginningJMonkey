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

/**
 *
 * @author GAMEOVER
 */
public class NodesAppState extends AbstractAppState {

    private Node towerNode;
    private Node creepNode;
    private Node playerNode;
    private Node rootNode;

    public void attachOnTowerNode(Spatial spatial) {
        towerNode.attachChild(spatial);
    }

    public void attachOnCreepNode(Spatial spatial) {
       creepNode.attachChild(spatial);
    }

    public void attachOnPlayerNode(Spatial spatial) {
        playerNode.attachChild(spatial);
    }

    public Node getRootNode() {
        return rootNode;
    }
    
    public NodesAppState(){
        towerNode = new Node("towerNode");
        creepNode = new Node("creepNode");
        playerNode = new Node("playerNode");
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        SimpleApplication simpleApp = (SimpleApplication) app;
        this.rootNode = simpleApp.getRootNode();
               
        // Set All nodes in root node here
        this.rootNode.attachChild(creepNode);
        this.rootNode.attachChild(towerNode);
        this.rootNode.attachChild(playerNode);
    }
}
