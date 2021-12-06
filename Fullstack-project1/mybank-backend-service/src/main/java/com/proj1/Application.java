package com.proj1;

import com.proj1.web.TransactionController;
import com.proj1.web.UserController;
import io.javalin.Javalin;

public class Application {

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);

        app.post("/usrs", UserController.createNewUser);
        app.post("/users/{userId}/mybank", TransactionController.createTransaction);
        app.get("/users/{userId}/mybank", TransactionController.getAllTransaction);
        app.get("/users/{userId}/mybank/{id}", TransactionController.getTransaction);
        app.delete("/todos/{}id", TransactionController.deleteTransaction);
    }
}
