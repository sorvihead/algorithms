package union_find;

import java.util.Date;

public class LogFile {
    private long time;
    private int f1;
    private int f2;

    public LogFile(int p, int q) {
        time = new Date().getTime();
        f1 = p;
        f2 = q;
    }

    public LogFile(){
        time = -1;
        f1 = -1;
        f2 = -1;
    }

    public long getTime() {
        return time;
    }

    public int getF1() {
        return f1;
    }

    public int getF2() {
        return f2;
    }
    public String toString(){
        return Long.toString(time) + " " + Integer.toString(f1) + " " + Integer.toString(f2);
    }
}
