package com.swulab.eatswunee.domain.order.adapter.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.OrderJpaRepository;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.order.application.port.out.SaveOrderPort;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements SaveOrderPort{

  private final OrderJpaRepository orderJpaRepository;
  private final OrderMapper orderMapper;


  @Override
  public Long saveOrder(Order order) {
    OrderJpaEntity orderJpaEntity = orderMapper.mapToJpaEntity(order);

    return orderJpaRepository.save(orderJpaEntity).getOrderId();
  }
}
