/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
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

/**
 * Used in C_EX_InitToken - extended function
 * for token formatting (C_InitToken will delete only PKCS#11-objects)
 */
@Structure.FieldOrder({"ulSizeofThisStructure", "UseRepairMode", "pNewAdminPin", "ulNewAdminPinLen",
        "pNewUserPin", "ulNewUserPinLen", "ChangeUserPINPolicy", "ulMinAdminPinLen", "ulMinUserPinLen",
        "ulMaxAdminRetryCount", "ulMaxUserRetryCount", "pTokenLabel", "ulLabelLen", "ulSmMode"})
public class CK_RUTOKEN_INIT_PARAM extends Pkcs11Structure {
    /**
     * init this field by size of this structure
     * [in] - size of input structure
     * [out] - return size of filled structure
     */
    public NativeLong ulSizeofThisStructure;
    /**
     * If field equals 0 - format procedure requires authentication as Administrator
     * if field does not equal 0 - format procedure executes without authentication as Administrator
     */
    public NativeLong UseRepairMode;
    /**
     * Pointer to byte array with new Administrator PIN
     */
    public Pointer pNewAdminPin;
    /**
     * Length of new Administrator PIN: minimum bMinAdminPinLength bytes, maximum 32 bytes
     */
    public NativeLong ulNewAdminPinLen;
    /**
     * Pointer to byte array with new User PIN
     */
    public Pointer pNewUserPin;
    /**
     * Length of new User PIN: minimum bMinUserPinLength bytes, maximum 32 bytes
     */
    public NativeLong ulNewUserPinLen;
    /**
     * Policy of change User PIN
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN (0x1) - Administrator can change User PIN
     * TOKEN_FLAGS_USER_CHANGE_USER_PIN (0x2) - User can change User PIN
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN | TOKEN_FLAGS_USER_CHANGE_USER_PIN (0x3) - Administrator
     * and User can change User PIN
     * In other cases - error
     */
    public NativeLong ChangeUserPINPolicy;
    /**
     * Minimal size of Administrator PIN minimum 1, maximum 31 bytes
     */
    public NativeLong ulMinAdminPinLen;
    /**
     * Minimal size of User PIN minimum 1, maximum 31 bytes
     */
    public NativeLong ulMinUserPinLen;
    /**
     * Minimum 3, maximum 10
     */
    public NativeLong ulMaxAdminRetryCount;
    /**
     * Minimum 1, maximum 10
     */
    public NativeLong ulMaxUserRetryCount;
    /**
     * Pointer to byte array with new token symbol name, if pTokenLabel == null - token symbol name
     * will not be set
     */
    public Pointer pTokenLabel;
    /**
     * Length of new token symbol name
     */
    public NativeLong ulLabelLen;
    /**
     * Secure messaging mode
     */
    public NativeLong ulSmMode;

    public CK_RUTOKEN_INIT_PARAM() {
        ulSizeofThisStructure = new NativeLong(size());
    }

    public CK_RUTOKEN_INIT_PARAM(Pointer pStruct) {
        super(pStruct);
        read();
    }

    public CK_RUTOKEN_INIT_PARAM(NativeLong useRepairMode, byte[] newAdminPin, byte[] newUserPin,
                                 NativeLong changeUserPINPolicy, NativeLong minAdminPinLen, NativeLong minUserPinLen,
                                 NativeLong maxAdminRetryCount, NativeLong maxUserRetryCount, byte[] tokenLabel,
                                 NativeLong smMode) {
        this();
        UseRepairMode = useRepairMode;

        if (newAdminPin != null) {
            ulNewAdminPinLen = new NativeLong(newAdminPin.length);
            pNewAdminPin = new Memory(newAdminPin.length);
            pNewAdminPin.write(0, newAdminPin, 0, newAdminPin.length);
        } else {
            ulNewAdminPinLen = new NativeLong(0);
        }

        if (newUserPin != null) {
            ulNewUserPinLen = new NativeLong(newUserPin.length);
            pNewUserPin = new Memory(newUserPin.length);
            pNewUserPin.write(0, newUserPin, 0, newUserPin.length);
        } else {
            ulNewUserPinLen = new NativeLong(0);
        }

        ChangeUserPINPolicy = changeUserPINPolicy;
        ulMinAdminPinLen = minAdminPinLen;
        ulMinUserPinLen = minUserPinLen;
        ulMaxAdminRetryCount = maxAdminRetryCount;
        ulMaxUserRetryCount = maxUserRetryCount;

        if (tokenLabel != null) {
            ulLabelLen = new NativeLong(tokenLabel.length);
            pTokenLabel = new Memory(tokenLabel.length);
            pTokenLabel.write(0, tokenLabel, 0, tokenLabel.length);
        } else {
            ulLabelLen = new NativeLong(0);
        }

        ulSmMode = smMode;
    }

    public static class ByReference extends CK_RUTOKEN_INIT_PARAM implements Structure.ByReference {
        public ByReference(Pointer pStruct) {
            super(pStruct);
        }

        public ByReference() {
        }
    }
}
