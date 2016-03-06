package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 *
 * @author normenhansen
 */
public class CubeChaser extends SimpleApplication {

    private static Box mesh = new Box(1, 1, 1);

    public Geometry myBox(String name, Vector3f loc, ColorRGBA color) {
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        if (FastMath.nextRandomInt(1, 4) == 4) {
            geom.addControl(new CubeChaseControl(cam, rootNode));
        }
        return geom;

    }

    private void makeCubes(int number) {
        for (int i = 0; i < number; i++) {
            // randomize 3d coordinates
            Vector3f loc = new Vector3f(
                    FastMath.nextRandomInt(-20, 20),
                    FastMath.nextRandomInt(-20, 20),
                    FastMath.nextRandomInt(-20, 20));
            rootNode.attachChild(
                    myBox("Cube", loc, ColorRGBA.randomColor()));
        }
    }

    public static void main(String[] args) {
        CubeChaser app = new CubeChaser();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        makeCubes(200);
        flyCam.setMoveSpeed(10f);
        CubeChaserState chaserState = new CubeChaserState();
        this.stateManager.attach(chaserState);
    }

    @Override
    public void simpleUpdate(float tpf) {
        System.out.println("Chase counter: " + stateManager.getState(CubeChaserState.class).getCounter());
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
