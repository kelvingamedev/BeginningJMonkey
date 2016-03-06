/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author GAMEOVER
 */
public class CubeChaseControl extends AbstractControl {
    
    public String Hello(){
        return "Hello, my name is " + this.spatial.getName();
    }

    private Ray ray = new Ray();
    private final Camera cam;
    private final Node rootNode;

    public CubeChaseControl(Camera cam, Node rootNode) {
        this.cam = cam;
        this.rootNode = rootNode;
    }

    @Override
    protected void controlUpdate(float tpf) {

    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
    

    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException(
                "Not supported yet.");
    }
}
