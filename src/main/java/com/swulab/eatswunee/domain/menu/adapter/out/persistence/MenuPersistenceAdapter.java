package com.swulab.eatswunee.domain.menu.adapter.out.persistence;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.menu.exception.MenuNotFoundException;
import com.swulab.eatswunee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuPersistenceAdapter implements FindMenuPort {

  private final MenuJpaRepository menuJpaRepository;
  private final MenuMapper menuMapper;


  @Override
  public Menu findMenu(Long menuId) {
    MenuJpaEntity menuJpaEntity = menuJpaRepository.findById(menuId)
        .orElseThrow(() -> new MenuNotFoundException(ErrorCode.MENU_NOT_FOUND, "메뉴 id : " + menuId + " 가 존재하지 않습니다."));

    return menuMapper.mapToDomainEntity(menuJpaEntity);
  }
}
