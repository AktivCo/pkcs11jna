/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"pulDerivationPath", "ulDerivationPathLength"})
public class CK_VENDOR_BIP32_DERIVE_PARAMS extends Pkcs11Structure {
    /**
     * CK_ULONG_PTR
     */
    public Pointer pulDerivationPath;
    public NativeLong ulDerivationPathLength;

    public CK_VENDOR_BIP32_DERIVE_PARAMS() {
    }

    public CK_VENDOR_BIP32_DERIVE_PARAMS(Pointer derivationPath, NativeLong derivationPathLength) {
        pulDerivationPath = derivationPath;
        ulDerivationPathLength = derivationPathLength;
    }

    public CK_VENDOR_BIP32_DERIVE_PARAMS(Pointer derivationPath, Long derivationPathLength) {
        pulDerivationPath = derivationPath;
        ulDerivationPathLength = new NativeLong(derivationPathLength);
    }

    public CK_VENDOR_BIP32_DERIVE_PARAMS(long[] derivationPath) {
        if (derivationPath != null && derivationPath.length != 0) {
            ulDerivationPathLength = new NativeLong(derivationPath.length);
            pulDerivationPath = new Memory((long) derivationPath.length * NativeLong.SIZE);
            for (int i = 0; i < derivationPath.length; i++) {
                pulDerivationPath.setNativeLong((long) i * NativeLong.SIZE, new NativeLong(derivationPath[i]));
            }
        } else {
            ulDerivationPathLength = new NativeLong(0);
        }
    }
}
