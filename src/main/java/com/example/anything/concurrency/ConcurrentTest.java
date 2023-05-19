package com.example.anything.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



 class ConcurrentTest {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(10000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1); // 임의의 지연 시간
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.deposit(10);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1); // 임의의 지연 시간
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.withdraw(10);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + account.getBalance());
    }

     public static class Account {
         private static final int NUM_THREADS = 100;
         private static final int NUM_ITERATIONS = 10000;

         private int balance;
         private Lock lock;

         public Account(int balance) {
             this.balance = balance;
             this.lock =  new ReentrantLock();
         }
         public void deposit(int amount) {
             lock.lock();
             try {
                 balance += amount;
             }finally {
                 lock.unlock();
             }
             balance += amount;
         }

         public void withdraw(int amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
             balance -= amount;
         }

         public int getBalance() {
//        lock.lock();
//        try {
//            return balance;
//        } finally {
//            lock.unlock();
//        }
             return balance;
         }


     }
}
