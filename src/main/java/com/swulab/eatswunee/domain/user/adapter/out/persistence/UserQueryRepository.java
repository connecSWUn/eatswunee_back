package com.swulab.eatswunee.domain.user.adapter.out.persistence;

import static com.querydsl.core.group.GroupBy.list;
import static com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.QRecruitJpaEntity.recruitJpaEntity;
import static com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.QUserJpaEntity.userJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand.PostCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserQueryRepository {

  private final JPAQueryFactory queryFactory;

  public WriteListCommand getWriteList(Long userId) {

    return queryFactory
        .select(Projections.constructor(WriteListCommand.class,
            userJpaEntity.id.as("userId"),
            userJpaEntity.name.as("userName"),
            userJpaEntity.profileUrl,
            list(
                Projections.fields(PostCommand.class,
                    recruitJpaEntity.id.as("postId"),
                    recruitJpaEntity.title.as("postTitle"),
                    recruitJpaEntity.startTime.as("postStartTime"),
                    recruitJpaEntity.endTime.as("postEndTime"),
                    recruitJpaEntity.createdAt.as("postCreatedAt"),
                    recruitJpaEntity.status.as("postRecruitStatus"))
            ).as("posts")
        ))
        .from(recruitJpaEntity)
        .join(recruitJpaEntity.userJpaEntity, userJpaEntity)
        .where(recruitJpaEntity.userJpaEntity.id.eq(userId))
        .groupBy(recruitJpaEntity.userJpaEntity.id)
        .fetchOne();

  }



}
