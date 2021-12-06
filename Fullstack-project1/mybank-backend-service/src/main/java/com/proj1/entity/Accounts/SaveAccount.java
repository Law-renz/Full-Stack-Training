package com.proj1.entity.Accounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SaveAccount {

    public static void main(String[] args) {

        Account account=new Account(); // New / Transient
        account.number="1";
        account.balance=1000.00;


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.persist(account);
        account.balance=200.00;


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
