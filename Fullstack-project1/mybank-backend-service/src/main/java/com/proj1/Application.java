package com.proj1;

import com.proj1.repository.JpaTransactionRepository;
import com.proj1.repository.TransactionRepository;
import com.proj1.web.TransactionController;
import io.javalin.Javalin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
    }
    static TransactionRepository transactionRepository =new JpaTransactionRepository(entityManagerFactory);
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);

        app.post("/todos", TransactionController.postTransaction);
        app.get("/todos", TransactionController.getAllTransaction);
        app.get("/todos/{id}", TransactionController.getTransaction);
        app.delete("/todos/{}id", TransactionController.deleteTransaction);
    }
}
