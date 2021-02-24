/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

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
    /** Pointer to byte array with new Administrator PIN */
    public Pointer pNewAdminPin;
    /** Length of new Administrator PIN: minimum bMinAdminPinLength bytes, maximum 32 bytes */
    public NativeLong ulNewAdminPinLen;
    /** Pointer to byte array with new User PIN */
    public Pointer pNewUserPin;
    /** Length of new User PIN: minimum bMinUserPinLength bytes, maximum 32 bytes */
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
    /** Minimal size of Administrator PIN minimum 1, maximum 31 bytes */
    public NativeLong ulMinAdminPinLen;
    /** Minimal size of User PIN minimum 1, maximum 31 bytes */
    public NativeLong ulMinUserPinLen;
    /** Minimum 3, maximum 10 */
    public NativeLong ulMaxAdminRetryCount;
    /** Minimum 1, maximum 10 */
    public NativeLong ulMaxUserRetryCount;
    /**
     * Pointer to byte array with new token symbol name, if pTokenLabel == null - token symbol name
     * will not be set
     */
    public Pointer pTokenLabel;
    /** Length of new token symbol name */
    public NativeLong ulLabelLen;
    /** Secure messaging mode*/
    public NativeLong ulSmMode;

    public CK_RUTOKEN_INIT_PARAM() {
    }

    public CK_RUTOKEN_INIT_PARAM(NativeLong ulSizeofThisStructure, NativeLong UseRepairMode, Pointer pNewAdminPin,
                                 NativeLong ulNewAdminPinLen, Pointer pNewUserPin, NativeLong ulNewUserPinLen,
                                 NativeLong ChangeUserPINPolicy, NativeLong ulMinAdminPinLen, NativeLong ulMinUserPinLen,
                                 NativeLong ulMaxAdminRetryCount, NativeLong ulMaxUserRetryCount, Pointer pTokenLabel,
                                 NativeLong ulLabelLen, NativeLong ulSmMode) {
        this.ulSizeofThisStructure = ulSizeofThisStructure;
        this.UseRepairMode = UseRepairMode;
        this.pNewAdminPin = pNewAdminPin;
        this.ulNewAdminPinLen = ulNewAdminPinLen;
        this.pNewUserPin = pNewUserPin;
        this.ulNewUserPinLen = ulNewUserPinLen;
        this.ChangeUserPINPolicy = ChangeUserPINPolicy;
        this.ulMinAdminPinLen = ulMinAdminPinLen;
        this.ulMinUserPinLen = ulMinUserPinLen;
        this.ulMaxAdminRetryCount = ulMaxAdminRetryCount;
        this.ulMaxUserRetryCount = ulMaxUserRetryCount;
        this.pTokenLabel = pTokenLabel;
        this.ulLabelLen = ulLabelLen;
        this.ulSmMode = ulSmMode;
    }
}
