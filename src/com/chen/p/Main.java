package com.chen.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/* 1. Есть схема:
dl.dropboxusercontent.com/s/6fnasg6j3o2chdn/crystalcell.png
На ней 8 точек и 2 красных маркера. Каждый ход каждый из маркеров прыгает на случайную из соседних точек.
Игра заканчивается когда оба красных маркера оказывается в одной точке.
Вывести вероятность того что игра закончится на 1, 2...N ходу. */

public class Main {

    /**
     * Диаграмма к данному решению https://prnt.sc/r232t5
     **/

    public static final int ITERATIONS = 100000;
    public static final int N = 3;
    public static final Random RANDOM = new Random();
    public static HashSet<Node> layout = new HashSet<>();

    static {


        layout.add(new Node(-1, 3, false, false, false, true));
        layout.add(new Node(-2, 2, true, false, false, false));
        layout.add(new Node(-1, 2, true, true, true, true));
        layout.add(new Node(0, 2, false, true, false, true));
        layout.add(new Node(-1, 1, true, false, true, false));
        layout.add(new Node(0, 1, true, true, true, true));
        layout.add(new Node(1, 1, false, true, false, false));
        layout.add(new Node(0, 0, false, false, true, false));
    }

    public static void main(String[] args) {

        Point particle1 = new Point(-1, 2);
        Point particle2 = new Point(0, 1);

        double gameOverCount = 0;
        for (int j = 0; j < ITERATIONS; j++) {
            for (int i = 1; i <= N; i++) {
                particle1 = step(particle1);
                System.out.println("Particle 1 " + Arrays.toString(particle1.getLoc()));
                particle2 = step(particle2);
                System.out.println("Particle 2 " + Arrays.toString(particle2.getLoc()));
                if (Arrays.equals(particle1.getLoc(), particle2.getLoc())&&i==N) {
                    gameOverCount++;
                    break;
                }
                System.out.println(" ");
            }
        }
        double p =  (gameOverCount / ITERATIONS)*100;
        System.out.println("Chance to collide ON steps #"+N+" is "+p+"%");
    }

    public static Point step(Point particle) {
        boolean[] freedomDimensions = new boolean[4];
        for (Node node : layout) {
            if (Arrays.equals(node.getLoc(), particle.getLoc())) {
                freedomDimensions = node.getFreedomDimensions();
                break;
            }
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < freedomDimensions.length; i++) {
            if (freedomDimensions[i]) {
                tmp.add(i);
            }
        }
        int rng = RANDOM.nextInt(tmp.size());
        int direction = tmp.get(rng);
        switch (direction) {
            case (0):
                if (!freedomDimensions[0]) {
                    return step(particle);
                }
                particle.stepX(1);
                break;
            case (1):
                if (!freedomDimensions[1]) {
                    return step(particle);
                }
                particle.stepX(-1);
                break;
            case (2):
                if (!freedomDimensions[2]) {
                    return step(particle);
                }
                particle.stepY(+1);
                break;
            case (3):
                if (!freedomDimensions[3]) {
                    return step(particle);
                }
                particle.stepY(-1);
                break;

        }
        return particle;
    }

}
