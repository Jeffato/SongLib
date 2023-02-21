package SongLib.app;

public class PriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(Key x){
        pq[++size] = x;
        swim(size);
    }

    public Key delMax(){
        Key max = pq[1];
        swap(1, size--);
        sink(1);
        pq[size+1] = null;

        return max;
    }

    private void swim(int k){
        while(k>1 && less(k/2,k)){
            swap(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= size){
            int j = 2*k;

            if(j < size && less(j, j+1)) j++;

            if(!less(k,j)) break;

            swap(k,j);
            k=j;
        }
    }

    private boolean less(int i, int j){ //TODO: Check if it should be > or <
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
