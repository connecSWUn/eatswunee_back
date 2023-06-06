package com.swulab.eatswunee.domain.seller.adapter.out.persistence;

import com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa.SellerJpaRepository;
import com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa.model.SellerJpaEntity;
import com.swulab.eatswunee.domain.seller.application.port.out.FindSellerPort;
import com.swulab.eatswunee.domain.seller.domain.model.Seller;
import com.swulab.eatswunee.domain.seller.exception.NotFoundSellerException;
import com.swulab.eatswunee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SellerPersistenceAdapter implements FindSellerPort {

  private final SellerJpaRepository sellerJpaRepository;
  private final SellerMapper sellerMapper;

  @Override
  public Seller findSeller(Long sellerId) {

    SellerJpaEntity sellerJpaEntity = sellerJpaRepository.findById(sellerId)
        .orElseThrow(() -> new NotFoundSellerException(ErrorCode.SELLER_NOT_FOUND,
            "[sellerId] " + sellerId + " 가 존재하지 않습니다."));

    return sellerMapper.mapToDomainEntity(sellerJpaEntity);
  }
}
