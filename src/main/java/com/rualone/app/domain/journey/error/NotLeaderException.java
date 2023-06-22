package com.rualone.app.domain.journey.error;

import com.rualone.app.global.error.ServiceRuntimeException;
import com.rualone.app.global.util.MessageUtils;
import org.apache.commons.lang3.StringUtils;

public class NotLeaderException extends ServiceRuntimeException {
    static final String MESSAGE_KEY = "error.notleader";

    static final String MESSAGE_DETAILS = "error.notleader.details";


    public NotLeaderException(Long memberId, Long journeyId) {
        super(MESSAGE_KEY, MESSAGE_DETAILS, new String[]{String.valueOf(memberId), String.valueOf(journeyId)});
    }

    @Override
    public String getMessage() {

        return MessageUtils.getMessage(getDetailKey(), getParams());
    }

    @Override
    public String toString() {
        return MessageUtils.getMessage(getMessageKey());
    }

}
