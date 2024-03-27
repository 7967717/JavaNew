package io.rr.optimisticlocking;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class OperationListener {

  @PostLoad
  public void postLoad(JustEntity obj) {
    System.out.println("Loaded operation: " + obj);
  }

  @PrePersist
  public void prePersist(JustEntity obj) {
    System.out.println("Pre-Persistiting operation: " + obj);
  }

  @PostPersist
  public void postPersist(JustEntity obj) {
    System.out.println("Post-Persist operation: " + obj);
  }

  @PreRemove
  public void preRemove(JustEntity obj) {
    System.out.println("Pre-Removing operation: " + obj);
  }

  @PostRemove
  public void postRemove(JustEntity obj) {
    System.out.println("Post-Remove operation: " + obj);
  }

  @PreUpdate
  public void preUpdate(JustEntity obj) {
    System.out.println("Pre-Updating operation: " + obj);
  }

  @PostUpdate
  public void postUpdate(JustEntity obj) {
    System.out.println("Post-Update operation: " + obj);
  }
}
