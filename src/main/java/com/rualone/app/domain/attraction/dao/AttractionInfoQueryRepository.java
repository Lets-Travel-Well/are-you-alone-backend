package com.rualone.app.domain.attraction.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.attraction.dto.response.AttractionInfoResponse;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static com.rualone.app.domain.attraction.entity.QAttractionInfo.attractionInfo;
import static com.rualone.app.domain.hotplace.entity.QHotPlace.hotPlace;

@Repository
@RequiredArgsConstructor
public class AttractionInfoQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public List<AttractionInfoResponse> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId) {
        List<AttractionInfoResponse> attractionInfoResponses = jpaQueryFactory
                .select(Projections.constructor(AttractionInfoResponse.class,
                        attractionInfo.contentId,
                        attractionInfo.title,
                        attractionInfo.addr1,
                        attractionInfo.tel,
                        attractionInfo.firstImage,
                        attractionInfo.latitude,
                        attractionInfo.longitude,
                        count(attractionInfo.contentId)))
                .from(attractionInfo)
                .leftJoin(hotPlace)
                .on(attractionInfo.eq(hotPlace.attractionInfo))
                .where(isContentTypeId(contentTypeId), isSidoCode(sidoCode), isGugunCode(gugunCode))
                .groupBy(attractionInfo.contentId)
                .fetch();
//                = jpaQueryFactory
//                .select(attractionInfo)
//                .from(attractionInfo)
//                .where(isContentTypeId(contentTypeId), isSidoCode(sidoCode), isGugunCode(gugunCode))
//                .fetch();
        return attractionInfoResponses;
    }

    // TODO: 2023/05/16 NULL check : 1. 제네릭 메서드 활용 2. 유틸로 빼내기
    private boolean isNull(Integer input){
        return input == null ? true : false;
    }

    private BooleanExpression isContentTypeId(Integer ContentTypeId) {
        return isNull(ContentTypeId) ? null : attractionInfo.contentTypeId.eq(ContentTypeId);
    }
    private BooleanExpression isSidoCode(Integer sidoCode) {
        return isNull(sidoCode) ? null : attractionInfo.sido.sidoCode.eq(sidoCode);
    }

    private BooleanExpression isGugunCode(Integer gugunCode) {
        return isNull(gugunCode) ? null :  attractionInfo.gugun.gugunCode.eq(gugunCode);
    }


    public Boolean isMyPlace(Integer contentId, Long memberId) {
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

    public Boolean checkLikeCnt(Integer contentId) {
        Integer fetchOne = jpaQueryFactory
                .selectOne()
                .from(hotPlace)
                .where(
                        hotPlace.attractionInfo.contentId.eq(contentId)
                )
                .fetchFirst(); // limit 1

        return fetchOne == null;
    }
}
