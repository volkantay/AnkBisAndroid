package tr.gov.meb.ankara.ankbs.DataLayer;

/**
 * Created by Basak on 30.12.2016.
 */

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.Data.User;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class
 * also usually provides the DAOs used by the other classes.
 * Bu sınıf Orm-Lite kütüphanesinin kullanımı için gereken ana sınıflardan birisidir.
 * Burada veri tabanı ismi ve versiyonu belirlenir,
 * veri tabanında bulunması istenilen tablolar oluşturulur.
 * Ayrıca veritabanı versiyon değişikliklerinde de eski tabloları yeni tablolara dönüştürme işlemleri bu sınıfta yapılır. (Bu sınıf kütüphanenin kaynak sayfalarına bakılarak benim oluşturduğum bir sınıftır.
 *
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "ankbis4";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable
     * statements here to create the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");

            // You must create table of the classes that you need to keep in database
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, OgmHedefler.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This
     * allows you to adjust the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");

            // You need to handle the new structure of the class when it changes
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, OgmHedefler.class, true);

            // After dropping the database, you need to create it again
            onCreate(db, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
