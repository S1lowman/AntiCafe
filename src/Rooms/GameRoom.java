package Rooms;

import Tables.ITable;
import Tables.Table;

public class GameRoom implements IRoom {
    private final ITable[] tables;
    private final Long[] earned;
    private final Integer[] count;
    private final Long[] timeSpent;
    private final Long[] currTime;
    public GameRoom() {
        tables = new Table[10];
        earned = new Long[10];
        count = new Integer[10];
        timeSpent = new Long[10];
        currTime = new Long[10];

        for (int i = 0; i < 10; i++) {
            tables[i] = new Table();
            earned[i] = 0L;
            count[i] = 0;
            timeSpent[i] = 0L;
            currTime[i] = 0L;
        }
    }
    @Override
    public void TakeASeat(int index) {
        if (tables[index].isFree()) {
            currTime[index] = System.currentTimeMillis();
        }

        tables[index].Occupy();
    }

    @Override
    public void toFree(int index) {
        if (!tables[index].isFree()) {
            earned[index] += Math.max((System.currentTimeMillis() - currTime[index]) / 36000 * 4, 4);
            timeSpent[index] += System.currentTimeMillis() - currTime[index];
            currTime[index] = 0L;
            count[index]++;
        }

        tables[index].toFree();
    }

    @Override
    public void GetStat() {
        for (int i = 0; i < 10; i++) {
            System.out.println("№ " + (i + 1));
            if (tables[i].isFree()) {
                System.out.println("Table is free");
            } else {
                System.out.println("Table is not free " + "for "
                        + (System.currentTimeMillis() - currTime[i]) / 36000 + " min "
                        + Math.max((System.currentTimeMillis() - currTime[i]) / 36000 * 4, 4) + " Rub");
            }

            System.out.println("Earned " + earned[i] + " Rub");
            System.out.println("Numbers of occupy " + count[i]);
            if (count[i] != 0) {
                System.out.println("Avg time " + timeSpent[i] / (36000 * count[i]) + " Min");
            }
            System.out.println("---------------------");
        }
    }

    @Override
    public void GetMaxOccupy() {
        int number = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > number) {
                number = count[i];
            }
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] == number) {
                System.out.println(i + 1 + " Table");
            }
        }
    }

    @Override
    public void GetMaxEarned() {
        long earning = 0;
        for (int i = 0; i < 10; i++) {
            if (earned[i] > earning) {
                earning = earned[i];
            }
        }

        for (int i = 0; i < 10; i++) {
            if (earning == earned[i]) {
                System.out.println(i + 1 + " Table");
            }
        }
    }

    @Override
    public void GetEarning() {
        long earning = 0;
        for (int i = 0; i < 10; i++) {
            earning += earned[i];
        }

        System.out.println(earning + " Rub");
    }
}