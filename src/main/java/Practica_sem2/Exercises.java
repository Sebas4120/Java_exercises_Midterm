package Practica_sem2;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercises {
// Ejercicios sacados de este link https://www.w3resource.com/java-exercises/basic/index.php
    public static void main(String[] args) {
//        Exercises e1 = new Exercises();
//        e1.Ejercicio5();
//        Ejercicio8();
//        Ejercicio9();
       // Ejercicio33();
        smallNumber();
    }

    public void Ejercicio5() {
        int number1;

        int number2;

        Scanner number = new Scanner(System.in);

        System.out.println("Ingresa el primer numero");
        number1=number.nextInt();

        System.out.println("Ingresa el segundo numero");
        number2=number.nextInt();

        int product = number1*number2;

        System.out.println("The product of both numbers is: " + product);
    }

    public static void Ejercicio8(){
        Scanner number = new Scanner(System.in);

        System.out.println("Please enter a number");
        int number1=number.nextInt();

        for(int i=1;i<=10;i++){
            System.out.println(number1 + " * " + i + " = " +(number1*i));
        }
    }

    public static void Ejercicio9(){
        System.out.println("   J    a   v     v  a ");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");
    }

    public static void Ejercicio32(){
        Scanner newNumber = new Scanner(System.in);

        System.out.println("Por favor ingresa el numero 1");
        int number1 = newNumber.nextInt();
        System.out.println("Por favor ingresa el numero 2");
        int number2 = newNumber.nextInt();

        // Compare and display the results
        if (number1 == number2)
            System.out.printf("%d == %d\n", number1, number2);
        if (number1 != number2)
            System.out.printf("%d != %d\n", number1, number2);
        if (number1 < number2)
            System.out.printf("%d < %d\n", number1, number2);
        if (number1 > number2)
            System.out.printf("%d > %d\n", number1, number2);
        if (number1 <= number2)
            System.out.printf("%d <= %d\n", number1, number2);
        if (number1 >= number2)
            System.out.printf("%d >= %d\n", number1, number2);
    }

    public static void Ejercicio33(){
        Scanner newNum = new Scanner (System.in);

        System.out.println("Please insert a number");
        int inputNumbers = newNum.nextInt();

//        Aca convierto el numero en String
        String numStr = String.valueOf(inputNumbers);

//        Luego ese String lo convierto en Array
        char[] result=numStr.toCharArray();

        for(char c:result){
            System.out.println(c + " ");
        }
        int sum=0;
        for (char digits:result){
            sum += Character.getNumericValue(digits);
        }
        System.out.println(sum);
    }

    public static void smallNumber(){
//        Write a Java method to find the smallest number among three numbers.
//        Test Data:
//        Input the first number: 25
//        Input the Second number: 37
//        Input the third number: 29
//        Expected Output:
//
//        The smallest value is 25.0

        //Creacion de lista de integers
        ArrayList<Integer> numList = new ArrayList<Integer>();

        Scanner newNum = new Scanner (System.in);

        System.out.println("Please insert the first number");

        int userInput = newNum.nextInt();

        System.out.println("Please insert the second number");

        int userInput2 = newNum.nextInt();

        System.out.println("Please insert the third number");

        int userInput3 = newNum.nextInt();

        numList.add(userInput);
        numList.add(userInput2);
        numList.add(userInput3);

        System.out.println(numList);

        int min = numList.get(0);
        for (int i =1; i <numList.size();i++){
            min = Math.min(min,numList.get(i));
        };

        System.out.println("The lowest values is : " + min);







    }









}
