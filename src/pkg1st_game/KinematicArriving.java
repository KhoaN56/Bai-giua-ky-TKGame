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

    Character character;
    Character target;
    float maxSpeed;
    float radius;
    private float timeToTarget = (float) 0.25;

    public KinematicArriving(Character character, Character target, float maxSpeed, float radius) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
        this.radius = radius;
    }

    public KinematicArriving() {
    }

    public Character getCharacter() {
        return character;
    }

    public Character getTarget() {
        return target;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getRadius() {
        return radius;
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

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public KinematicOutput generateKinematicOutput() {
        Vector2D velocity = new Vector2D();
        velocity = Vector2D.subVector2D(target.getPosition(), character.getPosition());
        if (velocity.getLength() < this.radius) {
            return new KinematicOutput(new Vector2D(0,0), 0);
        }
        velocity = velocity.mulConstant(1 / timeToTarget);
        if (velocity.getLength() > this.maxSpeed) {
            velocity.normalize();
            velocity.mulConstant(maxSpeed);
        }
        character.setOrientation(Character.getNewOrientation(character.getOrientation(), velocity));
//        character.setRotation(0);
        return new KinematicOutput(velocity, 0);
    }
}
