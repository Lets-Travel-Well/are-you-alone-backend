package com.rualone.app.domain.hotplace.dao;

import com.querydsl.core.types.*;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static com.rualone.app.domain.attraction.entity.QAttractionInfo.attractionInfo;
import static com.rualone.app.domain.hotplace.entity.QHotPlace.hotPlace;

@Repository
@RequiredArgsConstructor
public class HotPlaceQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public List<HotPlaceResponse> findTopAttractionInfo(){
        List<HotPlaceResponse> hotPlaceResponses = jpaQueryFactory
                .select(Projections.constructor(HotPlaceResponse.class,
                        attractionInfo.contentId,
                        attractionInfo.title,
                        attractionInfo.addr1,
                        attractionInfo.tel,
                        attractionInfo.firstImage,
                        attractionInfo.latitude,
                        attractionInfo.longitude,
                        count(attractionInfo.contentId)))
                .from(hotPlace)
                .join(attractionInfo)
                .on(hotPlace.attractionInfo.eq(attractionInfo))
                .groupBy(attractionInfo.contentId)
                .orderBy(new OrderSpecifier(Order.DESC, count(attractionInfo.contentId)))
                .limit(10)
                .fetch();
        return hotPlaceResponses;
    }

    public Boolean isMyHotPlace(Integer contentId, Long memberId) {
        Integer fetchOne = jpaQueryFactory
                .selectOne()
                .from(hotPlace)
                .where(
                        hotPlace.attractionInfo.contentId.eq(contentId),
                        hotPlace.member.id.eq(memberId)
                        )
                .fetchFirst(); // limit 1

        return fetchOne != null;
    }
}
