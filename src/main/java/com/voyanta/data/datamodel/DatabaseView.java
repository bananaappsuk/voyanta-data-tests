package com.voyanta.data.datamodel;

import com.voyanta.data.datamodel.dbtables.loadDBRecords;
import com.voyanta.data.utils.DBUtils;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.utils.VHashMap;

import java.util.List;

/**
 * Created by sriramangajala on 01/07/2014.
 */
public class DatabaseView {

    String SQL;

    public String getSQL(String sqlFileName)
    {
        return SQLEnum.getEnum(sqlFileName).getSQL();
    }

    public List<VHashMap> getDataBaseRecords(String sqlFileName)
    {
        SQL = getSQL(sqlFileName);
        return getDataBaseRecordsWithQuery(SQL);
    }

    private List<VHashMap> getDataBaseRecordsWithQuery(String query) {
        loadDBRecords loadDBRecords = new loadDBRecords();
        return loadDBRecords.loadRecords(PropertiesLoader.getProperty("dbuserName"), PropertiesLoader.getProperty("dbpassword"), PropertiesLoader.getProperty("url"), query);
    }

    public List<VHashMap> getDataBaseRecordsInString(String sqlFileName)
    {
        List<VHashMap> vHashMapList = getDataBaseRecords(sqlFileName);
            for(VHashMap vHashMap:vHashMapList)
            {
                vHashMap = vHashMap.humanise();
            }

        return  vHashMapList;
    }

    public List<VHashMap> getDataBaseRecordsInStringWithLimit(String sqlFileName,int limit)
    {
        String SQL = getSQL(sqlFileName);
        return getSQLDataFromQueryWithLimit(limit, SQL);

    }

    private List<VHashMap> getSQLDataFromQueryWithLimit(int limit, String SQL) {
        SQL = SQL.replace(";","") + " LIMIT 0,"+limit;
        return getDataBaseRecordsWithQuery(SQL);
    }

    public List<VHashMap> getDataBaseRecordsFromFile(String fileName,int limit)
    {
        String SQL = DBUtils.loadSQLFile(fileName);
        if(SQL.trim().equals(""))
            throw new RuntimeException("File "+fileName+"not found to run the sql query");
        return getSQLDataFromQueryWithLimit(limit, SQL);
    }


}
