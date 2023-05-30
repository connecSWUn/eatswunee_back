package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import static com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.QOrderJpaEntity.orderJpaEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public List<OrderJpaEntity> findAllOrderByUserId(Long userId) {
    return jpaQueryFactory
        .selectFrom(orderJpaEntity)
        .where(orderJpaEntity.userJpaEntity.userId.eq(userId))
        .fetch();
  }


}
