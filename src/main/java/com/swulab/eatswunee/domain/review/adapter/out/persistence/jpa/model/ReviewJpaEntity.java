package com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "review_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "review_created_at"))
})
@SuperBuilder
@Getter
public class ReviewJpaEntity extends BaseEntity {

  private int score;

  private String title;

  private String content;

  @UpdateTimestamp
  private LocalDateTime editedAt;

  private String reviewImg;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @ManyToOne
  @JoinColumn(name = "menu_id")
  private MenuJpaEntity menuJpaEntity;

  @OneToOne
  @JoinColumn(name = "order_menu_id")
  private OrderMenuJpaEntity orderMenuEntity;

  public ReviewJpaEntity(Long reviewId, int score, String title, String content,
      LocalDateTime createdAt, LocalDateTime editedAt, String reviewImg,
      UserJpaEntity userJpaEntity,
      MenuJpaEntity menuJpaEntity,
      OrderMenuJpaEntity orderMenuEntity) {
    super(reviewId, createdAt);
    this.score = score;
    this.title = title;
    this.content = content;
    this.editedAt = editedAt;
    this.reviewImg = reviewImg;
    this.userJpaEntity = userJpaEntity;
    this.menuJpaEntity = menuJpaEntity;
    this.orderMenuEntity = orderMenuEntity;
  }
}
