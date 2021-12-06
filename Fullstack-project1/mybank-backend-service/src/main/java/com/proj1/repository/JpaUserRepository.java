package com.proj1.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class JpaUserRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        entityManager.persist(employee); // insert into employee values(?,?)


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


}
