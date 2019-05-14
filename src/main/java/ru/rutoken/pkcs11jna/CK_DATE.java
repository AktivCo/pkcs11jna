/*
 *  Copyright (c) 2019, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 *  All Rights Reserved.
 *
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.List;

public class CK_DATE extends Pkcs11Structure {
    public byte[] year = new byte[4];

    public byte[] month = new byte[2];

    public byte[] day = new byte[2];

    public CK_DATE() {
    }

    public CK_DATE(Pointer pointer) {
        super(pointer);
        read();
    }

    public CK_DATE(byte[] year, byte[] month, byte[] day ) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("year", "month", "day");
    }
}
