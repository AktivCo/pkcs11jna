/*
 * Copyright (c) 2024, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;


import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"pPassphrase", "ulPassphraseLen", "ulMnemonicLength"})
public class CK_VENDOR_BIP32_WITH_BIP39_KEY_PAIR_GEN_PARAMS {
    /**
     * CK_UTF8CHAR_PTR
     */
    public Pointer pPassphrase;

    public NativeLong ulPassphraseLen;
    public NativeLong ulMnemonicLength;

    public CK_VENDOR_BIP32_WITH_BIP39_KEY_PAIR_GEN_PARAMS() {
    }

    public CK_VENDOR_BIP32_WITH_BIP39_KEY_PAIR_GEN_PARAMS(byte[] passphrase, NativeLong mnemonicLength) {
        if (passphrase == null || passphrase.length == 0) {
            pPassphrase = Pointer.NULL;
            ulPassphraseLen = new NativeLong(0);
        } else {
            pPassphrase = new Memory(passphrase.length);
            pPassphrase.write(0, passphrase, 0, passphrase.length);
            ulPassphraseLen = new NativeLong(passphrase.length);
        }

        ulMnemonicLength = mnemonicLength;
    }
}
