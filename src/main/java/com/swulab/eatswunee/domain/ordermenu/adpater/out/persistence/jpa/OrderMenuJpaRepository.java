package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa;

import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMenuJpaRepository extends JpaRepository<OrderMenuJpaEntity, Long> {

}
