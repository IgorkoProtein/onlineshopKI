package kupchack.com.ua.onlineShop.users;

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
        String surname;

        do {

            try {
                System.out.println("Enter your surname");
                surname = temp.next();

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

    public int getYear() {
        //Scanner temp = new Scanner(System.in);
        int year = -1;
        do {
            try {
                System.out.println("Enter year");
                year = ReadingInt.getData();

                if (year > 2018 || year <1918) {
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

    public int getMounth(){
        int mounth = -1;
        do {
            try {
                System.out.println("Enter mounth");
                mounth = ReadingInt.getData();

                if (mounth > 12 || mounth <= 0) {
                    throw new InputExceptoin("Ви ввели неіснуючий місяць");
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

        return mounth;
    }

    public int getDay31() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (day > 31 || day < 1) {
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

    public int getDay30() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (day > 30 || day < 1) {
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

    public int getDay28() {
        int day = -1;
        do {
            try {
                System.out.println("Enter day");
                day = ReadingInt.getData();

                if (day > 28 || day < 1) {
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

    public void setBirthday() {
        int year = getYear();
        int mounth = getMounth();
        int day = -1;

        if(mounth == 1 || mounth == 3 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12  ){
            day = getDay31();
        }else if (mounth == 4 || mounth == 6 || mounth == 9 || mounth == 11){
            day = getDay30();
        }else if(mounth == 2){
            day = getDay28();
        }

        birthDay = LocalDate.of(year,mounth,day);
    }

    public void setBirthday(boolean result) {
       int[] mounths = {31,28,31,30,31,30,31,31,30,31,30,31};

       int year = 0, mounth = 0,day = 0;

       if (day == mounths[mounth-1]){
           birthDay = LocalDate.of(year,mounth,day);
       }


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
