package com.proj1.entity.Accounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteAccount {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Account account=entityManager.find(Account.class,"1"); // Managed
        entityManager.remove(account); // Removed


        entityManager.getTransaction().commit(); // Transient
        entityManager.close();
        entityManagerFactory.close();

    }

}
