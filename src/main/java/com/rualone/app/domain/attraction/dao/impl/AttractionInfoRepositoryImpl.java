package com.rualone.app.domain.attraction.dao.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rualone.app.domain.attraction.dao.AttractionInfoRepositoryCustom;
import com.rualone.app.domain.attraction.entity.AttractionInfo;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.rualone.app.domain.attraction.entity.QAttractionInfo.attractionInfo;

@RequiredArgsConstructor
public class AttractionInfoRepositoryImpl implements AttractionInfoRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<AttractionInfo> findAllByCriteria(Integer sidoCode, Integer gugunCode, Integer contentTypeId) {
        List<AttractionInfo> attractionInfos = jpaQueryFactory
                .select(attractionInfo)
                .from(attractionInfo)
                .where(isContentTypeId(contentTypeId), isSidoCode(sidoCode), isGugunCode(gugunCode))
                .fetch();
        return attractionInfos;
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


}
