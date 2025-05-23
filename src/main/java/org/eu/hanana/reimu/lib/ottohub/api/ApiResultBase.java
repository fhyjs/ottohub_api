package org.eu.hanana.reimu.lib.ottohub.api;

import org.eu.hanana.reimu.lib.ottohub.api.interfaces.IStatusGetter;
import org.jetbrains.annotations.Nullable;

public class ApiResultBase implements IStatusGetter {
    public String status;
    public String message;
    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public boolean isSuccess() {
        return SUCCESS.equals(status);
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }
}
