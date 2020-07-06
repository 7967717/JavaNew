package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            String out = "";
            String cName = "";
            String[] strings = s.trim().split("\\s+");
            if (strings.length == 2) {
                s = strings[0];
                cName = strings[1];
            }
            switch (s) {
                case "new":
                    out = "---NEW RELEASES---\n" +
                            "Mountains [Sia, Diplo, Labrinth]\n" +
                            "Runaway [Lil Peep]\n" +
                            "The Greatest Show [Panic! At The Disco]\n" +
                            "All Out Life [Slipknot]";
                    break;
                case "featured":
                    out = "---FEATURED---\n" +
                            "Mellow Morning\n" +
                            "Wake Up and Smell the Coffee\n" +
                            "Monday Motivation\n" +
                            "Songs to Sing in the Shower";
                    break;
                case "categories":
                    out = "---CATEGORIES---\n" +
                            "Top Lists\n" +
                            "Pop\n" +
                            "Mood\n" +
                            "Latin";
                    break;
                case "playlists":
                    out = "---" + cName.toUpperCase() + " PLAYLISTS---\n" +
                            "Walk Like A Badass  \n" +
                            "Rage Beats  \n" +
                            "Arab Mood Booster  \n" +
                            "Sunday Stroll";
                    break;
                case "exit":
                    System.out.println("---GOODBYE!---");
                    System.exit(0);
                    break;
            }
            System.out.println(out);
        }
    }
}
