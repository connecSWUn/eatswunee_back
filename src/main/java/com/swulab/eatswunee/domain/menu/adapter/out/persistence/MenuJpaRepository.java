package com.swulab.eatswunee.domain.menu.adapter.out.persistence;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuJpaRepository extends JpaRepository<MenuJpaEntity, Long> {

}
