package kupchack.com.ua.Lesson42_SimpleDAO.DAO.beans;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.Identificator;

public class MuscleGroup implements Identificator<Integer>{

    private int id;
    private String name;

    public MuscleGroup() {
        this.id = 0;
        this.name = name;
    }

    public MuscleGroup(String name) {
        this.name = name;
    }

    public MuscleGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MuscleGroup{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
