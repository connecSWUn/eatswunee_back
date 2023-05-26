package com.swulab.eatswunee.domain.order.adapter.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.OrderJpaRepository;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.order.application.port.out.SaveOrderPort;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.OrderMenuMapper;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.OrderMenuJpaRepository;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements SaveOrderPort{

  private final OrderJpaRepository orderJpaRepository;
  private final OrderMapper orderMapper;
  private final OrderMenuMapper orderMenuMapper;
  private final OrderMenuJpaRepository orderMenuJpaRepository;


  @Override
  public Long saveOrder(Order order) {

    List<OrderMenuJpaEntity> orderMenuJpaEntities = order.getOrderMenus().stream().map(
        orderMenuMapper::mapToJpaEntity).toList();


    OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);

    // TODO: caseCade 적용하기
    orderMenuJpaEntities
        .forEach(
            jpaEntity -> {
              jpaEntity.setOrderJpaEntity(orderJpaEntity);
            }
        );

    OrderJpaEntity save = orderJpaRepository.save(orderJpaEntity);

    orderMenuJpaRepository.saveAll(orderMenuJpaEntities);

    return save.getOrderId();
  }
}
