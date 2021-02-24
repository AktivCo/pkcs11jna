/*
 *  Copyright (c) 2019, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 *  All Rights Reserved.
 *
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;

import java.util.Objects;

public class NativeComparator {
    public static boolean isRawUnsignedNativeLongEqualsLong(NativeLong rawNativeLong, long l) {
        return Objects.equals(new NativeLong(l), rawNativeLong);
    }
}
