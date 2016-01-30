/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard Howard
 * Write a program in Java that will output all prime numbers up to a given upper 
 * bound (integer N which is a program input) in a computationally efficient 
 * manner using Euler’s sieve algorithm  
 */
public class Prime {

     /*
    Function: main
    
    the function main allows the user to set the value of N and change the 
    output file to whatever they want, by default it is set to output.txt
    
    Receives: String[] args
    Constants: none
    Returns: outputs all prime numbers in N to the output file
     * @param args
     * @throws FileNotFoundException
     */
    
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> N = new ArrayList<>();
        N = PrimesNumbers(1500230);
        System.out.println(N);
        
        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(N);
        writer.close();
        
    }
     /*
    Function: PrimeNumbers
    
    the function PrimeNumbers test to see if a number is prime if true adds to
    the list 
    
    Receives: int N ( the upper bound of the prime numbers you wish to find )
    Constants: none
    Returns: all the prime numbers up to N
     * @param N
     * @return
     */
    
    public static List<Integer> PrimesNumbers(int N) {

    List<Integer> list = new ArrayList<>();

    boolean [] isPrime = new boolean [N + 1]; // limit + 1 because we won't use '0'th index of the array
    isPrime[1] = true;

    // finds all the prime numbers
    for (int i = 2; i <= N; i++) {
        if (!isPrime[i]) {
            // 'i' is a prime number
            list.add(i);
            int multiple = 2;
            while (i * multiple <= N) {
                isPrime [i * multiple] = true;
                multiple++;
            }
        }
    }

    return list;
}
}


   
