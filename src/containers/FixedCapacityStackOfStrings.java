package containers;

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
        N = 0;
    }

    public void push(String elem){
        a[N++] = elem;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public String pop(){
        return a[--N];
    }
}
