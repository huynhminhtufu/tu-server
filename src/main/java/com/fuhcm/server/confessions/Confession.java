package com.fuhcm.server.confessions;

import com.fuhcm.server.common.entities.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "confessions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Confession extends BaseEntity {
  private String content;
  private String senderToken;
  @Builder.Default
  private STATUS status = STATUS.PENDING;
  private String note;

  enum STATUS {
    PENDING,
    APPROVED,
    REJECTED
  }
}
