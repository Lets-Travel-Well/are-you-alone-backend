package com.rualone.app.domain.hotplace.dao;

import com.querydsl.core.types.*;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.hotplace.dto.response.HotPlaceResponse;
import com.rualone.app.domain.hotplace.dto.response.MyPlaceResponse;
import com.rualone.app.domain.member.entity.Member;
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
                .limit(8)
                .fetch();
        return hotPlaceResponses;
    }
    public List<MyPlaceResponse> findMyPlaceList(Long memberId) {
        List<MyPlaceResponse> myPlaceResponses = jpaQueryFactory
                .select(Projections.constructor(MyPlaceResponse.class,
                        attractionInfo.contentId,
                        attractionInfo.title,
                        attractionInfo.firstImage,
                        attractionInfo.addr1,
                        count(hotPlace.member.id)))
                .from(hotPlace)
                .join(attractionInfo)
                .on(hotPlace.attractionInfo.eq(attractionInfo))
                .groupBy(hotPlace.attractionInfo.contentId)
                .having(hotPlace.attractionInfo.contentId.in(
                        JPAExpressions
                                .select(hotPlace.attractionInfo.contentId)
                                .from(hotPlace)
                                .where(hotPlace.member.id.eq(memberId))))
                .fetch();
/*
    select content_id, title, first_image, addr1, count(member_id)
    from hot_place
    join attraction_info
    on content_id=attraction_info_content_id
    group by content_id
    having content_id in
    (select attraction_info_content_id
    from hot_place
    where member_id=59);
* */
        return myPlaceResponses;
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
