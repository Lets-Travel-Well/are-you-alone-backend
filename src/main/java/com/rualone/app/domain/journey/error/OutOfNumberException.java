package com.rualone.app.domain.journey.error;

import com.rualone.app.global.error.ServiceRuntimeException;
import com.rualone.app.global.util.MessageUtils;
import org.apache.commons.lang3.StringUtils;

public class OutOfNumberException extends ServiceRuntimeException {
    static final String MESSAGE_KEY = "error.outofnumber";

    static final String MESSAGE_DETAILS = "error.outofnumber.details";

    public OutOfNumberException(Class cls, Object... values) {
        this(cls.getSimpleName(), values);
    }

    public OutOfNumberException(String targetName, Object... values) {
        super(MESSAGE_KEY, MESSAGE_DETAILS, new String[]{targetName, (values != null && values.length > 0) ? StringUtils.join(values, ",") : ""});
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
