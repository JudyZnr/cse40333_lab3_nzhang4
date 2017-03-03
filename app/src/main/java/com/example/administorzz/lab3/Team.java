package com.example.administorzz.lab3;

import java.io.Serializable;
import android.content.Context;
/**
 * Created by administorzz on 17/2/10.
 */

public class Team implements Serializable {
    public String teamName;
    public String imagename;
    public String teamDate;
    public String matchSite;
    public String nickName;
    public int rank;
    public String score;
    Context context;


    public Team (Context context, String name, String imagename, String time, String matchSite,String nickName,int rank,String score){
        this.context = context;
        this.teamName=name;
        this.imagename=imagename;
        this.teamDate=time;
        this.matchSite=matchSite;
        this.nickName=nickName;
        this.rank=rank;
        this.score=score;
    }

    public String getTeamName(){
        return teamName;

    }
    public int getImageId(){

        int imageId = context.getResources().getIdentifier(imagename, "drawable", "com.example.administorzz.lab3");
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
      public String getScore(){
          return score;
      }



}
