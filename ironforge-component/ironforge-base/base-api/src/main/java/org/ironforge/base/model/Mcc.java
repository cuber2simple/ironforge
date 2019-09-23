package org.ironforge.base.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Mcc {
  private int id;
  private String mccCode;
  private String officialNameEn;
  private String officialNameCn;
  private String isSys;
  private String status;
  private String updateUserId;
  private String createUserId;
  private LocalDateTime expireDatetime;
  private LocalDateTime updateDatetime;
  private LocalDateTime createDatetime;
}
