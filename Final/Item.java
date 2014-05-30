
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item {
    private int gold;
    private String name;
    private int lvl;
    
    public Item() {
        gold = 0;
    }
    
    public int getGold() {
        return gold;
    }
    
    public String getName() {
        return name;
    }
    
    public int getLvl() {
        return lvl;
    }
    
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
