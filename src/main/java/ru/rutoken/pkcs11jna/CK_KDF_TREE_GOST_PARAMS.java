/*
 * Copyright (c) 2021, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static ru.rutoken.pkcs11jna.JnaPointerLenPair.makeJnaPointerLenPair;

@Structure.FieldOrder({"ulLabelLength", "pLabel", "ulSeedLength", "pSeed", "ulR", "ulL", "ulOffset"})
public class CK_KDF_TREE_GOST_PARAMS extends Pkcs11Structure {
    public NativeLong ulLabelLength;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pLabel;
    public NativeLong ulSeedLength;
    /**
     * CK_BYTE_PTR
     */
    public Pointer pSeed;
    public NativeLong ulR;
    public NativeLong ulL;
    public NativeLong ulOffset;

    public CK_KDF_TREE_GOST_PARAMS() {
    }

    public CK_KDF_TREE_GOST_PARAMS(byte[] label, byte[] seed, NativeLong ulR, NativeLong ulL, NativeLong ulOffset) {
        JnaPointerLenPair labelPair = makeJnaPointerLenPair(label);
        pLabel = labelPair.getPointer();
        ulLabelLength = labelPair.getLength();

        JnaPointerLenPair seedPair = makeJnaPointerLenPair(seed);
        pSeed = seedPair.getPointer();
        ulSeedLength = seedPair.getLength();

        this.ulR = ulR;
        this.ulL = ulL;
        this.ulOffset = ulOffset;
    }
}
