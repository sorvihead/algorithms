package containers;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
        N = 0;
    }
    public void push(Item elem){
        a[N++] = elem;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public Item pop(){
        return a[--N];
    }
}
