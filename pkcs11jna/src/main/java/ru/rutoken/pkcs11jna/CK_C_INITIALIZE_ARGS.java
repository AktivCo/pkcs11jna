/*
 * Copyright (c) 2016, CJSC Aktiv-Soft. See the LICENSE file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.List;


public class CK_C_INITIALIZE_ARGS extends Pkcs11Structure {
    public Pointer CreateMutex;
    public Pointer DestroyMutex;
    public Pointer LockMutex;
    public Pointer UnlockMutex;
    public NativeLong flags;
    public Pointer pReserved;

    public CK_C_INITIALIZE_ARGS() {
    }

    public CK_C_INITIALIZE_ARGS(Pointer CreateMutex, Pointer DestroyMutex, Pointer LockMutex,
                                Pointer UnlockMutex, NativeLong flags, Pointer pReserved) {
        this.CreateMutex = CreateMutex;
        this.DestroyMutex = DestroyMutex;
        this.LockMutex = LockMutex;
        this.UnlockMutex = UnlockMutex;
        this.flags = flags;
        this.pReserved = pReserved;

    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "CreateMutex",
                "DestroyMutex",
                "LockMutex",
                "UnlockMutex",
                "flags",
                "pReserved");
    }
}
