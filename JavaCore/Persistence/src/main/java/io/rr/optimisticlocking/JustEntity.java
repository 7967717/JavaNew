package io.rr.optimisticlocking;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;

public class JustEntity {

  @Version
  private long version;

  @Id
  @GeneratedValue
  @Getter
  @Setter
  private Integer id;

  @Getter
  @Setter
  private String value;

  @Override
  public String toString() {
    return "JustEntity{" +
        "version=" + version +
        ", id=" + id +
        ", value='" + value + '\'' +
        '}';
  }
}
