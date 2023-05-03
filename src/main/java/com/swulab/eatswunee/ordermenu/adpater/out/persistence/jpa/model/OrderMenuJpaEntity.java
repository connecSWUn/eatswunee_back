package com.swulab.eatswunee.ordermenu.adpater.out.persistence.jpa.model;

import com.swulab.eatswunee.order.domain.model.OrderStatus;
import com.swulab.eatswunee.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderMenuJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderMenuId;

  private int orderNum;

  @Enumerated
  private OrderStatus orderStatus;

  @ManyToOne
  @JoinColumn(name = "user_Id")
  private UserJpaEntity userJpaEntity;

  @Builder
  public OrderMenuJpaEntity(Long orderMenuId, int orderNum,
      OrderStatus orderStatus,
      UserJpaEntity userJpaEntity) {
    this.orderMenuId = orderMenuId;
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.userJpaEntity = userJpaEntity;
  }
}
