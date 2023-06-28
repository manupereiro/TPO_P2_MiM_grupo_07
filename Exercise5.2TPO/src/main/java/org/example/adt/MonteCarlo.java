package org.example.adt;

import java.util.Random;
import java.util.*;

public class MonteCarlo {

    public double approx(){

        int numForApproximation = 100000;
        double numInCircle = 0;

        for (int i = 0; i < numForApproximation; i++){
            Axis axis = new Axis(Math.random(),Math.random());
            if (Math.pow(axis.getX(), 2) + Math.pow(axis.getY(), 2) < 1){
                numInCircle++;
            }
        }
        return 4 * numInCircle / numForApproximation;
    }


}
