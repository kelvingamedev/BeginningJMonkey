/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import sun.org.mozilla.javascript.internal.ast.CatchClause;

/**
 *
 * @author GAMEOVER
 */
public abstract class ConcretObject {

    protected Box box;
    protected Material mat;
    protected Geometry geometry;

    protected ConcretObject(AssetManager assetManager, Node objectNode) {
        try {
            CreateSimple(assetManager, objectNode);
        } catch (Exception ex) {
            CatchErrorInConstructor(ex);
        }
    }

    protected ConcretObject(AssetManager assetManager, Node objectNode, Vector3f pos) {
        try {
            CreateSimple(assetManager, objectNode);
            geometry.setLocalTranslation(pos);
        } catch (Exception ex) {
            CatchErrorInConstructor(ex);
        }
    }

    protected abstract void CreateSimple(AssetManager assetManager, Node objectNode);

    protected abstract void CatchErrorInConstructor(Exception ex);
}
