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
    public NativeLong kdf;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pPublicData;
    public NativeLong ulPublicDataLen;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pUKM;
    public NativeLong ulUKMLen;

    public CK_VENDOR_VKO_GOSTR3410_2012_512_PARAMS() {
    }

    public CK_VENDOR_VKO_GOSTR3410_2012_512_PARAMS(NativeLong kdf, byte[] publicData, byte[] ukm) {
        this.kdf = kdf;

        if (publicData != null) {
            ulPublicDataLen = new NativeLong(publicData.length);
            pPublicData = new Memory(publicData.length);
            pPublicData.write(0, publicData, 0, publicData.length);
        } else {
            ulPublicDataLen = new NativeLong(0);
        }

        if (ukm != null) {
            ulUKMLen = new NativeLong(ukm.length);
            pUKM = new Memory(ukm.length);
            pUKM.write(0, ukm, 0, ukm.length);
        } else {
            ulUKMLen = new NativeLong(0);
        }
    }
}
