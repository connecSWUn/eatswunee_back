package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.QRestaurantJpaEntity.restaurantJpaEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RestaurantQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public RestaurantJpaEntity findRestaurantByMenuId(Long menuId) {

        return jpaQueryFactory
                .select(restaurantJpaEntity)
                .from(menuJpaEntity)
                .join(menuJpaEntity.restaurantJpaEntity, restaurantJpaEntity)
                .where(menuJpaEntity.menuId.eq(menuId))
                .fetchOne();
    }
}
