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
public class GreenCube{

    public static final float X_SCALE = 1f;
    public static final float Y_SCALE = 1f;
    public static final float Z_SCALE = 1f;
    private Geometry geometry;

   
    /*
     * Instantiates a simple tower model  and attach it in the scene
     */
    public GreenCube(AssetManager assetManager, Vector3f pos) {
        this.geometry = createSimple3DModel(assetManager);
        this.geometry.setLocalTranslation(pos);
        
    }

    private Geometry createSimple3DModel(AssetManager assetManager) {
        Box box = new Box(X_SCALE, Y_SCALE, Z_SCALE);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        Geometry geometry = new Geometry("Tower", box);
        geometry.setMaterial(mat);
        return geometry;
    }
    
    public void changePos(Vector3f pos){
        this.geometry.setLocalTranslation(pos);
    }
    
    
    public Geometry getGeometry(){
        return geometry;
    }
    
}
