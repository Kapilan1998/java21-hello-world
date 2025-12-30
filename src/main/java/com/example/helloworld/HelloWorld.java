package com.example.helloworld;


public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World from Java 21!");
        System.out.println("This application was created and deployed by Ansible automation");

        int result = addNumbers(10, 20);
        System.out.println("10 + 20 = " + result);
    }


    public static int addNumbers(int a, int b) {
        return a + b;
    }
}