/*
 * Copyright (c) 2016, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
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


public final class Pkcs11Constants {
    public static final long CRYPTOKI_VERSION_MAJOR = 2;
    public static final long CRYPTOKI_VERSION_MINOR = 20;
    public static final long CRYPTOKI_VERSION_AMENDMENT = 3;

    public static final byte CK_TRUE = 1;
    public static final byte CK_FALSE = 0;

    /* some special values for certain CK_ULONG variables */
    public static final long CK_UNAVAILABLE_INFORMATION = ~0;
    public static final long CK_EFFECTIVELY_INFINITE = 0;

    /* The following value is always invalid if used as a session */
    /* handle or object handle */
    public static final long CK_INVALID_HANDLE = 0;

    public static final long CKN_SURRENDER = 0;

    /* The following notification is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKN_OTP_CHANGED = 1;

    /* flags: bit flags that provide capabilities of the slot
     *      Bit Flag              Mask        Meaning
     */
    public static final long CKF_TOKEN_PRESENT = 0x00000001;  /* a token is there */
    public static final long CKF_REMOVABLE_DEVICE = 0x00000002;  /* removable devices */
    public static final long CKF_HW_SLOT = 0x00000004;  /* hardware slot */

    /* The flags parameter is defined as follows:
     *      Bit Flag                    Mask        Meaning */
    public static final long CKF_RNG = 0x00000001;  /* has random # generator */
    public static final long CKF_WRITE_PROTECTED = 0x00000002;  /* token is write-protected */
    public static final long CKF_LOGIN_REQUIRED = 0x00000004;  /* user must login */
    public static final long CKF_USER_PIN_INITIALIZED = 0x00000008;  /* normal user's PIN is set */

    /* CKF_RESTORE_KEY_NOT_NEEDED is new for v2.0. If it is set,
     * that means that *every* time the state of cryptographic
     * operations of a session is successfully saved, all keys
     * needed to continue those operations are stored in the state */
    public static final long CKF_RESTORE_KEY_NOT_NEEDED = 0x00000020;

    /* CKF_CLOCK_ON_TOKEN is new for v2.0. If it is set, that means
     * that the token has some sort of clock.  The time on that
     * clock is returned in the token info structure */
    public static final long CKF_CLOCK_ON_TOKEN = 0x00000040;

    /* CKF_PROTECTED_AUTHENTICATION_PATH is new for v2.0. If it is
     * set, that means that there is some way for the user to login
     * without sending a PIN through the Cryptoki library itself */
    public static final long CKF_PROTECTED_AUTHENTICATION_PATH = 0x00000100;

    /* CKF_DUAL_CRYPTO_OPERATIONS is new for v2.0. If it is true,
     * that means that a single session with the token can perform
     * dual simultaneous cryptographic operations (digest and
     * encrypt; decrypt and digest; sign and encrypt; and decrypt
     * and sign) */
    public static final long CKF_DUAL_CRYPTO_OPERATIONS = 0x00000200;

    /* CKF_TOKEN_INITIALIZED is new for v2.10. If it is true, the
     * token has been initialized using C_InitializeToken or an
     * equivalent mechanism outside the scope of PKCS #11.
     * Calling C_InitializeToken when this flag is set will cause
     * the token to be reinitialized. */
    public static final long CKF_TOKEN_INITIALIZED = 0x00000400;

    /* CKF_SECONDARY_AUTHENTICATION is new for v2.10. If it is
     * true, the token supports secondary authentication for
     * private key objects. This flag is deprecated in v2.11 and
       onwards. */
    public static final long CKF_SECONDARY_AUTHENTICATION = 0x00000800;

    /* CKF_USER_PIN_COUNT_LOW is new for v2.10. If it is true, an
     * incorrect user login PIN has been entered at least once
     * since the last successful authentication. */
    public static final long CKF_USER_PIN_COUNT_LOW = 0x00010000;

    /* CKF_USER_PIN_FINAL_TRY is new for v2.10. If it is true,
     * entering an incorrect user PIN will lock it. */
    public static final long CKF_USER_PIN_FINAL_TRY = 0x00020000;

    /* CKF_USER_PIN_LOCKED is new for v2.10. If it is true, the
     * user PIN has been locked. User login to the token is not
     * possible. */
    public static final long CKF_USER_PIN_LOCKED = 0x00040000;

    /* CKF_USER_PIN_TO_BE_CHANGED is new for v2.10. If it is true,
     * the user PIN value is the default value set by token
     * initialization or manufacturing, or the PIN has been
     * expired by the card. */
    public static final long CKF_USER_PIN_TO_BE_CHANGED = 0x00080000;

    /* CKF_SO_PIN_COUNT_LOW is new for v2.10. If it is true, an
     * incorrect SO login PIN has been entered at least once since
     * the last successful authentication. */
    public static final long CKF_SO_PIN_COUNT_LOW = 0x00100000;

    /* CKF_SO_PIN_FINAL_TRY is new for v2.10. If it is true,
     * entering an incorrect SO PIN will lock it. */
    public static final long CKF_SO_PIN_FINAL_TRY = 0x00200000;

    /* CKF_SO_PIN_LOCKED is new for v2.10. If it is true, the SO
     * PIN has been locked. SO login to the token is not possible.
     */
    public static final long CKF_SO_PIN_LOCKED = 0x00400000;

    /* CKF_SO_PIN_TO_BE_CHANGED is new for v2.10. If it is true,
     * the SO PIN value is the default value set by token
     * initialization or manufacturing, or the PIN has been
     * expired by the card. */
    public static final long CKF_SO_PIN_TO_BE_CHANGED = 0x00800000;

    /* Security Officer */
    public static final long CKU_SO = 0;
    /* Normal user */
    public static final long CKU_USER = 1;
    /* Context specific (added in v2.20) */
    public static final long CKU_CONTEXT_SPECIFIC = 2;

    public static final long CKS_RO_PUBLIC_SESSION = 0;
    public static final long CKS_RO_USER_FUNCTIONS = 1;
    public static final long CKS_RW_PUBLIC_SESSION = 2;
    public static final long CKS_RW_USER_FUNCTIONS = 3;
    public static final long CKS_RW_SO_FUNCTIONS = 4;

    /* The flags are defined in the following table:
     *      Bit Flag                Mask        Meaning
     */
    public static final long CKF_RW_SESSION = 0x00000002;  /* session is r/w */
    public static final long CKF_SERIAL_SESSION = 0x00000004;  /* no parallel */

    /* The following classes of objects are defined: */
    /* CKO_HW_FEATURE is new for v2.10 */
    /* CKO_DOMAIN_PARAMETERS is new for v2.11 */
    /* CKO_MECHANISM is new for v2.20 */
    public static final long CKO_DATA = 0x00000000;
    public static final long CKO_CERTIFICATE = 0x00000001;
    public static final long CKO_PUBLIC_KEY = 0x00000002;
    public static final long CKO_PRIVATE_KEY = 0x00000003;
    public static final long CKO_SECRET_KEY = 0x00000004;
    public static final long CKO_HW_FEATURE = 0x00000005;
    public static final long CKO_DOMAIN_PARAMETERS = 0x00000006;
    public static final long CKO_MECHANISM = 0x00000007;

    /* CKO_OTP_KEY is new for PKCS #11 v2.20 amendment 1 */
    public static final long CKO_OTP_KEY = 0x00000008;

    public static final long CKO_VENDOR_DEFINED = 0x80000000;

    /* The following hardware feature types are defined */
    /* CKH_USER_INTERFACE is new for v2.20 */
    public static final long CKH_MONOTONIC_COUNTER = 0x00000001;
    public static final long CKH_CLOCK = 0x00000002;
    public static final long CKH_USER_INTERFACE = 0x00000003;
    public static final long CKH_VENDOR_DEFINED = 0x80000000;

    /* the following key types are defined: */
    public static final long CKK_RSA = 0x00000000;
    public static final long CKK_DSA = 0x00000001;
    public static final long CKK_DH = 0x00000002;

    /* CKK_ECDSA and CKK_KEA are new for v2.0 */
    /* CKK_ECDSA is deprecated in v2.11, CKK_EC is preferred. */
    public static final long CKK_ECDSA = 0x00000003;
    public static final long CKK_EC = 0x00000003;
    public static final long CKK_X9_42_DH = 0x00000004;
    public static final long CKK_KEA = 0x00000005;

    public static final long CKK_GENERIC_SECRET = 0x00000010;
    public static final long CKK_RC2 = 0x00000011;
    public static final long CKK_RC4 = 0x00000012;
    public static final long CKK_DES = 0x00000013;
    public static final long CKK_DES2 = 0x00000014;
    public static final long CKK_DES3 = 0x00000015;

    /* all these key types are new for v2.0 */
    public static final long CKK_CAST = 0x00000016;
    public static final long CKK_CAST3 = 0x00000017;
    /* CKK_CAST5 is deprecated in v2.11, CKK_CAST128 is preferred. */
    public static final long CKK_CAST5 = 0x00000018;
    public static final long CKK_CAST128 = 0x00000018;
    public static final long CKK_RC5 = 0x00000019;
    public static final long CKK_IDEA = 0x0000001A;
    public static final long CKK_SKIPJACK = 0x0000001B;
    public static final long CKK_BATON = 0x0000001C;
    public static final long CKK_JUNIPER = 0x0000001D;
    public static final long CKK_CDMF = 0x0000001E;
    public static final long CKK_AES = 0x0000001F;

    /* BlowFish and TwoFish are new for v2.20 */
    public static final long CKK_BLOWFISH = 0x00000020;
    public static final long CKK_TWOFISH = 0x00000021;

    /* SecurID, HOTP, and ACTI are new for PKCS #11 v2.20 amendment 1 */
    public static final long CKK_SECURID = 0x00000022;
    public static final long CKK_HOTP = 0x00000023;
    public static final long CKK_ACTI = 0x00000024;

    /* Camellia is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKK_CAMELLIA = 0x00000025;
    /* ARIA is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKK_ARIA = 0x00000026;


    public static final long CKK_VENDOR_DEFINED = 0x80000000;

    /* The following certificate types are defined: */
    /* CKC_X_509_ATTR_CERT is new for v2.10 */
    /* CKC_WTLS is new for v2.20 */
    public static final long CKC_X_509 = 0x00000000;
    public static final long CKC_X_509_ATTR_CERT = 0x00000001;
    public static final long CKC_WTLS = 0x00000002;
    public static final long CKC_VENDOR_DEFINED = 0x80000000;

    /* The CKF_ARRAY_ATTRIBUTE flag identifies an attribute which
       consists of an array of values. */
    public static final long CKF_ARRAY_ATTRIBUTE = 0x40000000;

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1
       and relates to the CKA_OTP_FORMAT attribute */
    public static final long CK_OTP_FORMAT_DECIMAL = 0;
    public static final long CK_OTP_FORMAT_HEXADECIMAL = 1;
    public static final long CK_OTP_FORMAT_ALPHANUMERIC = 2;
    public static final long CK_OTP_FORMAT_BINARY = 3;

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1
       and relates to the CKA_OTP_..._REQUIREMENT attributes */
    public static final long CK_OTP_PARAM_IGNORED = 0;
    public static final long CK_OTP_PARAM_OPTIONAL = 1;
    public static final long CK_OTP_PARAM_MANDATORY = 2;

    /* The following attribute types are defined: */
    public static final long CKA_CLASS = 0x00000000;
    public static final long CKA_TOKEN = 0x00000001;
    public static final long CKA_PRIVATE = 0x00000002;
    public static final long CKA_LABEL = 0x00000003;
    public static final long CKA_APPLICATION = 0x00000010;
    public static final long CKA_VALUE = 0x00000011;

    /* CKA_OBJECT_ID is new for v2.10 */
    public static final long CKA_OBJECT_ID = 0x00000012;

    public static final long CKA_CERTIFICATE_TYPE = 0x00000080;
    public static final long CKA_ISSUER = 0x00000081;
    public static final long CKA_SERIAL_NUMBER = 0x00000082;

    /* CKA_AC_ISSUER, CKA_OWNER, and CKA_ATTR_TYPES are new
     * for v2.10 */
    public static final long CKA_AC_ISSUER = 0x00000083;
    public static final long CKA_OWNER = 0x00000084;
    public static final long CKA_ATTR_TYPES = 0x00000085;

    /* CKA_TRUSTED is new for v2.11 */
    public static final long CKA_TRUSTED = 0x00000086;

    /* CKA_CERTIFICATE_CATEGORY ...
     * CKA_CHECK_VALUE are new for v2.20 */
    public static final long CKA_CERTIFICATE_CATEGORY = 0x00000087;
    public static final long CKA_JAVA_MIDP_SECURITY_DOMAIN = 0x00000088;
    public static final long CKA_URL = 0x00000089;
    public static final long CKA_HASH_OF_SUBJECT_PUBLIC_KEY = 0x0000008A;
    public static final long CKA_HASH_OF_ISSUER_PUBLIC_KEY = 0x0000008B;
    public static final long CKA_CHECK_VALUE = 0x00000090;

    public static final long CKA_KEY_TYPE = 0x00000100;
    public static final long CKA_SUBJECT = 0x00000101;
    public static final long CKA_ID = 0x00000102;
    public static final long CKA_SENSITIVE = 0x00000103;
    public static final long CKA_ENCRYPT = 0x00000104;
    public static final long CKA_DECRYPT = 0x00000105;
    public static final long CKA_WRAP = 0x00000106;
    public static final long CKA_UNWRAP = 0x00000107;
    public static final long CKA_SIGN = 0x00000108;
    public static final long CKA_SIGN_RECOVER = 0x00000109;
    public static final long CKA_VERIFY = 0x0000010A;
    public static final long CKA_VERIFY_RECOVER = 0x0000010B;
    public static final long CKA_DERIVE = 0x0000010C;
    public static final long CKA_START_DATE = 0x00000110;
    public static final long CKA_END_DATE = 0x00000111;
    public static final long CKA_MODULUS = 0x00000120;
    public static final long CKA_MODULUS_BITS = 0x00000121;
    public static final long CKA_PUBLIC_EXPONENT = 0x00000122;
    public static final long CKA_PRIVATE_EXPONENT = 0x00000123;
    public static final long CKA_PRIME_1 = 0x00000124;
    public static final long CKA_PRIME_2 = 0x00000125;
    public static final long CKA_EXPONENT_1 = 0x00000126;
    public static final long CKA_EXPONENT_2 = 0x00000127;
    public static final long CKA_COEFFICIENT = 0x00000128;
    public static final long CKA_PRIME = 0x00000130;
    public static final long CKA_SUBPRIME = 0x00000131;
    public static final long CKA_BASE = 0x00000132;

    /* CKA_PRIME_BITS and CKA_SUB_PRIME_BITS are new for v2.11 */
    public static final long CKA_PRIME_BITS = 0x00000133;
    public static final long CKA_SUBPRIME_BITS = 0x00000134;
    public static final long CKA_SUB_PRIME_BITS = CKA_SUBPRIME_BITS;
    /* (To retain backwards-compatibility) */

    public static final long CKA_VALUE_BITS = 0x00000160;
    public static final long CKA_VALUE_LEN = 0x00000161;

    /* CKA_EXTRACTABLE, CKA_LOCAL, CKA_NEVER_EXTRACTABLE,
     * CKA_ALWAYS_SENSITIVE, CKA_MODIFIABLE, CKA_ECDSA_PARAMS,
     * and CKA_EC_POINT are new for v2.0 */
    public static final long CKA_EXTRACTABLE = 0x00000162;
    public static final long CKA_LOCAL = 0x00000163;
    public static final long CKA_NEVER_EXTRACTABLE = 0x00000164;
    public static final long CKA_ALWAYS_SENSITIVE = 0x00000165;

    /* CKA_KEY_GEN_MECHANISM is new for v2.11 */
    public static final long CKA_KEY_GEN_MECHANISM = 0x00000166;

    public static final long CKA_MODIFIABLE = 0x00000170;

    /* CKA_ECDSA_PARAMS is deprecated in v2.11,
     * CKA_EC_PARAMS is preferred. */
    public static final long CKA_ECDSA_PARAMS = 0x00000180;
    public static final long CKA_EC_PARAMS = 0x00000180;

    public static final long CKA_EC_POINT = 0x00000181;

    /* CKA_SECONDARY_AUTH, CKA_AUTH_PIN_FLAGS,
     * are new for v2.10. Deprecated in v2.11 and onwards. */
    public static final long CKA_SECONDARY_AUTH = 0x00000200;
    public static final long CKA_AUTH_PIN_FLAGS = 0x00000201;

    /* CKA_ALWAYS_AUTHENTICATE ...
     * CKA_UNWRAP_TEMPLATE are new for v2.20 */
    public static final long CKA_ALWAYS_AUTHENTICATE = 0x00000202;

    public static final long CKA_WRAP_WITH_TRUSTED = 0x00000210;
    public static final long CKA_WRAP_TEMPLATE = CKF_ARRAY_ATTRIBUTE | 0x00000211;
    public static final long CKA_UNWRAP_TEMPLATE = CKF_ARRAY_ATTRIBUTE | 0x00000212;

    /* CKA_OTP... atttributes are new for PKCS #11 v2.20 amendment 3. */
    public static final long CKA_OTP_FORMAT = 0x00000220;
    public static final long CKA_OTP_LENGTH = 0x00000221;
    public static final long CKA_OTP_TIME_INTERVAL = 0x00000222;
    public static final long CKA_OTP_USER_FRIENDLY_MODE = 0x00000223;
    public static final long CKA_OTP_CHALLENGE_REQUIREMENT = 0x00000224;
    public static final long CKA_OTP_TIME_REQUIREMENT = 0x00000225;
    public static final long CKA_OTP_COUNTER_REQUIREMENT = 0x00000226;
    public static final long CKA_OTP_PIN_REQUIREMENT = 0x00000227;
    public static final long CKA_OTP_COUNTER = 0x0000022E;
    public static final long CKA_OTP_TIME = 0x0000022F;
    public static final long CKA_OTP_USER_IDENTIFIER = 0x0000022A;
    public static final long CKA_OTP_SERVICE_IDENTIFIER = 0x0000022B;
    public static final long CKA_OTP_SERVICE_LOGO = 0x0000022C;
    public static final long CKA_OTP_SERVICE_LOGO_TYPE = 0x0000022D;


    /* CKA_HW_FEATURE_TYPE, CKA_RESET_ON_INIT, and CKA_HAS_RESET
     * are new for v2.10 */
    public static final long CKA_HW_FEATURE_TYPE = 0x00000300;
    public static final long CKA_RESET_ON_INIT = 0x00000301;
    public static final long CKA_HAS_RESET = 0x00000302;

    /* The following attributes are new for v2.20 */
    public static final long CKA_PIXEL_X = 0x00000400;
    public static final long CKA_PIXEL_Y = 0x00000401;
    public static final long CKA_RESOLUTION = 0x00000402;
    public static final long CKA_CHAR_ROWS = 0x00000403;
    public static final long CKA_CHAR_COLUMNS = 0x00000404;
    public static final long CKA_COLOR = 0x00000405;
    public static final long CKA_BITS_PER_PIXEL = 0x00000406;
    public static final long CKA_CHAR_SETS = 0x00000480;
    public static final long CKA_ENCODING_METHODS = 0x00000481;
    public static final long CKA_MIME_TYPES = 0x00000482;
    public static final long CKA_MECHANISM_TYPE = 0x00000500;
    public static final long CKA_REQUIRED_CMS_ATTRIBUTES = 0x00000501;
    public static final long CKA_DEFAULT_CMS_ATTRIBUTES = 0x00000502;
    public static final long CKA_SUPPORTED_CMS_ATTRIBUTES = 0x00000503;
    public static final long CKA_ALLOWED_MECHANISMS = CKF_ARRAY_ATTRIBUTE | 0x00000600;

    public static final long CKA_VENDOR_DEFINED = 0x80000000;

    /* the following mechanism types are defined: */
    public static final long CKM_RSA_PKCS_KEY_PAIR_GEN = 0x00000000;
    public static final long CKM_RSA_PKCS = 0x00000001;
    public static final long CKM_RSA_9796 = 0x00000002;
    public static final long CKM_RSA_X_509 = 0x00000003;

    /* CKM_MD2_RSA_PKCS, CKM_MD5_RSA_PKCS, and CKM_SHA1_RSA_PKCS
     * are new for v2.0.  They are mechanisms which hash and sign */
    public static final long CKM_MD2_RSA_PKCS = 0x00000004;
    public static final long CKM_MD5_RSA_PKCS = 0x00000005;
    public static final long CKM_SHA1_RSA_PKCS = 0x00000006;

    /* CKM_RIPEMD128_RSA_PKCS, CKM_RIPEMD160_RSA_PKCS, and
     * CKM_RSA_PKCS_OAEP are new for v2.10 */
    public static final long CKM_RIPEMD128_RSA_PKCS = 0x00000007;
    public static final long CKM_RIPEMD160_RSA_PKCS = 0x00000008;
    public static final long CKM_RSA_PKCS_OAEP = 0x00000009;

    /* CKM_RSA_X9_31_KEY_PAIR_GEN, CKM_RSA_X9_31, CKM_SHA1_RSA_X9_31,
     * CKM_RSA_PKCS_PSS, and CKM_SHA1_RSA_PKCS_PSS are new for v2.11 */
    public static final long CKM_RSA_X9_31_KEY_PAIR_GEN = 0x0000000A;
    public static final long CKM_RSA_X9_31 = 0x0000000B;
    public static final long CKM_SHA1_RSA_X9_31 = 0x0000000C;
    public static final long CKM_RSA_PKCS_PSS = 0x0000000D;
    public static final long CKM_SHA1_RSA_PKCS_PSS = 0x0000000E;

    public static final long CKM_DSA_KEY_PAIR_GEN = 0x00000010;
    public static final long CKM_DSA = 0x00000011;
    public static final long CKM_DSA_SHA1 = 0x00000012;
    public static final long CKM_DH_PKCS_KEY_PAIR_GEN = 0x00000020;
    public static final long CKM_DH_PKCS_DERIVE = 0x00000021;

    /* CKM_X9_42_DH_KEY_PAIR_GEN, CKM_X9_42_DH_DERIVE,
     * CKM_X9_42_DH_HYBRID_DERIVE, and CKM_X9_42_MQV_DERIVE are new for
     * v2.11 */
    public static final long CKM_X9_42_DH_KEY_PAIR_GEN = 0x00000030;
    public static final long CKM_X9_42_DH_DERIVE = 0x00000031;
    public static final long CKM_X9_42_DH_HYBRID_DERIVE = 0x00000032;
    public static final long CKM_X9_42_MQV_DERIVE = 0x00000033;

    /* CKM_SHA256/384/512 are new for v2.20 */
    public static final long CKM_SHA256_RSA_PKCS = 0x00000040;
    public static final long CKM_SHA384_RSA_PKCS = 0x00000041;
    public static final long CKM_SHA512_RSA_PKCS = 0x00000042;
    public static final long CKM_SHA256_RSA_PKCS_PSS = 0x00000043;
    public static final long CKM_SHA384_RSA_PKCS_PSS = 0x00000044;
    public static final long CKM_SHA512_RSA_PKCS_PSS = 0x00000045;

    /* SHA-224 RSA mechanisms are new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_SHA224_RSA_PKCS = 0x00000046;
    public static final long CKM_SHA224_RSA_PKCS_PSS = 0x00000047;

    public static final long CKM_RC2_KEY_GEN = 0x00000100;
    public static final long CKM_RC2_ECB = 0x00000101;
    public static final long CKM_RC2_CBC = 0x00000102;
    public static final long CKM_RC2_MAC = 0x00000103;

    /* CKM_RC2_MAC_GENERAL and CKM_RC2_CBC_PAD are new for v2.0 */
    public static final long CKM_RC2_MAC_GENERAL = 0x00000104;
    public static final long CKM_RC2_CBC_PAD = 0x00000105;

    public static final long CKM_RC4_KEY_GEN = 0x00000110;
    public static final long CKM_RC4 = 0x00000111;
    public static final long CKM_DES_KEY_GEN = 0x00000120;
    public static final long CKM_DES_ECB = 0x00000121;
    public static final long CKM_DES_CBC = 0x00000122;
    public static final long CKM_DES_MAC = 0x00000123;

    /* CKM_DES_MAC_GENERAL and CKM_DES_CBC_PAD are new for v2.0 */
    public static final long CKM_DES_MAC_GENERAL = 0x00000124;
    public static final long CKM_DES_CBC_PAD = 0x00000125;

    public static final long CKM_DES2_KEY_GEN = 0x00000130;
    public static final long CKM_DES3_KEY_GEN = 0x00000131;
    public static final long CKM_DES3_ECB = 0x00000132;
    public static final long CKM_DES3_CBC = 0x00000133;
    public static final long CKM_DES3_MAC = 0x00000134;

    /* CKM_DES3_MAC_GENERAL, CKM_DES3_CBC_PAD, CKM_CDMF_KEY_GEN,
     * CKM_CDMF_ECB, CKM_CDMF_CBC, CKM_CDMF_MAC,
     * CKM_CDMF_MAC_GENERAL, and CKM_CDMF_CBC_PAD are new for v2.0 */
    public static final long CKM_DES3_MAC_GENERAL = 0x00000135;
    public static final long CKM_DES3_CBC_PAD = 0x00000136;
    public static final long CKM_CDMF_KEY_GEN = 0x00000140;
    public static final long CKM_CDMF_ECB = 0x00000141;
    public static final long CKM_CDMF_CBC = 0x00000142;
    public static final long CKM_CDMF_MAC = 0x00000143;
    public static final long CKM_CDMF_MAC_GENERAL = 0x00000144;
    public static final long CKM_CDMF_CBC_PAD = 0x00000145;

    /* the following four DES mechanisms are new for v2.20 */
    public static final long CKM_DES_OFB64 = 0x00000150;
    public static final long CKM_DES_OFB8 = 0x00000151;
    public static final long CKM_DES_CFB64 = 0x00000152;
    public static final long CKM_DES_CFB8 = 0x00000153;

    public static final long CKM_MD2 = 0x00000200;

    /* CKM_MD2_HMAC and CKM_MD2_HMAC_GENERAL are new for v2.0 */
    public static final long CKM_MD2_HMAC = 0x00000201;
    public static final long CKM_MD2_HMAC_GENERAL = 0x00000202;

    public static final long CKM_MD5 = 0x00000210;

    /* CKM_MD5_HMAC and CKM_MD5_HMAC_GENERAL are new for v2.0 */
    public static final long CKM_MD5_HMAC = 0x00000211;
    public static final long CKM_MD5_HMAC_GENERAL = 0x00000212;

    public static final long CKM_SHA_1 = 0x00000220;

    /* CKM_SHA_1_HMAC and CKM_SHA_1_HMAC_GENERAL are new for v2.0 */
    public static final long CKM_SHA_1_HMAC = 0x00000221;
    public static final long CKM_SHA_1_HMAC_GENERAL = 0x00000222;

    /* CKM_RIPEMD128, CKM_RIPEMD128_HMAC,
     * CKM_RIPEMD128_HMAC_GENERAL, CKM_RIPEMD160, CKM_RIPEMD160_HMAC,
     * and CKM_RIPEMD160_HMAC_GENERAL are new for v2.10 */
    public static final long CKM_RIPEMD128 = 0x00000230;
    public static final long CKM_RIPEMD128_HMAC = 0x00000231;
    public static final long CKM_RIPEMD128_HMAC_GENERAL = 0x00000232;
    public static final long CKM_RIPEMD160 = 0x00000240;
    public static final long CKM_RIPEMD160_HMAC = 0x00000241;
    public static final long CKM_RIPEMD160_HMAC_GENERAL = 0x00000242;

    /* CKM_SHA256/384/512 are new for v2.20 */
    public static final long CKM_SHA256 = 0x00000250;
    public static final long CKM_SHA256_HMAC = 0x00000251;
    public static final long CKM_SHA256_HMAC_GENERAL = 0x00000252;

    /* SHA-224 is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_SHA224 = 0x00000255;
    public static final long CKM_SHA224_HMAC = 0x00000256;
    public static final long CKM_SHA224_HMAC_GENERAL = 0x00000257;

    public static final long CKM_SHA384 = 0x00000260;
    public static final long CKM_SHA384_HMAC = 0x00000261;
    public static final long CKM_SHA384_HMAC_GENERAL = 0x00000262;
    public static final long CKM_SHA512 = 0x00000270;
    public static final long CKM_SHA512_HMAC = 0x00000271;
    public static final long CKM_SHA512_HMAC_GENERAL = 0x00000272;

    /* SecurID is new for PKCS #11 v2.20 amendment 1 */
    public static final long CKM_SECURID_KEY_GEN = 0x00000280;
    public static final long CKM_SECURID = 0x00000282;

    /* HOTP is new for PKCS #11 v2.20 amendment 1 */
    public static final long CKM_HOTP_KEY_GEN = 0x00000290;
    public static final long CKM_HOTP = 0x00000291;

    /* ACTI is new for PKCS #11 v2.20 amendment 1 */
    public static final long CKM_ACTI = 0x000002A0;
    public static final long CKM_ACTI_KEY_GEN = 0x000002A1;

    /* All of the following mechanisms are new for v2.0 */
    /* Note that CAST128 and CAST5 are the same algorithm */
    public static final long CKM_CAST_KEY_GEN = 0x00000300;
    public static final long CKM_CAST_ECB = 0x00000301;
    public static final long CKM_CAST_CBC = 0x00000302;
    public static final long CKM_CAST_MAC = 0x00000303;
    public static final long CKM_CAST_MAC_GENERAL = 0x00000304;
    public static final long CKM_CAST_CBC_PAD = 0x00000305;
    public static final long CKM_CAST3_KEY_GEN = 0x00000310;
    public static final long CKM_CAST3_ECB = 0x00000311;
    public static final long CKM_CAST3_CBC = 0x00000312;
    public static final long CKM_CAST3_MAC = 0x00000313;
    public static final long CKM_CAST3_MAC_GENERAL = 0x00000314;
    public static final long CKM_CAST3_CBC_PAD = 0x00000315;
    public static final long CKM_CAST5_KEY_GEN = 0x00000320;
    public static final long CKM_CAST128_KEY_GEN = 0x00000320;
    public static final long CKM_CAST5_ECB = 0x00000321;
    public static final long CKM_CAST128_ECB = 0x00000321;
    public static final long CKM_CAST5_CBC = 0x00000322;
    public static final long CKM_CAST128_CBC = 0x00000322;
    public static final long CKM_CAST5_MAC = 0x00000323;
    public static final long CKM_CAST128_MAC = 0x00000323;
    public static final long CKM_CAST5_MAC_GENERAL = 0x00000324;
    public static final long CKM_CAST128_MAC_GENERAL = 0x00000324;
    public static final long CKM_CAST5_CBC_PAD = 0x00000325;
    public static final long CKM_CAST128_CBC_PAD = 0x00000325;
    public static final long CKM_RC5_KEY_GEN = 0x00000330;
    public static final long CKM_RC5_ECB = 0x00000331;
    public static final long CKM_RC5_CBC = 0x00000332;
    public static final long CKM_RC5_MAC = 0x00000333;
    public static final long CKM_RC5_MAC_GENERAL = 0x00000334;
    public static final long CKM_RC5_CBC_PAD = 0x00000335;
    public static final long CKM_IDEA_KEY_GEN = 0x00000340;
    public static final long CKM_IDEA_ECB = 0x00000341;
    public static final long CKM_IDEA_CBC = 0x00000342;
    public static final long CKM_IDEA_MAC = 0x00000343;
    public static final long CKM_IDEA_MAC_GENERAL = 0x00000344;
    public static final long CKM_IDEA_CBC_PAD = 0x00000345;
    public static final long CKM_GENERIC_SECRET_KEY_GEN = 0x00000350;
    public static final long CKM_CONCATENATE_BASE_AND_KEY = 0x00000360;
    public static final long CKM_CONCATENATE_BASE_AND_DATA = 0x00000362;
    public static final long CKM_CONCATENATE_DATA_AND_BASE = 0x00000363;
    public static final long CKM_XOR_BASE_AND_DATA = 0x00000364;
    public static final long CKM_EXTRACT_KEY_FROM_KEY = 0x00000365;
    public static final long CKM_SSL3_PRE_MASTER_KEY_GEN = 0x00000370;
    public static final long CKM_SSL3_MASTER_KEY_DERIVE = 0x00000371;
    public static final long CKM_SSL3_KEY_AND_MAC_DERIVE = 0x00000372;

    /* CKM_SSL3_MASTER_KEY_DERIVE_DH, CKM_TLS_PRE_MASTER_KEY_GEN,
     * CKM_TLS_MASTER_KEY_DERIVE, CKM_TLS_KEY_AND_MAC_DERIVE, and
     * CKM_TLS_MASTER_KEY_DERIVE_DH are new for v2.11 */
    public static final long CKM_SSL3_MASTER_KEY_DERIVE_DH = 0x00000373;
    public static final long CKM_TLS_PRE_MASTER_KEY_GEN = 0x00000374;
    public static final long CKM_TLS_MASTER_KEY_DERIVE = 0x00000375;
    public static final long CKM_TLS_KEY_AND_MAC_DERIVE = 0x00000376;
    public static final long CKM_TLS_MASTER_KEY_DERIVE_DH = 0x00000377;

    /* CKM_TLS_PRF is new for v2.20 */
    public static final long CKM_TLS_PRF = 0x00000378;

    public static final long CKM_SSL3_MD5_MAC = 0x00000380;
    public static final long CKM_SSL3_SHA1_MAC = 0x00000381;
    public static final long CKM_MD5_KEY_DERIVATION = 0x00000390;
    public static final long CKM_MD2_KEY_DERIVATION = 0x00000391;
    public static final long CKM_SHA1_KEY_DERIVATION = 0x00000392;

    /* CKM_SHA256/384/512 are new for v2.20 */
    public static final long CKM_SHA256_KEY_DERIVATION = 0x00000393;
    public static final long CKM_SHA384_KEY_DERIVATION = 0x00000394;
    public static final long CKM_SHA512_KEY_DERIVATION = 0x00000395;

    /* SHA-224 key derivation is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_SHA224_KEY_DERIVATION = 0x00000396;

    public static final long CKM_PBE_MD2_DES_CBC = 0x000003A0;
    public static final long CKM_PBE_MD5_DES_CBC = 0x000003A1;
    public static final long CKM_PBE_MD5_CAST_CBC = 0x000003A2;
    public static final long CKM_PBE_MD5_CAST3_CBC = 0x000003A3;
    public static final long CKM_PBE_MD5_CAST5_CBC = 0x000003A4;
    public static final long CKM_PBE_MD5_CAST128_CBC = 0x000003A4;
    public static final long CKM_PBE_SHA1_CAST5_CBC = 0x000003A5;
    public static final long CKM_PBE_SHA1_CAST128_CBC = 0x000003A5;
    public static final long CKM_PBE_SHA1_RC4_128 = 0x000003A6;
    public static final long CKM_PBE_SHA1_RC4_40 = 0x000003A7;
    public static final long CKM_PBE_SHA1_DES3_EDE_CBC = 0x000003A8;
    public static final long CKM_PBE_SHA1_DES2_EDE_CBC = 0x000003A9;
    public static final long CKM_PBE_SHA1_RC2_128_CBC = 0x000003AA;
    public static final long CKM_PBE_SHA1_RC2_40_CBC = 0x000003AB;

    /* CKM_PKCS5_PBKD2 is new for v2.10 */
    public static final long CKM_PKCS5_PBKD2 = 0x000003B0;

    public static final long CKM_PBA_SHA1_WITH_SHA1_HMAC = 0x000003C0;

    /* WTLS mechanisms are new for v2.20 */
    public static final long CKM_WTLS_PRE_MASTER_KEY_GEN = 0x000003D0;
    public static final long CKM_WTLS_MASTER_KEY_DERIVE = 0x000003D1;
    public static final long CKM_WTLS_MASTER_KEY_DERIVE_DH_ECC = 0x000003D2;
    public static final long CKM_WTLS_PRF = 0x000003D3;
    public static final long CKM_WTLS_SERVER_KEY_AND_MAC_DERIVE = 0x000003D4;
    public static final long CKM_WTLS_CLIENT_KEY_AND_MAC_DERIVE = 0x000003D5;

    public static final long CKM_KEY_WRAP_LYNKS = 0x00000400;
    public static final long CKM_KEY_WRAP_SET_OAEP = 0x00000401;

    /* CKM_CMS_SIG is new for v2.20 */
    public static final long CKM_CMS_SIG = 0x00000500;

    /* CKM_KIP mechanisms are new for PKCS #11 v2.20 amendment 2 */
    public static final long CKM_KIP_DERIVE = 0x00000510;
    public static final long CKM_KIP_WRAP = 0x00000511;
    public static final long CKM_KIP_MAC = 0x00000512;

    /* Camellia is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_CAMELLIA_KEY_GEN = 0x00000550;
    public static final long CKM_CAMELLIA_ECB = 0x00000551;
    public static final long CKM_CAMELLIA_CBC = 0x00000552;
    public static final long CKM_CAMELLIA_MAC = 0x00000553;
    public static final long CKM_CAMELLIA_MAC_GENERAL = 0x00000554;
    public static final long CKM_CAMELLIA_CBC_PAD = 0x00000555;
    public static final long CKM_CAMELLIA_ECB_ENCRYPT_DATA = 0x00000556;
    public static final long CKM_CAMELLIA_CBC_ENCRYPT_DATA = 0x00000557;
    public static final long CKM_CAMELLIA_CTR = 0x00000558;

    /* ARIA is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_ARIA_KEY_GEN = 0x00000560;
    public static final long CKM_ARIA_ECB = 0x00000561;
    public static final long CKM_ARIA_CBC = 0x00000562;
    public static final long CKM_ARIA_MAC = 0x00000563;
    public static final long CKM_ARIA_MAC_GENERAL = 0x00000564;
    public static final long CKM_ARIA_CBC_PAD = 0x00000565;
    public static final long CKM_ARIA_ECB_ENCRYPT_DATA = 0x00000566;
    public static final long CKM_ARIA_CBC_ENCRYPT_DATA = 0x00000567;

    /* Fortezza mechanisms */
    public static final long CKM_SKIPJACK_KEY_GEN = 0x00001000;
    public static final long CKM_SKIPJACK_ECB64 = 0x00001001;
    public static final long CKM_SKIPJACK_CBC64 = 0x00001002;
    public static final long CKM_SKIPJACK_OFB64 = 0x00001003;
    public static final long CKM_SKIPJACK_CFB64 = 0x00001004;
    public static final long CKM_SKIPJACK_CFB32 = 0x00001005;
    public static final long CKM_SKIPJACK_CFB16 = 0x00001006;
    public static final long CKM_SKIPJACK_CFB8 = 0x00001007;
    public static final long CKM_SKIPJACK_WRAP = 0x00001008;
    public static final long CKM_SKIPJACK_PRIVATE_WRAP = 0x00001009;
    public static final long CKM_SKIPJACK_RELAYX = 0x0000100a;
    public static final long CKM_KEA_KEY_PAIR_GEN = 0x00001010;
    public static final long CKM_KEA_KEY_DERIVE = 0x00001011;
    public static final long CKM_FORTEZZA_TIMESTAMP = 0x00001020;
    public static final long CKM_BATON_KEY_GEN = 0x00001030;
    public static final long CKM_BATON_ECB128 = 0x00001031;
    public static final long CKM_BATON_ECB96 = 0x00001032;
    public static final long CKM_BATON_CBC128 = 0x00001033;
    public static final long CKM_BATON_COUNTER = 0x00001034;
    public static final long CKM_BATON_SHUFFLE = 0x00001035;
    public static final long CKM_BATON_WRAP = 0x00001036;

    /* CKM_ECDSA_KEY_PAIR_GEN is deprecated in v2.11,
     * CKM_EC_KEY_PAIR_GEN is preferred */
    public static final long CKM_ECDSA_KEY_PAIR_GEN = 0x00001040;
    public static final long CKM_EC_KEY_PAIR_GEN = 0x00001040;

    public static final long CKM_ECDSA = 0x00001041;
    public static final long CKM_ECDSA_SHA1 = 0x00001042;

    /* CKM_ECDH1_DERIVE, CKM_ECDH1_COFACTOR_DERIVE, and CKM_ECMQV_DERIVE
     * are new for v2.11 */
    public static final long CKM_ECDH1_DERIVE = 0x00001050;
    public static final long CKM_ECDH1_COFACTOR_DERIVE = 0x00001051;
    public static final long CKM_ECMQV_DERIVE = 0x00001052;

    public static final long CKM_JUNIPER_KEY_GEN = 0x00001060;
    public static final long CKM_JUNIPER_ECB128 = 0x00001061;
    public static final long CKM_JUNIPER_CBC128 = 0x00001062;
    public static final long CKM_JUNIPER_COUNTER = 0x00001063;
    public static final long CKM_JUNIPER_SHUFFLE = 0x00001064;
    public static final long CKM_JUNIPER_WRAP = 0x00001065;
    public static final long CKM_FASTHASH = 0x00001070;

    /* CKM_AES_KEY_GEN, CKM_AES_ECB, CKM_AES_CBC, CKM_AES_MAC,
     * CKM_AES_MAC_GENERAL, CKM_AES_CBC_PAD, CKM_DSA_PARAMETER_GEN,
     * CKM_DH_PKCS_PARAMETER_GEN, and CKM_X9_42_DH_PARAMETER_GEN are
     * new for v2.11 */
    public static final long CKM_AES_KEY_GEN = 0x00001080;
    public static final long CKM_AES_ECB = 0x00001081;
    public static final long CKM_AES_CBC = 0x00001082;
    public static final long CKM_AES_MAC = 0x00001083;
    public static final long CKM_AES_MAC_GENERAL = 0x00001084;
    public static final long CKM_AES_CBC_PAD = 0x00001085;

    /* AES counter mode is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKM_AES_CTR = 0x00001086;

    /* BlowFish and TwoFish are new for v2.20 */
    public static final long CKM_BLOWFISH_KEY_GEN = 0x00001090;
    public static final long CKM_BLOWFISH_CBC = 0x00001091;
    public static final long CKM_TWOFISH_KEY_GEN = 0x00001092;
    public static final long CKM_TWOFISH_CBC = 0x00001093;


    /* CKM_xxx_ENCRYPT_DATA mechanisms are new for v2.20 */
    public static final long CKM_DES_ECB_ENCRYPT_DATA = 0x00001100;
    public static final long CKM_DES_CBC_ENCRYPT_DATA = 0x00001101;
    public static final long CKM_DES3_ECB_ENCRYPT_DATA = 0x00001102;
    public static final long CKM_DES3_CBC_ENCRYPT_DATA = 0x00001103;
    public static final long CKM_AES_ECB_ENCRYPT_DATA = 0x00001104;
    public static final long CKM_AES_CBC_ENCRYPT_DATA = 0x00001105;

    public static final long CKM_DSA_PARAMETER_GEN = 0x00002000;
    public static final long CKM_DH_PKCS_PARAMETER_GEN = 0x00002001;
    public static final long CKM_X9_42_DH_PARAMETER_GEN = 0x00002002;

    public static final long CKM_VENDOR_DEFINED = 0x80000000;


    /* The flags are defined as follows:
     *      Bit Flag               Mask        Meaning */
    public static final long CKF_HW = 0x00000001;  /* performed by HW */

    /* The flags CKF_ENCRYPT, CKF_DECRYPT, CKF_DIGEST, CKF_SIGN,
     * CKG_SIGN_RECOVER, CKF_VERIFY, CKF_VERIFY_RECOVER,
     * CKF_GENERATE, CKF_GENERATE_KEY_PAIR, CKF_WRAP, CKF_UNWRAP,
     * and CKF_DERIVE are new for v2.0.  They specify whether or not
     * a mechanism can be used for a particular task */
    public static final long CKF_ENCRYPT = 0x00000100;
    public static final long CKF_DECRYPT = 0x00000200;
    public static final long CKF_DIGEST = 0x00000400;
    public static final long CKF_SIGN = 0x00000800;
    public static final long CKF_SIGN_RECOVER = 0x00001000;
    public static final long CKF_VERIFY = 0x00002000;
    public static final long CKF_VERIFY_RECOVER = 0x00004000;
    public static final long CKF_GENERATE = 0x00008000;
    public static final long CKF_GENERATE_KEY_PAIR = 0x00010000;
    public static final long CKF_WRAP = 0x00020000;
    public static final long CKF_UNWRAP = 0x00040000;
    public static final long CKF_DERIVE = 0x00080000;

    /* CKF_EC_F_P, CKF_EC_F_2M, CKF_EC_ECPARAMETERS, CKF_EC_NAMEDCURVE,
     * CKF_EC_UNCOMPRESS, and CKF_EC_COMPRESS are new for v2.11. They
     * describe a token's EC capabilities not available in mechanism
     * information. */
    public static final long CKF_EC_F_P = 0x00100000;
    public static final long CKF_EC_F_2M = 0x00200000;
    public static final long CKF_EC_ECPARAMETERS = 0x00400000;
    public static final long CKF_EC_NAMEDCURVE = 0x00800000;
    public static final long CKF_EC_UNCOMPRESS = 0x01000000;
    public static final long CKF_EC_COMPRESS = 0x02000000;

    public static final long CKF_EXTENSION = 0x80000000; /* FALSE for this version */

    public static final long CKR_OK = 0x00000000;
    public static final long CKR_CANCEL = 0x00000001;
    public static final long CKR_HOST_MEMORY = 0x00000002;
    public static final long CKR_SLOT_ID_INVALID = 0x00000003;

    /* CKR_FLAGS_INVALID was removed for v2.0 */

    /* CKR_GENERAL_ERROR and CKR_FUNCTION_FAILED are new for v2.0 */
    public static final long CKR_GENERAL_ERROR = 0x00000005;
    public static final long CKR_FUNCTION_FAILED = 0x00000006;

    /* CKR_ARGUMENTS_BAD, CKR_NO_EVENT, CKR_NEED_TO_CREATE_THREADS,
     * and CKR_CANT_LOCK are new for v2.01 */
    public static final long CKR_ARGUMENTS_BAD = 0x00000007;
    public static final long CKR_NO_EVENT = 0x00000008;
    public static final long CKR_NEED_TO_CREATE_THREADS = 0x00000009;
    public static final long CKR_CANT_LOCK = 0x0000000A;

    public static final long CKR_ATTRIBUTE_READ_ONLY = 0x00000010;
    public static final long CKR_ATTRIBUTE_SENSITIVE = 0x00000011;
    public static final long CKR_ATTRIBUTE_TYPE_INVALID = 0x00000012;
    public static final long CKR_ATTRIBUTE_VALUE_INVALID = 0x00000013;
    public static final long CKR_DATA_INVALID = 0x00000020;
    public static final long CKR_DATA_LEN_RANGE = 0x00000021;
    public static final long CKR_DEVICE_ERROR = 0x00000030;
    public static final long CKR_DEVICE_MEMORY = 0x00000031;
    public static final long CKR_DEVICE_REMOVED = 0x00000032;
    public static final long CKR_ENCRYPTED_DATA_INVALID = 0x00000040;
    public static final long CKR_ENCRYPTED_DATA_LEN_RANGE = 0x00000041;
    public static final long CKR_FUNCTION_CANCELED = 0x00000050;
    public static final long CKR_FUNCTION_NOT_PARALLEL = 0x00000051;

    /* CKR_FUNCTION_NOT_SUPPORTED is new for v2.0 */
    public static final long CKR_FUNCTION_NOT_SUPPORTED = 0x00000054;

    public static final long CKR_KEY_HANDLE_INVALID = 0x00000060;

    /* CKR_KEY_SENSITIVE was removed for v2.0 */

    public static final long CKR_KEY_SIZE_RANGE = 0x00000062;
    public static final long CKR_KEY_TYPE_INCONSISTENT = 0x00000063;

    /* CKR_KEY_NOT_NEEDED, CKR_KEY_CHANGED, CKR_KEY_NEEDED,
     * CKR_KEY_INDIGESTIBLE, CKR_KEY_FUNCTION_NOT_PERMITTED,
     * CKR_KEY_NOT_WRAPPABLE, and CKR_KEY_UNEXTRACTABLE are new for
     * v2.0 */
    public static final long CKR_KEY_NOT_NEEDED = 0x00000064;
    public static final long CKR_KEY_CHANGED = 0x00000065;
    public static final long CKR_KEY_NEEDED = 0x00000066;
    public static final long CKR_KEY_INDIGESTIBLE = 0x00000067;
    public static final long CKR_KEY_FUNCTION_NOT_PERMITTED = 0x00000068;
    public static final long CKR_KEY_NOT_WRAPPABLE = 0x00000069;
    public static final long CKR_KEY_UNEXTRACTABLE = 0x0000006A;

    public static final long CKR_MECHANISM_INVALID = 0x00000070;
    public static final long CKR_MECHANISM_PARAM_INVALID = 0x00000071;

    /* CKR_OBJECT_CLASS_INCONSISTENT and CKR_OBJECT_CLASS_INVALID
     * were removed for v2.0 */
    public static final long CKR_OBJECT_HANDLE_INVALID = 0x00000082;
    public static final long CKR_OPERATION_ACTIVE = 0x00000090;
    public static final long CKR_OPERATION_NOT_INITIALIZED = 0x00000091;
    public static final long CKR_PIN_INCORRECT = 0x000000A0;
    public static final long CKR_PIN_INVALID = 0x000000A1;
    public static final long CKR_PIN_LEN_RANGE = 0x000000A2;

    /* CKR_PIN_EXPIRED and CKR_PIN_LOCKED are new for v2.0 */
    public static final long CKR_PIN_EXPIRED = 0x000000A3;
    public static final long CKR_PIN_LOCKED = 0x000000A4;

    public static final long CKR_SESSION_CLOSED = 0x000000B0;
    public static final long CKR_SESSION_COUNT = 0x000000B1;
    public static final long CKR_SESSION_HANDLE_INVALID = 0x000000B3;
    public static final long CKR_SESSION_PARALLEL_NOT_SUPPORTED = 0x000000B4;
    public static final long CKR_SESSION_READ_ONLY = 0x000000B5;
    public static final long CKR_SESSION_EXISTS = 0x000000B6;

    /* CKR_SESSION_READ_ONLY_EXISTS and
     * CKR_SESSION_READ_WRITE_SO_EXISTS are new for v2.0 */
    public static final long CKR_SESSION_READ_ONLY_EXISTS = 0x000000B7;
    public static final long CKR_SESSION_READ_WRITE_SO_EXISTS = 0x000000B8;

    public static final long CKR_SIGNATURE_INVALID = 0x000000C0;
    public static final long CKR_SIGNATURE_LEN_RANGE = 0x000000C1;
    public static final long CKR_TEMPLATE_INCOMPLETE = 0x000000D0;
    public static final long CKR_TEMPLATE_INCONSISTENT = 0x000000D1;
    public static final long CKR_TOKEN_NOT_PRESENT = 0x000000E0;
    public static final long CKR_TOKEN_NOT_RECOGNIZED = 0x000000E1;
    public static final long CKR_TOKEN_WRITE_PROTECTED = 0x000000E2;
    public static final long CKR_UNWRAPPING_KEY_HANDLE_INVALID = 0x000000F0;
    public static final long CKR_UNWRAPPING_KEY_SIZE_RANGE = 0x000000F1;
    public static final long CKR_UNWRAPPING_KEY_TYPE_INCONSISTENT = 0x000000F2;
    public static final long CKR_USER_ALREADY_LOGGED_IN = 0x00000100;
    public static final long CKR_USER_NOT_LOGGED_IN = 0x00000101;
    public static final long CKR_USER_PIN_NOT_INITIALIZED = 0x00000102;
    public static final long CKR_USER_TYPE_INVALID = 0x00000103;

    /* CKR_USER_ANOTHER_ALREADY_LOGGED_IN and CKR_USER_TOO_MANY_TYPES
     * are new for v2.01 */
    public static final long CKR_USER_ANOTHER_ALREADY_LOGGED_IN = 0x00000104;
    public static final long CKR_USER_TOO_MANY_TYPES = 0x00000105;

    public static final long CKR_WRAPPED_KEY_INVALID = 0x00000110;
    public static final long CKR_WRAPPED_KEY_LEN_RANGE = 0x00000112;
    public static final long CKR_WRAPPING_KEY_HANDLE_INVALID = 0x00000113;
    public static final long CKR_WRAPPING_KEY_SIZE_RANGE = 0x00000114;
    public static final long CKR_WRAPPING_KEY_TYPE_INCONSISTENT = 0x00000115;
    public static final long CKR_RANDOM_SEED_NOT_SUPPORTED = 0x00000120;

    /* This is new for v2.0 */
    public static final long CKR_RANDOM_NO_RNG = 0x00000121;

    /* This is new for v2.11 */
    public static final long CKR_DOMAIN_PARAMS_INVALID = 0x00000130;

    /* These are new for v2.0 */
    public static final long CKR_BUFFER_TOO_SMALL = 0x00000150;
    public static final long CKR_SAVED_STATE_INVALID = 0x00000160;
    public static final long CKR_INFORMATION_SENSITIVE = 0x00000170;
    public static final long CKR_STATE_UNSAVEABLE = 0x00000180;

    /* These are new for v2.01 */
    public static final long CKR_CRYPTOKI_NOT_INITIALIZED = 0x00000190;
    public static final long CKR_CRYPTOKI_ALREADY_INITIALIZED = 0x00000191;
    public static final long CKR_MUTEX_BAD = 0x000001A0;
    public static final long CKR_MUTEX_NOT_LOCKED = 0x000001A1;

    /* The following return values are new for PKCS #11 v2.20 amendment 3 */
    public static final long CKR_NEW_PIN_MODE = 0x000001B0;
    public static final long CKR_NEXT_OTP = 0x000001B1;

    /* This is new for v2.20 */
    public static final long CKR_FUNCTION_REJECTED = 0x00000200;

    public static final long CKR_VENDOR_DEFINED = 0x80000000;

    /* flags: bit flags that provide capabilities of the slot
     *      Bit Flag                           Mask       Meaning
     */
    public static final long CKF_LIBRARY_CANT_CREATE_OS_THREADS = 0x00000001;
    public static final long CKF_OS_LOCKING_OK = 0x00000002;


    /* CKF_DONT_BLOCK is for the function C_WaitForSlotEvent */
    public static final long CKF_DONT_BLOCK = 1;

    /* The following MGFs are defined */
    /* CKG_MGF1_SHA256, CKG_MGF1_SHA384, and CKG_MGF1_SHA512
     * are new for v2.20 */
    public static final long CKG_MGF1_SHA1 = 0x00000001;
    public static final long CKG_MGF1_SHA256 = 0x00000002;
    public static final long CKG_MGF1_SHA384 = 0x00000003;
    public static final long CKG_MGF1_SHA512 = 0x00000004;
    /* SHA-224 is new for PKCS #11 v2.20 amendment 3 */
    public static final long CKG_MGF1_SHA224 = 0x00000005;

    /* The following encoding parameter sources are defined */
    public static final long CKZ_DATA_SPECIFIED = 0x00000001;

    /* The following EC Key Derivation Functions are defined */
    public static final long CKD_NULL = 0x00000001;
    public static final long CKD_SHA1_KDF = 0x00000002;

    /* The following X9.42 DH key derivation functions are defined
       (besides CKD_NULL already defined : */
    public static final long CKD_SHA1_KDF_ASN1 = 0x00000003;
    public static final long CKD_SHA1_KDF_CONCATENATE = 0x00000004;

    /* The following PRFs are defined in PKCS #5 v2.0. */
    public static final long CKP_PKCS5_PBKD2_HMAC_SHA1 = 0x00000001;

    /* The following salt value sources are defined in PKCS #5 v2.0. */
    public static final long CKZ_SALT_SPECIFIED = 0x00000001;

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1 */
    public static final long CK_OTP_VALUE = 0;
    public static final long CK_OTP_PIN = 1;
    public static final long CK_OTP_CHALLENGE = 2;
    public static final long CK_OTP_TIME = 3;
    public static final long CK_OTP_COUNTER = 4;
    public static final long CK_OTP_FLAGS = 5;
    public static final long CK_OTP_OUTPUT_LENGTH = 6;
    public static final long CK_OTP_OUTPUT_FORMAT = 7;

    /* The following OTP-related defines are new for PKCS #11 v2.20 amendment 1 */
    public static final long CKF_NEXT_OTP = 0x00000001;
    public static final long CKF_EXCLUDE_TIME = 0x00000002;
    public static final long CKF_EXCLUDE_COUNTER = 0x00000004;
    public static final long CKF_EXCLUDE_CHALLENGE = 0x00000008;
    public static final long CKF_EXCLUDE_PIN = 0x00000010;
    public static final long CKF_USER_FRIENDLY_OTP = 0x00000020;

    private Pkcs11Constants() {
    }
}
