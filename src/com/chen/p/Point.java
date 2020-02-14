package com.chen.p;

import java.util.Arrays;
import java.util.Objects;

public class Point {
    public int x;
    public int y;
    public int[] loc;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        loc = new int[]{this.x, this.y};
    }

    public void stepX(int x) {
        this.x += x;
        this.loc[0] = this.x;
    }

    public void stepY(int y) {
        this.y += y;
        this.loc[1] = this.y;
    }

    public int[] getLoc() {
        return loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y &&
                Arrays.equals(loc, point.loc);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(x, y);
        result = 31 * result + Arrays.hashCode(loc);
        return result;
    }
}
