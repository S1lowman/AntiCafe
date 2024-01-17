package Rooms;

public interface IRoom {
    void TakeASeat(int index);
    void toFree(int index);
    void GetStat();
    void GetMaxOccupy();
    void GetMaxEarned();
    void GetEarning();
}