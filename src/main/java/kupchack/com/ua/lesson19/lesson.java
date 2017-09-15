package kupchack.com.ua.lesson19;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Home on 15.09.2017.
 */
public class lesson {
    public static void submain() {
        boolean controlValue = false;
        do {
            try {
                controlValue = false;
                Scanner temp = new Scanner(System.in);
                System.out.print("Enter a: ");
                int a = temp.nextInt();

                int result = 100 / a;

                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Сталася помилка : "+ e.getMessage());
                controlValue = true;
                //e.printStackTrace();
            }
        } while (controlValue);
    }

    public static void submain2() throws InvalidInputYearException {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter a: ");
                int a = input.nextInt();
                if ( a > 2017 || a < 1917){
                    throw new InvalidInputYearException("Неправильно введений рік");
                }
                int result = 100 / a;
                System.out.println(result);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Сталася помилка "+e.getClass()+" : "+ e.getMessage());
                continue;
                //e.printStackTrace();
            }catch(InputMismatchException e){
                System.out.println("Сталася помилка "+e.getClass()+" : "+ e.getMessage());
                input.nextLine();
                continue;
            }

        } while (true);
    }

    public static void main(String[] args) {

        try {
            submain2();
        } catch (InvalidInputYearException e) {
            System.out.println("Сталася помилка " + e.getClass() + " : " + e.getMessage());
        }

    }
}
