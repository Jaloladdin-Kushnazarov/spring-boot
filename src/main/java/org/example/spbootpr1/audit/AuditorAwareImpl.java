package org.example.spbootpr1.audit;


import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        // test uchun current user id
        return Optional.of(new Random().nextLong(1,7));




        // Agar Spring Security o‘rnatilgan bo‘lsa:
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if (authentication == null || !authentication.isAuthenticated()) {
        //     return Optional.empty();
        // }
        // return Optional.of(authentication.getName());
    }
}