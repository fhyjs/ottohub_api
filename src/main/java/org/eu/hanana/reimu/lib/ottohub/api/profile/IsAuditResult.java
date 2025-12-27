package org.eu.hanana.reimu.lib.ottohub.api.profile;

import org.eu.hanana.reimu.lib.ottohub.api.ApiResultBase;

public class IsAuditResult extends ApiResultBase {
    public int is_audit;
    public boolean isAudit(){
        return is_audit==1;
    }
}
