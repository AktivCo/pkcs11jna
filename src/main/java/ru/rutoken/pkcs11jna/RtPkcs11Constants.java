/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_VENDOR_DEFINED;

/* Derived from rtpkcs11t.h include file for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

public final class RtPkcs11Constants {
    /* Extended error codes */
    public static final long CKR_CORRUPTED_MAPFILE = Pkcs11Constants.CKR_VENDOR_DEFINED + 1L;
    public static final long CKR_WRONG_VERSION_FIELD = Pkcs11Constants.CKR_VENDOR_DEFINED + 2L;
    public static final long CKR_WRONG_PKCS1_ENCODING = Pkcs11Constants.CKR_VENDOR_DEFINED + 3L;
    public static final long CKR_RTPKCS11_DATA_CORRUPTED = Pkcs11Constants.CKR_VENDOR_DEFINED + 4L;
    public static final long CKR_RTPKCS11_RSF_DATA_CORRUPTED = Pkcs11Constants.CKR_VENDOR_DEFINED + 5L;
    public static final long CKR_SM_PASSWORD_INVALID = Pkcs11Constants.CKR_VENDOR_DEFINED + 6L;
    public static final long CKR_LICENSE_READ_ONLY = Pkcs11Constants.CKR_VENDOR_DEFINED + 7L;
    public static final long CKR_VENDOR_EMITENT_KEY_BLOCKED = Pkcs11Constants.CKR_VENDOR_DEFINED + 8L;
    public static final long CKR_CERT_CHAIN_NOT_VERIFIED = Pkcs11Constants.CKR_VENDOR_DEFINED + 9L;
    public static final long CKR_INAPPROPRIATE_PIN = Pkcs11Constants.CKR_VENDOR_DEFINED + 10L;
    public static final long CKR_PIN_IN_HISTORY = Pkcs11Constants.CKR_VENDOR_DEFINED + 11L;

    /* Необходимые определения для работы с расширениями PKCS для ГОСТ */
    public static final long NSSCK_VENDOR_PKCS11_RU_TEAM = (Pkcs11Constants.CKR_VENDOR_DEFINED | 0x54321000L);
    @Deprecated
    public static final long CK_VENDOR_PKCS11_RU_TEAM_TK26 = NSSCK_VENDOR_PKCS11_RU_TEAM;
    public static final long CK_VENDOR_PKCS11_RU_TEAM_TC26 = NSSCK_VENDOR_PKCS11_RU_TEAM;

    /* GOST KEY TYPES */
    public static final long CKK_GOSTR3410 = 0x00000030L;
    public static final long CKK_GOSTR3410_256 = CKK_GOSTR3410;
    public static final long CKK_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x003L);
    public static final long CKK_GOSTR3411 = 0x00000031L;
    public static final long CKK_GOST28147 = 0x00000032L;

    public static final long CKK_KUZNECHIK = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x004);
    public static final long CKK_KUZNYECHIK = CKK_KUZNECHIK;
    public static final long CKK_MAGMA = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x005);
    public static final long CKK_KUZNECHIK_TWIN_KEY = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x006);
    public static final long CKK_KUZNYECHIK_TWIN_KEY = CKK_KUZNECHIK_TWIN_KEY;
    public static final long CKK_MAGMA_TWIN_KEY = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x007);

    /* GOST OBJECT ATTRIBUTES */
    public static final long CKA_GOSTR3410_PARAMS = 0x00000250L;
    public static final long CKA_GOSTR3410_256PARAMS = CKA_GOSTR3410_PARAMS;
    public static final long CKA_GOSTR3411_PARAMS = 0x00000251L;
    public static final long CKA_GOST28147_PARAMS = 0x00000252L;

    /* PKCS #5 PRF Functions */
    public static final long CKP_PKCS5_PBKD2_HMAC_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x003);

    /* GOST MECHANISMS */
    public static final long CKM_GOSTR3410_KEY_PAIR_GEN = 0x00001200L;
    public static final long CKM_GOSTR3410_256_KEY_PAIR_GEN = CKM_GOSTR3410_KEY_PAIR_GEN;
    public static final long CKM_GOSTR3410 = 0x00001201L;
    public static final long CKM_GOSTR3410_256 = CKM_GOSTR3410;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411 = 0x00001202L;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_94 = CKM_GOSTR3410_WITH_GOSTR3411;
    public static final long CKM_GOSTR3410_KEY_WRAP = 0x00001203L;
    public static final long CKM_GOSTR3410_DERIVE = 0x00001204L;
    public static final long CKM_GOSTR3410_512_KEY_PAIR_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x005L);
    public static final long CKM_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x006L);
    public static final long CKM_GOSTR3410_2012_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x007L);
    public static final long CKM_GOSTR3410_12_DERIVE = CKM_GOSTR3410_2012_DERIVE;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x008L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_256 = CKM_GOSTR3410_WITH_GOSTR3411_2012_256;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x009L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_512 = CKM_GOSTR3410_WITH_GOSTR3411_2012_512;
    public static final long CKM_GOSTR3410_PUBLIC_KEY_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x00A);
    public static final long CKM_GOSTR3410_512_PUBLIC_KEY_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x00B);

    public static final long CKM_GOSTR3411 = 0x00001210L;
    public static final long CKM_GOSTR3411_94 = CKM_GOSTR3411;
    public static final long CKM_GOSTR3411_HMAC = 0x00001211L;
    public static final long CKM_GOSTR3411_94_HMAC = CKM_GOSTR3411_HMAC;
    public static final long CKM_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x012L);
    public static final long CKM_GOSTR3411_12_256 = CKM_GOSTR3411_2012_256;
    public static final long CKM_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x013L);
    public static final long CKM_GOSTR3411_12_512 = CKM_GOSTR3411_2012_512;
    public static final long CKM_GOSTR3411_2012_256_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x014L);
    public static final long CKM_GOSTR3411_12_256_HMAC = CKM_GOSTR3411_2012_256_HMAC;
    public static final long CKM_GOSTR3411_2012_512_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x015L);
    public static final long CKM_GOSTR3411_12_512_HMAC = CKM_GOSTR3411_2012_512_HMAC;

    public static final long CKM_GOST28147_KEY_GEN = 0x00001220L;
    public static final long CKM_GOST28147_ECB = 0x00001221L;
    public static final long CKM_GOST28147 = 0x00001222L;
    public static final long CKM_GOST28147_MAC = 0x00001223L;
    public static final long CKM_GOST28147_KEY_WRAP = 0x00001224L;

    public static final long CKM_TLS_GOST_PRF_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x016);
    public static final long CKM_TLS_GOST_PRF_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x017);
    public static final long CKM_TLS_GOST_PRE_MASTER_KEY_GEN = CKM_GOST28147_KEY_GEN;
    public static final long CKM_TLS_GOST_MASTER_KEY_DERIVE_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x018);

    public static final long CKM_KDF_4357 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x025L);
    public static final long CKM_KDF_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x026L);

    public static final long CKM_KDF_HMAC3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x028);
    public static final long KDF_TREE_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02A);
    public static final long CKM_KDF_TREE_GOSTR3411_2012_256 = KDF_TREE_GOSTR3411_2012_256;

    public static final long CKM_KUZNECHIK_KEXP_15_WRAP = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02B);
    public static final long CKM_KUZNYECHIK_KEXP_15_WRAP = CKM_KUZNECHIK_KEXP_15_WRAP;
    public static final long CKM_MAGMA_KEXP_15_WRAP = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02C);
    public static final long CKM_KUZNECHIK_MGM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02D);
    public static final long CKM_KUZNYECHIK_MGM = CKM_KUZNECHIK_MGM;
    public static final long CKM_MAGMA_MGM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02E);

    public static final long CKM_KUZNECHIK_KEY_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x030);
    public static final long CKM_KUZNYECHIK_KEY_GEN = CKM_KUZNECHIK_KEY_GEN;
    public static final long CKM_KUZNECHIK_ECB = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x031);
    public static final long CKM_KUZNYECHIK_ECB = CKM_KUZNECHIK_ECB;
    public static final long CKM_KUZNECHIK_CTR_ACPKM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x032);
    public static final long CKM_KUZNYECHIK_CTR_ACPKM = CKM_KUZNECHIK_CTR_ACPKM;
    public static final long CKM_KUZNECHIK_MAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x033);
    public static final long CKM_KUZNYECHIK_MAC = CKM_KUZNECHIK_MAC;

    public static final long CKM_MAGMA_KEY_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x034);
    public static final long CKM_MAGMA_ECB = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x035);
    public static final long CKM_MAGMA_CTR_ACPKM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x036);
    public static final long CKM_MAGMA_MAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x037);

    public static final long CKM_VENDOR_VKO_GOSTR3410_2012_512 = (CKM_VENDOR_DEFINED + 4);
    public static final long CKM_VENDOR_GOST_KEG = (CKM_VENDOR_DEFINED + 5);

    public static final long CKM_VKO_GOSTR3410_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x038);
    public static final long CKM_GOST_KEG = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x039);

    /* GOST DIVERSIFICATION TYPES */
    public static final long CKD_CPDIVERSIFY_KDF = 0x00000009L;
    public static final long CKD_KDF_4357 = CKM_KDF_4357;
    public static final long CKD_KDF_GOSTR3411_2012_256 = CKM_KDF_GOSTR3411_2012_256;

    public static final long CKP_PKCS5_PBKD2_HMAC_GOSTR3411 = 0x00000002L;

    /*
     * Token flags (field "flags" from CK_TOKEN_INFO_EXTENDED +
     * field "ChangeUserPINPolicy" from CK_RUTOKEN_INIT_PARAM)
     */

    /**
     * TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - if it is set, that
     * means that Administrator (SO) can change User PIN
     */
    public static final long TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN = 0x00000001L;

    /**
     * TOKEN_FLAGS_USER_CHANGE_USER_PIN - if it is set, that
     * means that User can change User PIN
     */
    public static final long TOKEN_FLAGS_USER_CHANGE_USER_PIN = 0x00000002L;

    /**
     * TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - if it is set, that
     * means that current Administrator (SO) PIN is not default
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT = 0x00000004L;

    /**
     * TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - if it is set, that
     * means that current User PIN is not default
     */
    public static final long TOKEN_FLAGS_USER_PIN_NOT_DEFAULT = 0x00000008L;

    /**
     * TOKEN_FLAGS_SUPPORT_FKN - if it is set, that
     * means that token support CryptoPro FKN
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
     * that token has Flash Drive
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
     * means that token supports Secure Messaging
     */
    public static final long TOKEN_FLAGS_SUPPORT_SECURE_MESSAGING = 0x00000100L;

    /**
     * TOKEN_FLAGS_HAS_BUTTON - if it is set, that means
     * that token is Rutoken Touch
     */
    public static final long TOKEN_FLAGS_HAS_BUTTON = 0x00000200L;

    /**
     * TOKEN_FLAGS_SUPPORT_JOURNAL - if it is set, that means
     * that token supports journal
     */
    public static final long TOKEN_FLAGS_SUPPORT_JOURNAL = 0x00000400L;

    /**
     * TOKEN_FLAGS_USER_PIN_UTF8 - if it is set, that means
     * that user PIN in UTF-8
     */
    public static final long TOKEN_FLAGS_USER_PIN_UTF8 = 0x00000800L;

    /**
     * TOKEN_FLAGS_ADMIN_PIN_UTF8 - if it is set, that means
     * that admin PIN in UTF-8
     */
    public static final long TOKEN_FLAGS_ADMIN_PIN_UTF8 = 0x00001000L;

    /**
     * TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE - if it is set, that
     * means Token does not support firmware checksum request
     * and 'ulFirmwareChecksum' can not be used
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_UNAVAILIBLE = 0x40000000L;

    /**
     * TOKEN_FLAGS_FW_CHECKSUM_INVALID - if it is set, that
     * means that 'ulFirmwareChecksum' field contains different
     * from the reference (stored at Token) firmware checksum
     */
    public static final long TOKEN_FLAGS_FW_CHECKSUM_INVALID = 0x80000000L;

    /*
     * Token types (CK_TOKEN_INFO_EXTENDED field "ulTokenType")
     * CK_TOKEN_INFO_EXTENDED's field ulTokenType is deprecated.
     */
    public static final long TOKEN_TYPE_UNKNOWN = 0xFFL;
    public static final long TOKEN_TYPE_RUTOKEN_ECP = 0x01L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE = 0x02L;
    public static final long TOKEN_TYPE_RUTOKEN = 0x03L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_USB = 0x09L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_BT = 0x69L;
    public static final long TOKEN_TYPE_RUTOKEN_ECPDUAL_UART = 0xA9L;
    public static final long TOKEN_TYPE_RUTOKEN_SC_JC = 0x41L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SC = TOKEN_TYPE_RUTOKEN_SC_JC;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_NFC = 0xC1L;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL = 0x49L;
    public static final long TOKEN_TYPE_RUTOKEN_SCDUAL_NFC = 0xC9L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SC_JC = 0x42L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON = 0x05L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SC = 0x45L;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL = 0x4DL;
    public static final long TOKEN_TYPE_RUTOKEN_MIKRON_SCDUAL_NFC = 0xCDL;
    public static final long TOKEN_TYPE_RUTOKEN_PINPAD_FAMILY = 0x04L;
    public static final long TOKEN_TYPE_RUTOKEN_WEB = 0x23L;
    public static final long TOKEN_TYPE_RUTOKEN_ECP_SD = 0x81L;
    public static final long TOKEN_TYPE_RUTOKEN_LITE_SD = 0x82L;

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

    /* Access modes for TM2 */
    public static final long ACCESS_MODE_HIDDEN = 0x00000000L;
    public static final long ACCESS_MODE_RO = 0x00000001L;
    public static final long ACCESS_MODE_RW = 0x00000003L;
    public static final long ACCESS_MODE_CD = 0x00000005L;

    /* PKCS7 constants */
    /**
     * Flags for C_EX_PKCS7Sign
     */
    public static final long PKCS7_DETACHED_SIGNATURE = 0x00000001L;
    public static final long USE_HARDWARE_HASH = 0x00000002L;

    /**
     * Flags for C_EX_PKCS7VerifyInit
     */
    public static final long CKF_VENDOR_DO_NOT_USE_INTERNAL_CMS_CERTS = 0x00000001L;
    public static final long CKF_VENDOR_ALLOW_PARTIAL_CHAINS = 0x00000002L;
    public static final long CKF_VENDOR_CHECK_SIGNATURE_ONLY = 0x00000004L;
    public static final long CKF_VENDOR_USE_TRUSTED_CERTS_FROM_TOKEN = 0x00000008L;

    public static final long OPTIONAL_CRL_CHECK = 0x00000000L;
    public static final long LEAF_CRL_CHECK = 0x00000001L;
    public static final long ALL_CRL_CHECK = 0x00000002L;

    private RtPkcs11Constants() {
    }
}
