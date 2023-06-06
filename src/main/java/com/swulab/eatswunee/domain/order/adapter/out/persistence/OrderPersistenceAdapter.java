package com.swulab.eatswunee.domain.order.adapter.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.OrderJpaRepository;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.order.application.port.out.FindNowOrderPort;
import com.swulab.eatswunee.domain.order.application.port.out.FindOrderPort;
import com.swulab.eatswunee.domain.order.application.port.out.FindRestaurantOrderListPort;
import com.swulab.eatswunee.domain.order.application.port.out.SaveOrderPort;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.order.exception.OrderNotFoundException;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.OrderMenuMapper;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.OrderQueryRepository;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.OrderMenuJpaRepository;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements SaveOrderPort, FindOrderPort, FindNowOrderPort,
    FindRestaurantOrderListPort {

  private final OrderJpaRepository orderJpaRepository;
  private final OrderMapper orderMapper;
  private final OrderMenuMapper orderMenuMapper;
  private final OrderMenuJpaRepository orderMenuJpaRepository;
  private final OrderQueryRepository orderQueryRepository;


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

  @Override
  public Order findOrder(Long orderId) {

    OrderJpaEntity orderJpaEntity = orderJpaRepository.findById(orderId).orElseThrow(
        () -> new OrderNotFoundException(ErrorCode.ORDER_NOT_FOUND,
            "아이디가 " + orderId + "인 주문이 존재하지 않습니다."));
    return orderMapper.mapToDomainEntity(orderJpaEntity);
  }

  @Override
  public List<Order> findAllByUserId(Long userId) {
    List<OrderJpaEntity> orderJpaEntityList = orderQueryRepository.findAllOrderByUserId(userId);

    return orderJpaEntityList.stream()
        .map(orderMapper::mapToDomainEntity).toList();
  }

  @Override
  public List<FindNowOrderCommand> findNowOrderPort(Long userId) {
    return orderQueryRepository.findNowOrderCommand(userId);
  }

  @Override
  public FindRestaurantOrderListCommand findRestaurantOrderList(Long orderId) {

    return orderQueryRepository.findRestaurantOrderList(orderId);
  }
}
