//package com.example.anything.transaction;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class TransactionBasic {
//    private static EntityManager entityManager;
//    private static SettleRepository repository;
//
//    public static void main(String[] args) {
//        entityManager = Persistence.createEntityManagerFactory("").createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//            repository.save(new PointHistory(1L,1L,1L,SAVE, PointUsedType.REFUND));
//            transaction.commit();
//
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//        }finally {
//            entityManager.close();
//        }
//
//    }
//}
//
