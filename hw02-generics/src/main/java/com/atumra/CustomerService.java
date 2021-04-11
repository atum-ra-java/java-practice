package com.atumra;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class CustomerService {

    private final TreeMap<Customer, String> treeMap = new TreeMap<>(Comparator.comparing(Customer::getScores));

    // todo: 3. надо реализовать методы этого класса
    // важно подобрать подходящую Map-у, посмотрите на редко используемые методы,
    // они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> res =  treeMap.firstEntry();
        Customer resultCustomer = res.getKey();
        return cloneEntry(res);

    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> res = treeMap.higherEntry(customer);
        if (res == null) return null;
        return cloneEntry(res);
    }

    public void add(Customer customer, String data) {
        treeMap.put(customer, data);
    }

    @Override
    public String toString() {
        return "CustomerService [treeMap=" + treeMap.size() + "]";
    }

    private Map.Entry<Customer, String> cloneEntry(Map.Entry<Customer, String> res) {
        Customer resultCustomer = res.getKey();
        Map.Entry<Customer, String> clone =  new AbstractMap.SimpleEntry<Customer, String>(
            new Customer(resultCustomer.getId(), resultCustomer.getName(), resultCustomer.getScores()), res.getValue()
        );
        return clone;
    }

    private void print() {
        treeMap.forEach( ( key, val ) -> System.out.println( "key:" + key + " , val:" + val ) );
    }

}
