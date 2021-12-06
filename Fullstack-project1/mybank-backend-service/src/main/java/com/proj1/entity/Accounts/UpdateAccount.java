package com.proj1.entity.Accounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateAccount {

    public static void main(String[] args) {



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Account account=entityManager.find(Account.class,"1"); // Managed

        entityManager.getTransaction().commit();
        entityManager.close();  // Detached

        account.balance=50.00;


        entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.merge(account); // Managed

        entityManager.getTransaction().commit();
        entityManager.close();

        entityManagerFactory.close();




    }

}