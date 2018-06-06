/*
 * Copyright (c) 2016, CJSC Aktiv-Soft. See the LICENSE file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;
/* Derived from rtpkcs11t.h include file for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;

public interface RtPkcs11Constants {
/*-----------------------------------------------------------------*/
/* Расширенные коды ошибок                                         */
/*-----------------------------------------------------------------*/

    NativeLong CKR_CORRUPTED_MAPFILE = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+1);
    NativeLong CKR_WRONG_VERSION_FIELD = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+2);
    NativeLong CKR_WRONG_PKCS1_ENCODING = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+3);
    NativeLong CKR_RTPKCS11_DATA_CORRUPTED = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+4);
    NativeLong CKR_RTPKCS11_RSF_DATA_CORRUPTED = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+5);
    NativeLong CKR_SM_PASSWORD_INVALID = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+6);
    NativeLong CKR_LICENSE_READ_ONLY = new NativeLong(Pkcs11Constants.CKR_VENDOR_DEFINED.longValue()+7);

/*-----------------------------------------------------------------*/
/* Необходимые определения для работы с расширениями PKCS для ГОСТ */
/*-----------------------------------------------------------------*/

    /* GOST KEY TYPES */
    NativeLong CKK_GOSTR3410 = new NativeLong(0x00000030);
    NativeLong CKK_GOSTR3411 = new NativeLong(0x00000031);
    NativeLong CKK_GOST28147 = new NativeLong(0x00000032);

    /* GOST OBJECT ATTRIBUTES */
    NativeLong CKA_GOSTR3410_PARAMS = new NativeLong(0x00000250);
    NativeLong CKA_GOSTR3411_PARAMS = new NativeLong(0x00000251);
    NativeLong CKA_GOST28147_PARAMS = new NativeLong(0x00000252);

    /* GOST MECHANISMS */
    NativeLong CKM_GOSTR3410_KEY_PAIR_GEN = new NativeLong(0x00001200);
    NativeLong CKM_GOSTR3410 = new NativeLong(0x00001201);
    NativeLong CKM_GOSTR3410_WITH_GOSTR3411 = new NativeLong(0x00001202);
    NativeLong CKM_GOSTR3410_KEY_WRAP = new NativeLong(0x00001203);
    NativeLong CKM_GOSTR3410_DERIVE = new NativeLong(0x00001204);
    NativeLong CKM_GOSTR3411 = new NativeLong(0x00001210);
    NativeLong CKM_GOSTR3411_HMAC = new NativeLong(0x00001211);
    NativeLong CKM_GOST28147_KEY_GEN = new NativeLong(0x00001220);
    NativeLong CKM_GOST28147_ECB = new NativeLong(0x00001221);
    NativeLong CKM_GOST28147 = new NativeLong(0x00001222);
    NativeLong CKM_GOST28147_MAC = new NativeLong(0x00001223);
    NativeLong CKM_GOST28147_KEY_WRAP = new NativeLong(0x00001224);

    NativeLong CKD_CPDIVERSIFY_KDF = new NativeLong(0x00000009);
    NativeLong CKP_PKCS5_PBKD2_HMAC_GOSTR3411 = new NativeLong(0x00000002);
    
/* Token flags (field "flags" from CK_TOKEN_INFO_EXTENDED +
 * field "ChangeUserPINPolicy" from CK_RUTOKEN_INIT_PARAM) */
/* TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN - if it is set, that
 * means that Administrator (SO) can change User PIN
 */
NativeLong TOKEN_FLAGS_ADMIN_CHANGE_USER_PIN = new NativeLong(0x00000001);

/* TOKEN_FLAGS_USER_CHANGE_USER_PIN - if it is set, that
 * means that User can change User PIN
 */
NativeLong TOKEN_FLAGS_USER_CHANGE_USER_PIN  = new NativeLong(0x00000002);

/* TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT - if it is set, that
 * means that current Administrator (SO) PIN is not default
 */
NativeLong TOKEN_FLAGS_ADMIN_PIN_NOT_DEFAULT = new NativeLong(0x00000004);

/* TOKEN_FLAGS_USER_PIN_NOT_DEFAULT - if it is set, that
 * means that current User PIN is not default
 */
NativeLong TOKEN_FLAGS_USER_PIN_NOT_DEFAULT  = new NativeLong(0x00000008);

/* Token types (field "ulTokenType") */
NativeLong TOKEN_TYPE_UNKNOWN               = new NativeLong(0xFF);
    NativeLong TOKEN_TYPE_RUTOKEN_ECP           = new NativeLong(0x01);
    NativeLong TOKEN_TYPE_RUTOKEN_LITE          = new NativeLong(0x02);
    NativeLong TOKEN_TYPE_RUTOKEN               = new NativeLong(0x03);
    NativeLong TOKEN_TYPE_RUTOKEN_PINPAD_FAMILY = new NativeLong(0x04);
    NativeLong TOKEN_TYPE_RUTOKEN_ECPDUAL_USB   = new NativeLong(0x09);
    NativeLong TOKEN_TYPE_RUTOKEN_ECPDUAL_BT    = new NativeLong(0x69);
    NativeLong TOKEN_TYPE_RUTOKEN_ECPDUAL_UART  = new NativeLong(0xA9);
    NativeLong TOKEN_TYPE_RUTOKEN_WEB           = new NativeLong(0x23);
    NativeLong TOKEN_TYPE_RUTOKEN_SC_JC         = new NativeLong(0x41);
    NativeLong TOKEN_TYPE_RUTOKEN_LITE_SC_JC    = new NativeLong(0x42);
    NativeLong TOKEN_TYPE_RUTOKEN_ECP_SD        = new NativeLong(0x81);
    NativeLong TOKEN_TYPE_RUTOKEN_LITE_SD       = new NativeLong(0x82);

/* TOKEN_FLAGS_SUPPORT_FKN - if it is set, that
 * means that token support CryptoPro FKN
 */
NativeLong TOKEN_FLAGS_SUPPORT_FKN           = new NativeLong(0x00000010);

/* TOKEN_FLAGS_SUPPORT_SM - if it is set, that
 * means that token supports Secure Messaging
 */
NativeLong TOKEN_FLAGS_SUPPORT_SM            = new NativeLong(0x00000040);

    /* Body color of the token */
    NativeLong TOKEN_BODY_COLOR_UNKNOWN          = new NativeLong(0);
    NativeLong TOKEN_BODY_COLOR_WHITE            = new NativeLong(1);
    NativeLong TOKEN_BODY_COLOR_BLACK            = new NativeLong(2);
}
