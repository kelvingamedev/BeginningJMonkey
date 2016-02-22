package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setSettingsDialogImage("Interface/StickChar.png");
        settings.setUseInput(true);
        
        
        //app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {

        
        // Creating the floor
        Box floorBox = new Box(33f,1f,33f);
        Geometry floor = new Geometry( "floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);
        floor.setLocalTranslation(0f, -2f, 10f);
        rootNode.attachChild(floor);
        
        Node playerNode = new Node("playerNode");
        Node creepNode = new Node("creepNode");
        Node towerNode = new Node("towerNode");
        
        Box baseBox = new Box(2f,5f,2f);
        Material yellowMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        yellowMat.setColor("Color", ColorRGBA.Yellow);
        Geometry playerBase = new Geometry("playerBase", baseBox);
        playerBase.setMaterial(yellowMat);
        playerNode.attachChild(playerBase);
        rootNode.attachChild(playerNode);
        playerBase.setLocalTranslation(0f,0f,0f);

        
        
        Box towerBox = new Box(1f, 3f, 1f);
        Material greenMat = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Geometry playerTower = new Geometry("playerTower", towerBox);
        greenMat.setColor("Color", ColorRGBA.Green);
        playerTower.setMaterial(greenMat);
        towerNode.attachChild(playerTower);
        rootNode.attachChild(towerNode);
        
        Box creepBox = new Box(1f, 1f, 1f);
        Geometry creep = new Geometry("creepBox", creepBox);
        Material blackMat = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        blackMat.setColor("Color", ColorRGBA.Black);
        creep.setMaterial(blackMat);
        creepNode.attachChild(creep);
        rootNode.attachChild(creepNode);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
