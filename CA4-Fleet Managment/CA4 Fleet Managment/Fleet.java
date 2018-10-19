/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment
 * purpose:		Fleet class		
 */
import java.util.ArrayList;

public class Fleet {
   
    private String name;
    private ArrayList<Boat> boats;
    public int fleetIdNum;

    
    //constructor method to set values
    public Fleet(String name) {
        this.name = name;
        boats = new ArrayList<Boat>();
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }
    
    
    public int getFleetIdNum() {
		return fleetIdNum;
	}

	public void setFleetIdNum(int fleetIdNum) {
		this.fleetIdNum = fleetIdNum;
	}


	//method to add new boat to fleet
    public void addBoat(Boat b){
        boats.add(b);
    }
    //method to remove a boat from a fleet
    public String removeBoat(Boat b){
        if(boats.contains(b)){
            boats.remove(b);
            return "Boat Removed!";
        }
        return "Boat Not Found!";
        
    }
    //method to retun number of boats in a fleet
    public int size(){
        return boats.size();
    }

    @Override
    public String toString() {
        if(size() == 0)
            return "Fleet Name: " + name + ", \nNo Boats Yet!";
        return "Fleet Name: " + name + "\nBoats: " + boats.toString();
        
    }
    
    
}
