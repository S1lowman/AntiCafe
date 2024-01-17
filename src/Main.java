import Rooms.GameRoom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameRoom room = new GameRoom();
        while (true) {
            System.out.println("Select option:");
            System.out.println("1 - Occupy table");
            System.out.println("2 - Table to free");
            System.out.println("3 - Get statistic");
            System.out.println("4 - Get max occupy table");
            System.out.println("5 - Get max earned table");
            System.out.println("6 - Get earning");
            System.out.println("7 - Break");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            switch (str) {
                case "1" -> room.TakeASeat(Integer.parseInt(sc.next()) - 1);
                case "2" -> room.toFree(Integer.parseInt(sc.next()) - 1);
                case "3" -> room.GetStat();
                case "4" -> room.GetMaxOccupy();
                case "5" -> room.GetMaxEarned();
                case "6" -> room.GetEarning();
                case "7" -> System.exit(0);
                default -> System.out.println("Unknown command");
            }
        }
    }
}
