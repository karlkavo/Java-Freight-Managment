/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment	
 * purpose:		Freight boat sub class of Boat	
 */
public class FreightBoat extends Boat {
    
    private int capacity;
    
    public FreightBoat(String name, int Staff, int capacity) {		//contructor method to set values
        super(name, Staff);
        this.capacity = capacity;
    }

    
    //setters and getters for the class attributes
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
        return super.toString()+", Capacity: " + capacity ;
    }
    
    
}

