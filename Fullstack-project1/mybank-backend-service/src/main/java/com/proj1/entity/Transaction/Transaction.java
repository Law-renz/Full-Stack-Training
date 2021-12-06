package com.proj1.entity.Transaction;
import javax.persistence.*;

    @Entity
    @Table(name = "Transactions")
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id; // 0
        private int amount; // 0
        private boolean completed; // false

        public Transaction(int id, int amount, boolean completed) {
            this.id = id;
            this.amount = amount;
            this.completed = completed;
        }

        public Transaction(int amount) {
            this.amount = amount;
        }

        public Transaction() {
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "id=" + id +
                    ", amount='" + amount + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }

