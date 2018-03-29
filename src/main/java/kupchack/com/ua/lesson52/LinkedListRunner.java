package kupchack.com.ua.lesson52;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LinkedListRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new LinkedList<String>();

        long startTime, endTime, generatingTime, findingTime;
        String someElement = "";

        System.out.print("Please enter amount of names: ");
        int amount = scanner.nextInt();
        System.out.print("Please enter names size: ");
        int size = scanner.nextInt();

        startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            String temp  =generateData(size);
            if(i == (amount/2)){
                someElement = temp;
                names.add(temp);
            }else{
                names.add(temp);
            }
        }
        endTime = System.currentTimeMillis();
        generatingTime = endTime - startTime;


        startTime = System.currentTimeMillis();
        names.contains(someElement);
        endTime = System.currentTimeMillis();
        findingTime = endTime - startTime;

        System.out.println("Genereting time = "+ (generatingTime));
        System.out.println("Finding time = "+ (findingTime));

    }


    public static String generateData(int size) {
        StringBuilder temp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char randomSymbol = (char) (random.nextInt(26 )+65);
            temp.append(randomSymbol);
        }

        return temp.toString();
    }
}
