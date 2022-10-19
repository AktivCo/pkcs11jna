/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

class JnaPointerLenPair {
    private final Pointer mPointer;
    private final NativeLong mLength;

    private JnaPointerLenPair() {
        mPointer = Pointer.NULL;
        mLength = new NativeLong(0);
    }

    private JnaPointerLenPair(Pointer pointer, long length) {
        mPointer = pointer;
        mLength = new NativeLong(length);
    }

    public static JnaPointerLenPair makeJnaPointerLenPair(byte[] buffer) {
        if (buffer == null || buffer.length == 0) {
            return new JnaPointerLenPair();
        } else {
            Pointer pointer = new Memory(buffer.length);
            pointer.write(0, buffer, 0, buffer.length);
            return new JnaPointerLenPair(pointer, buffer.length);
        }
    }

    public static JnaPointerLenPair makeJnaPointerLenPair(NativeLong value) {
        Pointer pointer = new Memory(NativeLong.SIZE);
        pointer.setNativeLong(0, value);
        return new JnaPointerLenPair(pointer, NativeLong.SIZE);
    }

    public static JnaPointerLenPair makeJnaPointerLenPair(boolean value) {
        int nativeSize = Native.getNativeSize(Byte.TYPE);
        Pointer pointer = new Memory(nativeSize);
        pointer.setByte(0, (byte) (value ? 1 : 0));
        return new JnaPointerLenPair(pointer, nativeSize);
    }

    public NativeLong getLength() {
        return mLength;
    }

    public Pointer getPointer() {
        return mPointer;
    }
}
