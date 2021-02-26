/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * Contains detailed volume information.
 */
@Structure.FieldOrder({"ulVolumeSize", "accessMode", "volumeOwner", "flags"})
public class CK_VOLUME_FORMAT_INFO_EXTENDED extends Pkcs11Structure {
    /**
     * Volume size, Mb, not bigger than the whole disk size
     */
    public NativeLong ulVolumeSize;
    /**
     * Access flags
     */
    public NativeLong accessMode;
    /**
     * Owner of a volume (who can change access flags)
     */
    public NativeLong volumeOwner;
    /**
     * Other flags
     */
    public NativeLong flags;

    public CK_VOLUME_FORMAT_INFO_EXTENDED() {
    }

    public CK_VOLUME_FORMAT_INFO_EXTENDED(NativeLong ulVolumeSize, NativeLong accessMode,
                                          NativeLong volumeOwner, NativeLong flags) {
        this.ulVolumeSize = ulVolumeSize;
        this.accessMode = accessMode;
        this.volumeOwner = volumeOwner;
        this.flags = flags;
    }
}
