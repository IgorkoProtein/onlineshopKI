package kupchack.com.ua.onlineShop.users;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate birthDay;

    public Person() {
        this.name = "name";
        this.surname = "surname";
        this.birthDay = LocalDate.now();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.birthDay = LocalDate.now();
    }

    public Person(String name, String surname, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public void setName() {this.name = ReadingData.getData("Enter your name:");}

    public void setName() {
        Scanner temp = new Scanner(System.in);
        String[] deniedSymbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String name;
        do {

            try {
                System.out.println("Enter your name");
                name = temp.next();

                for (int i = 0; i < deniedSymbols.length; i++) {
                    if (name.contains(deniedSymbols[i])) {
                        throw new InputExceptoin("Введіть ім'я без цифр ");
                    }
                }
                if (name.length() < 4) {
                    throw new InputExceptoin("Ви ввели за надто коротке ім'я ");
                } else if (name.length() > 15) {
                    throw new InputExceptoin("Ви ввели за надто довге ім'я ");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            }
        } while (true);
        setName(name);
    }

    public void setSurname() {
        Scanner temp = new Scanner(System.in);
        String[] deniedSymbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String surname = temp.next();

        do {

            try {
                System.out.println("Enter your surname");

                for (int i = 0; i < deniedSymbols.length; i++) {
                    if (surname.contains(deniedSymbols[i])) {
                        throw new InputExceptoin("Введіть прізвище без цифр ");
                    }
                }
                if (surname.length() < 4) {
                    throw new InputExceptoin("Ви ввели за надто коротке прізвище");
                } else if (surname.length() > 15) {
                    throw new InputExceptoin("Ви ввели за надто довге прізвище");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            }
        } while (true);
        setSurname(surname);
    }

    public void setBirthday() {


    }

    public int getYear() {
        //Scanner temp = new Scanner(System.in);
        int year = -1;
        do {
            try {
                System.out.println("Enter year");
                year = ReadingInt.getData();

                if (2018 > year || year < 1918) {
                    throw new InputExceptoin("Ви ввели неіснуючий рік");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                continue;
            }
        } while (true);

        return year;
    }

    public int getMounth() {
        int mounth = -1;
        do {
            try {
                System.out.println("Enter year");
                mounth = ReadingInt.getData();

                switch (mounth) {
                    case 1:
                        getDay1();
                        break;
                    case 2:
                        getDay3();
                        break;
                    case 3:
                        getDay1();
                        break;
                    case 4:
                        getDay2();
                        break;
                    case 5:
                        getDay1();
                        break;
                    case 6:
                        getDay1();
                        break;
                    case 7:
                        getDay2();
                        break;
                    case 8:
                        getDay1();
                        break;
                    case 9:
                        getDay2();
                        break;
                    case 10:
                        getDay1();
                        break;
                    case 11:
                        getDay2();
                        break;
                    case 12:
                        getDay1();
                        break;
                    default:
                        throw new InputExceptoin("Ви ввели неіснуючий місяць");
                }
            }catch (InputExceptoin inputExceptoin) {
                inputExceptoin.getMessage();
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                continue;
            }
            }while (true) ;
                return mounth;
        }

    public int getDay1() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (31 > day || day < 1) {
                    throw new InputExceptoin("Ви ввели неіснуючий день");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                continue;
            }
        } while (true);

        return day;
    }

    public int getDay2() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (30 > day || day < 1) {
                    throw new InputExceptoin("Ви ввели неіснуючий день");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                continue;
            }
        } while (true);

        return day;
    }

    public int getDay3() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (28 > day || day < 1) {
                    throw new InputExceptoin("Ви ввели неіснуючий день");
                }
                break;
            } catch (InputExceptoin e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Сталася помилка введеня :" + e.getClass());
                continue;
            }
        } while (true);

        return day;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public abstract int getAge();

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

}
