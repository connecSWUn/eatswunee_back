package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {

  @Override
  <S extends OrderJpaEntity> S save(S entity);
}
