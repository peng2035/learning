package com.bobby.peng.learning.java.stream;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by bobby.peng on 2018/4/19.
 */
public class StreamMap {

    public static List<Integer> newRandomList() {
        List<Integer> list = new ArrayList<>(50);
        for(int i=0;i<50;i++) {
            list.add(i);
        }
        return list;
    }

    public static void printOut(List<Integer> list) {
        list.stream().forEach(StreamMap::println);
    }

    public static void println(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
//        List<Integer> list = StreamMap.newRandomList();
//
//        List<Integer> list2 = list.stream().map(i->i*5).collect(Collectors.toList());
//
//        StreamMap.printOut(list2);
//
//        list = list.subList(0,11);
//        StreamMap.printOut(list);
//
//        String value = "INSERT INTO tech_subao_00.subao_renew_list (id, extra_info, gmt_created, gmt_modified, is_deleted, creator, modifier, remark, status, unqiue_flag, list_biz_id, province_name, province_code, city_name, city_code, license_no, engine_no, frame_no, factory_plate_model, first_register_date, applicant_name, owner_name, owner_certificate_type, owner_id_no, owner_mobile, contact_phone1, contact_phone2, bi_end_date, ci_end_date, vehicle_id, list_allocation_time, booking_start_date, booking_end_date, user_id, renew_batch_id, renew_biz_name, source, organization_id) VALUES (%d, null, '2018-08-07 02:50:36', '2018-08-07 02:50:37', 'N', '', 'system', null, 10, '000000%d', '1', '北京', '110000', '北京', '110100', '12312313', '12313', '31231', '111', '2018-05-12', '123', '123', 1, '310111111111111111', '13311111111', '13311111111', '13311111111', '2019-08-07 05:24:56', '2019-08-07 05:25:03', 1, null, null, null, null, %d, 'batch1', 50, 1);";
//
//        int id = 3;
//        for(int i=3;i<100;i++) {
//            for(int j=0;j<2;j++) {
//                System.out.println(String.format(value,id,id,i));
//                id++;
//            }
//        }


        List<Integer> test = new ArrayList<>();
        for(int i=0;i<1000;i++) {
            test.add(i);
        }

        test.parallelStream().map(i->{
            System.out.println(i);
            return i;
        }).collect(Collectors.toList());

        System.out.println("===================我是分割线================");

        test.stream().map(i->{
            System.out.println(i);
            return i;
        }).collect(Collectors.toList());



    }




}
