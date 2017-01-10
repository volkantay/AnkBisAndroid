package tr.gov.meb.ankara.ankbs.Data;

import tr.gov.meb.ankara.ankbs.DataLayer.PersistenceManager;

/**
 * Created by Basak on 29.12.2016.
 */

public class OgmSorumluYoneticiler extends BaseClass implements PersistenceManager.Modal{

    private int id;
    private long tc;
    private String name;
    private String surName;


    @Override
    public long getId() {
        return 0;
    }
}
