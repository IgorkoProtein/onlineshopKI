package kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic;

import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.DAOException;
import kupchack.com.ua.Lesson42_SimpleDAO.DAO.basic.GenericDAO;

public interface DAOFactory<CN> {
    public interface CreatorDAO<CN>{
        public GenericDAO createDAO(CN connection);
    }

    public CN getConnection() throws DAOException;
    public GenericDAO getDAO(CN connection, Class daoClass) throws DAOException;

}
