import java.util.Scanner;
import java.util.Random;

public class Main {

    // Main (public) variables
    static Scanner input; // declare scanner variable
    static Random rand;
    // main function:
    public static void main(String[] args){
        input = new Scanner(System.in);
        rand = new Random();
        new Game();

    } // main

    //Main function/methods
    static void testArrays(){
        // arrays: basically just lists
        int[] intArray = new int[5];
        int[] intArray2 = {7,24,8,23,13,1,6};
        int length = intArray2.length;
        for(int i=0; i<length; i++){
            //System.out.println(intArray2[i]);
        }
        //two-dimensional arrays: arrays of arrays
        int[][] array2D = new int[4][3]; // 4 arrays, each with 3 elements
        int[][] array2D_2 = {{1,2,3},{4,5,6},{7,8,9}}; // 3x3 2D array
        System.out.println(array2D_2[2][0]);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.println(array2D_2[i][j] + " ");
            } //loop over j
            System.out.println();
        }// loop over i
    }
    static void testRecursiveMethods(){ // recursive method calls itself
        factorial(5);
        factorial(4);
        factorial(3);
        System.out.printf("\n5! = %d\n", recursiveFactorial(5));
        System.out.printf("\n4! = %d\n", recursiveFactorial(4));
    }

    static int recursiveFactorial(int n){ //recursive method
        if(n == 1)
            return 1;
        return n * recursiveFactorial(n - 1);
    }

    static void factorial(int n){
        int fact = 1;
        for(int i = 2; i <= n; i++){
            //fact = fact*i
            fact *= 1;
        }
        System.out.printf("%d! = %d \n", n, fact);
    }

} //public class Main
