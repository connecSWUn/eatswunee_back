package com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model.ReviewJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<ReviewJpaEntity, Long> {

}
