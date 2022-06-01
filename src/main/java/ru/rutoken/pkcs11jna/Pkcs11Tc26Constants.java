/*
 * Copyright (c) 2022, Aktiv-Soft JSC. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKA_GOSTR3410_PARAMS;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKK_GOSTR3410;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOST28147_KEY_GEN;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOSTR3410;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOSTR3410_KEY_PAIR_GEN;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOSTR3410_WITH_GOSTR3411;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOSTR3411;
import static ru.rutoken.pkcs11jna.Pkcs11Constants.CKM_GOSTR3411_HMAC;

/* Derived from pkcs11tc26_12.h and pkcs11tc26_18.h include files for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

public final class Pkcs11Tc26Constants {
    /**
     * 0x80000000 | 0x54321000.
     */
    public static final long NSSCK_VENDOR_PKCS11_RU_TEAM = 0xD4321000L;
    public static final long CK_VENDOR_PKCS11_RU_TEAM_TC26 = NSSCK_VENDOR_PKCS11_RU_TEAM;

    /* GOST KEY TYPES */
    public static final long CKK_GOSTR3410_256 = CKK_GOSTR3410;
    public static final long CKK_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x003L);

    public static final long CKK_KUZNECHIK = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x004L);
    public static final long CKK_KUZNYECHIK = CKK_KUZNECHIK;
    public static final long CKK_MAGMA = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x005L);
    public static final long CKK_KUZNECHIK_TWIN_KEY = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x006L);
    public static final long CKK_KUZNYECHIK_TWIN_KEY = CKK_KUZNECHIK_TWIN_KEY;
    public static final long CKK_MAGMA_TWIN_KEY = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x007L);

    /* GOST OBJECT ATTRIBUTES */
    public static final long CKA_GOSTR3410_256PARAMS = CKA_GOSTR3410_PARAMS;

    /* PKCS #5 PRF Functions */
    public static final long CKP_PKCS5_PBKD2_HMAC_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x003L);

    /* GOST MECHANISMS */
    public static final long CKM_GOSTR3410_256_KEY_PAIR_GEN = CKM_GOSTR3410_KEY_PAIR_GEN;
    public static final long CKM_GOSTR3410_512_KEY_PAIR_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x005L);
    public static final long CKM_GOSTR3410_256 = CKM_GOSTR3410;
    public static final long CKM_GOSTR3410_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x006L);
    public static final long CKM_GOSTR3410_2012_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x007L);
    public static final long CKM_GOSTR3410_12_DERIVE = CKM_GOSTR3410_2012_DERIVE;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_94 = CKM_GOSTR3410_WITH_GOSTR3411;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x008L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x009L);
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_256 = CKM_GOSTR3410_WITH_GOSTR3411_2012_256;
    public static final long CKM_GOSTR3410_WITH_GOSTR3411_12_512 = CKM_GOSTR3410_WITH_GOSTR3411_2012_512;
    public static final long CKM_GOSTR3410_PUBLIC_KEY_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x00AL);
    public static final long CKM_GOSTR3410_512_PUBLIC_KEY_DERIVE = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x00BL);

    public static final long CKM_GOSTR3411_94 = CKM_GOSTR3411;
    public static final long CKM_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x012L);
    public static final long CKM_GOSTR3411_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x013L);
    public static final long CKM_GOSTR3411_12_256 = CKM_GOSTR3411_2012_256;
    public static final long CKM_GOSTR3411_12_512 = CKM_GOSTR3411_2012_512;
    public static final long CKM_GOSTR3411_94_HMAC = CKM_GOSTR3411_HMAC;
    public static final long CKM_GOSTR3411_2012_256_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x014L);
    public static final long CKM_GOSTR3411_2012_512_HMAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x015L);
    public static final long CKM_GOSTR3411_12_256_HMAC = CKM_GOSTR3411_2012_256_HMAC;
    public static final long CKM_GOSTR3411_12_512_HMAC = CKM_GOSTR3411_2012_512_HMAC;

    public static final long CKM_TLS_GOST_PRF_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x016L);
    public static final long CKM_TLS_GOST_PRF_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x017L);
    public static final long CKM_TLS_GOST_PRE_MASTER_KEY_GEN = CKM_GOST28147_KEY_GEN;
    public static final long CKM_TLS_GOST_MASTER_KEY_DERIVE_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x018L);

    public static final long CKM_KDF_4357 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x025L);
    public static final long CKM_KDF_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x026L);

    public static final long CKM_KDF_HMAC3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x028L);
    public static final long CKM_KDF_TREE_GOSTR3411_2012_256 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02AL);
    public static final long KDF_TREE_GOSTR3411_2012_256 = CKM_KDF_TREE_GOSTR3411_2012_256;

    public static final long CKM_KUZNECHIK_KEXP_15_WRAP = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02BL);
    public static final long CKM_KUZNYECHIK_KEXP_15_WRAP = CKM_KUZNECHIK_KEXP_15_WRAP;
    public static final long CKM_MAGMA_KEXP_15_WRAP = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02CL);
    public static final long CKM_KUZNECHIK_MGM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02DL);
    public static final long CKM_KUZNYECHIK_MGM = CKM_KUZNECHIK_MGM;
    public static final long CKM_MAGMA_MGM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x02EL);

    public static final long CKM_KUZNECHIK_KEY_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x030L);
    public static final long CKM_KUZNYECHIK_KEY_GEN = CKM_KUZNECHIK_KEY_GEN;
    public static final long CKM_KUZNECHIK_ECB = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x031L);
    public static final long CKM_KUZNYECHIK_ECB = CKM_KUZNECHIK_ECB;
    public static final long CKM_KUZNECHIK_CTR_ACPKM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x032L);
    public static final long CKM_KUZNYECHIK_CTR_ACPKM = CKM_KUZNECHIK_CTR_ACPKM;
    public static final long CKM_KUZNECHIK_MAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x033L);
    public static final long CKM_KUZNYECHIK_MAC = CKM_KUZNECHIK_MAC;

    public static final long CKM_MAGMA_KEY_GEN = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x034L);
    public static final long CKM_MAGMA_ECB = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x035L);
    public static final long CKM_MAGMA_CTR_ACPKM = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x036L);
    public static final long CKM_MAGMA_MAC = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x037L);

    public static final long CKM_VKO_GOSTR3410_2012_512 = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x038L);
    public static final long CKM_GOST_KEG = (CK_VENDOR_PKCS11_RU_TEAM_TC26 | 0x039L);

    private Pkcs11Tc26Constants() {
    }
}
