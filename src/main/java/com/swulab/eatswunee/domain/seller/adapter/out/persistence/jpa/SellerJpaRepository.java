package com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa.model.SellerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerJpaRepository extends JpaRepository<SellerJpaEntity, Long> {

}
