package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  private int orderNum;

  @CreationTimestamp
  private LocalDateTime orderCreatedAt;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @OneToMany(mappedBy = "orderJpaEntity")
  private List<OrderMenuJpaEntity> orderMenuJpaEntities = new ArrayList<>();

  @Builder
  public OrderJpaEntity(Long orderId, int orderNum, LocalDateTime orderCreatedAt,
      OrderStatus orderStatus,
      UserJpaEntity userJpaEntity,
      List<OrderMenuJpaEntity> orderMenuJpaEntities) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.orderStatus = orderStatus;
    this.userJpaEntity = userJpaEntity;
    this.orderMenuJpaEntities = orderMenuJpaEntities;
  }
}
