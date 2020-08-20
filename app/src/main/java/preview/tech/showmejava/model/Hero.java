package preview.tech.showmejava.model;

import java.io.Serializable;

public class Hero implements Serializable {

    private String name;
    private String imageurl;

    public Hero(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }



}
