/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"kdf", "pPublicData", "ulPublicDataLen", "pUKM", "ulUKMLen"})
public class CK_VENDOR_VKO_GOSTR3410_2012_512_PARAMS extends Pkcs11Structure {
    NativeLong kdf;
    /**
     * CK_BYTE_PTR
     */
    Pointer pPublicData;
    NativeLong ulPublicDataLen;
    /**
     * CK_BYTE_PTR
     */
    Pointer pUKM;
    NativeLong ulUKMLen;

    public CK_VENDOR_VKO_GOSTR3410_2012_512_PARAMS() {
    }

    public CK_VENDOR_VKO_GOSTR3410_2012_512_PARAMS(NativeLong kdf, byte[] publicData, byte[] ukm) {
        this.kdf = kdf;
        ulPublicDataLen = new NativeLong(publicData.length);
        pPublicData = new Memory(publicData.length);
        pPublicData.write(0, publicData, 0, publicData.length);

        ulUKMLen = new NativeLong(ukm.length);
        pUKM = new Memory(ukm.length);
        pUKM.write(0, ukm, 0, ukm.length);
    }
}