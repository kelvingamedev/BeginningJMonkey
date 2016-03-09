/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.FastMath;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.control.AbstractControl;

/**
 *
 * @author GAMEOVER
 */
public class CreepControl extends AbstractControl {

    private GameplayAppState gmAppState;
    private NodesAppState nodesAppStates;
    public static final int MIN_HEALTH_DECREASE = 15;
    public static final int MAX_HEALTH_DECREASE = 25;
    public static final float SPEED = -2f;
    public static final boolean STOP_MOVE = false;
    public static final int HEALTH = 100;

    public float getSpeed() {
        return (Float) spatial.getUserData(IndexKeys.SPEED_KEY);
    }

    public void setSpeed(float speed) {
        spatial.setUserData(IndexKeys.SPEED_KEY, speed);
    }

    public void decreaseHealth(Charge takedShoot) {
        setHealth(getHealth() - FastMath.nextRandomInt(
                takedShoot.minDamage, takedShoot.maxDamage));
    }

    private void setHealth(int health) {
        spatial.setUserData(IndexKeys.HEALTH_KEY, health);
    }

    public Integer getHealth() {
        return (Integer) spatial.getUserData(IndexKeys.HEALTH_KEY);
    }

    public boolean getStopToMove() {
        return (Boolean) spatial.getUserData("stopToMove");
    }

    private void setStopToMove(boolean state) {
        spatial.setUserData("stopToMove", state);
    }

    public CreepControl(GameplayAppState gmAppState, NodesAppState nodeAppState) {
        this.gmAppState = gmAppState;
        this.nodesAppStates = nodeAppState;
    }

    /**
     * Use this for set creep data defined by default
     *
     */
    public void setUserData() {
        setSpeed(SPEED);
        setStopToMove(STOP_MOVE);
        setHealth(HEALTH);
    }

    /**
     * Use this for set custom creep data
     *
     */
    public void setUserData(float speed, int health, boolean stopToMove) {
        setSpeed(speed);
        setHealth(health);
        setStopToMove(stopToMove);
    }

    @Override
    protected void controlUpdate(float tpf) {
        if (!getStopToMove()) {
            if (spatial.getLocalTranslation().z > Simple3DPlayerBaseModel.Z_SCALE + Simple3DCreepModel.Z_SCALE
                    && getHealth() > 0) {
                spatial.move(0, 0, getSpeed() * tpf);
            } else {
                setStopToMove(true);
            }
        }
        
        // Creep dies
        if (getHealth() <= 0) {
            gmAppState.scoreForPlayerKill();
            nodesAppStates.getCreepNode().detachChild(spatial);
            
        // Creep causes damage    
        } else if (spatial.getLocalTranslation().z <= Simple3DPlayerBaseModel.Z_SCALE + Simple3DCreepModel.Z_SCALE) {
            gmAppState.decreaseHealth(); // What about the player health stay at playerNode?
            nodesAppStates.getCreepNode().detachChild(spatial);
        }

    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
    }
}
