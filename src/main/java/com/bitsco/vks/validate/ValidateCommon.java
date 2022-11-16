package com.bitsco.vks.validate;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.constant.MessageContent;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.utils.MessageCommon;
import com.bitsco.vks.utils.StringCommon;

import java.time.DayOfWeek;
import java.util.Objects;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe :
 */
public class ValidateCommon {

    public static void validateNullObject(Object object, String objectName) {
        if (object instanceof String) {
            if (StringCommon.isNullOrBlank(String.valueOf(object)))
                throw new CommonException(Response.MISSING_PARAM, MessageCommon.getMessage(MessageContent.MISSING_PARAM, objectName));
        } else if (Objects.isNull(object))
            throw new CommonException(Response.MISSING_PARAM, MessageCommon.getMessage(MessageContent.MISSING_PARAM, objectName));
    }

    public static void validateStatusObject(Integer status) {
        if (status != Constant.STATUS_OBJECT.ACTIVE && status != Constant.STATUS_OBJECT.INACTIVE)
            throw new CommonException(Response.DATA_INVALID, "Trạng thái phải có giá trị " + Constant.STATUS_OBJECT.ACTIVE + " hoặc " + Constant.STATUS_OBJECT.INACTIVE);
    }

    public static void validateDayOfWeek(Integer dayOfWeek) {
        try {
            DayOfWeek.of(dayOfWeek);
        } catch (Exception e) {
            throw new CommonException(Response.DATA_INVALID, e.getMessage());
        }
    }
}
