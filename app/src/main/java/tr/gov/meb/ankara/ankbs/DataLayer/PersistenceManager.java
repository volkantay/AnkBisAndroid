package tr.gov.meb.ankara.ankbs.DataLayer;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

/**
 * This class creates an abstraction for making the model storage easier. You can extend this class
 * to have a simple DAO for your model.
 *
 * IMPORTANT: The class you use to store must have an empty constructor which is required ormlite.
 * Bu sınıfı tek tek DAO objeleri oluşturma gereksinimi ortadan kaldırmak için oluşturdum.
 * Ayrıca bu sınıf her vetitabanı sınıfı için tekrar tekrar yazmanız gereken
 * ekleme, düzenleme, silme gibi metodları tek yerde barındıran
 * ve sizi bu metodları oluşturma zahmetinden kurtaran bir sınıftır.

 *
 * @param <E>
 */
public abstract class PersistenceManager<E extends PersistenceManager.Modal> {

    protected Dao dao;
    private String TAG = "PersistenceManager";

    protected PersistenceManager(Context context, Class c) {
        DatabaseHelper helper = OpenHelperManager.getHelper(context, DatabaseHelper.class);

        try {
            dao = DaoManager.createDao(helper.getConnectionSource(), c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public final boolean create(E e) {
        if (exists(e.getId())) {
            Log.e(TAG, "An entry with the same id already exists.");
            return false;
        }
        try {
            dao.create(e);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public final E read(long id) {
        try {
            return (E) dao.queryForId(id + "");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final List<E> readAll() {
        try {
            return (List<E>) dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean update(E e){
        try {
            dao.update(e);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public final boolean delete(long id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public final boolean exists(long id) {
        try {
            return dao.queryForId(id + "") != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public interface Modal {
        public long getId();
    }

}