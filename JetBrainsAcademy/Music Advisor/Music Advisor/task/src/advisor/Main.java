package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String CLIENT_ID = "17afd21c93d34971a1d12aef3511977a";
        boolean auth = false;
        String noAuth = "Please, provide access for application.";

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
                case "auth":
                    auth = true;
                    out = "https://accounts.spotify.com/authorize?client_id=" + CLIENT_ID +
                            "&redirect_uri=http://localhost:8080&response_type=code\n" +
                            "---SUCCESS---";
                    break;
                case "new":
                    if (auth) {
                        out = "---NEW RELEASES---\n" +
                                "Mountains [Sia, Diplo, Labrinth]\n" +
                                "Runaway [Lil Peep]\n" +
                                "The Greatest Show [Panic! At The Disco]\n" +
                                "All Out Life [Slipknot]";
                    } else {
                        out = noAuth;
                    }
                    break;
                case "featured":
                    if (auth) {
                        out = "---FEATURED---\n" +
                                "Mellow Morning\n" +
                                "Wake Up and Smell the Coffee\n" +
                                "Monday Motivation\n" +
                                "Songs to Sing in the Shower";
                    } else {
                        out = noAuth;
                    }
                    break;
                case "categories":
                    if (auth) {
                        out = "---CATEGORIES---\n" +
                                "Top Lists\n" +
                                "Pop\n" +
                                "Mood\n" +
                                "Latin";
                    } else {
                        out = noAuth;
                    }
                    break;
                case "playlists":
                    if (auth) {
                        out = "---" + cName.toUpperCase() + " PLAYLISTS---\n" +
                                "Walk Like A Badass  \n" +
                                "Rage Beats  \n" +
                                "Arab Mood Booster  \n" +
                                "Sunday Stroll";
                    } else {
                        out = noAuth;
                    }
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
