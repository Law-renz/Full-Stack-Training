package com.proj1.web;

import com.proj1.entity.Transaction;
import com.proj1.repository.JpaTransactionRepository;
import com.proj1.repository.TransactionRepository;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TransactionController {
    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }

    static TransactionRepository transactionRepository = new JpaTransactionRepository(entityManagerFactory);

    public static Handler postTransaction = ctx -> {
        Transaction transaction =ctx.bodyAsClass(Transaction.class);
        transactionRepository.save(transaction);
        ctx.status(HttpStatus.CREATED_201);
    };

    public static Handler getAllTransaction = ctx -> {
        String filter = ctx.queryParam("filter");
        if(filter == null) {
            filter = "all";
        }
            List<Transaction> transactions = transactionRepository.findAll(filter);
            ctx.json(transactions);
        };
        public static Handler getTransaction = ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Transaction transaction = transactionRepository.findById(id);
            ctx.json(transaction);
        };
    public static Handler deleteTransaction = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        transactionRepository.delete(id);
        ctx.status(HttpStatus.OK_200);
    };
}

