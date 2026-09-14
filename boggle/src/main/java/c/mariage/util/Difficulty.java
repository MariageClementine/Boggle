package c.mariage.util;

public enum Difficulty {
    EASY(1,5),
    NORMAL(2,3),
    HARD(3,2);

    private final int code;
    private final int time;


    Difficulty(int code, int time){
        this.code = code;
        this.time = time;
    }

    public int getCode() {
        return this.code;
    }
    public int getTime() {
        return this.time;
    }

}
