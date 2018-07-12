/*
 * Copyright (c) 2016, CJSC Aktiv-Soft. See the LICENSE file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;
/* Derived from pkcs11t.h include file for PKCS #11. */

/* License to copy and use this software is granted provided that it is
 * identified as "RSA Security Inc. PKCS #11 Cryptographic Token Interface
 * (Cryptoki)" in all material mentioning or referencing this software.

 * License is also granted to make and use derivative works provided that
 * such works are identified as "derived from the RSA Security Inc. PKCS #11
 * Cryptographic Token Interface (Cryptoki)" in all material mentioning or
 * referencing the derived work.

 * RSA Security Inc. makes no representations concerning either the
 * merchantability of this software or the suitability of this software for
 * any particular purpose. It is provided "as is" without express or implied
 * warranty of any kind.
 */
/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;

public interface Pkcs11Constants {
    NativeLong  CRYPTOKI_VERSION_MAJOR = new NativeLong(2);
    NativeLong  CRYPTOKI_VERSION_MINOR = new NativeLong(20);
    NativeLong  CRYPTOKI_VERSION_AMENDMENT = new NativeLong(3);

    byte CK_TRUE = 1;
    byte CK_FALSE = 0;

    /* some special values for certain CK_ULONG variables */
    NativeLong CK_UNAVAILABLE_INFORMATION = new NativeLong(~0);
    NativeLong  CK_EFFECTIVELY_INFINITE = new NativeLong(0);

    /* The following value is always invalid if used as a session */
    /* handle or object handle */
    NativeLong  CK_INVALID_HANDLE = new NativeLong(0);

    NativeLong  CKN_SURRENDER = new NativeLong(0);

    /* The following notification is new for PKCS #11 v2.20 amendment 3 */
    NativeLong  CKN_OTP_CHANGED = new NativeLong(1);

    /* flags: bit flags that provide capabilities of the slot
     *      Bit Flag              Mask        Meaning
     */
    NativeLong  CKF_TOKEN_PRESENT = new NativeLong(0x00000001);  /* a token is there */
    NativeLong  CKF_REMOVABLE_DEVICE = new NativeLong(0x00000002);  /* removable devices */
    NativeLong  CKF_HW_SLOT = new NativeLong(0x00000004);  /* hardware slot */

    /* The flags parameter is defined as follows:
     *      Bit Flag                    Mask        Meaning */
    NativeLong  CKF_RNG = new NativeLong(0x00000001);  /* has random # generator */
    NativeLong  CKF_WRITE_PROTECTED = new NativeLong(0x00000002);  /* token is write-protected */
    NativeLong  CKF_LOGIN_REQUIRED = new NativeLong(0x00000004);  /* user must login */
    NativeLong  CKF_USER_PIN_INITIALIZED = new NativeLong(0x00000008);  /* normal user's PIN is set */

    /* CKF_RESTORE_KEY_NOT_NEEDED is new for v2.0. If it is set,
     * that means that *every* time the state of cryptographic
     * operations of a session is successfully saved, all keys
     * needed to continue those operations are stored in the state */
    NativeLong  CKF_RESTORE_KEY_NOT_NEEDED = new NativeLong(0x00000020);

    /* CKF_CLOCK_ON_TOKEN is new for v2.0. If it is set, that means
     * that the token has some sort of clock.  The time on that
     * clock is returned in the token info structure */
    NativeLong  CKF_CLOCK_ON_TOKEN = new NativeLong(0x00000040);

    /* CKF_PROTECTED_AUTHENTICATION_PATH is new for v2.0. If it is
     * set, that means that there is some way for the user to login
     * without sending a PIN through the Cryptoki library itself */
    NativeLong  CKF_PROTECTED_AUTHENTICATION_PATH = new NativeLong(0x00000100);

    /* CKF_DUAL_CRYPTO_OPERATIONS is new for v2.0. If it is true,
     * that means that a single session with the token can perform
     * dual simultaneous cryptographic operations (digest and
     * encrypt; decrypt and digest; sign and encrypt; and decrypt
     * and sign) */
    NativeLong  CKF_DUAL_CRYPTO_OPERATIONS = new NativeLong(0x00000200);

    /* CKF_TOKEN_INITIALIZED is new for v2.10. If it is true, the
     * token has been initialized using C_InitializeToken or an
     * equivalent mechanism outside the scope of PKCS #11.
     * Calling C_InitializeToken when this flag is set will cause
     * the token to be reinitialized. */
    NativeLong  CKF_TOKEN_INITIALIZED = new NativeLong(0x00000400);

    /* CKF_SECONDARY_AUTHENTICATION is new for v2.10. If it is
     * true, the token supports secondary authentication for
     * private key objects. This flag is deprecated in v2.11 and
       onwards. */
    NativeLong  CKF_SECONDARY_AUTHENTICATION = new NativeLong(0x00000800);

    /* CKF_USER_PIN_COUNT_LOW is new for v2.10. If it is true, an
     * incorrect user login PIN has been entered at least once
     * since the last successful authentication. */
    NativeLong  CKF_USER_PIN_COUNT_LOW = new NativeLong(0x00010000);

    /* CKF_USER_PIN_FINAL_TRY is new for v2.10. If it is true,
     * entering an incorrect user PIN will lock it. */
    NativeLong  CKF_USER_PIN_FINAL_TRY = new NativeLong(0x00020000);

    /* CKF_USER_PIN_LOCKED is new for v2.10. If it is true, the
     * user PIN has been locked. User login to the token is not
     * possible. */
    NativeLong  CKF_USER_PIN_LOCKED = new NativeLong(0x00040000);

    /* CKF_USER_PIN_TO_BE_CHANGED is new for v2.10. If it is true,
     * the user PIN value is the default value set by token
     * initialization or manufacturing, or the PIN has been
     * expired by the card. */
    NativeLong  CKF_USER_PIN_TO_BE_CHANGED = new NativeLong(0x00080000);

    /* CKF_SO_PIN_COUNT_LOW is new for v2.10. If it is true, an
     * incorrect SO login PIN has been entered at least once since
     * the last successful authentication. */
    NativeLong  CKF_SO_PIN_COUNT_LOW = new NativeLong(0x00100000);

    /* CKF_SO_PIN_FINAL_TRY is new for v2.10. If it is true,
     * entering an incorrect SO PIN will lock it. */
    NativeLong  CKF_SO_PIN_FINAL_TRY = new NativeLong(0x00200000);

    /* CKF_SO_PIN_LOCKED is new for v2.10. If it is true, the SO
     * PIN has been locked. SO login to the token is not possible.
     */
    NativeLong  CKF_SO_PIN_LOCKED = new NativeLong(0x00400000);

    /* CKF_SO_PIN_TO_BE_CHANGED is new for v2.10. If it is true,
     * the SO PIN value is the default value set by token
     * initialization or manufacturing, or the PIN has been
     * expired by the card. */
    NativeLong  CKF_SO_PIN_TO_BE_CHANGED = new NativeLong(0x00800000);

    /* Security Officer */
    NativeLong  CKU_SO = new NativeLong(0);
    /* Normal user */
    NativeLong  CKU_USER = new NativeLong(1);
    /* Context specific (added in v2.20) */
    NativeLong  CKU_CONTEXT_SPECIFIC = new NativeLong(2);

    NativeLong  CKS_RO_PUBLIC_SESSION = new NativeLong(0);
    NativeLong  CKS_RO_USER_FUNCTIONS = new NativeLong(1);
    NativeLong  CKS_RW_PUBLIC_SESSION = new NativeLong(2);
    NativeLong  CKS_RW_USER_FUNCTIONS = new NativeLong(3);
    NativeLong  CKS_RW_SO_FUNCTIONS = new NativeLong(4);

    /* The flags are defined in the following table:
     *      Bit Flag                Mask        Meaning
     */
    NativeLong  CKF_RW_SESSION = new NativeLong(0x00000002);  /* session is r/w */
    NativeLong  CKF_SERIAL_SESSION = new NativeLong(0x00000004);  /* no parallel */

    /* The following classes of objects are defined: */
    /* CKO_HW_FEATURE is new for v2.10 */
    /* CKO_DOMAIN_PARAMETERS is new for v2.11 */
    /* CKO_MECHANISM is new for v2.20 */
    NativeLong  CKO_DATA = new NativeLong(0x00000000);
    NativeLong  CKO_CERTIFICATE = new NativeLong(0x00000001);
    NativeLong  CKO_PUBLIC_KEY = new NativeLong(0x00000002);
    NativeLong  CKO_PRIVATE_KEY = new NativeLong(0x00000003);
    NativeLong  CKO_SECRET_KEY = new NativeLong(0x00000004);
    NativeLong  CKO_HW_FEATURE = new NativeLong(0x00000005);
    NativeLong  CKO_DOMAIN_PARAMETERS = new NativeLong(0x00000006);
    NativeLong  CKO_MECHANISM = new NativeLong(0x00000007);

    /* CKO_OTP_KEY is new for PKCS #11 v2.20 amendment 1 */
    NativeLong  CKO_OTP_KEY = new NativeLong(0x00000008);

    NativeLong  CKO_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* The following hardware feature types are defined */
    /* CKH_USER_INTERFACE is new for v2.20 */
    NativeLong  CKH_MONOTONIC_COUNTER = new NativeLong(0x00000001);
    NativeLong  CKH_CLOCK = new NativeLong(0x00000002);
    NativeLong  CKH_USER_INTERFACE = new NativeLong(0x00000003);
    NativeLong  CKH_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* the following key types are defined: */
    NativeLong  CKK_RSA = new NativeLong(0x00000000);
    NativeLong  CKK_DSA = new NativeLong(0x00000001);
    NativeLong  CKK_DH = new NativeLong(0x00000002);

    /* CKK_ECDSA and CKK_KEA are new for v2.0 */
    /* CKK_ECDSA is deprecated in v2.11, CKK_EC is preferred. */
    NativeLong  CKK_ECDSA = new NativeLong(0x00000003);
    NativeLong  CKK_EC = new NativeLong(0x00000003);
    NativeLong  CKK_X9_42_DH = new NativeLong(0x00000004);
    NativeLong  CKK_KEA = new NativeLong(0x00000005);

    NativeLong  CKK_GENERIC_SECRET = new NativeLong(0x00000010);
    NativeLong  CKK_RC2 = new NativeLong(0x00000011);
    NativeLong  CKK_RC4 = new NativeLong(0x00000012);
    NativeLong  CKK_DES = new NativeLong(0x00000013);
    NativeLong  CKK_DES2 = new NativeLong(0x00000014);
    NativeLong  CKK_DES3 = new NativeLong(0x00000015);

    /* all these key types are new for v2.0 */
    NativeLong  CKK_CAST = new NativeLong(0x00000016);
    NativeLong  CKK_CAST3 = new NativeLong(0x00000017);
    /* CKK_CAST5 is deprecated in v2.11, CKK_CAST128 is preferred. */
    NativeLong  CKK_CAST5 = new NativeLong(0x00000018);
    NativeLong  CKK_CAST128 = new NativeLong(0x00000018);
    NativeLong  CKK_RC5 = new NativeLong(0x00000019);
    NativeLong  CKK_IDEA = new NativeLong(0x0000001A);
    NativeLong  CKK_SKIPJACK = new NativeLong(0x0000001B);
    NativeLong  CKK_BATON = new NativeLong(0x0000001C);
    NativeLong  CKK_JUNIPER = new NativeLong(0x0000001D);
    NativeLong  CKK_CDMF = new NativeLong(0x0000001E);
    NativeLong  CKK_AES = new NativeLong(0x0000001F);

    /* BlowFish and TwoFish are new for v2.20 */
    NativeLong  CKK_BLOWFISH = new NativeLong(0x00000020);
    NativeLong  CKK_TWOFISH = new NativeLong(0x00000021);

    /* SecurID, HOTP, and ACTI are new for PKCS #11 v2.20 amendment 1 */
    NativeLong  CKK_SECURID = new NativeLong(0x00000022);
    NativeLong  CKK_HOTP = new NativeLong(0x00000023);
    NativeLong  CKK_ACTI = new NativeLong(0x00000024);

    /* Camellia is new for PKCS #11 v2.20 amendment 3 */
    NativeLong  CKK_CAMELLIA = new NativeLong(0x00000025);
    /* ARIA is new for PKCS #11 v2.20 amendment 3 */
    NativeLong  CKK_ARIA = new NativeLong(0x00000026);


    NativeLong  CKK_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* The following certificate types are defined: */
    /* CKC_X_509_ATTR_CERT is new for v2.10 */
    /* CKC_WTLS is new for v2.20 */
    NativeLong  CKC_X_509 = new NativeLong(0x00000000);
    NativeLong  CKC_X_509_ATTR_CERT = new NativeLong(0x00000001);
    NativeLong  CKC_WTLS = new NativeLong(0x00000002);
    NativeLong  CKC_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* The CKF_ARRAY_ATTRIBUTE flag identifies an attribute which
       consists of an array of values. */
    NativeLong  CKF_ARRAY_ATTRIBUTE = new NativeLong(0x40000000);

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1
       and relates to the CKA_OTP_FORMAT attribute */
    NativeLong  CK_OTP_FORMAT_DECIMAL = new NativeLong(0);
    NativeLong  CK_OTP_FORMAT_HEXADECIMAL = new NativeLong(1);
    NativeLong  CK_OTP_FORMAT_ALPHANUMERIC = new NativeLong(2);
    NativeLong  CK_OTP_FORMAT_BINARY = new NativeLong(3);

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1
       and relates to the CKA_OTP_..._REQUIREMENT attributes */
    NativeLong  CK_OTP_PARAM_IGNORED = new NativeLong(0);
    NativeLong  CK_OTP_PARAM_OPTIONAL = new NativeLong(1);
    NativeLong  CK_OTP_PARAM_MANDATORY = new NativeLong(2);

    /* The following attribute types are defined: */
    NativeLong  CKA_CLASS = new NativeLong(0x00000000);
    NativeLong  CKA_TOKEN = new NativeLong(0x00000001);
    NativeLong  CKA_PRIVATE = new NativeLong(0x00000002);
    NativeLong  CKA_LABEL = new NativeLong(0x00000003);
    NativeLong  CKA_APPLICATION = new NativeLong(0x00000010);
    NativeLong  CKA_VALUE = new NativeLong(0x00000011);

    /* CKA_OBJECT_ID is new for v2.10 */
    NativeLong  CKA_OBJECT_ID = new NativeLong(0x00000012);

    NativeLong  CKA_CERTIFICATE_TYPE = new NativeLong(0x00000080);
    NativeLong  CKA_ISSUER = new NativeLong(0x00000081);
    NativeLong  CKA_SERIAL_NUMBER = new NativeLong(0x00000082);

    /* CKA_AC_ISSUER, CKA_OWNER, and CKA_ATTR_TYPES are new
     * for v2.10 */
    NativeLong  CKA_AC_ISSUER = new NativeLong(0x00000083);
    NativeLong  CKA_OWNER = new NativeLong(0x00000084);
    NativeLong  CKA_ATTR_TYPES = new NativeLong(0x00000085);

    /* CKA_TRUSTED is new for v2.11 */
    NativeLong  CKA_TRUSTED = new NativeLong(0x00000086);

    /* CKA_CERTIFICATE_CATEGORY ...
     * CKA_CHECK_VALUE are new for v2.20 */
    NativeLong  CKA_CERTIFICATE_CATEGORY = new NativeLong(0x00000087);
    NativeLong  CKA_JAVA_MIDP_SECURITY_DOMAIN = new NativeLong(0x00000088);
    NativeLong  CKA_URL = new NativeLong(0x00000089);
    NativeLong  CKA_HASH_OF_SUBJECT_PUBLIC_KEY = new NativeLong(0x0000008A);
    NativeLong  CKA_HASH_OF_ISSUER_PUBLIC_KEY = new NativeLong(0x0000008B);
    NativeLong  CKA_CHECK_VALUE = new NativeLong(0x00000090);

    NativeLong  CKA_KEY_TYPE = new NativeLong(0x00000100);
    NativeLong  CKA_SUBJECT = new NativeLong(0x00000101);
    NativeLong  CKA_ID = new NativeLong(0x00000102);
    NativeLong  CKA_SENSITIVE = new NativeLong(0x00000103);
    NativeLong  CKA_ENCRYPT = new NativeLong(0x00000104);
    NativeLong  CKA_DECRYPT = new NativeLong(0x00000105);
    NativeLong  CKA_WRAP = new NativeLong(0x00000106);
    NativeLong  CKA_UNWRAP = new NativeLong(0x00000107);
    NativeLong  CKA_SIGN = new NativeLong(0x00000108);
    NativeLong  CKA_SIGN_RECOVER = new NativeLong(0x00000109);
    NativeLong  CKA_VERIFY = new NativeLong(0x0000010A);
    NativeLong  CKA_VERIFY_RECOVER = new NativeLong(0x0000010B);
    NativeLong  CKA_DERIVE = new NativeLong(0x0000010C);
    NativeLong  CKA_START_DATE = new NativeLong(0x00000110);
    NativeLong  CKA_END_DATE = new NativeLong(0x00000111);
    NativeLong  CKA_MODULUS = new NativeLong(0x00000120);
    NativeLong  CKA_MODULUS_BITS = new NativeLong(0x00000121);
    NativeLong  CKA_PUBLIC_EXPONENT = new NativeLong(0x00000122);
    NativeLong  CKA_PRIVATE_EXPONENT = new NativeLong(0x00000123);
    NativeLong  CKA_PRIME_1 = new NativeLong(0x00000124);
    NativeLong  CKA_PRIME_2 = new NativeLong(0x00000125);
    NativeLong  CKA_EXPONENT_1 = new NativeLong(0x00000126);
    NativeLong  CKA_EXPONENT_2 = new NativeLong(0x00000127);
    NativeLong  CKA_COEFFICIENT = new NativeLong(0x00000128);
    NativeLong  CKA_PRIME = new NativeLong(0x00000130);
    NativeLong  CKA_SUBPRIME = new NativeLong(0x00000131);
    NativeLong  CKA_BASE = new NativeLong(0x00000132);

    /* CKA_PRIME_BITS and CKA_SUB_PRIME_BITS are new for v2.11 */
    NativeLong  CKA_PRIME_BITS = new NativeLong(0x00000133);
    NativeLong  CKA_SUBPRIME_BITS = new NativeLong(0x00000134);
    NativeLong  CKA_SUB_PRIME_BITS = CKA_SUBPRIME_BITS;
    /* (To retain backwards-compatibility) */

    NativeLong  CKA_VALUE_BITS = new NativeLong(0x00000160);
    NativeLong  CKA_VALUE_LEN = new NativeLong(0x00000161);

    /* CKA_EXTRACTABLE, CKA_LOCAL, CKA_NEVER_EXTRACTABLE,
     * CKA_ALWAYS_SENSITIVE, CKA_MODIFIABLE, CKA_ECDSA_PARAMS,
     * and CKA_EC_POINT are new for v2.0 */
    NativeLong  CKA_EXTRACTABLE = new NativeLong(0x00000162);
    NativeLong  CKA_LOCAL = new NativeLong(0x00000163);
    NativeLong  CKA_NEVER_EXTRACTABLE = new NativeLong(0x00000164);
    NativeLong  CKA_ALWAYS_SENSITIVE = new NativeLong(0x00000165);

    /* CKA_KEY_GEN_MECHANISM is new for v2.11 */
    NativeLong  CKA_KEY_GEN_MECHANISM = new NativeLong(0x00000166);

    NativeLong  CKA_MODIFIABLE = new NativeLong(0x00000170);

    /* CKA_ECDSA_PARAMS is deprecated in v2.11,
     * CKA_EC_PARAMS is preferred. */
    NativeLong  CKA_ECDSA_PARAMS = new NativeLong(0x00000180);
    NativeLong  CKA_EC_PARAMS = new NativeLong(0x00000180);

    NativeLong  CKA_EC_POINT = new NativeLong(0x00000181);

    /* CKA_SECONDARY_AUTH, CKA_AUTH_PIN_FLAGS,
     * are new for v2.10. Deprecated in v2.11 and onwards. */
    NativeLong  CKA_SECONDARY_AUTH = new NativeLong(0x00000200);
    NativeLong  CKA_AUTH_PIN_FLAGS = new NativeLong(0x00000201);

    /* CKA_ALWAYS_AUTHENTICATE ...
     * CKA_UNWRAP_TEMPLATE are new for v2.20 */
    NativeLong  CKA_ALWAYS_AUTHENTICATE = new NativeLong(0x00000202);

    NativeLong  CKA_WRAP_WITH_TRUSTED = new NativeLong(0x00000210);
    NativeLong CKA_WRAP_TEMPLATE = new NativeLong(CKF_ARRAY_ATTRIBUTE.longValue()|0x00000211);
    NativeLong CKA_UNWRAP_TEMPLATE = new NativeLong(CKF_ARRAY_ATTRIBUTE.longValue()|0x00000212);

    /* CKA_OTP... atttributes are new for PKCS #11 v2.20 amendment 3. */
    NativeLong  CKA_OTP_FORMAT = new NativeLong(0x00000220);
    NativeLong  CKA_OTP_LENGTH = new NativeLong(0x00000221);
    NativeLong  CKA_OTP_TIME_INTERVAL = new NativeLong(0x00000222);
    NativeLong  CKA_OTP_USER_FRIENDLY_MODE = new NativeLong(0x00000223);
    NativeLong  CKA_OTP_CHALLENGE_REQUIREMENT = new NativeLong(0x00000224);
    NativeLong  CKA_OTP_TIME_REQUIREMENT = new NativeLong(0x00000225);
    NativeLong  CKA_OTP_COUNTER_REQUIREMENT = new NativeLong(0x00000226);
    NativeLong  CKA_OTP_PIN_REQUIREMENT = new NativeLong(0x00000227);
    NativeLong  CKA_OTP_COUNTER = new NativeLong(0x0000022E);
    NativeLong  CKA_OTP_TIME = new NativeLong(0x0000022F);
    NativeLong  CKA_OTP_USER_IDENTIFIER = new NativeLong(0x0000022A);
    NativeLong  CKA_OTP_SERVICE_IDENTIFIER = new NativeLong(0x0000022B);
    NativeLong  CKA_OTP_SERVICE_LOGO = new NativeLong(0x0000022C);
    NativeLong  CKA_OTP_SERVICE_LOGO_TYPE = new NativeLong(0x0000022D);


    /* CKA_HW_FEATURE_TYPE, CKA_RESET_ON_INIT, and CKA_HAS_RESET
     * are new for v2.10 */
    NativeLong  CKA_HW_FEATURE_TYPE = new NativeLong(0x00000300);
    NativeLong  CKA_RESET_ON_INIT = new NativeLong(0x00000301);
    NativeLong  CKA_HAS_RESET = new NativeLong(0x00000302);

    /* The following attributes are new for v2.20 */
    NativeLong  CKA_PIXEL_X = new NativeLong(0x00000400);
    NativeLong  CKA_PIXEL_Y = new NativeLong(0x00000401);
    NativeLong  CKA_RESOLUTION = new NativeLong(0x00000402);
    NativeLong  CKA_CHAR_ROWS = new NativeLong(0x00000403);
    NativeLong  CKA_CHAR_COLUMNS = new NativeLong(0x00000404);
    NativeLong  CKA_COLOR = new NativeLong(0x00000405);
    NativeLong  CKA_BITS_PER_PIXEL = new NativeLong(0x00000406);
    NativeLong  CKA_CHAR_SETS = new NativeLong(0x00000480);
    NativeLong  CKA_ENCODING_METHODS = new NativeLong(0x00000481);
    NativeLong  CKA_MIME_TYPES = new NativeLong(0x00000482);
    NativeLong  CKA_MECHANISM_TYPE = new NativeLong(0x00000500);
    NativeLong  CKA_REQUIRED_CMS_ATTRIBUTES = new NativeLong(0x00000501);
    NativeLong  CKA_DEFAULT_CMS_ATTRIBUTES = new NativeLong(0x00000502);
    NativeLong  CKA_SUPPORTED_CMS_ATTRIBUTES = new NativeLong(0x00000503);
    NativeLong  CKA_ALLOWED_MECHANISMS = new NativeLong(CKF_ARRAY_ATTRIBUTE.longValue()|0x00000600);

    NativeLong  CKA_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* The flags are defined as follows:
     *      Bit Flag               Mask        Meaning */
    NativeLong  CKF_HW = new NativeLong(0x00000001);  /* performed by HW */

    /* The flags CKF_ENCRYPT, CKF_DECRYPT, CKF_DIGEST, CKF_SIGN,
     * CKG_SIGN_RECOVER, CKF_VERIFY, CKF_VERIFY_RECOVER,
     * CKF_GENERATE, CKF_GENERATE_KEY_PAIR, CKF_WRAP, CKF_UNWRAP,
     * and CKF_DERIVE are new for v2.0.  They specify whether or not
     * a mechanism can be used for a particular task */
    NativeLong  CKF_ENCRYPT = new NativeLong(0x00000100);
    NativeLong  CKF_DECRYPT = new NativeLong(0x00000200);
    NativeLong  CKF_DIGEST = new NativeLong(0x00000400);
    NativeLong  CKF_SIGN = new NativeLong(0x00000800);
    NativeLong  CKF_SIGN_RECOVER = new NativeLong(0x00001000);
    NativeLong  CKF_VERIFY = new NativeLong(0x00002000);
    NativeLong  CKF_VERIFY_RECOVER = new NativeLong(0x00004000);
    NativeLong  CKF_GENERATE = new NativeLong(0x00008000);
    NativeLong  CKF_GENERATE_KEY_PAIR = new NativeLong(0x00010000);
    NativeLong  CKF_WRAP = new NativeLong(0x00020000);
    NativeLong  CKF_UNWRAP = new NativeLong(0x00040000);
    NativeLong  CKF_DERIVE = new NativeLong(0x00080000);

    /* CKF_EC_F_P, CKF_EC_F_2M, CKF_EC_ECPARAMETERS, CKF_EC_NAMEDCURVE,
     * CKF_EC_UNCOMPRESS, and CKF_EC_COMPRESS are new for v2.11. They
     * describe a token's EC capabilities not available in mechanism
     * information. */
    NativeLong  CKF_EC_F_P = new NativeLong(0x00100000);
    NativeLong  CKF_EC_F_2M = new NativeLong(0x00200000);
    NativeLong  CKF_EC_ECPARAMETERS = new NativeLong(0x00400000);
    NativeLong  CKF_EC_NAMEDCURVE = new NativeLong(0x00800000);
    NativeLong  CKF_EC_UNCOMPRESS = new NativeLong(0x01000000);
    NativeLong  CKF_EC_COMPRESS = new NativeLong(0x02000000);

    NativeLong  CKF_EXTENSION = new NativeLong(0x80000000); /* FALSE for this version */

    NativeLong  CKR_OK = new NativeLong(0x00000000);
    NativeLong  CKR_CANCEL = new NativeLong(0x00000001);
    NativeLong  CKR_HOST_MEMORY = new NativeLong(0x00000002);
    NativeLong  CKR_SLOT_ID_INVALID = new NativeLong(0x00000003);

    /* CKR_FLAGS_INVALID was removed for v2.0 */

    /* CKR_GENERAL_ERROR and CKR_FUNCTION_FAILED are new for v2.0 */
    NativeLong  CKR_GENERAL_ERROR = new NativeLong(0x00000005);
    NativeLong  CKR_FUNCTION_FAILED = new NativeLong(0x00000006);

    /* CKR_ARGUMENTS_BAD, CKR_NO_EVENT, CKR_NEED_TO_CREATE_THREADS,
     * and CKR_CANT_LOCK are new for v2.01 */
    NativeLong  CKR_ARGUMENTS_BAD = new NativeLong(0x00000007);
    NativeLong  CKR_NO_EVENT = new NativeLong(0x00000008);
    NativeLong  CKR_NEED_TO_CREATE_THREADS = new NativeLong(0x00000009);
    NativeLong  CKR_CANT_LOCK = new NativeLong(0x0000000A);

    NativeLong  CKR_ATTRIBUTE_READ_ONLY = new NativeLong(0x00000010);
    NativeLong  CKR_ATTRIBUTE_SENSITIVE = new NativeLong(0x00000011);
    NativeLong  CKR_ATTRIBUTE_TYPE_INVALID = new NativeLong(0x00000012);
    NativeLong  CKR_ATTRIBUTE_VALUE_INVALID = new NativeLong(0x00000013);
    NativeLong  CKR_DATA_INVALID = new NativeLong(0x00000020);
    NativeLong  CKR_DATA_LEN_RANGE = new NativeLong(0x00000021);
    NativeLong  CKR_DEVICE_ERROR = new NativeLong(0x00000030);
    NativeLong  CKR_DEVICE_MEMORY = new NativeLong(0x00000031);
    NativeLong  CKR_DEVICE_REMOVED = new NativeLong(0x00000032);
    NativeLong  CKR_ENCRYPTED_DATA_INVALID = new NativeLong(0x00000040);
    NativeLong  CKR_ENCRYPTED_DATA_LEN_RANGE = new NativeLong(0x00000041);
    NativeLong  CKR_FUNCTION_CANCELED = new NativeLong(0x00000050);
    NativeLong  CKR_FUNCTION_NOT_PARALLEL = new NativeLong(0x00000051);

    /* CKR_FUNCTION_NOT_SUPPORTED is new for v2.0 */
    NativeLong  CKR_FUNCTION_NOT_SUPPORTED = new NativeLong(0x00000054);

    NativeLong  CKR_KEY_HANDLE_INVALID = new NativeLong(0x00000060);

    /* CKR_KEY_SENSITIVE was removed for v2.0 */

    NativeLong  CKR_KEY_SIZE_RANGE = new NativeLong(0x00000062);
    NativeLong  CKR_KEY_TYPE_INCONSISTENT = new NativeLong(0x00000063);

    /* CKR_KEY_NOT_NEEDED, CKR_KEY_CHANGED, CKR_KEY_NEEDED,
     * CKR_KEY_INDIGESTIBLE, CKR_KEY_FUNCTION_NOT_PERMITTED,
     * CKR_KEY_NOT_WRAPPABLE, and CKR_KEY_UNEXTRACTABLE are new for
     * v2.0 */
    NativeLong  CKR_KEY_NOT_NEEDED = new NativeLong(0x00000064);
    NativeLong  CKR_KEY_CHANGED = new NativeLong(0x00000065);
    NativeLong  CKR_KEY_NEEDED = new NativeLong(0x00000066);
    NativeLong  CKR_KEY_INDIGESTIBLE = new NativeLong(0x00000067);
    NativeLong  CKR_KEY_FUNCTION_NOT_PERMITTED = new NativeLong(0x00000068);
    NativeLong  CKR_KEY_NOT_WRAPPABLE = new NativeLong(0x00000069);
    NativeLong  CKR_KEY_UNEXTRACTABLE = new NativeLong(0x0000006A);

    NativeLong  CKR_MECHANISM_INVALID = new NativeLong(0x00000070);
    NativeLong  CKR_MECHANISM_PARAM_INVALID = new NativeLong(0x00000071);

    /* CKR_OBJECT_CLASS_INCONSISTENT and CKR_OBJECT_CLASS_INVALID
     * were removed for v2.0 */
    NativeLong  CKR_OBJECT_HANDLE_INVALID = new NativeLong(0x00000082);
    NativeLong  CKR_OPERATION_ACTIVE = new NativeLong(0x00000090);
    NativeLong  CKR_OPERATION_NOT_INITIALIZED = new NativeLong(0x00000091);
    NativeLong  CKR_PIN_INCORRECT = new NativeLong(0x000000A0);
    NativeLong  CKR_PIN_INVALID = new NativeLong(0x000000A1);
    NativeLong  CKR_PIN_LEN_RANGE = new NativeLong(0x000000A2);

    /* CKR_PIN_EXPIRED and CKR_PIN_LOCKED are new for v2.0 */
    NativeLong  CKR_PIN_EXPIRED = new NativeLong(0x000000A3);
    NativeLong  CKR_PIN_LOCKED = new NativeLong(0x000000A4);

    NativeLong  CKR_SESSION_CLOSED = new NativeLong(0x000000B0);
    NativeLong  CKR_SESSION_COUNT = new NativeLong(0x000000B1);
    NativeLong  CKR_SESSION_HANDLE_INVALID = new NativeLong(0x000000B3);
    NativeLong  CKR_SESSION_PARALLEL_NOT_SUPPORTED = new NativeLong(0x000000B4);
    NativeLong  CKR_SESSION_READ_ONLY = new NativeLong(0x000000B5);
    NativeLong  CKR_SESSION_EXISTS = new NativeLong(0x000000B6);

    /* CKR_SESSION_READ_ONLY_EXISTS and
     * CKR_SESSION_READ_WRITE_SO_EXISTS are new for v2.0 */
    NativeLong  CKR_SESSION_READ_ONLY_EXISTS = new NativeLong(0x000000B7);
    NativeLong  CKR_SESSION_READ_WRITE_SO_EXISTS = new NativeLong(0x000000B8);

    NativeLong  CKR_SIGNATURE_INVALID = new NativeLong(0x000000C0);
    NativeLong  CKR_SIGNATURE_LEN_RANGE = new NativeLong(0x000000C1);
    NativeLong  CKR_TEMPLATE_INCOMPLETE = new NativeLong(0x000000D0);
    NativeLong  CKR_TEMPLATE_INCONSISTENT = new NativeLong(0x000000D1);
    NativeLong  CKR_TOKEN_NOT_PRESENT = new NativeLong(0x000000E0);
    NativeLong  CKR_TOKEN_NOT_RECOGNIZED = new NativeLong(0x000000E1);
    NativeLong  CKR_TOKEN_WRITE_PROTECTED = new NativeLong(0x000000E2);
    NativeLong  CKR_UNWRAPPING_KEY_HANDLE_INVALID = new NativeLong(0x000000F0);
    NativeLong  CKR_UNWRAPPING_KEY_SIZE_RANGE = new NativeLong(0x000000F1);
    NativeLong  CKR_UNWRAPPING_KEY_TYPE_INCONSISTENT = new NativeLong(0x000000F2);
    NativeLong  CKR_USER_ALREADY_LOGGED_IN = new NativeLong(0x00000100);
    NativeLong  CKR_USER_NOT_LOGGED_IN = new NativeLong(0x00000101);
    NativeLong  CKR_USER_PIN_NOT_INITIALIZED = new NativeLong(0x00000102);
    NativeLong  CKR_USER_TYPE_INVALID = new NativeLong(0x00000103);

    /* CKR_USER_ANOTHER_ALREADY_LOGGED_IN and CKR_USER_TOO_MANY_TYPES
     * are new for v2.01 */
    NativeLong  CKR_USER_ANOTHER_ALREADY_LOGGED_IN = new NativeLong(0x00000104);
    NativeLong  CKR_USER_TOO_MANY_TYPES = new NativeLong(0x00000105);

    NativeLong  CKR_WRAPPED_KEY_INVALID = new NativeLong(0x00000110);
    NativeLong  CKR_WRAPPED_KEY_LEN_RANGE = new NativeLong(0x00000112);
    NativeLong  CKR_WRAPPING_KEY_HANDLE_INVALID = new NativeLong(0x00000113);
    NativeLong  CKR_WRAPPING_KEY_SIZE_RANGE = new NativeLong(0x00000114);
    NativeLong  CKR_WRAPPING_KEY_TYPE_INCONSISTENT = new NativeLong(0x00000115);
    NativeLong  CKR_RANDOM_SEED_NOT_SUPPORTED = new NativeLong(0x00000120);

    /* This is new for v2.0 */
    NativeLong  CKR_RANDOM_NO_RNG = new NativeLong(0x00000121);

    /* This is new for v2.11 */
    NativeLong  CKR_DOMAIN_PARAMS_INVALID = new NativeLong(0x00000130);

    /* These are new for v2.0 */
    NativeLong  CKR_BUFFER_TOO_SMALL = new NativeLong(0x00000150);
    NativeLong  CKR_SAVED_STATE_INVALID = new NativeLong(0x00000160);
    NativeLong  CKR_INFORMATION_SENSITIVE = new NativeLong(0x00000170);
    NativeLong  CKR_STATE_UNSAVEABLE = new NativeLong(0x00000180);

    /* These are new for v2.01 */
    NativeLong  CKR_CRYPTOKI_NOT_INITIALIZED = new NativeLong(0x00000190);
    NativeLong  CKR_CRYPTOKI_ALREADY_INITIALIZED = new NativeLong(0x00000191);
    NativeLong  CKR_MUTEX_BAD = new NativeLong(0x000001A0);
    NativeLong  CKR_MUTEX_NOT_LOCKED = new NativeLong(0x000001A1);

    /* The following return values are new for PKCS #11 v2.20 amendment 3 */
    NativeLong  CKR_NEW_PIN_MODE = new NativeLong(0x000001B0);
    NativeLong  CKR_NEXT_OTP = new NativeLong(0x000001B1);

    /* This is new for v2.20 */
    NativeLong  CKR_FUNCTION_REJECTED = new NativeLong(0x00000200);

    NativeLong  CKR_VENDOR_DEFINED = new NativeLong(0x80000000);

    /* flags: bit flags that provide capabilities of the slot
     *      Bit Flag                           Mask       Meaning
     */
    NativeLong  CKF_LIBRARY_CANT_CREATE_OS_THREADS = new NativeLong(0x00000001);
    NativeLong  CKF_OS_LOCKING_OK = new NativeLong(0x00000002);



    /* CKF_DONT_BLOCK is for the function C_WaitForSlotEvent */
    NativeLong  CKF_DONT_BLOCK = new NativeLong(1);

    /* The following MGFs are defined */
    /* CKG_MGF1_SHA256, CKG_MGF1_SHA384, and CKG_MGF1_SHA512
     * are new for v2.20 */
    NativeLong  CKG_MGF1_SHA1 = new NativeLong(0x00000001);
    NativeLong  CKG_MGF1_SHA256 = new NativeLong(0x00000002);
    NativeLong  CKG_MGF1_SHA384 = new NativeLong(0x00000003);
    NativeLong  CKG_MGF1_SHA512 = new NativeLong(0x00000004);
    /* SHA-224 is new for PKCS #11 v2.20 amendment 3 */
    NativeLong  CKG_MGF1_SHA224 = new NativeLong(0x00000005);

    /* The following encoding parameter sources are defined */
    NativeLong  CKZ_DATA_SPECIFIED = new NativeLong(0x00000001);

    /* The following EC Key Derivation Functions are defined */
    NativeLong  CKD_NULL = new NativeLong(0x00000001);
    NativeLong  CKD_SHA1_KDF = new NativeLong(0x00000002);

    /* The following X9.42 DH key derivation functions are defined
       (besides CKD_NULL already defined : */
    NativeLong  CKD_SHA1_KDF_ASN1 = new NativeLong(0x00000003);
    NativeLong  CKD_SHA1_KDF_CONCATENATE = new NativeLong(0x00000004);

    /* The following PRFs are defined in PKCS #5 v2.0. */
    NativeLong  CKP_PKCS5_PBKD2_HMAC_SHA1 = new NativeLong(0x00000001);

    /* The following salt value sources are defined in PKCS #5 v2.0. */
    NativeLong  CKZ_SALT_SPECIFIED = new NativeLong(0x00000001);

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1 */
    NativeLong  CK_OTP_VALUE = new NativeLong(0);
    NativeLong  CK_OTP_PIN = new NativeLong(1);
    NativeLong  CK_OTP_CHALLENGE = new NativeLong(2);
    NativeLong  CK_OTP_TIME = new NativeLong(3);
    NativeLong  CK_OTP_COUNTER = new NativeLong(4);
    NativeLong  CK_OTP_FLAGS = new NativeLong(5);
    NativeLong  CK_OTP_OUTPUT_LENGTH = new NativeLong(6);
    NativeLong  CK_OTP_OUTPUT_FORMAT = new NativeLong(7);

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1 */
    NativeLong  CKF_NEXT_OTP = new NativeLong(0x00000001);
    NativeLong  CKF_EXCLUDE_TIME = new NativeLong(0x00000002);
    NativeLong  CKF_EXCLUDE_COUNTER = new NativeLong(0x00000004);
    NativeLong  CKF_EXCLUDE_CHALLENGE = new NativeLong(0x00000008);
    NativeLong  CKF_EXCLUDE_PIN = new NativeLong(0x00000010);
    NativeLong  CKF_USER_FRIENDLY_OTP = new NativeLong(0x00000020);

    /* Access modes for TM2 */
    NativeLong  ACCESS_MODE_HIDDEN = new NativeLong(0x00000000);
    NativeLong  ACCESS_MODE_RO = new NativeLong(0x00000001);
    NativeLong  ACCESS_MODE_RW = new NativeLong(0x00000003);
    NativeLong  ACCESS_MODE_CD = new NativeLong(0x00000005);
}
