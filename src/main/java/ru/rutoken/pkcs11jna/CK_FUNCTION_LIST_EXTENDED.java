/*
 * Copyright (c) 2022, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({"version", "C_EX_GetFunctionListExtended", "C_EX_InitToken", "C_EX_GetTokenInfoExtended",
        "C_EX_UnblockUserPIN", "C_EX_SetTokenName", "C_EX_SetLicense", "C_EX_GetLicense", "C_EX_GetCertificateInfoText",
        "C_EX_PKCS7Sign", "C_EX_CreateCSR", "C_EX_FreeBuffer", "C_EX_GetTokenName", "C_EX_SetLocalPIN",
        "C_EX_LoadActivationKey", "C_EX_SetActivationPassword", "C_EX_GetVolumesInfo", "C_EX_GetDriveSize",
        "C_EX_ChangeVolumeAttributes", "C_EX_FormatDrive", "C_EX_TokenManage", "C_EX_GenerateActivationPassword",
        "C_EX_GetJournal", "C_EX_SignInvisibleInit", "C_EX_SignInvisible", "C_EX_SlotManage", "C_EX_WrapKey",
        "C_EX_UnwrapKey", "C_EX_PKCS7VerifyInit", "C_EX_PKCS7Verify", "C_EX_PKCS7VerifyUpdate",
        "C_EX_PKCS7VerifyFinal"})
public class CK_FUNCTION_LIST_EXTENDED extends Pkcs11Structure {
    public CK_VERSION version;
    public Pointer C_EX_GetFunctionListExtended;
    public Pointer C_EX_InitToken;
    public Pointer C_EX_GetTokenInfoExtended;
    public Pointer C_EX_UnblockUserPIN;
    public Pointer C_EX_SetTokenName;
    public Pointer C_EX_SetLicense;
    public Pointer C_EX_GetLicense;
    public Pointer C_EX_GetCertificateInfoText;
    public Pointer C_EX_PKCS7Sign;
    public Pointer C_EX_CreateCSR;
    public Pointer C_EX_FreeBuffer;
    public Pointer C_EX_GetTokenName;
    public Pointer C_EX_SetLocalPIN;
    public Pointer C_EX_LoadActivationKey;
    public Pointer C_EX_SetActivationPassword;
    public Pointer C_EX_GetVolumesInfo;
    public Pointer C_EX_GetDriveSize;
    public Pointer C_EX_ChangeVolumeAttributes;
    public Pointer C_EX_FormatDrive;
    public Pointer C_EX_TokenManage;
    public Pointer C_EX_GenerateActivationPassword;
    public Pointer C_EX_GetJournal;
    public Pointer C_EX_SignInvisibleInit;
    public Pointer C_EX_SignInvisible;
    public Pointer C_EX_SlotManage;
    public Pointer C_EX_WrapKey;
    public Pointer C_EX_UnwrapKey;
    public Pointer C_EX_PKCS7VerifyInit;
    public Pointer C_EX_PKCS7Verify;
    public Pointer C_EX_PKCS7VerifyUpdate;
    public Pointer C_EX_PKCS7VerifyFinal;

    public CK_FUNCTION_LIST_EXTENDED() {
        super();
    }

    public CK_FUNCTION_LIST_EXTENDED(Pointer pStruct) {
        super(pStruct);
        read();
    }
}
