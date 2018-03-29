package kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.Identificator;
import kupchack.com.ua.onlineShop.users.ReadingData;

import java.time.LocalDate;

public class Person implements Identificator<Integer>{
    private int id;
    private String name;
    private String surname;
    private LocalDate birthDay;

    public Person() {
        this.id = 0;
        this.name = "name";
        this.surname = "surname";
        this.birthDay = LocalDate.now();
    }

    public Person(int id, String name, String surname, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public Person( String name, String surname, LocalDate birthDay) {
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

    public void setName() {this.name = ReadingData.getStringData("Enter your name");}

    public void setSurname() {
        this.surname = ReadingData.getStringData("Enter your surname");
    }

    public void setBirthday() {
        int year = ReadingData.getIntData("Enter your born year");
        int month = ReadingData.getIntData("Enter your born month");
        int day = ReadingData.getIntData("Enter your born day");

        birthDay = LocalDate.of(year,month,day);
    }

    public void setBirthday(boolean result) {
       int[] mounths = {31,28,31,30,31,30,31,31,30,31,30,31};

       int year = 0, mounth = 0,day = 0;

       if (day == mounths[mounth-1]){
           birthDay = LocalDate.of(year,mounth,day);
       }


    }

    protected void setId(int id) {
        this.id = id;
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

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public int enterId(){
        int id = ReadingData.getIntData("Please enter id ->");
        return id;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", birthDay=" + birthDay + '}';
    }
}
