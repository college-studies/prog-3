package com.company;

public class Main {

    public static void main(String[] args) {

        Friend friend1 = new Friend("Spongebob");
        Friend friend2 = new Friend("Phatrick");
        Friend friend3 = new Friend("Squidward");


        System.out.println(Friend.numberOfFriends);
        Friend.displayFriends();
    }
}
