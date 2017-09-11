package kupchack.com.ua;

import java.time.LocalDate;

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
