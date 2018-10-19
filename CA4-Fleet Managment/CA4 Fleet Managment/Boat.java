/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment	
 * purpose:		Boat super class	
 */
import java.util.ArrayList;


public class Boat {
	
    private String name;
    private int Staff;
   
    private ArrayList<Sailing> sailingSchedule = new ArrayList<Sailing>();		//container  for sailing schedule
    
    public Boat(String name, int Staff) {		//constructor to set the vaules
        this.name = name;
        this.Staff = Staff;
    }

    //setters and getters for the class attributes
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaff() {
        return Staff;
    }

    public void setStaff(int Staff) {
        this.Staff = Staff;
    }
    // new sailing schedule method
    public void addSailingSchedule(Sailing sailing){
        sailingSchedule.add(sailing);
    }
    //method to return the sailing schedule for a boat
    public ArrayList<Sailing> getSailingSchedule(){
        return sailingSchedule;
    }
  
    @Override
    public String toString() {
        return "Name: " + name + "\nStaff= " + Staff;
    }
    
}
