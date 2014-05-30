
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Item {
    private int dmg;
    
    public Weapon() {
        super();
        dmg = 0;
    }
    
    public int getDmg() {
        return dmg;
    }
    
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
