/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment
 * purpose:		Passenger boat sub class of Boat			
 */

public class PassengerBoat extends Boat{		//subclass of Boat class
    private int passengers;
    private boolean carryCars;

    //constructor method to set values
    public PassengerBoat(String name, int Staff, int passengers, boolean carryCars) {
        super(name, Staff);
        this.passengers = passengers;
        this.carryCars = carryCars;
    }

    
    //setters and getters for the class attributes
    
    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public boolean isCarryCars() {
        return carryCars;
    }

    public void setCarryCars(boolean carryCars) {
        this.carryCars = carryCars;
    }

    //method to return passenger boat information
    @Override
    public String toString() {
        return super.toString() + "\nPassengers: " + passengers + "\nCarries Cars: " + carryCars;
    }
    
}
