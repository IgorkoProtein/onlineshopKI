package kupchack.com.ua.lesson36_jdbc_crud_person;

import kupchack.com.ua.onlineShop.users.ReadingData;

import java.util.Scanner;

public class PersonMenu {
//    private static int choose = -1;
//    public static void main(String[] args) {
//        do {
//            showMenu();
//            choose = getMenuNumber();
//            doAction(choose);
//        } while (choose != 0);
//    }
//
//    public static void showMenu() {
//
//        System.out.println("1 - add person");
//        System.out.println("2 - get persons information");
//        System.out.println("3 - delete person");
//        System.out.println("4 - get one person information");
//        System.out.println("5 - update person information");
//        System.out.println("0 - exit");
//        System.out.println("          ");
//    }
//
//    public static int getMenuNumber() {
//        Scanner input = new Scanner(System.in);
//        int temp = -1;
//
//        do {
//            System.out.print("Enter menu's number : ");
//
//            temp = input.nextInt();
//        } while (temp < 0 || temp > 5);
//
//        return temp;
//    }
//
//    public static void doAction(int choise) {
//        switch (choise) {
//            case 1:
//                Person person = new Person();
//                person.setName();
//                person.setSurname();
//                person.setBirthday();
//               PersonCRUD.createPerson(person);
//                break;
//            case 2:
//                PersonCRUD.getUsers(); break;
//            case 3:
//                PersonCRUD.getUsers();
//                int userChoise1 = ReadingData.getIntData("please, enter user id");
//                Person per1 = PersonCRUD.getPerson(userChoise1);
//
//                PersonCRUD.deletePerson(per1);
//                break;
//            case 4:
//                PersonCRUD.getUsers();
//                Person per2 = PersonCRUD.getPerson(ReadingData.getIntData("please, enter user id"));
//                per2.toString();
//                break;
//            case 5:
//                PersonCRUD.getUsers();
//                int userChoise2 = ReadingData.getIntData("please, select the id of person, which you want to change");
//                Person somePersone = PersonCRUD.getPerson(userChoise2);
//                System.out.println(somePersone.toString());
//
//                System.out.println("1 - Change name");
//                System.out.println("2 - Change surname");
//                System.out.println("3 - Change BD");
//                userChoise2 =  ReadingData.getIntData("Your choice");
//
//
//
//                System.out.println();
//
//                Person person2 = new Person();
//                person2.setName();
//                person2.setSurname();
//                person2.setBirthday();
//
//                PersonCRUD.updatePerson(person2, userChoise2);
//                break;
//            case 0:
//                System.exit(0);
//        }
//    }
}
