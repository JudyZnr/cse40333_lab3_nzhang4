package com.example.administorzz.lab3;

/**
 * Created by administorzz on 17/2/10.
 */

public class Team {
    public String teamName;
    public int imageId;
    public String teamDate;

    public Team (String name, int imageId, String time){
        this.teamName=name;
        this.imageId=imageId;
        this.teamDate=time;
    }

    public String getTeamName(){
        return teamName;

    }
    public int getImageId(){

        return imageId;
    }
      public String getTeamDate(){
          return teamDate;
      }
}
