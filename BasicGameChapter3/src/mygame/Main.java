package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private NodesAppState nodesAppState;
    private GameplayAppState gmAppState;
    private static final Vector3f camFixedPOS = (new Vector3f(0f, 20f, 20f));

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        nodesAppState = new NodesAppState();
        this.stateManager.attach(nodesAppState);
        gmAppState = new GameplayAppState();
        this.stateManager.attach(gmAppState);

        // FlyCam settings
        flyCam.setMoveSpeed(10f);
        flyCam.setZoomSpeed(10f);
        cam.setLocation(camFixedPOS);
        cam.lookAt(new Vector3f(0f, -20f, 0f), new Vector3f(0f, 0f, 0f));


        // Creating the floor
        Box floorBox = new Box(33f, 1f, 33f);
        Geometry floor = new Geometry("floor", floorBox);
        Material orangeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        orangeMat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(orangeMat);
        floor.setLocalTranslation(0f, -2f, 10f);
        rootNode.attachChild(floor);



        // Player base
        Simple3DPlayerBaseModel playerBase = new Simple3DPlayerBaseModel(nodesAppState, assetManager, Vector3f.ZERO);

        // Place Towers    
        Geometry myTower = Simple3DTowerModel.create(assetManager, new Vector3f(-4f, 0f, 7f));
        myTower.addControl(new TowerControl(nodesAppState, gmAppState));
        myTower.getControl(TowerControl.class).setUserData();
        nodesAppState.getTowerNode().attachChild(myTower);
        
        Geometry otherTower = Simple3DTowerModel.create(assetManager, new Vector3f(4f, 0f, 7f));
        otherTower.addControl(new TowerControl(nodesAppState, gmAppState));
        otherTower.getControl(TowerControl.class).setUserData();
        nodesAppState.getTowerNode().attachChild(otherTower);

        // Create creeps
        Geometry[] creeps = new Geometry[5];
        int i = 0;
        float posZ = 20f;
        while (i < 5) {
            creeps[i] = Simple3DCreepModel.create(assetManager, new Vector3f(0f, 0f, posZ));
            creeps[i].addControl(new CreepControl(gmAppState, nodesAppState));
            creeps[i].getControl(CreepControl.class).setUserData();
            nodesAppState.getCreepNode().attachChild(creeps[i]);
            i++;
            posZ += 3f;
        }
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
