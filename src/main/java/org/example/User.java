package org.example;

public class User {
    int userId;
    String name;

    User(int userId, String name){
        this.userId=userId;
        this.name=name;
    }

    int getUserId(){
        return userId;
    }

    String getName(){
        return name;
    }
}
