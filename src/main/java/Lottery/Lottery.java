package Lottery;

import java.util.Random;

public class Lottery {
    public static void main(String[] args) {

        int[] balls = new int[100];

        for (int i = 0; i < balls.length; i++){
            balls[i] = i;
        }

        Random rand = new Random();
        for (int i = balls.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = balls[i];

            balls[i] = balls[j];
            balls[j] = temp;
        }

        for (int i = 0; i < 10; i++){
            System.out.println(balls[i]);
        }
    }
}