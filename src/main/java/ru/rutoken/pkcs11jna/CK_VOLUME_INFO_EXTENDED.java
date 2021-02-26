/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * Provides extended information about Rutoken ECP Flash partitions
 */
@Structure.FieldOrder({"idVolume", "volumeSize", "accessMode", "volumeOwner", "flags"})
public class CK_VOLUME_INFO_EXTENDED extends Pkcs11Structure {
    /**
     * Volume identifier
     */
    public NativeLong idVolume;
    /**
     * Volume size, Mb, not bigger than the whole disk size
     */
    public NativeLong volumeSize;
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

    public CK_VOLUME_INFO_EXTENDED() {
    }

    public CK_VOLUME_INFO_EXTENDED(NativeLong idVolume, NativeLong volumeSize, NativeLong accessMode,
                                   NativeLong volumeOwner, NativeLong flags) {
        this.idVolume = idVolume;
        this.volumeSize = volumeSize;
        this.accessMode = accessMode;
        this.volumeOwner = volumeOwner;
        this.flags = flags;
    }
}
