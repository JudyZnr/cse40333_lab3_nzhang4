package com.example.administorzz.lab3;

/**
 * Created by administorzz on 17/2/10.
 */

public class Team {
    public String teamName;
    public int imageId;
    public String teamDate;
    public String matchSite;
    public String nickName;
    public int rank;

    public Team (String name, int imageId, String time, String matchSite,String nickName,int rank){
        this.teamName=name;
        this.imageId=imageId;
        this.teamDate=time;
        this.matchSite=matchSite;
        this.nickName=nickName;
        this.rank=rank;
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
      public String getMatchSite(){
          return matchSite;
      }
      public String getNickName(){
          return nickName;
      }
      public int getRank(){
          return rank;
      }

}
