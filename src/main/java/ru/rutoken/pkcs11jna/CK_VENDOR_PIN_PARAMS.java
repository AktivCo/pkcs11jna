/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import static ru.rutoken.pkcs11jna.JnaPointerLenPair.makeJnaPointerLenPair;

@Structure.FieldOrder({"userType", "pPinValue", "ulPinLength"})
public class CK_VENDOR_PIN_PARAMS extends Pkcs11Structure {
    public NativeLong userType;
    /**
     * CK_UTF8CHAR_PTR
     */
    public Pointer pPinValue;
    public NativeLong ulPinLength;

    public CK_VENDOR_PIN_PARAMS() {
    }

    public CK_VENDOR_PIN_PARAMS(NativeLong userType, byte[] pin) {
        this.userType = userType;

        JnaPointerLenPair pinPair = makeJnaPointerLenPair(pin);
        pPinValue = pinPair.getPointer();
        ulPinLength = pinPair.getLength();
    }
}
