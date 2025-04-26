package org.example.spbootpr1.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.example.spbootpr1.entity.BaseEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;



@RequiredArgsConstructor
@Component
public class CustomAuditingEntityListener {

    private final AuditorAwareImpl auditorAware;




    @PrePersist
    public void prePersist(Object target) {
        if (target instanceof BaseEntity entity) {
            LocalDateTime now = LocalDateTime.now();
            Long userId = auditorAware.getCurrentAuditor().orElse(null);

            entity.setCreatedAt(now);
            entity.setCreatedBy(userId);
            // ❗ Updated fields TOUCH QILMAYMIZ (shuning uchun null turadi!)
        }
    }

    @PreUpdate
    public void preUpdate(Object target) {
        if (target instanceof BaseEntity entity) {
            LocalDateTime now = LocalDateTime.now();
            Long userId = auditorAware.getCurrentAuditor().orElse(null);

            entity.setUpdatedAt(now);
            entity.setUpdatedBy(userId);
        }
    }
}