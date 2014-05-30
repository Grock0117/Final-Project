
/**
 * Write a description of class Armor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Armor extends Item {
    private int end;
    
    public Armor() {
        super();
        setGold(100 + (50 * end));
        end = 0;
    }
    
    public int getEnd() {
        return end;
    }
    
    public void setEnd(int end) {
        this.end = end;
    }
}
