package org.eu.hanana.reimu.lib.ottohub.api.common;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;
import org.jetbrains.annotations.Nullable;

public class DataWrapResult<T extends ApiResultBase> extends ApiResultBase {
    protected T data;


    public DataWrapResult(T data) {
        this.data = data;
    }

    @Nullable
    public T getData() {
        if (data==null) {
            return null;
        }
        data.code=code;
        data.message=message;
        data.status=status;
        return data;
    }
}
