package io.rr.optimisticlocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

  private static EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("persistenceUnit");

  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(10);
    try {
      persistFill();
      for (int i = 0; i < 10; i++) {
        int finalI = i;
        es.execute(() -> {
          updateEntity(finalI);
        });
      }
      es.shutdown();
      try {
        es.awaitTermination(10, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } finally {
      entityManagerFactory.close();
    }
  }

  private static void updateEntity(int index) {
    EntityManager em = entityManagerFactory.createEntityManager();

    JustEntity entity = null;
    try {
      em.getTransaction().begin();
      entity = em.find(JustEntity.class, 1);
      System.out.println("load = " + index);
      em.lock(entity, LockModeType.OPTIMISTIC);

      entity.setValue("WoW_" + index);
      em.getTransaction().commit();
      em.close();
      System.out.println("--Greeter updated : " + entity + " __--__ " + index);
    } catch (RollbackException ex) {
      System.out.println("RollbackException" + entity);
    }
  }

  public static void persistFill() {
    JustEntity entity = new JustEntity();
    entity.setValue("JPA");
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }
}
