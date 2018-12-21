/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1st_game;

import static java.lang.invoke.MethodHandles.constant;

/**
 *
 * @author USER
 */
public class KinematicArriving {

    private Character character;
    private Character target;
    private double maxSpeed;
    private double maxAcceleration;
    private double targetRadius;
    private double slowRadius;
    private float timeToTarget = (float) 0.25;

    public KinematicArriving(Character character, Character target, double maxSpeed, double maxAcceleration, double targetRadius, double slowRadius) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
        this.maxAcceleration = maxAcceleration;
        this.targetRadius = targetRadius;
        this.slowRadius = slowRadius;
    }

    

    public KinematicArriving() {
    }

    public Character getCharacter() {
        return character;
    }

    public Character getTarget() {
        return target;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
    
    public double getMaxAcceleration(){
        return this.maxAcceleration;
    }
    
    public double getSlowRadius(){
        return this.slowRadius;
    }

    public double getTargetRadius() {
        return targetRadius;
    }

    public float getTimeToTarget() {
        return timeToTarget;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setTargetRadius(float targetRadius) {
        this.targetRadius = targetRadius;
    }

    public KinematicOutput generateKinematicOutput() {
        Vector2D direction = new Vector2D();
        direction = Vector2D.subVector2D(target.getPosition(), character.getPosition());
        double distance = direction.getLength();
        if (distance < this.targetRadius) {
            return new KinematicOutput(new Vector2D(0,0), 0);
        }
        double targetSpeed;
        if(distance > this.slowRadius)
            targetSpeed = this.maxSpeed;
        else
            targetSpeed = this.maxSpeed*(distance/this.slowRadius);
        Vector2D targetVelocity = new Vector2D();
        targetVelocity = direction;
        targetVelocity.normalize();
        targetVelocity.mulConstant(targetSpeed);
        Vector2D linear = new Vector2D();
        character.setOrientation(Character.getNewOrientation(character.getOrientation(), targetVelocity));
//        character.setRotation(0);
        return new KinematicOutput(targetVelocity, 0);
    }
}
