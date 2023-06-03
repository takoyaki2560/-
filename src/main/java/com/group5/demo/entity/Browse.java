package com.group5.demo.entity;

import java.util.UUID;

public class Browse {
    public String _id ;
    public String uid ;
    public String pid ;
    public long browseTime ;

    public Browse(String uid, String pid, long browseTime) {
        this._id = UUID.randomUUID().toString().replaceAll("-","");
        this.uid = uid;
        this.pid = pid;
        this.browseTime = browseTime;
    }

    public Browse() {
    }
}
