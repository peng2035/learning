package com.bobby.peng.learning.tair;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.impl.DefaultTairManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng2035 on 2017/8/22.
 */
public class TairTest {

    public static void main(String[] args) {
        int nameSpace = 1;

        List<String> ips = new ArrayList<String>();
        ips.add("10.139.32.174:5198");

        DefaultTairManager defaultTairManager = new DefaultTairManager();
        defaultTairManager.setConfigServerList(ips);
        defaultTairManager.setGroupName("zatair");
        defaultTairManager.init();

        DefaultTairManager defaultTairManager1 = new DefaultTairManager();
        defaultTairManager1.setConfigServerList(ips);
        defaultTairManager1.setGroupName("zatair");
        defaultTairManager1.init();

        defaultTairManager.put(nameSpace,"pthtest", "value3");
        Result<DataEntry> result = defaultTairManager.get(nameSpace, "pthtest");
        System.out.println(result.getValue().toString());

        defaultTairManager1.put(nameSpace,"pthtest", "value4");
        Result<DataEntry> result1 = defaultTairManager.get(nameSpace, "pthtest");
        System.out.println(result1.getValue().toString());

        result = defaultTairManager.get(nameSpace, "pthtest");
        System.out.println(result.getValue().toString());

    }

}
