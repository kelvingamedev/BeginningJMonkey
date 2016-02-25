package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setSettingsDialogImage("Interface/StickChar.png");
        settings.setUseInput(true);


        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        // SimpleApplication settings
        //this.setDisplayFps(false);
        //this.setDisplayStatView(false);
        
        // FlyCam settings
        flyCam.setMoveSpeed(10f);
        flyCam.setZoomSpeed(10f);
        cam.setLocation(new Vector3f(0f, 20f, 20f));
        cam.lookAt(new Vector3f(0f, -20f, 0f), new Vector3f(0f, 0f, 0f));


        // Creating the floor
        Box floorBox = new Box(33f, 1f, 33f);
        Geometry floor = new Geometry("floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);
        floor.setLocalTranslation(0f, -2f, 10f);
        rootNode.attachChild(floor);

        // Nodes creation
        Node playerNode = new Node("playerNode");
        Node creepNode = new Node("creepNode");
        Node towerNode = new Node("towerNode");

        // Player base
        Box baseBox = new Box(3f, 2f, 3f);
        Material yellowMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        yellowMat.setColor("Color", ColorRGBA.Yellow);
        Geometry playerBase = new Geometry("playerBase", baseBox);
        playerBase.setMaterial(yellowMat);
        playerNode.attachChild(playerBase);
        rootNode.attachChild(playerNode);
        playerBase.setLocalTranslation(0f, 0f, 0f);



        // Towers
        Tower myTower = new Tower(assetManager, towerNode, new Vector3f(-4f, 0f, 7f));
        Tower otherTower = new Tower(assetManager, towerNode, new Vector3f(4f, 0f, 7f));
        rootNode.attachChild(towerNode);

        // Creeps
        Creep myCreep = new Creep(assetManager, creepNode, new Vector3f(0f, 0f, 10f));
        Creep otherCreep = new Creep(assetManager, creepNode, new Vector3f(0f, 0f, 13f));
        Creep yetOtherCreep = new Creep(assetManager, creepNode, new Vector3f(0f, 0f, 16f));
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
