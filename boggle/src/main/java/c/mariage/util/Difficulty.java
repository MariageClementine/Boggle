package c.mariage.util;

public enum Difficulty {
    EASY(1),
    NORMAL(2),
    HARD(3);

    private final int code;

    Difficulty(int code){
        this.code = code;
    }

    public int getCode() {return this.code;}

}
