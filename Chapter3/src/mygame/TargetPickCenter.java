package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;


/**
 * test
 * @author normenhansen
 */
public class TargetPickCenter extends SimpleApplication {

    //private final static Trigger TRIGGER_COLOR = new KeyTrigger(KeyInput.KEY_SPACE);
    private final static Trigger TRIGGER_ROTATE = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    //private final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_C);
    
    //private final static String MAPPING_COLOR = "Toggle Color";
    private final static String MAPPING_ROTATE = "Rotate";
    
    public static void main(String[] args) {
        TargetPickCenter app = new TargetPickCenter();
        app.start();
    }
    
    private static Box mesh = new Box(1,1,1);
    
    public Geometry myBox(String name, Vector3f loc, ColorRGBA color)
    {
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        return geom;
        
    }
    
    private void attachCenterMark(){
        Geometry c = myBox("center mark", Vector3f.ZERO, ColorRGBA.White);
        c.scale(4);
        c.setLocalTranslation(settings.getWidth()/2, settings.getHeight()/2, 0);
        guiNode.attachChild(c);
    }

    @Override
    public void simpleInitApp() {
        //Como eu posso tirar o INPUT que ja vem com o jogo (A,S,D,W, mmovimento mouse...)
        
        
        attachCenterMark();
        
        
        //Mappings
        inputManager.addMapping(MAPPING_ROTATE, TRIGGER_ROTATE);
        inputManager.addListener(analogListener,new String[] {MAPPING_ROTATE});

        rootNode.attachChild(myBox("Red Cube", new Vector3f(0, 1.5f, 0), ColorRGBA.Red));
        rootNode.attachChild(myBox("Blue Cube", new Vector3f(0, -1.5f, 0), ColorRGBA.Blue));
        
    }
    
    private AnalogListener analogListener = new AnalogListener() {

        public void onAnalog(String name, float value, float tpf) {
           if (name.equals(MAPPING_ROTATE)) {
               CollisionResults results = new CollisionResults();
               Ray ray = new Ray(cam.getLocation(), cam.getDirection());
               rootNode.collideWith(ray, results);
               
               for (int i = 0; i < results.size(); i++){
                   float dist = results.getCollision(i).getDistance();
                   Vector3f pt = results.getCollision(i).getContactPoint();
                   String target = results.getCollision(i).getGeometry().getName();
                    System.out.println("Selection: #" + i + ": " + target +        " at " + pt + ", " + dist + " WU away."); 
               }
               
               if (results.size() > 0){
                   Geometry target = results.getClosestCollision().getGeometry();
                   if (target.getName().equals("Red Cube")){
                       target.rotate(0, -value, 0); //rotate left
                   }else if (target.getName().equals("Blue Cube")){
                       target.rotate(0, value, 0); // rotate right                       
                   }
                   
               }else{
                   System.out.println("Selection: Nothing ");
               }
               
           }
        }
    };
    
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
