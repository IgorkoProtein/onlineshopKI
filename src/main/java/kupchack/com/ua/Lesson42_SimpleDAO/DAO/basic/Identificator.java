package kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic;

import java.io.Serializable;

public interface Identificator<PK extends Serializable> {
    public PK getId();
}
