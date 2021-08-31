/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({"ulPinID", "ulMinSize", "ulMaxSize", "ulMaxRetryCount", "ulCurrentRetryCount", "flags"})
public class CK_LOCAL_PIN_INFO extends Pkcs11Structure {
    public NativeLong ulPinID;
    public NativeLong ulMinSize;
    public NativeLong ulMaxSize;
    public NativeLong ulMaxRetryCount;
    public NativeLong ulCurrentRetryCount;
    public NativeLong flags;

    public CK_LOCAL_PIN_INFO() {
    }

    public CK_LOCAL_PIN_INFO(NativeLong pinID, NativeLong minSize, NativeLong maxSize, NativeLong maxRetryCount,
                             NativeLong currentRetryCount, NativeLong flags) {
        ulPinID = pinID;
        ulMinSize = minSize;
        ulMaxSize = maxSize;
        ulMaxRetryCount = maxRetryCount;
        ulCurrentRetryCount = currentRetryCount;
        this.flags = flags;
    }
}
