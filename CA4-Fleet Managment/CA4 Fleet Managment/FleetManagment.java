
/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment		
 * Purpose:		Main driver class
 */
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FleetManagment extends Application {

    @Override
    public void start(Stage stage) {
        initUI(stage);
    }

    public static ArrayList<Fleet> fleets = new ArrayList<Fleet>();
    public static Boat boat = null;
    public static Fleet fleet = null;
    private void initUI(Stage stage) {
    

        GridPane root = new GridPane();
   
        TextArea taDisplay = new TextArea();  		//Displays fleet output information
        taDisplay.setPrefSize(350, 500);
        taDisplay.setText("Fleet List:");
        taDisplay.setStyle("-fx-font: 14 arial;");
       
       
        root.setHgap(30);
        root.setVgap(20);
        root.setPadding(new Insets(25));
        
        Button btAddFleet = new Button("Add Fleet Item");
        btAddFleet.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");		//styles the font size and button colour
        btAddFleet.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //ask user for the name of fleet
                String name = JOptionPane.showInputDialog("Name of Fleet: ");
                fleet = new Fleet(name);    //create new fleet
                //check the fleet size should not exceed 5
                if(fleets.size() == 5){
                    JOptionPane.showMessageDialog(null, "You already have 5 fleets added!");
                }
                else
                    fleets.add(fleet);  //add the fleet
            }
        });
        
        Button btRemoveFleet = new Button("Remove Fleet item");
        btRemoveFleet.setStyle("-fx-font: 14 arial; -fx-base: #B22222;");		//styles the font size and button colour
        btRemoveFleet.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String name = JOptionPane.showInputDialog("Name of Fleet: ");   //ask the fleet name
                boolean valid = false;
                //check if the fleet exists
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){   //if the fleet is found
                        fleets.remove(i);   //remove it 
                        valid = true;
                    }
                }
                if(valid == true)   
                    JOptionPane.showMessageDialog(null, "Fleet Removed!");		//message if the fleet is deleted
                else 
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");    //display the error message 
            }
        });
        Button btAddPBoat = new Button("Add Passenger Boat");
        btAddPBoat.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");		//styles the font size and button colour
        btAddPBoat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ind = 0;
                String name = JOptionPane.showInputDialog("Name of Fleet: ");   //prompts for the fleet name
                boolean valid = false;
                //check if the fleet exists
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){
                        valid = true;
                        ind = i;
                    }
                }
                if(valid == true){  //if the fleet is found
                    name = JOptionPane.showInputDialog("Name of Boat: ");   ///enter boat name and other information
                    int staff = Integer.parseInt(JOptionPane.showInputDialog("No. Of Staff: "));
                    int passengers = Integer.parseInt(JOptionPane.showInputDialog("No. Of Passengers: "));
                    int carryCars = JOptionPane.showOptionDialog(null, null, "Does it carry cars?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    //create new boat 
                    if(carryCars == 0)
                        boat = new PassengerBoat(name, staff, passengers, true);    
                    else if(carryCars == 1)
                        boat = new PassengerBoat(name, staff, passengers, false);
                    fleets.get(ind).addBoat(boat);  //add boat to fleet

                }
                else 
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");    //display error message, if the fleet is not found
            }
        });
        Button btAddFBoat = new Button("Add Frieght Boat");
        btAddFBoat.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");		//styles the font size and button colour
        btAddFBoat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ind = 0;
                String name = JOptionPane.showInputDialog("Name of Fleet: ");   //prompts for fleet name
                boolean valid = false;
                //check for the fleet's existance
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){
                        valid = true;
                        ind = i;
                    }
                }
                if(valid == true){  //if the fleet is found
                    name = JOptionPane.showInputDialog("Name of Boat: ");   // name of boat and other info
                    int staff = Integer.parseInt(JOptionPane.showInputDialog("No. Of Staff: "));
                    int capacity = Integer.parseInt(JOptionPane.showInputDialog("Capacity: "));
                    boat = new FreightBoat(name, staff, capacity);  //create a new boat
                    fleets.get(ind).addBoat(boat);  //add a boat to a fleet
                }
                else 
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");    //if the fleet is not found
            }
        });
        Button btRemoveBoat = new Button("Remove A Boat");
        btRemoveBoat.setStyle("-fx-font: 14 arial; -fx-base: #B22222;");		//styles the font size and button colour
        btRemoveBoat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ind = 0;
                //enter name of fleet
                String name = JOptionPane.showInputDialog("Name of Fleet: ");
                boolean valid = false;
                //checks if fleet excists
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){
                        valid = true;
                        ind = i;
                    }
                }
                if(valid == true){  //if fleet name is valid
                    name = JOptionPane.showInputDialog("Name of Boat: ");   //enter name of boat to delete it
                    valid = false;
                    for (int i = 0; i < fleets.get(ind).getBoats().size(); i++) {   //find the boat in a fleet
                        if(name.equals(fleets.get(ind).getBoats().get(i).getName())){   //if the boat is found
                            fleets.get(ind).getBoats().remove(i);   //remove it from the fleet
                        }
                    }
                }
                else //displays an error message if the fleet is not found
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");
            }
        });
        Button btDisplay = new Button("Display Fleet List");
        btDisplay.setStyle("-fx-font: 14 arial; -fx-base: #ADD8E6;");		//styles the font size and button colour
        btDisplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String res = "";
                
                for (int i = 0; i < fleets.size(); i++) {		//append all boats and fleets to the string
                    res += fleets.get(i)+"\n";
                }
              
                taDisplay.setText(res);
                //JOptionPane.showMessageDialog(null, res);   //display the results to the user
        
            }
        });
        Button btAddSchedule = new Button("Add sailing Schedule");
        btAddSchedule.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");		//styles the font size and button colour
        btAddSchedule.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Sailing sailing = null;
                int ind = 0;
                String name = JOptionPane.showInputDialog("Name of Fleet: ");   //enter fleet name 
                boolean valid = false;
                //check for fleet's existance
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){
                        valid = true;
                        ind = i;
                    }
                }
                if(valid == true){  //if the fleet is valid
                    name = JOptionPane.showInputDialog("Name of Boat: ");   //enter boat name
                    valid = false;
                    int indB = 0;
                    //chec if the boat name is valid
                    for (int i = 0; i < fleets.get(ind).getBoats().size(); i++) {
                        if(name.equals(fleets.get(ind).getBoats().get(i).getName())){
                            valid = true;
                            indB = i;
                        }
                    }
                    if(valid == true){  //if the boat is found
                        //ask information to create a sailing scheule
                        String start = JOptionPane.showInputDialog("Starting Point: ");
                        String end = JOptionPane.showInputDialog("Destination: ");
                        String startTime = JOptionPane.showInputDialog("Starting Time: ");
                        String endTime = JOptionPane.showInputDialog("Ending Time: ");
                        int duration = Integer.parseInt(JOptionPane.showInputDialog("Duration (in hours): "));
                        sailing = new Sailing(start, end, startTime, endTime, duration);    //create a schedule
                        fleets.get(ind).getBoats().get(indB).addSailingSchedule(sailing);   //add it to saling schedule list
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Boat Not Found!"); //error if boat name is invalid
                }
                else 
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");    //error if fleet name is invalid

            }
        });
        Button btSeeSchedule = new Button("See Sailing Schedule");
        btSeeSchedule.setStyle("-fx-font: 14 arial; -fx-base: #ADD8E6;");		//styles the font size and button colour
        btSeeSchedule.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                int ind = 0;
                String name = JOptionPane.showInputDialog("Name of Fleet: ");   //enter fleet name
                boolean valid = false;
                //check for fleet's existance
                for (int i = 0; i < fleets.size(); i++) {
                    if(name.equals(fleets.get(i).getName())){
                        valid = true;
                        ind = i;
                    }
                }
                if(valid == true){
                    name = JOptionPane.showInputDialog("Name of Boat: ");   //enter boat name
                    valid = false;
                    int indB = 0;
                    //check for boat's existance
                    for (int i = 0; i < fleets.get(ind).getBoats().size(); i++) {
                        if(name.equals(fleets.get(ind).getBoats().get(i).getName())){
                            valid = true;
                            indB = i;
                        }
                    }
                    if(valid == true){  //if the boat is found
                        String res = "";
                        //apend all the sailing schedule in a string 
                        for (int a = 0; a < fleets.get(ind).getBoats().get(indB).getSailingSchedule().size(); a++) {
                            res += fleets.get(ind).getBoats().get(indB).getSailingSchedule().get(a)+"\n";
                        }
                        JOptionPane.showMessageDialog(null, res);   //display the schedule to the user
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Boat Not Found!"); //error if the boat name is invalid
                }
                else 
                    JOptionPane.showMessageDialog(null, "Fleet Not Found!");    //error if the fleet name is invalid
            }
        });
        
        root.add(btAddFleet, 0, 0);
        root.add(btAddPBoat, 0, 1);
        root.add(btAddFBoat, 0, 2);
        root.add(btAddSchedule, 0, 3);
        root.add(btRemoveFleet, 1, 0);
        root.add(btRemoveBoat, 1, 1);
        root.add(btDisplay, 1, 2);
        root.add(btSeeSchedule, 1, 3);
        root.add(taDisplay, 0,4);
        
 
        Scene scene = new Scene(root, 550, 700, Color.AZURE);	//sets the size and background colour of the scene
     
        stage.setTitle("Fleet Managment App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}