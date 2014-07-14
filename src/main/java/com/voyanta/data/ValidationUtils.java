package com.voyanta.data;

import com.voyanta.data.utils.VHashMap;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.util.*;

/**
 * Created by sriramangajala on 09/07/2014.
 */
public class ValidationUtils {
    static Logger LOGGER = Logger.getLogger(ValidationUtils.class);
    
    public static List<VHashMap> lowerCaseColumnsAndRemoveSpaces(List<VHashMap> data) {
        List<VHashMap> newData = new LinkedList<VHashMap>();

        for(VHashMap singleRow:data)
        {
//            Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
            VHashMap newRecord = new VHashMap();
            Set set2 = singleRow.entrySet();
            Iterator iterator2 = set2.iterator();
            while(iterator2.hasNext()) {
                Map.Entry me2 = (Map.Entry)iterator2.next();
                newRecord.put(me2.getKey().toString().replace(" ","").toLowerCase(),singleRow.get(me2.getKey()));
             //   LOGGER.info("Before change....:");
               // LOGGER.info(me2.getKey() + ": ");
               // LOGGER.info(singleRow.get(me2.getKey()));
                //LOGGER.info("   After change....:");
                //LOGGER.info(me2.getKey().toString().replace(" ", "").toLowerCase() + ": ");
            }
            newData.add(newRecord);
        }
            return newData;
    }

//    public static List<HashMap> sortColumns(List<HashMap> data) {
//        for(HashMap singleRow:data)
//        {

//        }
//        return new TreeMap<String, Float>(yourMap);
//    }

    public static void compareColumnHeaders(List<VHashMap> excelSheetData, List<VHashMap> dataBaseData) {

// int i = 0;
        int failcounter=0;
        int failedcounter=0,counter = 0;
        int totalCount = excelSheetData.size()-1;


        for(int i=0;i<=totalCount;i++)
        {
// dataBaseData.get(i).humanise()
            VHashMap dbMap = dataBaseData.get(i).humanise().addExceptions();
            VHashMap excelMap = excelSheetData.get(i).addExceptions();

            if(!(excelSheetData.get(i).size()==(dbMap.size())))
            {
                LOGGER.info("Columns size not matching...");
                LOGGER.info("Excel Sheet columns are "+excelMap.size()+" where as Database columns are "+dbMap.size()+"");
                failedcounter++;

            }

//            if(!excelSheetData.get(i).keySet().equals(dataBaseData.get(i).keySet()))
//            {
//                LOGGER.info("Columns not matching");
//            }

             Set<String> set1=dbMap.keySet();
             Iterator<String> iter1=set1.iterator();

            while (iter1.hasNext())
            {
                String key = iter1.next();
                // Check if the current value is a key in the 2nd map
                if (!excelMap.containsKey(key) ){
                    LOGGER.info("This Key not available in Excel Sheet:"+key);
                    failedcounter ++;
                }
                else if (!dbMap.get(key).equals(excelMap.get(key)) )
                {
                    LOGGER.info("Column name :" + key.toString() + " Actual Value :'" + dbMap.get(key) + "' Expected Value :'" + excelMap.get(key) + "'");
//                    LOGGER.info("Expected available:"+excelMap.get(key));
                    failedcounter ++;
                }
                counter++;
            }

            LOGGER.info("TOTAL TESTS : "+counter+" record :"+(i+1));

            if(failedcounter==0)
                LOGGER.info("NO TESTS FAILED AT DATA LEVEL VALIDATION record:"+(i+1));
            else
            {
                LOGGER.info("FAILED TESTS : "+failedcounter+" record:"+(i+1));
                failcounter++;
            }


//        Set<String> set2=excelSheetData.get(i).entrySet();
//        Iterator<String> iter2=set2.iterator();
//
//        while (iter2.hasNext())
//        {
//           String value1 = iter2.next();
//           String value2 =  ((value1).getValue();
//            // Check if the current value is a key in the 2nd map
//            if (!dataBaseData.get(i).containsValue(value1) ){
//                LOGGER.info("value not available "+value1);
//
//            }
//        }


        }
        Assert.assertEquals("Data validation failed. Please see the details above",0,failedcounter);
    }

    public static void compareRowsNumbers(List<VHashMap> excelSheetData, List<VHashMap> dataBaseData) {

        if(!(excelSheetData.size()==(dataBaseData.size())))
        {
            LOGGER.info("Row Number not matching...");
            LOGGER.info("Excel Sheet rows are :"+excelSheetData.size()+" where as Datbase rows are :"+dataBaseData.size());
        }

        for(int i=0;i<=excelSheetData.size()-1;i++)
        {
            if(excelSheetData.get(i).keySet().equals(dataBaseData.get(i).keySet()))
            {
                LOGGER.info("Both keys are Equal");
            }
            else
                LOGGER.info("Both keys are not Equal");

            if(excelSheetData.get(i).entrySet().equals(dataBaseData.get(i).entrySet()))
            {
                LOGGER.info("Both datasets are Equal");
            }
            else
                LOGGER.info("Both datasets are NOT Equal");
        }
    }

    public static void compareData(List<VHashMap> excelSheetData, List<VHashMap> dataBaseData) {
        int counter = 0;
        for(int i=0;i<=excelSheetData.size()-1;i++)
        {
            VHashMap hMap3=new VHashMap();
            Set<String> set1=excelSheetData.get(i).keySet();
            Set<String> set2=dataBaseData.get(i).keySet();

            Iterator<String> iter1=set1.iterator();
            Iterator<String> iter2=set2.iterator();
            String val="";
            while(iter1.hasNext()) {

                val=iter1.next();
             //   LOGGER.info("key and value in hmap is " + val + " " + excelSheetData.get(i).get(val));

                iter2=set2.iterator();

                while(iter2.hasNext()) {
                    String val2=iter2.next();
                   // LOGGER.info("val2 value is "+val2);

                    if(!excelSheetData.get(i).get(val).equals(dataBaseData.get(i).get(val2))) {
                     //   LOGGER.info("NO matching found for Excel " + excelSheetData.get(i).get(val) + " and Database " + dataBaseData.get(i).get(val2));
                     //   LOGGER.info("value adding");

                    }
                }
            }

        }
    }
}
