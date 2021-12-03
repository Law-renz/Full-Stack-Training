package com.proj1.repository;

import com.proj1.entity.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaTransactionRepository implements TransactionRepository {

    private EntityManagerFactory entityManagerFactory;

    public JpaTransactionRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Transaction transaction) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(transaction);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(Transaction.class,id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Transaction> findAll(String filter) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql="from Todo";
        if(filter.equals("active")) {
            jpql="from Todo where completed = false";
        }
        if(filter.equals("completed")) {
            jpql = "from Todo where completed = true";
        }
        Query query=entityManager.createQuery(jpql);
        List<Transaction> transactions = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return transactions;
    }

    @Override
    public Transaction findById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Transaction transaction =entityManager.find(Transaction.class,id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return transaction;
    }
}
