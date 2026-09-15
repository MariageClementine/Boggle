package c.mariage.util;

public enum Difficulty {
    EASY(300,5),    //5 minutes
    NORMAL(180,3),    //3 minutes
    HARD(120,2);      //2 minutes

    private final int seconds;
    private final int minutes;


    Difficulty(int sec, int min){
        this.seconds = sec;
        this.minutes = min;
    }

    public int getSeconds() {
        return this.seconds;
    }
    public int getMinutes(){
        return this.minutes;
    }

}
