package tr.gov.meb.ankara.ankbs.DataLayer;
import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tr.gov.meb.ankara.ankbs.Data.User;
import tr.gov.meb.ankara.ankbs.DataLayer.PersistenceManager;


public class UserPersistenceManager extends PersistenceManager<User> {

    /**
     * This constructor is used to initialise the DAO object for the given class.
     * @param context
     */
    public UserPersistenceManager(Context context) {
        super(context, User.class);
    }

    /**
     * Returns the records that contains the given name in the 'name' column
     *
     * @param name: The string that is expected in the 'name' column
     * @return
     */
    public List<User> getUsersWithName(String name) {

        // query for all users which has the given name
        try {
            return dao.query(dao.queryBuilder().where().eq("ad", name).prepare());

        } catch (SQLException e) {

            e.printStackTrace();
            return new ArrayList<User>();
        }
    }

}