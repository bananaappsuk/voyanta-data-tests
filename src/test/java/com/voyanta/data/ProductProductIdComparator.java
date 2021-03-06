package com.voyanta.data;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by sriramangajala on 17/07/2014.
 */


public class ProductProductIdComparator implements Comparator<Map>
{
    String key;
    String key1=null;
    public ProductProductIdComparator(String key)
    {
        this.key = key;
        this.key1=key1;
    }

    @Override
    public int compare(Map o1, Map o2) {
        if(o1.get(key)==null||o2.get(key)==null)
        {
            return 0;
        }
        if(o1.get(key).hashCode()>o2.get(key).hashCode())
            if(!(o1.containsKey(key)&&o2.containsKey(key)))
                return 0;
            if (o1.get(key).hashCode() > o2.get(key).hashCode())
//            if(key1==null)
                return 1;
//            return 1;
            else if (o1.get(key).hashCode() < o2.get(key).hashCode())
                return -1;
            else
                return 0;


    }
}

