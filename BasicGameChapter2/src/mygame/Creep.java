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
public class Creep extends ConcretObject {

    private int numOfInstances;

    public Creep(AssetManager assetManager, Node creepNode) {
        super(assetManager, creepNode);
    }
    
    public Creep(AssetManager assetManager, Node creepNode, Vector3f pos)
    {
        super(assetManager, creepNode, pos);
    }

    @Override
    protected void CreateSimple(AssetManager assetManager, Node objectNode) {
        box = new Box(1f, 1f, 1f);
        mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Black);
        ++numOfInstances;
        geometry = new Geometry("Creep" + numOfInstances, box);
        geometry.setMaterial(mat);
        objectNode.attachChild(geometry);
    }

    @Override
    protected void CatchErrorInConstructor(Exception ex) {
        System.out.println("Error in Creep" + numOfInstances + " constructor: " + ex.getMessage());
    }

    @Override
    public int getNumInstance() {
        return numOfInstances;
    }
}
