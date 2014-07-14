package com.voyanta.data.datamodel;

import com.voyanta.data.datamodel.sheets.AccountSheetData;
import com.voyanta.data.utils.DataSheetUtil;
import com.voyanta.data.utils.VHashMap;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sriramangajala on 01/07/2014.
 */
public class DataSheetsView {

    public int getNumberOfRecordsInExcel() {
        return numberOfRecordsInExcel;
    }

    public void setNumberOfRecordsInExcel(int numberOfRecordsInExcel) {
        this.numberOfRecordsInExcel = numberOfRecordsInExcel;
    }

    private int numberOfRecordsInExcel =0;

    public void getDataSheetData(String file)
    {

    }

    public List<VHashMap> getExcelFileDataInHashMap(String folder,String file,String sheet)
    {
        AccountSheetData accountSheetData = new AccountSheetData();
        accountSheetData.loadAccountData(folder,file,sheet);
        numberOfRecordsInExcel = accountSheetData.getNumberOfRecordsInExcel();
        return accountSheetData.getSheetDataInHashMap();
    }

    public List<VHashMap> copyDataToAdditionalColumn(List<VHashMap> vHashMapList, String additionalColumn, String existingColumn) {


        return DataUtils.addAdditionalColumnFrom(vHashMapList,additionalColumn,existingColumn);
    }
}
