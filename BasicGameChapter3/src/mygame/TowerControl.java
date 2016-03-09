/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author GAMEOVER
 */
public class TowerControl extends AbstractControl {

    // The book tells to create a height field, but i'm not taking that suggestion.
    private NodesAppState nodesAppState;
    private GameplayAppState gmAppState;
    private static float timer = 0;
    private static final float RELOAD = 2f;

   /* public int getNumOfBullets() {
        return getCharge().numOfBullets;
    }*/

    public TowerControl(NodesAppState nodesAppState, GameplayAppState gmAppState) {
        this.nodesAppState = nodesAppState;
        this.gmAppState = gmAppState;
    }

   /* private void setCharge(Charge charge) {
        spatial.setUserData(IndexKeys.CHARGE_KEY, charge);
    }*/

    private void setReloadTime(float reload) {
        spatial.setUserData(IndexKeys.RELOAD_KEY, reload);
    }
    
    public float getReloadTime(){
        return spatial.getUserData(IndexKeys.RELOAD_KEY);
    }

    /*public Charge getCharge() {
        return (Charge) spatial.getUserData(IndexKeys.CHARGE_KEY);
    }*/

    public void setUserData() {
        setReloadTime(RELOAD);
    }

    @Override
    protected void controlUpdate(float tpf) {
        timer += tpf;
        if (timer > getReloadTime()) {
            // Shoot
        }

    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
