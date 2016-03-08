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
import com.jme3.scene.control.Control;
import com.jme3.scene.shape.Box;

/**
 *
 * @author GAMEOVER
 */
public class Simple3DCreepModel{

    private Geometry geometry;
    public static final float X_SCALE = 1f, Y_SCALE = 1f, Z_SCALE = 1f;

    /*
     * Instantiates a new Creep 3d model and assign it to the scene
     */
    public Simple3DCreepModel(NodesAppState nodesAppState , AssetManager assetManager, Vector3f pos) {
        this.geometry = create(assetManager, pos);
    }

    public static Geometry create(AssetManager assetManager, Vector3f pos) {
        Box box = new Box(X_SCALE, Y_SCALE, Z_SCALE);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Black);
        Geometry creep = new Geometry("Creep", box);
        creep.setMaterial(mat);
        creep.setLocalTranslation(pos);
        return creep;
    }

    public Geometry getGeometry() {
        return geometry;
    }
   
}
