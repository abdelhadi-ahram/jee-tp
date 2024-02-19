package tp1.dao;

import java.util.Date;

public class DaoImpl implements IDao {
    @Override
    public Date getDate() {
        return new Date();
    }
}
