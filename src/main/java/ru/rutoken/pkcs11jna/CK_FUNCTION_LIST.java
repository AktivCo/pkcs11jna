/*
 * Copyright (c) 2019, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Function;
import com.sun.jna.Structure;

@Structure.FieldOrder({"version", "C_Initialize", "C_Finalize", "C_GetInfo", "C_GetFunctionList", "C_GetSlotList",
        "C_GetSlotInfo", "C_GetTokenInfo", "C_GetMechanismList", "C_GetMechanismInfo", "C_InitToken", "C_InitPIN",
        "C_SetPIN", "C_OpenSession", "C_CloseSession", "C_CloseAllSessions", "C_GetSessionInfo", "C_GetOperationState",
        "C_SetOperationState", "C_Login", "C_Logout", "C_CreateObject", "C_CopyObject", "C_DestroyObject", "C_GetObjectSize",
        "C_GetAttributeValue", "C_SetAttributeValue", "C_FindObjectsInit", "C_FindObjects", "C_FindObjectsFinal",
        "C_EncryptInit", "C_Encrypt", "C_EncryptUpdate", "C_EncryptFinal", "C_DecryptInit", "C_Decrypt", "C_DecryptUpdate",
        "C_DecryptFinal", "C_DigestInit", "C_Digest", "C_DigestUpdate", "C_DigestKey", "C_DigestFinal", "C_SignInit",
        "C_Sign", "C_SignUpdate", "C_SignFinal", "C_SignRecoverInit", "C_SignRecover", "C_VerifyInit", "C_Verify",
        "C_VerifyUpdate", "C_VerifyFinal", "C_VerifyRecoverInit", "C_VerifyRecover", "C_DigestEncryptUpdate",
        "C_DecryptDigestUpdate", "C_SignEncryptUpdate", "C_DecryptVerifyUpdate", "C_GenerateKey", "C_GenerateKeyPair",
        "C_WrapKey", "C_UnwrapKey", "C_DeriveKey", "C_SeedRandom", "C_GenerateRandom", "C_GetFunctionStatus",
        "C_CancelFunction", "C_WaitForSlotEvent"})
public class CK_FUNCTION_LIST extends Pkcs11Structure {
    public CK_VERSION.ByReference version;
    public Function C_Initialize;
    public Function C_Finalize;
    public Function C_GetInfo;
    public Function C_GetFunctionList;
    public Function C_GetSlotList;
    public Function C_GetSlotInfo;
    public Function C_GetTokenInfo;
    public Function C_GetMechanismList;
    public Function C_GetMechanismInfo;
    public Function C_InitToken;
    public Function C_InitPIN;
    public Function C_SetPIN;
    public Function C_OpenSession;
    public Function C_CloseSession;
    public Function C_CloseAllSessions;
    public Function C_GetSessionInfo;
    public Function C_GetOperationState;
    public Function C_SetOperationState;
    public Function C_Login;
    public Function C_Logout;
    public Function C_CreateObject;
    public Function C_CopyObject;
    public Function C_DestroyObject;
    public Function C_GetObjectSize;
    public Function C_GetAttributeValue;
    public Function C_SetAttributeValue;
    public Function C_FindObjectsInit;
    public Function C_FindObjects;
    public Function C_FindObjectsFinal;
    public Function C_EncryptInit;
    public Function C_Encrypt;
    public Function C_EncryptUpdate;
    public Function C_EncryptFinal;
    public Function C_DecryptInit;
    public Function C_Decrypt;
    public Function C_DecryptUpdate;
    public Function C_DecryptFinal;
    public Function C_DigestInit;
    public Function C_Digest;
    public Function C_DigestUpdate;
    public Function C_DigestKey;
    public Function C_DigestFinal;
    public Function C_SignInit;
    public Function C_Sign;
    public Function C_SignUpdate;
    public Function C_SignFinal;
    public Function C_SignRecoverInit;
    public Function C_SignRecover;
    public Function C_VerifyInit;
    public Function C_Verify;
    public Function C_VerifyUpdate;
    public Function C_VerifyFinal;
    public Function C_VerifyRecoverInit;
    public Function C_VerifyRecover;
    public Function C_DigestEncryptUpdate;
    public Function C_DecryptDigestUpdate;
    public Function C_SignEncryptUpdate;
    public Function C_DecryptVerifyUpdate;
    public Function C_GenerateKey;
    public Function C_GenerateKeyPair;
    public Function C_WrapKey;
    public Function C_UnwrapKey;
    public Function C_DeriveKey;
    public Function C_SeedRandom;
    public Function C_GenerateRandom;
    public Function C_GetFunctionStatus;
    public Function C_CancelFunction;
    public Function C_WaitForSlotEvent;
}
