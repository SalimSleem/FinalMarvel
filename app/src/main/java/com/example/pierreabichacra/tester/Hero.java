package com.example.pierreabichacra.tester;

/**
 * Created by Pierre Abi Chacra on 3/12/2018.
 */

public class Hero {
    private String name, imgurl, wiki;

    public Hero(String name, String imgurl)
    {
        this.name = name;
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
}
