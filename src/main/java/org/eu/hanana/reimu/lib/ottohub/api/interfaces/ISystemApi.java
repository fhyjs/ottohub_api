package org.eu.hanana.reimu.lib.ottohub.api.interfaces;

import org.eu.hanana.reimu.lib.ottohub.api.system.SlideshowResult;
import org.eu.hanana.reimu.lib.ottohub.api.system.VersionResult;

public interface ISystemApi {
    VersionResult version();
    SlideshowResult slideshow();
}
