/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * Provides extended information about a token
 */
@Structure.FieldOrder({"ulSizeofThisStructure", "ulTokenType", "ulProtocolNumber", "ulMicrocodeNumber",
        "ulOrderNumber", "flags", "ulMaxAdminPinLen", "ulMinAdminPinLen", "ulMaxUserPinLen",
        "ulMinUserPinLen", "ulMaxAdminRetryCount", "ulAdminRetryCountLeft", "ulMaxUserRetryCount",
        "ulUserRetryCountLeft", "serialNumber", "ulTotalMemory", "ulFreeMemory", "ATR", "ulATRLen",
        "ulTokenClass", "ulBatteryVoltage", "ulBodyColor", "ulFirmwareChecksum", "ulBatteryPercentage", "ulBatteryFlags"})
public class CK_TOKEN_INFO_EXTENDED extends Pkcs11Structure {
    /**
     * Init this field by size of this structure
     * [in] - size of input structure
     * [out] - return size of filled structure
     */
    public NativeLong ulSizeofThisStructure;
    /**
     * @deprecated This field is deprecated in Rutoken PKCS11 library version 2.0.5.0 and above.
     * If you need to check current token connection type you should use hardware feature instead.
     */
    @Deprecated
    public NativeLong ulTokenType;
    /**
     * Exchange protocol number
     */
    public NativeLong ulProtocolNumber;
    public NativeLong ulMicrocodeNumber;
    public NativeLong ulOrderNumber;
    /**
     * Information flags
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - Administrator can change User PIN
     * TOKEN_FLAGS_USER_CHANGE_USER_PIN - User can change User PIN
     * TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - Administrator PIN is not default
     * TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - User PIN is not default
     * TOKEN_FLAGS_SUPPORT_FKN - token supports CryptoPro FKN
     */
    public NativeLong flags;
    public NativeLong ulMaxAdminPinLen;
    public NativeLong ulMinAdminPinLen;
    public NativeLong ulMaxUserPinLen;
    public NativeLong ulMinUserPinLen;
    /**
     * Max count of unsuccessful Administrator login attempts
     */
    public NativeLong ulMaxAdminRetryCount;
    /**
     * Count of unsuccessful login attempts left (for Administrator PIN) if field equals 0 - that means
     * that PIN is blocked
     */
    public NativeLong ulAdminRetryCountLeft;
    /**
     * Min counts of unsuccessful User login attempts
     */
    public NativeLong ulMaxUserRetryCount;
    /**
     * Count of unsuccessful login attempts left (for User PIN) if field equals 0 - that means that PIN is
     * blocked
     */
    public NativeLong ulUserRetryCountLeft;
    /**
     * Token serial number in Big Endian format
     */
    public byte[] serialNumber = new byte[8];
    /**
     * Size of all memory in bytes
     */
    public NativeLong ulTotalMemory;
    /**
     * Size of free memory in bytes
     */
    public NativeLong ulFreeMemory;
    /**
     * ATR of the token
     */
    public byte[] ATR = new byte[64];
    /**
     * Size of ATR
     */
    public NativeLong ulATRLen;
    /**
     * Class of token
     */
    public NativeLong ulTokenClass;
    /**
     * Battery voltage in microvolts
     */
    public NativeLong ulBatteryVoltage;

    public NativeLong ulBodyColor;

    public NativeLong ulFirmwareChecksum;

    public NativeLong ulBatteryPercentage;

    public NativeLong ulBatteryFlags;

    public CK_TOKEN_INFO_EXTENDED() {
        ulSizeofThisStructure = new NativeLong(size());
    }

    public CK_TOKEN_INFO_EXTENDED(NativeLong tokenType, NativeLong protocolNumber, NativeLong microcodeNumber,
                                  NativeLong orderNumber, NativeLong flags, NativeLong maxAdminPinLen,
                                  NativeLong minAdminPinLen, NativeLong maxUserPinLen, NativeLong minUserPinLen,
                                  NativeLong maxAdminRetryCount, NativeLong adminRetryCountLeft,
                                  NativeLong maxUserRetryCount, NativeLong userRetryCountLeft, byte[] serialNumber,
                                  NativeLong totalMemory, NativeLong freeMemory, byte[] atr, NativeLong atrLen,
                                  NativeLong tokenClass, NativeLong batteryVoltage, NativeLong bodyColor,
                                  NativeLong firmwareChecksum, NativeLong batteryPercentage, NativeLong batteryFlags) {
        this();
        ulTokenType = tokenType;
        ulProtocolNumber = protocolNumber;
        ulMicrocodeNumber = microcodeNumber;
        ulOrderNumber = orderNumber;
        this.flags = flags;
        ulMaxAdminPinLen = maxAdminPinLen;
        ulMinAdminPinLen = minAdminPinLen;
        ulMaxUserPinLen = maxUserPinLen;
        ulMinUserPinLen = minUserPinLen;
        ulMaxAdminRetryCount = maxAdminRetryCount;
        ulAdminRetryCountLeft = adminRetryCountLeft;
        ulMaxUserRetryCount = maxUserRetryCount;
        ulUserRetryCountLeft = userRetryCountLeft;
        this.serialNumber = serialNumber;
        ulTotalMemory = totalMemory;
        ulFreeMemory = freeMemory;
        ATR = atr;
        ulATRLen = atrLen;
        ulTokenClass = tokenClass;
        ulBatteryVoltage = batteryVoltage;
        ulBodyColor = bodyColor;
        ulFirmwareChecksum = firmwareChecksum;
        ulBatteryPercentage = batteryPercentage;
        ulBatteryFlags = batteryFlags;
    }
}
