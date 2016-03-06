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
import com.jme3.scene.shape.Box;

/**
 *
 * @author GAMEOVER
 */
public class Simple3DCreepModel implements ISimple3DModel {

    private Geometry geometry;

    /*
     * Instantiates a new Creep 3d model and assign it to the scene
     */
    public Simple3DCreepModel(NodesAppState  nodesAppState, AssetManager assetManager, Vector3f pos) {
        this.geometry = createSimple3DModel(assetManager);
        this.geometry.setLocalTranslation(pos);
        nodesAppState.attachOnCreepNode(geometry);
    }

    public Geometry createSimple3DModel(AssetManager assetManager) {
        Box box = new Box(1f, 1f, 1f);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Black);
        Geometry creep = new Geometry("Creep", box);
        creep.setMaterial(mat);
        return creep;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
