package movement;

public class KinematicFlee {
	private Character character;	
	private Character target;	
	private double maxSpeed;	
	
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
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public KinematicFlee() {
		super();
	}

	public KinematicFlee(Character character, Character target, double maxSpeed) {
		super();
		this.character = character;
		this.target = target;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "KinematicSeek [character=" + character + ", target=" + target + ", maxSpeed=" + maxSpeed + "]";
	}

	public KinematicOutput generateKinematicOutput(){
		Vector2D velocity = new Vector2D();
		//velocity = this.target.getPosition().subVector2D(this.character.getPosition());
		velocity = this.character.getPosition().subVector2D(this.target.getPosition());
		velocity.normalize();
		velocity.mulConstant(this.maxSpeed);
		
		return new KinematicOutput(velocity, 0);
	}
	
	public static void main(String[] args) {
		Character character = new Character();
		character.setPosition(new Vector2D(2, 1));
		
		Character target = new Character();
		target.setPosition(new Vector2D(9, 1));
		
                System.out.println(target.getPosition());
		System.out.println(target.getOrientation());
                
		KinematicFlee kinematicSeek = new KinematicFlee(character, target, 3);
		KinematicOutput kinematicOutputFlee = kinematicSeek.generateKinematicOutput();
		
                System.out.println(character.getPosition());
		System.out.println(character.getOrientation());
                
		character.update(kinematicOutputFlee, 2);
		character.applyNewOrientation();
		
		System.out.println(character.getPosition());
		System.out.println(character.getOrientation());
	}
}
