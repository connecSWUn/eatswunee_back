package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  private int orderNum;

  @Enumerated
  private OrderStatus orderStatus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @OneToMany(mappedBy = "orderMenuId", cascade = CascadeType.ALL)
  private List<OrderMenuJpaEntity> orderMenuJpaEntities;

  @Builder
  public OrderJpaEntity(Long orderId, int orderNum,
      OrderStatus orderStatus,
      UserJpaEntity userJpaEntity,
      List<OrderMenuJpaEntity> orderMenuJpaEntities) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.userJpaEntity = userJpaEntity;
    this.orderMenuJpaEntities = orderMenuJpaEntities;
  }
}
