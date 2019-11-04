package union_find;

import java.util.ArrayList;

public class SocialNetwork {
    private QuickUnionUF uf;
    private ArrayList<LogFile> log;
    private int size;
    private LogFile congratsLog;

    public SocialNetwork(int N) {
        uf = new QuickUnionUF(N);
        log = new ArrayList<>();
        size = N;
        congratsLog = new LogFile();
    }

    public void friendship(int p, int q) {
        int root = uf.union(p, q);
        logging(root, p, q);
    }

    public boolean isFriendly(int p, int q) {
        return uf.connected(p, q);
    }

    private void logging(int root, int p, int q) {
        LogFile logfile = new LogFile(p, q);
        log.add(logfile);
        int length = uf.getSize(root);
        if (length == size && congratsLog.getTime() == -1) {
            setCongratulationsLog(logfile);
        }
    }

    private void setCongratulationsLog(LogFile logfile) {
        congratsLog = logfile;
    }

    public String getCongratsLog() {
        return congratsLog.toString();
    }

}
