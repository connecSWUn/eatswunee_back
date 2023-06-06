package com.swulab.eatswunee.domain.seller.application.port.out;

import com.swulab.eatswunee.domain.seller.domain.model.Seller;

public interface FindSellerPort {

  Seller findSeller(Long sellerId);

}
