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
public class Tower extends ConcretObject {

    public static final float X_SCALE = 1f;
    public static final float Y_SCALE = 3f;
    public static final float Z_SCALE = 1f;
    public static int numOfInstances;


    
    public Tower(AssetManager assetManger, Node towerNode){
        super(assetManger, towerNode);
    }
    
    public Tower(AssetManager assetManager, Node towerNode, Vector3f pos){
        super(assetManager, towerNode, pos);
    }

    @Override
    public void CatchErrorInConstructor(Exception ex) {
            System.out.println("Error in Tower" + numOfInstances + " constructor: " + ex.getMessage());
    }  

    @Override
    public void CreateSimple(AssetManager assetManager, Node towerNode) {
        box = new Box(X_SCALE, Y_SCALE, Z_SCALE);
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Green);
        ++numOfInstances;
        geometry = new Geometry("Tower" + numOfInstances, box);
        geometry.setMaterial(mat);
        towerNode.attachChild(geometry);
    }
    
    

    

}
