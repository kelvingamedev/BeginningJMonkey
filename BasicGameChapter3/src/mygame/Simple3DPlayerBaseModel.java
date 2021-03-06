/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author GAMEOVER
 */
public class Simple3DPlayerBaseModel implements ISimple3DModel {

    private Geometry geometry;
    public static final float X_SCALE = 3f, Y_SCALE = 2f, Z_SCALE = 3f;
  
    /*
     * Instantiate a new Player Base Model and assign it to the root node
     */
    public Simple3DPlayerBaseModel(NodesAppState nodesAppState,AssetManager assetManager, Vector3f pos) {
        this.geometry = createSimple3DModel(assetManager);
        this.geometry.setLocalTranslation(pos);
        Node playerNode = nodesAppState.getPlayerNode();
        playerNode.attachChild(geometry);
    }    


    public Geometry createSimple3DModel(AssetManager assetManager) {
        Box baseBox = new Box(X_SCALE, Y_SCALE, Z_SCALE);
        Material yellowMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        yellowMat.setColor("Color", ColorRGBA.Yellow);
        Geometry playerBase = new Geometry("playerBase", baseBox);
        playerBase.setMaterial(yellowMat);
        return playerBase;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
