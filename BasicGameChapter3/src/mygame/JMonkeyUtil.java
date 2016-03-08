/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author GAMEOVER
 */
public class JMonkeyUtil {
    public static void AttachAndSetIndex(Spatial s, Node n){
        int index = n.attachChild(s);
        s.setUserData(n.getName(), index);
    }
}
