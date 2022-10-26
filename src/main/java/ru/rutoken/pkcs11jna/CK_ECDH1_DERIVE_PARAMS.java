/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static ru.rutoken.pkcs11jna.JnaPointerLenPair.makeJnaPointerLenPair;

@Structure.FieldOrder({"kdf", "ulSharedDataLen", "pSharedData", "ulPublicDataLen", "pPublicData"})
public class CK_ECDH1_DERIVE_PARAMS extends Pkcs11Structure {
    public NativeLong kdf;
    public NativeLong ulSharedDataLen;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pSharedData;
    public NativeLong ulPublicDataLen;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pPublicData;

    public CK_ECDH1_DERIVE_PARAMS() {
    }

    public CK_ECDH1_DERIVE_PARAMS(NativeLong kdf, byte[] publicData, byte[] sharedData) {
        this.kdf = kdf;

        JnaPointerLenPair publicDataPair = makeJnaPointerLenPair(publicData);
        pPublicData = publicDataPair.getPointer();
        ulPublicDataLen = publicDataPair.getLength();

        JnaPointerLenPair sharedDataPair = makeJnaPointerLenPair(sharedData);
        pSharedData = sharedDataPair.getPointer();
        ulSharedDataLen = sharedDataPair.getLength();
    }
}
