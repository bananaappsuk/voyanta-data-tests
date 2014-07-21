package com.voyanta.data;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by sriramangajala on 17/07/2014.
 */


public class ProductProductIdComparator implements Comparator<Map>
{
    String key;
    public ProductProductIdComparator(String key)
    {
        this.key = key;
    }

    @Override
    public int compare(Map o1, Map o2) {
        if(o1.get(key).hashCode()>o2.get(key).hashCode())
            return 1;
        else if(o1.get(key).hashCode()<o2.get(key).hashCode())
            return -1;
        else
            return 0;
    }
}

