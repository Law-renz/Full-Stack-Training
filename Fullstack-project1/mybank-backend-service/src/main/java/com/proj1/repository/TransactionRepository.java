package com.proj1.repository;


import com.proj1.entity.Transaction;

import java.util.List;

public interface TransactionRepository {

    // data accessing methods ( dao ) on any datasource ( database )
    void save(Transaction transaction);

    void delete(int id);

    List<Transaction> findAll(String filter);
    Transaction findById(int id);

}
