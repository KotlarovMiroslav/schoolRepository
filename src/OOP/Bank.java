package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank  {
    public String name;
    public int account = 0;


    class User extends Bank implements UserInterface {
        public int getAccount() {
            return account;
        }

        public String getName() {
            return this.name;
        }

    }

    class Admin extends Bank implements AdminInterface{
        public int getAccount() {
            return account;
        }

        public String getName() {
            return this.name;
        }

        public void addToAccount(int account) {
            this.account += account;
        }


    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Bank> clients = new ArrayList<>();
        String input = scan.nextLine();
        while(!input.equalsIgnoreCase("stop")) {
            System.out.println("Admin or User?");
            input = scan.nextLine();
            if(input.equalsIgnoreCase("admin")){

            }else{

            }
                input = scan.nextLine();
        }
    }

    public static void createProfile(){

    }






}


