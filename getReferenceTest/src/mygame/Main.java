package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
       /* TestGet myTest = new TestGet("Hello World");
        String message = new String(myTest.getMessage());
        message = "Hello Kelvin";
        String copyReferenceMsg = message;
        copyReferenceMsg = "Hello Copy";
        System.out.println("This in myTest class"+ myTest.getMessage());
        System.out.println("This in message reference" + message);
        System.err.println("This is a copy of message reference " + copyReferenceMsg);
        */
        
        GreenCube tower = new GreenCube(assetManager, Vector3f.ZERO);
        rootNode.attachChild(tower.getGeometry());
        
        //tower.getGeometry() = new Geometry("a");        
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
