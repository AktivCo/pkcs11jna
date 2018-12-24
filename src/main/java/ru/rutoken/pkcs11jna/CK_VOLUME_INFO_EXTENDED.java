/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;

import java.util.Arrays;
import java.util.List;

/* CK_VOLUME_INFO_EXTENDED provides extended information about a TM2 token */
public class CK_VOLUME_INFO_EXTENDED extends Pkcs11Structure {

    /* volume identifier */
    public NativeLong idVolume;
    /* volume size, Mb, not bigger than the whole disk size */
    public NativeLong volumeSize;
    /* access flags */
    public NativeLong accessMode;
    /* owner of a volume (who can change access flags) */
    public NativeLong volumeOwner;
    /* rest flags */
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

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("idVolume", "volumeSize", "accessMode", "volumeOwner", "flags");
    }
}
