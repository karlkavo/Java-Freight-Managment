/*
 * Author:		Karl Kavanagh
 * Date:		April 2018
 * Title:		CA4 - Fleet Managment
 * purpose:		Sets the sailing times		
 */

public class Sailing {
    //sailing class attributes
    private String start;
    private String end;
    private String startTime;
    private String endTime;
    private int duration;

    //method to set values
    public Sailing(String start, String end, String startTime, String endTime, int duration) {
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    //setters and getters for the class attributes
    
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "From: " + start + ", To " + end + ", Start Time: " + startTime + ", End Time: " + endTime + ", Duration: " + duration + " Hours";
    }
    
}
