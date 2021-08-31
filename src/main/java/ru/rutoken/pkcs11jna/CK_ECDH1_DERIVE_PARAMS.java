/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"kdf", "ulSharedDataLen", "pSharedData", "ulPublicDataLen", "pPublicData"})
public class CK_ECDH1_DERIVE_PARAMS extends Pkcs11Structure {
    NativeLong kdf;
    NativeLong ulSharedDataLen;
    /**
     * CK_BYTE_PTR
     */
    Pointer pSharedData;
    NativeLong ulPublicDataLen;
    /**
     * CK_BYTE_PTR
     */
    Pointer pPublicData;

    public CK_ECDH1_DERIVE_PARAMS() {
    }

    public CK_ECDH1_DERIVE_PARAMS(NativeLong kdf, byte[] publicData, byte[] sharedData) {
        this.kdf = kdf;
        ulPublicDataLen = new NativeLong(publicData.length);
        pPublicData = new Memory(publicData.length);
        pPublicData.write(0, publicData, 0, publicData.length);

        if (sharedData != null) {
            ulSharedDataLen = new NativeLong(sharedData.length);
            pSharedData = new Memory(sharedData.length);
            pSharedData.write(0, sharedData, 0, sharedData.length);
        } else {
            ulSharedDataLen = new NativeLong(0);
            pSharedData = Pointer.NULL;
        }
    }
}
