package com.fuhcm.server.common.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
public class BaseEntity implements Serializable {
  @Id
  @Indexed
  protected String id;

  @CreatedDate
  protected long createdDate;

  @LastModifiedDate
  protected long updatedAt;
}
