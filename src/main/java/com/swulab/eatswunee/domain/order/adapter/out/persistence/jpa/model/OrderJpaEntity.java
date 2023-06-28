package com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "order_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "order_created_at"))
})
@SuperBuilder
@Getter
public class OrderJpaEntity extends BaseEntity {

  private int orderNum;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @Builder.Default
  @OneToMany(mappedBy = "orderJpaEntity")
  private List<OrderMenuJpaEntity> orderMenuJpaEntities = new ArrayList<>();

  public OrderJpaEntity(Long orderId, int orderNum, LocalDateTime orderCreatedAt,
      OrderStatus orderStatus,
      UserJpaEntity userJpaEntity,
      List<OrderMenuJpaEntity> orderMenuJpaEntities) {
    super(orderId, orderCreatedAt);
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.userJpaEntity = userJpaEntity;
    this.orderMenuJpaEntities = orderMenuJpaEntities;
  }
}
