package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.OrderNotificationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderNotificationJpaRepository extends JpaRepository<OrderNotificationJpaEntity, Long> {

    @Override
    <S extends OrderNotificationJpaEntity> S save(S entity);
}
