package kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic;

        import java.util.List;

public interface GenericDAO<T, P> {
    public T create(T obj) throws DAOException;

    public T create() throws DAOException;

    public T read(P key) throws DAOException;

    public void update(T obj) throws DAOException;

    public void delete(T obj) throws DAOException;

    public List<T> readAll() throws DAOException;

}
