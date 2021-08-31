/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"ulSizeofThisStructure", "pAdminPin", "ulAdminPinLen", "pInitParam", "pNewEmitentKey",
        "ulNewEmitentKeyLen", "ulNewEmitentKeyRetryCount"})
public class CK_VENDOR_RESTORE_FACTORY_DEFAULTS_PARAMS extends Pkcs11Structure {
    public NativeLong ulSizeofThisStructure;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pAdminPin;
    public NativeLong ulAdminPinLen;
    public CK_RUTOKEN_INIT_PARAM.ByReference pInitParam;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pNewEmitentKey;
    public NativeLong ulNewEmitentKeyLen;
    public NativeLong ulNewEmitentKeyRetryCount;

    public CK_VENDOR_RESTORE_FACTORY_DEFAULTS_PARAMS() {
        ulSizeofThisStructure = new NativeLong(size());
    }

    public CK_VENDOR_RESTORE_FACTORY_DEFAULTS_PARAMS(byte[] adminPin, CK_RUTOKEN_INIT_PARAM.ByReference initParam,
                                                     byte[] newEmitentKey, NativeLong newEmitentKeyRetryCount) {
        this();
        if (adminPin != null) {
            ulAdminPinLen = new NativeLong(adminPin.length);
            pAdminPin = new Memory(adminPin.length);
            pAdminPin.write(0, adminPin, 0, adminPin.length);
        } else {
            ulAdminPinLen = new NativeLong(0);
        }

        pInitParam = initParam;

        if (newEmitentKey != null) {
            ulNewEmitentKeyLen = new NativeLong(newEmitentKey.length);
            pNewEmitentKey = new Memory(newEmitentKey.length);
            pNewEmitentKey.write(0, newEmitentKey, 0, newEmitentKey.length);
        } else {
            ulNewEmitentKeyLen = new NativeLong(0);
        }

        ulNewEmitentKeyRetryCount = newEmitentKeyRetryCount;
    }
}
