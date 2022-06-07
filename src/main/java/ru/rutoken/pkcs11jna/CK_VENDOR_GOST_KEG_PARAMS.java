/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"pPublicData", "ulPublicDataLen", "pUKM", "ulUKMLen"})
public class CK_VENDOR_GOST_KEG_PARAMS extends Pkcs11Structure {
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

    public CK_VENDOR_GOST_KEG_PARAMS() {
    }

    public CK_VENDOR_GOST_KEG_PARAMS(byte[] publicData, byte[] ukm) {
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
