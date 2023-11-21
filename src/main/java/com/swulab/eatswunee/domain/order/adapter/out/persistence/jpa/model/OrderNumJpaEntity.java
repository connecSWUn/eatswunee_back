package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class OrderNumJpaEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumId;

    private Integer orderNum;

    @Builder
    public OrderNumJpaEntity(Long orderNumId, Integer orderNum) {
        this.orderNumId = orderNumId;
        this.orderNum = orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
