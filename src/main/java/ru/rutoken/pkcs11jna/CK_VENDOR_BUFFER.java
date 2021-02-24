/*
 * Copyright (c) 2019, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"pData", "ulSize"})
public class CK_VENDOR_BUFFER extends Pkcs11Structure {
    /**
     * CK_BYTE_PTR
     */
    public Pointer pData;
    public NativeLong ulSize;

    public CK_VENDOR_BUFFER() {
    }

    public CK_VENDOR_BUFFER(Pointer pStruct) {
        super(pStruct);
        read();
    }

    public CK_VENDOR_BUFFER(byte[] data) {
        if (data != null && data.length != 0) {
            pData = new Memory(data.length);
            pData.write(0, data, 0, data.length);
            ulSize = new NativeLong(data.length);
        } else {
            ulSize = new NativeLong(0);
        }
    }

    public static class ByReference extends CK_VENDOR_BUFFER implements Structure.ByReference {
        public ByReference(Pointer pStruct) {
            super(pStruct);
        }

        public ByReference(byte[] data) {
            super(data);
        }

        public ByReference() {
        }
    }
}
