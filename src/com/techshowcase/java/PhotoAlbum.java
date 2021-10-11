package com.techshowcase.java;

import java.util.Scanner;
import static com.techshowcase.java.ReadJSON.albumLookup;
import static java.lang.Integer.parseInt;


public class PhotoAlbum {

    public static void main(String[] args) {

        Scanner albumIn = new Scanner(System.in);
        System.out.print("Enter album number (ex. photo-album #): ");


        String result = albumIn.nextLine().split(" ")[1];
        int num = parseInt(result);
        albumLookup(num);
    }
}
