package com.chen.p;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Layout {

    public ArrayList<int[]> map = new ArrayList<int[]>();

    public void add(Node node){
        map.add(node.getLoc());
    }


}
