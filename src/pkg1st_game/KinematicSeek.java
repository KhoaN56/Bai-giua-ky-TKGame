package pkg1st_game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class KinematicSeek {
    
    private Character character;
    private Character target;
    private float maxSpeed;

    public KinematicSeek() {
    }

    public KinematicSeek(Character character, Character target, float maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getTarget() {
        return target;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public KinematicOutput generateKinematicOutput(){
        Vector2D velocity = new Vector2D();
        velocity = Vector2D.subVector2D(target.getPosition(),character.getPosition());
        velocity.normalize();
        velocity.mulConstant(maxSpeed);
        character.setOrientation(Character.getNewOrientation(character.getOrientation(), velocity));
        return new KinematicOutput(velocity, 0);
    }
    
    public static void main(String[] args) {
        Character character = new Character();
        character.setPosition(new Vector2D(2, 1));
        System.out.println(character.getPosition());
        System.out.println(character.getOrientation());
        Character target = new Character();
        target.setPosition(new Vector2D(9, 1));
        System.out.println(character.getPosition());
        System.out.println(character.getOrientation());
        KinematicSeek kinematicSeek = new KinematicSeek(character, target, 1);
        KinematicOutput kinematicOutput = kinematicSeek.generateKinematicOutput();
        character.update(kinematicOutput, 1);
        character.applyNewOrientation();
        
        System.out.println(character.getPosition());
        System.out.println(character.getOrientation());
    }
}
