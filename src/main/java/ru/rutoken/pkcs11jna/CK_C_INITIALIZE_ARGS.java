/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;

@Structure.FieldOrder({"CreateMutex", "DestroyMutex", "LockMutex", "UnlockMutex", "flags", "pReserved"})
public class CK_C_INITIALIZE_ARGS extends Pkcs11Structure {
    public CreateMutexCallback CreateMutex;
    public MutexCallback DestroyMutex;
    public MutexCallback LockMutex;
    public MutexCallback UnlockMutex;
    public NativeLong flags;
    public Pointer pReserved;

    public CK_C_INITIALIZE_ARGS() {
    }

    public CK_C_INITIALIZE_ARGS(CreateMutexCallback CreateMutex, MutexCallback DestroyMutex, MutexCallback LockMutex,
                                MutexCallback UnlockMutex, NativeLong flags, Pointer pReserved) {
        this.CreateMutex = CreateMutex;
        this.DestroyMutex = DestroyMutex;
        this.LockMutex = LockMutex;
        this.UnlockMutex = UnlockMutex;
        this.flags = flags;
        this.pReserved = pReserved;

    }

    public interface CreateMutexCallback extends Callback {
        NativeLong callback(PointerByReference mutex);
    }

    public interface MutexCallback extends Callback {
        NativeLong callback(Pointer mutex);
    }
}
