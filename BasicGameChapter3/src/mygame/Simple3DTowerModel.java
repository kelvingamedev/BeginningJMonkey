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
public class Simple3DTowerModel{

    public static final float X_SCALE = 1f;
    public static final float Y_SCALE = 3f;
    public static final float Z_SCALE = 1f;
    private Geometry geometry;

    /**
     * Instantiates a simple tower model  and attach it in the scene
     */
    public Simple3DTowerModel(AssetManager assetManager, Vector3f pos) {
        this.geometry = create(assetManager, pos);
        this.geometry.setLocalTranslation(pos);

    }

    public static Geometry create(AssetManager assetManager, Vector3f pos) {
        Box box = new Box(X_SCALE, Y_SCALE, Z_SCALE);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        Geometry tower = new Geometry("Tower", box);
        tower.setMaterial(mat);
        tower.setLocalTranslation(pos);
        return tower;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
