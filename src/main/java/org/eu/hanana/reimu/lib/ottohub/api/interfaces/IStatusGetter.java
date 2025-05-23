package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.jetbrains.annotations.Nullable;

public interface IStatusGetter {
    String SUCCESS = "success";
    String ERROR = "error";

    String getStatus();
    boolean isSuccess();
    @Nullable
    String getMessage();
}
