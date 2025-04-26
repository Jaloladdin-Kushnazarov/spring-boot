package org.example.spbootpr1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.spbootpr1.audit.CustomAuditingEntityListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class) // Custom Listener ulanadi!
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // yoki Integer id

    @CreatedDate
    @Column(updatable = false)// ⬅️ faqat birinchi marta set qilinadi
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(updatable = false)// ⬅️ faqat birinchi marta set qilinadi
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;
}
