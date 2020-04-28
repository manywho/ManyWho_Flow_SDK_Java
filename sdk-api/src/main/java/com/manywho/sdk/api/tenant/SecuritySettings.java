package com.manywho.sdk.api.tenant;

import com.manywho.sdk.api.security.IpRange;
import com.manywho.sdk.api.security.RemoteSite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SecuritySettings {
    private boolean isAdminRestrictedByIPRange;
    private boolean isDrawRestrictedByIPRange;
    private boolean isPackagingRestrictedByIPRange;
    private boolean isRunRestrictedByIPRange;
    private boolean isServiceRestrictedByRemoteSites;
    private List<IpRange> authorizedAdminIPRanges;
    private List<IpRange> authorizedDrawIPRanges;
    private List<IpRange> authorizedPackagingIPRanges;
    private List<IpRange> authorizedRunIPRanges;
    private List<RemoteSite> authorizedServiceRemoteSites;
}
