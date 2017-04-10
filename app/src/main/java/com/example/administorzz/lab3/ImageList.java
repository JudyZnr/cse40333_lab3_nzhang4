package com.example.administorzz.lab3;

/**
 * Created by administorzz on 2017/4/7.
 */

public class ImageList {

    byte []imageCa;
    String name;
    int _id;

    public ImageList (){
    }
    public ImageList(int _id, String name, byte[] imageCa) {
        this._id = _id;
        this.name = name;
        this.imageCa = imageCa;

    }
    public ImageList(String name, byte[] imageCa) {
        this.name = name;
        this.imageCa = imageCa;

    }
    public ImageList(int _id) {
        this._id = _id;

    }    public String getName(){
        return name;
    }
    public int get_id(){return _id;
    }

    public void set_id(int _id){this._id=_id;}
    public void setName(String name){this.name = name;}
    public byte[] getImage() {
        return this.imageCa;
    }

    public void setImage(byte[] imageCa) {
        this.imageCa = imageCa;
    }

}
