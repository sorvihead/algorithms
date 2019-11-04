package union_find;

import java.util.ArrayList;
import java.util.Collections;

public class QuickUnionUF {

    private int[] id;
    private int[] size;
    private ArrayList<ArrayList<Integer>> components;

    public QuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        components = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
            ArrayList<Integer> container = new ArrayList<>();
            container.add(i);
            components.add(container);
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public int union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) {
            return i;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
            ArrayList<Integer> container = components.get(j);
            container.addAll(components.get(i));
            return j;
        } else {
            id[j] = i;
            size[i] += size[j];
            ArrayList<Integer> container = components.get(i);
            container.addAll(components.get(j));
            return i;
        }
    }

    public int getSize(int i) {
        return size[i];
    }

    public int find(int i) {
        int r = root(i);
        return Collections.max(components.get(r));
    }

    public String getComponent(int i) {
        return components.get(i).toString();
    }

    public ArrayList<ArrayList<Integer>> getComponents() {
        return components;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
