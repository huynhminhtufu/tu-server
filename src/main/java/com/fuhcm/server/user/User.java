package com.fuhcm.server.user;

import com.fuhcm.server.common.entities.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
  @Indexed(unique = true, sparse = true)
  private String email;
  private String name;
  @Builder.Default
  private Boolean isAdmin = false;
}
