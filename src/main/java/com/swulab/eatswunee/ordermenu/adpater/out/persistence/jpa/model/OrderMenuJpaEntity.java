package com.swulab.eatswunee.ordermenu.adpater.out.persistence.jpa.model;

import com.swulab.eatswunee.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import com.swulab.eatswunee.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import jakarta.persistence.Entity;
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

  private int menuCnt;

  private Integer orderPrice;

  @ManyToOne
  @JoinColumn(name = "menu_id")
  private MenuJpaEntity menuJpaEntity;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderJpaEntity orderJpaEntity;

  @Builder
  public OrderMenuJpaEntity(Long orderMenuId, int menuCnt, Integer orderPrice,
      MenuJpaEntity menuJpaEntity,
      OrderJpaEntity orderJpaEntity) {
    this.orderMenuId = orderMenuId;
    this.menuCnt = menuCnt;
    this.orderPrice = orderPrice;
    this.menuJpaEntity = menuJpaEntity;
    this.orderJpaEntity = orderJpaEntity;
  }
}
