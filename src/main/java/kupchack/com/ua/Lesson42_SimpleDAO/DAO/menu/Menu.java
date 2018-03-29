package kupchack.com.ua.Lesson42_SimpleDAO.DAO.menu;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.WorkWithPerson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        do {
            showmenu();
            doaction(chooseMenu());
        } while (true);
    }

    public static void showmenu() {
        System.out.println("1 - Create person ");
        System.out.println("2 - Read one person information ");
        System.out.println("3 - Update person information ");
        System.out.println("4 - Delete person ");
        System.out.println("5 - Read all persons information ");
        System.out.println("0 - Exit ");
        System.out.println(" ");
        System.out.println("__________________________________________________________");
        System.out.println(" ");
    }

    private static int chooseMenu(){
        Scanner input = new Scanner(System.in);
        int temp;
        do {
            try {
                System.out.print("Enter menu's number ->");
                temp = input.nextInt();

                if (temp <0 || temp >5) throw new RuntimeException("was entered without a menu item");
            } catch (InputMismatchException e) {
                System.out.println("was entered inadmissible menu item");
                input.nextLine();
                continue;
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }while (true);

        return temp;
    }

    private static void doaction(int choose){
        switch (choose){
            case 1: WorkWithPerson.createPerson();break;
            case 2: //WorkWithPerson.readPerson();break;
            case 3: WorkWithPerson.updatePerson();break;
            case 4: WorkWithPerson.deletePerson();break;
            case 5: WorkWithPerson.readAllPersons(); break;
            case 0: System.exit(0);
        }
    }
}
