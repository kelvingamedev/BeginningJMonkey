package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.setPauseOnLostFocus(true); // Pause the game when gamer don t use the game window
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        // Prints the camera position in the scene begin
        System.out.println("CAMERA POSITION BEGIN "+   cam.getLocation());
        System.out.println("CAMERA ROTATION BEGIN "+  cam.getRotation());
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);
   
        

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        geom.setLocalScale(0.5f, 0.5f, 0.5f);
        geom.rotate(FastMath.DEG_TO_RAD * 15, 
                0f, 0f);
        
        rootNode.attachChild(geom);
        
        Vector3f v = new Vector3f(2.0f, 3.0f, -4.0f);
        Box boxYellow = new Box(1,1,1);
        Geometry cubeYellow = new Geometry("Box", boxYellow);
        Material yellowMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        yellowMat.setColor(("Color"), ColorRGBA.Yellow);
        cubeYellow.setMaterial(yellowMat);
        cubeYellow.setLocalScale(2.0f);
        cubeYellow.setLocalScale(2.0f);
        
        Quaternion quart45XAxis = new Quaternion();
        quart45XAxis.fromAngleAxis(FastMath.DEG_TO_RAD  * -45,Vector3f.UNIT_X );
        
        cubeYellow.setLocalRotation(quart45XAxis);
        cubeYellow.setLocalTranslation(v);
        
        rootNode.attachChild(cubeYellow);
        
        Node pivot = new Node("pivot node");
        pivot.attachChild(geom);
        pivot.attachChild(cubeYellow);
        pivot.rotate(0, 0, FastMath.DEG_TO_RAD * 45);
        rootNode.attachChild(pivot);
        
        
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
