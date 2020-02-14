package com.chen.p;

import java.util.Arrays;

public class Node extends Point {
    public boolean E;
    public boolean W;
    public boolean N;
    public boolean S;
    public boolean[] freedom;

    public Node(int x, int y, boolean e, boolean w, boolean n, boolean s) {
        super(x, y);
        E = e;
        W = w;
        N = n;
        S = s;
        this.freedom = new boolean[]{this.E, this.W, this.N, this.S};
    }

    public String getNode() {
        return Arrays.toString(this.getLoc()) + " " + Arrays.toString(freedom);
    }

    public boolean[] getFreedomDimensions() {
        return this.freedom;
    }

    @Override
    public String toString() {
        return getNode();
    }

}
