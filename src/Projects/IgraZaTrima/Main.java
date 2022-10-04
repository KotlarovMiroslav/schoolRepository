package IgraZaTrima;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = 30;
        String[] words = {
                "Bed","Rape", "Space","Window","Medicine",
                "Beach", "Childhood","Justice","Criticism","Young","Adventure",
                "Weakness","Food","Death","Depression","Future","Past","Present",
                "Magic","Religion","Revenge","Passion","Anger","Music", "Confusion",
                "Sex","Laziness","Dream","Nostalgia","Mystery","Sport","Lost","First Love :/",
                "Family","Kindness","Sweetness","Warm","Woman","Man","Society","Paranormal",
                "Nightmare","Work","Fears","Holidays","Happiness","Drunkenness","Minecraft","Weirdness",
                "Addiction","Weather","JoJo's Bizarre Adventure","Love","Relaxing","Boring","Galaxy","Dirty",
                "BDZ","Craziness","Poison","Books","Knowledge","Travel","Winter","Summer","Maika ti"

                };
        String answer;
        Random rand = new Random();
        int pickAWord = rand.nextInt(words.length);
        String theme = words[pickAWord];
        int random = rand.nextInt(3);
        answer = theme;
        if(random + 1 == 1){

            System.out.println("======PLAYER 1======");
            System.out.println("You don't know the word");
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 2======");
            System.out.println("Your word is:" + answer);
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 3======");
            System.out.println("Your word is:" + answer);

        }else if(random + 1 == 2){

            System.out.println("======PLAYER 1======");
            System.out.println("Your word is:" + answer);
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 2======");
            System.out.println("You don't know the word");
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 3======");
            System.out.println("Your word is:" + answer);

        }else{

            System.out.println("======PLAYER 1======");
            System.out.println("Your word is:" + answer);
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 2======");
            System.out.println("Your word is:" + answer);
            for (int i = 0; i < rows; i++) {
                System.out.println();
            }
            System.out.println("======PLAYER 3======");
            System.out.println("You don't know the word");

        }






    }
}
