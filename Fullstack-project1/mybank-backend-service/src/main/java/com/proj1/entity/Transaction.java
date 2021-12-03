package com.proj1.entity;
import javax.persistence.*;

    @Entity
    @Table(name = "Transactions")
    public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id; // 0
        private String title; // null
        private boolean completed; // false

        public Transaction(int id, String title, boolean completed) {
            this.id = id;
            this.title = title;
            this.completed = completed;
        }

        public Transaction(String title) {
            this.title = title;
        }

        public Transaction() {
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "Todo{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }

