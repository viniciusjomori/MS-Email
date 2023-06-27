package com.ms.msemail.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ms.msemail.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    @Column
    private String ownerRef;
    @Column
    private String emailFrom;
    @Column
    private String emailTo;
    @Column
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column
    private LocalDateTime sendDateEmail;
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
