package warriors.player;

import warriors.weapon.Weapon;

public abstract class Player {
	
	
	public Player() {;
		minAttack = 9;
		MAX_ATTACK = 15;
		minLife = 3;
		maxLife = 10;
		weapon = new Weapon();
	}
	
	/**
	 * Constructor of Player with information
	 * 
	 *
	 * @param String name , Player_type type
	 * @return void
	 */
	public Player(String _name, int _minLife, int _maxLife, int _minAttack, int _maxAttack ) {
		this.name = _name;
		
		this.minLife = _minLife;
		this.maxLife = _maxLife;
		this.minAttack = _minAttack;
		this.MAX_ATTACK = _maxAttack;
		this.life = (int)( Math.random()*(this.maxLife-this.minLife) + this.minLife  );
		this.attack = (int)(Math.random()*(this.MAX_ATTACK-this.minAttack) + this.minAttack);
		weapon = new Weapon();
		
	}
	
	//Name of player
	private String name;
	// Life lever until dying
	private int life;
	// Minimum life when initialized
	public final int minLife;
	// Maximum life during all the game ( init + game )
	public final int maxLife;
	// Level of attack without weapon
	private int attack;
	// Minimum level of attack when initialized
	public final int minAttack;
	// Maximum level of attack considering the addition of the weapon attack
	public final int MAX_ATTACK;
	//Weapon
	private Weapon weapon;
	
	
	
	
	/**
	 * Return all information in one string
	 * 
	 *
	 * @param void
	 * @return String 
	 */
	public String toString() {
		return ("Personnage = "+this.name+" | type="+this.getPlayerTypeToString()+" | vie="+this.life+" | attack="+this.attack+" | Arme="+this.weapon.getName());
	}
	
	/**
	 * Getter from name attribute
	 * 
	 *
	 * @param void
	 * @return String 
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Setter from name attribute
	 * 
	 *
	 * @param String new name
	 * @return Void 
	 */
	public void setName(String _name) {
		if(_name.length()>0) {
			this.name = _name;
		}
	}
	
	/**
	 * Get type of concrete abstraction of player type, 
	 * given in String 
	 *
	 * @param void
	 * @return String 
	 */
	public String getPlayerTypeToString() {
		if( this instanceof Magician) {
			return "Magicien";
		}
		else if( this instanceof Warrior) {
			return "Guerrier";
		}
		else {
			return "UNDEFINED";
		}
	}
	
	
	/**
	 * Getter from life attribute
	 * 
	 *
	 * @param void
	 * @return int life level
	 */
	public int getLife() {
		return this.life;
	}
	
	
	
	/**
	 * Setter from life attribute
	 * 
	 *
	 * @param int new life
	 * @return void
	 */
	public void setLife(int l) {

		if(l<=this.maxLife) {
			this.life = l;
		}else {
			this.life = maxLife;
		}
			
	}
	
	/**
	 * Getter from attack attribute
	 * 
	 *
	 * @param void
	 * @return int attack level
	 */
	public int getAttack() {
		return this.attack;
	}
	
	/**
	 * Get the addition of player force + weapon force
	 * This addition cannot exceed player max force
	 * 
	 *
	 * @param void
	 * @return int attack level
	 */
	public int getFinalAttack() {
		if( (this.attack + this.weapon.getForce()) > this.MAX_ATTACK) {
			return this.MAX_ATTACK;
		}else {
			return (this.attack + this.weapon.getForce());
		}
	}
	
	/**
	 * Setter from attack attribute
	 * 
	 *
	 * @param void
	 * @return int attack level
	 */
	public void setAttack(int a) {

		if(a <= this.MAX_ATTACK) {
			this.attack = a;
		}else {
			this.attack = this.MAX_ATTACK;
		}
		
	}
	
	public void setWeapon(Weapon w) {
		if(w != null) {
			this.weapon = w;
		}
	}
	

}
