package ad2.ss16.pa;

import java.util.HashMap;

public class MinHeap {

    private HashMap<Integer, Edge> H = new HashMap<>();
    private Integer size;

    public MinHeap() {
        this.size = 0;
        this.H.put(0, new Edge(0,0,Integer.MIN_VALUE));
    }

    public void push(Edge v) {
        int n = size + 1;
        this.H.put(n,v);
        this.size++;
        this.heapifyUp(n);
    }

    public Edge pull() {
        Edge ret = this.H.remove(1);
        this.size--;
        this.heapifyDown(1);
        return ret;
    }

    private void heapifyUp(int i) {
        if (i > 1) {
            int j = (int) Math.floor(i / 2);
            if (this.H.get(i).weight < this.H.get(j).weight) {
                // swap
                Edge temp = this.H.get(i);
                this.H.replace(i, this.H.get(j));
                this.H.replace(j, temp);
                this.heapifyUp(j);
            }
        }
    }

    private void heapifyDown(int i) {
        int n = this.size - 1;
        int j;
        if (2*i > n) { // Leaf
            return;
        } else if (2*i < n) {
            int l = 2*i;
            int r = 2*i + 1;
            Edge min = this.H.get(l).weight > this.H.get(r).weight ? this.H.get(r) : this.H.get(l);
            j = this.getKey(min);
        } else {
            j = 2*i;
        }
        if (this.H.get(j).weight < this.H.get(i).weight) {
            Edge temp = this.H.get(i);
            this.H.replace(i, this.H.get(j));
            this.H.replace(j, temp);
            this.heapifyDown(j);
        }
    }

    public String toString() {
        String out = "[";
        for(Edge e : this.H.values()) {
            out += e.weight + ",";
        }
        out = out.substring(0,out.length()-1) + "]";
        return out;
    }

    private Integer getKey(Edge v) {
        for (Integer i : this.H.keySet()) {
            if (this.H.get(i).equals(v)) {
                return i;
            }
        }
        throw new RuntimeException("Key "+v+" not found in MinHeap");
    }

    public static void main(String[] args) {

    }

}
