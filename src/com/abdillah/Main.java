package com.abdillah;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Album californication = new Album("Californication", "Red Hot Chili Peppers");
        californication.addSong("Parallel Universe", 4.35);
        californication.addSong("Scar Tissue", 3.37);
        californication.addSong("Otherside", 4.16);
        californication.addSong("Get OnTop", 3.18);
        californication.addSong("Californication", 5.22);

        Album voulezVous = new Album("Voulez-Vous", "ABBA");
        voulezVous.addSong("Angel eyes", 4.21);
        voulezVous.addSong("The King Has Lost His Crown", 3.34);
        voulezVous.addSong("As Good as New", 3.25);

        LinkedList<Song> playlist1 = new LinkedList<Song>();

        californication.addToPlaylist("Parallel Universe", playlist1);
        voulezVous.addToPlaylist("Angel eyes", playlist1);
        californication.addToPlaylist(5, playlist1) ;

        play(playlist1);
    }

    public static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No song in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString() + "\n");
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward && listIterator.hasNext()){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward && listIterator.hasPrevious()){
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now Replaying " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("We are at the end of the list");
                            forward = false;
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
            }
        }
    }

    public static void printList(LinkedList<Song> playlist){
        System.out.println("Songs available");

        for(int i = 0; i < playlist.size(); i++){
            System.out.println( (i + 1) + ". " + playlist.get(i).toString());
        }
    }

    public static void printMenu(){
        System.out.println("Available action:\n");
        System.out.println("0 - Quit\n");
        System.out.println("1 - play next song\n");
        System.out.println("2 - play previous song\n");
        System.out.println("3 - repeat current song\n");
        System.out.println("4 - songs available in the playlist\n");
        System.out.println("5 - print available actions\n");
    }

}
