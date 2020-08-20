package preview.tech.showmejava.model;

import java.io.Serializable;

public class Menues implements Serializable {

    private String name;
    private String thumbnail;


    public Menues(String name, String img) {
        this.name = name;

        this.thumbnail = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImageurl() {
        return thumbnail;
    }

    public void setImageurl(String imageurl) {
        this.thumbnail = imageurl;
    }



}
