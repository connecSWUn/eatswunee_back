package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderNumJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderNumJpaEntityRepository extends JpaRepository<OrderNumJpaEntity, Long> {
}
