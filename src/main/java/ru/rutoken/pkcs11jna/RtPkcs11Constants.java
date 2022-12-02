/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import static ru.rutoken.pkcs11jna.Pkcs11Constants.*;
import static ru.rutoken.pkcs11jna.Pkcs11Tc26Constants.CKM_KDF_4357;
import static ru.rutoken.pkcs11jna.Pkcs11Tc26Constants.CKM_KDF_GOSTR3411_2012_256;
import static ru.rutoken.pkcs11jna.Pkcs11Tc26Constants.NSSCK_VENDOR_PKCS11_RU_TEAM;

/* Derived from rtpkcs11t.h include file for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

public final class RtPkcs11Constants {
    public static final long CK_VENDOR_PKCS11_RU_TEAM_TK26 = NSSCK_VENDOR_PKCS11_RU_TEAM;

    /* Attributes for CKH_VENDOR_TOKEN_INFO hardware feature */
    public static final long CKA_VENDOR_SECURE_MESSAGING_AVAILABLE = (CKA_VENDOR_DEFINED | 0x3000);
    public static final long CKA_VENDOR_CURRENT_SECURE_MESSAGING_MODE = (CKA_VENDOR_DEFINED | 0x3001);
    public static final long CKA_VENDOR_SUPPORTED_SECURE_MESSAGING_MODES = (CKA_VENDOR_DEFINED | 0x3002);

    public static final long CKA_VENDOR_CURRENT_TOKEN_INTERFACE = (CKA_VENDOR_DEFINED | 0x3003);
    public static final long CKA_VENDOR_SUPPORTED_TOKEN_INTERFACE = (CKA_VENDOR_DEFINED | 0x3004);

    public static final long CKA_VENDOR_EXTERNAL_AUTHENTICATION = (CKA_VENDOR_DEFINED | 0x3005);
    public static final long CKA_VENDOR_BIOMETRIC_AUTHENTICATION = (CKA_VENDOR_DEFINED | 0x3006);

    public static final long CKA_VENDOR_SUPPORT_CUSTOM_PIN = (CKA_VENDOR_DEFINED | 0x3007);
    public static final long CKA_VENDOR_CUSTOM_ADMIN_PIN = (CKA_VENDOR_DEFINED | 0x3008);
    public static final long CKA_VENDOR_CUSTOM_USER_PIN = (CKA_VENDOR_DEFINED | 0x3009);

    public static final long CKA_VENDOR_SUPPORT_INTERNAL_TRUSTED_CERTS = (CKA_VENDOR_DEFINED | 0x300A);
    public static final long CKA_VENDOR_SUPPORT_FKC2 = (CKA_VENDOR_DEFINED | 0x300B);
    public static final long CKA_VENDOR_SUPPORT_HW_RESULT_FOR_GOST28147_KEY_UNWRAP = (CKA_VENDOR_DEFINED | 0x300C);
    public static final long CKA_VENDOR_SUPPORT_HW_KDF_TREE = (CKA_VENDOR_DEFINED | 0x300D);
    public static final long CKA_VENDOR_SUPPORT_KIMP15 = (CKA_VENDOR_DEFINED | 0x300E);

    /* KTI attributes */
    /**
     * Array of bytes containing the checksum of the object.
     */
    public static final long CKA_VENDOR_CHECKSUM = (CKA_VENDOR_DEFINED | 0x3100);
    /**
     * Byte array containing the HMAC from the transmitted data.
     */
    public static final long CKA_VENDOR_HMAC_VALUE = (CKA_VENDOR_DEFINED | 0x3101);
    /**
     * Certificate attribute - a trusted certificate enrolled using an issuer key.
     */
    public static final long CKA_VENDOR_INTERNAL_TRUSTED_CERT = (CKA_VENDOR_DEFINED | 0x3102);
    /**
     * Attribute of the initialization vector used when entering data using the issuer key.
     */
    public static final long CKA_VENDOR_IV = (CKA_VENDOR_DEFINED | 0x3103);

    /**
     * PIN state.
     */
    public static final long CKA_VENDOR_PIN_POLICY_STATE = (CKA_VENDOR_DEFINED | 0x3200);
    /**
     * Pin policies will be removed during format.
     */
    public static final long CKA_VENDOR_PIN_POLICIES_DELETABLE = (CKA_VENDOR_DEFINED | 0x3201);
    /**
     * Get array of CK_ATTRIBUTE_TYPE of supported policies.
     */
    public static final long CKA_VENDOR_SUPPORTED_PIN_POLICIES = (CKA_VENDOR_DEFINED | CKF_ARRAY_ATTRIBUTE | 0x3202);
    /**
     * Minimal PIN length.
     */
    public static final long CKA_VENDOR_PIN_POLICY_MIN_LENGTH = (CKA_VENDOR_DEFINED | 0x3203);
    /**
     * Number of previous PINs remembered. New PINs cannot be set to those values.
     */
    public static final long CKA_VENDOR_PIN_POLICY_HISTORY_DEPTH = (CKA_VENDOR_DEFINED | 0x3204);
    /**
     * Permits operations with default PIN.
     */
    public static final long CKA_VENDOR_PIN_POLICY_ALLOW_DEFAULT_PIN_USAGE = (CKA_VENDOR_DEFINED | 0x3205);
    /**
     * PIN contains at least one digit.
     */
    public static final long CKA_VENDOR_PIN_POLICY_DIGIT_REQUIRED = (CKA_VENDOR_DEFINED | 0x3206);
    /**
     * PIN contains at least one upper case letter.
     */
    public static final long CKA_VENDOR_PIN_POLICY_UPPERCASE_REQUIRED = (CKA_VENDOR_DEFINED | 0x3207);
    /**
     * PIN contains at least one lower case letter.
     */
    public static final long CKA_VENDOR_PIN_POLICY_LOWERCASE_REQUIRED = (CKA_VENDOR_DEFINED | 0x3208);
    /**
     * PIN contains at least one special character.
     */
    public static final long CKA_VENDOR_PIN_POLICY_SPEC_CHAR_REQUIRED = (CKA_VENDOR_DEFINED | 0x3209);
    /**
     * PIN doesn't consist of one repeated character.
     */
    public static final long CKA_VENDOR_PIN_POLICY_DIFF_CHARS_REQUIRED = (CKA_VENDOR_DEFINED | 0x320a);
    public static final long CKA_VENDOR_USER_TYPE = (CKA_VENDOR_DEFINED | 0x320b);

    /**
     * Chaincode value
     */
    public static final long CKA_VENDOR_BIP32_CHAINCODE = (CKA_VENDOR_DEFINED | 0x3300);
    /**
     * HASH160 from public key
     */
    public static final long CKA_VENDOR_BIP32_ID = (CKA_VENDOR_DEFINED | 0x3301);
    /**
     * First 32 bits of CKA_VENDOR_BIP32_ID
     */
    public static final long CKA_VENDOR_BIP32_FINGERPRINT = (CKA_VENDOR_DEFINED | 0x3302);

    /* GOST DIVERSIFICATION TYPES */
    public static final long CKD_KDF_4357 = CKM_KDF_4357;
    public static final long CKD_KDF_GOSTR3411_2012_256 = CKM_KDF_GOSTR3411_2012_256;

    /**
     * Do not attach signed data to PKCS#7 signature.
     */
    public static final long PKCS7_DETACHED_SIGNATURE = 0x00000001L;
    /**
     * Use hardware hash in operation, can be passed only to PKCS#7 signature operation.
     */
    public static final long USE_HARDWARE_HASH = 0x00000002L;

    /* Token types (CK_TOKEN_INFO_EXTENDED field "ulTokenType")
       CK_TOKEN_INFO_EXTENDED's field ulTokenType is deprecated. */
    public static final long TOKEN_TYPE_UNKNOWN = 0xFFL;
    public static final long TOKEN_TYPE_RUTOKEN_ECP = 0x01L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE = 0x02L;
    public static final long TOKEN_TYPE_RUTOKEN = 0x03L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_USB = 0x09L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_BT = 0x69L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_UART = 0xA9L;
    public static final long TOKEN_TYPE_RUTOKEN_SC_JC = 0x41L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SC = TOKEN_TYPE_RUTOKEN_SC_JC;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL = 0x49L;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL_NFC = 0xC9L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SC_JC = 0x42L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON = 0x05L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SC = 0x45L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL = 0x4DL;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL_NFC = 0xCDL;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_NFC = 0xC1L;
    public static final long TOKEN_TYPE_RUTOKEN_PINPAD_FAMILY = 0x04L;
    public static final long TOKEN_TYPE_RUTOKEN_WEB = 0x23L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SD = 0x81L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SD = 0x82L;

    /* Token flags (field "flags" from CK_TOKEN_INFO_EXTENDED +
       field "ChangeUserPINPolicy" from CK_RUTOKEN_INIT_PARAM) */

    /**
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - if it is set, that
     * means that Administrator (SO) can change User PIN.
     */
    public static final long TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN = 0x00000001L;

    /**
     * TOKEN_FLAGS_USER_CHANGE_USER_PIN - if it is set, that
     * means that User can change User PIN.
     */
    public static final long TOKEN_FLAGS_USER_CHANGE_USER_PIN = 0x00000002L;

    /**
     * TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - if it is set, that
     * means that current Administrator (SO) PIN is not default.
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT = 0x00000004L;

    /**
     * TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - if it is set, that
     * means that current User PIN is not default.
     */
    public static final long TOKEN_FLAGS_USER_PIN_NOT_DEFAULT = 0x00000008L;

    /**
     * TOKEN_FLAGS_SUPPORT_FKN - if it is set, that
     * means that token support CryptoPro FKN.
     */
    public static final long TOKEN_FLAGS_SUPPORT_FKN = 0x00000010L;

    /**
     * TOKEN_FLAGS_SUPPORT_SM - if it is set, that
     * means that token supports Secure Messaging.
     *
     * @deprecated use TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING instead.
     */
    @Deprecated
    public static final long TOKEN_FLAGS_SUPPORT_SM = 0x00000040L;

    /**
     * TOKEN_FLAGS_HAS_FLASH_DRIVE - if it is set, that means
     * that token has Flash Drive.
     */
    public static final long TOKEN_FLAGS_HAS_FLASH_DRIVE = 0x00000080L;

    /**
     * TOKEN_FLAGS_CAN_CHANGE_SM_MODE - if it is set, that means
     * that token can be formatted to support SM.
     *
     * @deprecated use TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING instead.
     */
    @Deprecated
    public static final long TOKEN_FLAGS_CAN_CHANGE_SM_MODE = 0x00000100L;

    /**
     * TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING - if it is set, that
     * means that token supports Secure Messaging.
     */
    public static final long TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING = 0x00000100L;

    /**
     * TOKEN_FLAGS_HAS_BUTTON - if it is set, that means
     * that token is Rutoken Touch.
     */
    public static final long TOKEN_FLAGS_HAS_BUTTON = 0x00000200L;

    /**
     * TOKEN_FLAGS_SUPPORT_JOURNAL - if it is set, that means
     * that token supports journal.
     */
    public static final long TOKEN_FLAGS_SUPPORT_JOURNAL = 0x00000400L;

    /**
     * TOKEN_FLAGS_USER_PIN_UTF8 - if it is set, that means
     * that user PIN in UTF-8.
     */
    public static final long TOKEN_FLAGS_USER_PIN_UTF8 = 0x00000800L;

    /**
     * TOKEN_FLAGS_ADMIN_PIN_UTF8 - if it is set, that means
     * that admin PIN in UTF-8.
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_UTF8 = 0x00001000L;

    /**
     * TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE - if it is set, that
     * means Token does not support firmware checksum request
     * and 'ulFirmwareChecksum' can not be used.
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE = 0x40000000L;

    /**
     * TOKEN_FLAGS_FW_CHECKSUM_INVALID - if it is set, that
     * means that 'ulFirmwareChecksum' field contains different
     * from the reference (stored at Token) firmware checksum.
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_INVALID = 0x80000000L;

    /* Token class (CK_TOKEN_INFO_EXTENDED field "ulTokenClass") */
    public static final long TOKEN_CLASS_UNKNOWN = 0xFFFFFFFFL;
    public static final long TOKEN_CLASS_S = 0x00L;
    public static final long TOKEN_CLASS_ECP = 0x01L;
    public static final long TOKEN_CLASS_LITE = 0x02L;
    public static final long TOKEN_CLASS_ECP_BT = 0x09L;
    @Deprecated
    public static final long TOKEN_CLASS_WEB = 0x03L;
    @Deprecated
    public static final long TOKEN_CLASS_PINPAD = 0x04L;
    @Deprecated
    public static final long TOKEN_CLASS_ECPDUAL = TOKEN_CLASS_ECP_BT;

    /* Body color of the token */
    public static final long TOKEN_BODY_COLOR_UNKNOWN = 0L;
    public static final long TOKEN_BODY_COLOR_WHITE = 1L;
    public static final long TOKEN_BODY_COLOR_BLACK = 2L;

    /* Extended error codes */
    public static final long CKR_CORRUPTED_MAPFILE = CKR_VENDOR_DEFINED + 1L;
    public static final long CKR_WRONG_VERSION_FIELD = CKR_VENDOR_DEFINED + 2L;
    public static final long CKR_WRONG_PKCS1_ENCODING = CKR_VENDOR_DEFINED + 3L;
    public static final long CKR_RTPKCS11_DATA_CORRUPTED = CKR_VENDOR_DEFINED + 4L;
    public static final long CKR_RTPKCS11_RSF_DATA_CORRUPTED = CKR_VENDOR_DEFINED + 5L;
    public static final long CKR_SM_PASSWORD_INVALID = CKR_VENDOR_DEFINED + 6L;
    public static final long CKR_LICENSE_READ_ONLY = CKR_VENDOR_DEFINED + 7L;
    public static final long CKR_VENDOR_EMITENT_KEY_BLOCKED = CKR_VENDOR_DEFINED + 8L;
    public static final long CKR_CERT_CHAIN_NOT_VERIFIED = CKR_VENDOR_DEFINED + 9L;
    public static final long CKR_INAPPROPRIATE_PIN = CKR_VENDOR_DEFINED + 10L;
    public static final long CKR_PIN_IN_HISTORY = CKR_VENDOR_DEFINED + 11L;

    public static final long CKF_ENCRYPTION = 0x01000000L;

    /* Access modes for TM2 */
    public static final long ACCESS_MODE_HIDDEN = 0x00000000L;
    public static final long ACCESS_MODE_RO = 0x00000001L;
    public static final long ACCESS_MODE_RW = 0x00000003L;
    public static final long ACCESS_MODE_CD = 0x00000005L;

    /* Rutoken S vendor defined constants */
    public static final long CKM_GOST_KEY_GEN = (CKM_VENDOR_DEFINED + 1);
    public static final long CKM_GOST = (CKM_VENDOR_DEFINED + 2);
    public static final long CKM_VENDOR_SECURE_IMPORT = (CKM_VENDOR_DEFINED + 3);

    /**
     * BIP32 key pair generation mechanism
     */
    public static final long CKM_VENDOR_BIP32_KEY_PAIR_GEN = (CKM_VENDOR_DEFINED + 6);
    /**
     * A mechanism for creating a private key through diversification
     */
    public static final long CKM_VENDOR_BIP32_DERIVE_PRIVATE_FROM_PRIVATE = (CKM_VENDOR_DEFINED + 7);
    /**
     * A mechanism for creating a public key through diversification
     */
    public static final long CKM_VENDOR_BIP32_DERIVE_PUBLIC_FROM_PRIVATE = (CKM_VENDOR_DEFINED + 8);

    public static final long CKK_VENDOR_BIP32 = (CKK_VENDOR_DEFINED + 2);

    /* Flags for C_EX_PKCS7VerifyInit */
    /**
     * Do not search signer certificates in certificates attached to CMS.
     */
    public static final long CKF_VENDOR_DO_NOT_USE_INTERNAL_CMS_CERTS = 0x00000001L;
    /**
     * If this flag is set - chain verification will be successful
     * if at least one CA certificate from chain is in trusted certificates list.
     */
    public static final long CKF_VENDOR_ALLOW_PARTIAL_CHAINS = 0x00000002L;
    /**
     * If this flag is set - certificate verification is not made
     * this flag is not compatible with CKF_VENDOR_DO_NOT_USE_INTERNAL_CMS_CERTS,
     * CKF_VENDOR_ALLOW_PARTIAL_CHAINS and CKF_VENDOR_USE_TRUSTED_CERTS_FROM_TOKEN
     * ckMode should be set to OPTIONAL_CRL_CHECK.
     */
    public static final long CKF_VENDOR_CHECK_SIGNATURE_ONLY = 0x00000004L;
    /**
     * If this flag is set - trusted certificate store will be used
     * to build a certificate chain. ulTrustedCertificateCount
     * in certificate store should be set to 0.
     */
    public static final long CKF_VENDOR_USE_TRUSTED_CERTS_FROM_TOKEN = 0x00000008L;

    /* CRL checking modes, should be passed in ckMode to C_EX_PKCS7VerifyInit */
    /**
     * If we have no suitable CRL - it won't be an error.
     */
    public static final long OPTIONAL_CRL_CHECK = 0x00000000L;
    /**
     * Signer's CA CRL should be passed.
     */
    public static final long LEAF_CRL_CHECK = 0x00000001L;
    /**
     * CRLs of all CA from the chain should be passed.
     */
    public static final long ALL_CRL_CHECK = 0x00000002L;

    /* Interfaces */
    public static final long INTERFACE_TYPE_USB = 0x00000001L;
    public static final long INTERFACE_TYPE_BT = 0x00000002L;
    public static final long INTERFACE_TYPE_UART = 0x00000004L;
    public static final long INTERFACE_TYPE_ISO = 0x00000008L;
    public static final long INTERFACE_TYPE_NFC_TYPE_B = 0x00000020L;
    public static final long INTERFACE_TYPE_SPI = 0x00000040L;
    public static final long INTERFACE_TYPE_NFC_TYPE_A = 0x00000080L;
    public static final long INTERFACE_TYPE_UNKNOWN = CK_UNAVAILABLE_INFORMATION;
    @Deprecated
    public static final long INTERFACE_TYPE_NFC = INTERFACE_TYPE_NFC_TYPE_B;

    /* Secure messaging types */
    public static final long SECURE_MESSAGING_DEFAULT = 0x00L;
    public static final long SECURE_MESSAGING_BUILT_IN = 0x01L;
    public static final long SECURE_MESSAGING_GOST = 0x02L;
    public static final long SECURE_MESSAGING_ENHANCED_GOST = 0x03L;
    public static final long SECURE_MESSAGING_UNSUPPORTED = 0xffL;

    /* Values for CKA_VENDOR_PIN_POLICY_STATE */
    public static final long PIN_POLICY_STATE_WELL_DEFINED = 0x00L;
    public static final long PIN_POLICY_STATE_HAS_UNKNOWN_ATTRIBUTES = 0x01L;
    public static final long PIN_POLICY_STATE_HAS_UNKNOWN_NONDEFAULT_ATTRIBUTES = 0x02L;

    /* Biometric types */
    public static final long BIOMETRIC_AUTHENTICATION_NOT_SUPPORTED = 0x00000000L;

    /* Hardware feature types */
    public static final long CKH_VENDOR_TOKEN_INFO = (CKH_VENDOR_DEFINED + 0x01);
    public static final long CKH_VENDOR_EMITENT_KEY = (CKH_VENDOR_DEFINED + 0x02);
    public static final long CKH_VENDOR_SECURE_COUNTER = (CKH_VENDOR_DEFINED + 0x03);
    public static final long CKH_VENDOR_NDEF_TAG = (CKH_VENDOR_DEFINED + 0x04);
    public static final long CKH_VENDOR_RNG = (CKH_VENDOR_DEFINED + 0x05);
    public static final long CKH_VENDOR_PIN_POLICY = (CKH_VENDOR_DEFINED + 0x06);

    private RtPkcs11Constants() {
    }
}
