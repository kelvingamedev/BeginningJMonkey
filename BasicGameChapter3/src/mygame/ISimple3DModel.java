/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Geometry;

/**
 *
 * @author GAMEOVER
 */
public interface ISimple3DModel {
    Geometry createSimple3DModel(AssetManager assetManager);
    Geometry getGeometry();
}
