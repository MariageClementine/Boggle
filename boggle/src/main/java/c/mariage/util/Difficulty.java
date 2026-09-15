package c.mariage.util;

public enum Difficulty {
    EASY(1,300,5),    //5 minutes
    NORMAL(2,180,3),    //3 minutes
    HARD(3,120,2);      //2 minutes

    private final int code;
    private final int seconds;
    private final int minutes;


    Difficulty(int code, int sec, int min){
        this.code = code;
        this.seconds = sec;
        this.minutes = min;
    }

    public int getCode() {
        return this.code;
    }
    public int getSeconds() {
        return this.seconds;
    }
    public int getMinutes(){
        return this.minutes;
    }

}
