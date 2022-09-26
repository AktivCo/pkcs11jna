/*
 * Copyright (c) 2019, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;

import com.sun.jna.Pointer;
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
    public CK_VERSION version;
    public Pointer C_Initialize;
    public Pointer C_Finalize;
    public Pointer C_GetInfo;
    public Pointer C_GetFunctionList;
    public Pointer C_GetSlotList;
    public Pointer C_GetSlotInfo;
    public Pointer C_GetTokenInfo;
    public Pointer C_GetMechanismList;
    public Pointer C_GetMechanismInfo;
    public Pointer C_InitToken;
    public Pointer C_InitPIN;
    public Pointer C_SetPIN;
    public Pointer C_OpenSession;
    public Pointer C_CloseSession;
    public Pointer C_CloseAllSessions;
    public Pointer C_GetSessionInfo;
    public Pointer C_GetOperationState;
    public Pointer C_SetOperationState;
    public Pointer C_Login;
    public Pointer C_Logout;
    public Pointer C_CreateObject;
    public Pointer C_CopyObject;
    public Pointer C_DestroyObject;
    public Pointer C_GetObjectSize;
    public Pointer C_GetAttributeValue;
    public Pointer C_SetAttributeValue;
    public Pointer C_FindObjectsInit;
    public Pointer C_FindObjects;
    public Pointer C_FindObjectsFinal;
    public Pointer C_EncryptInit;
    public Pointer C_Encrypt;
    public Pointer C_EncryptUpdate;
    public Pointer C_EncryptFinal;
    public Pointer C_DecryptInit;
    public Pointer C_Decrypt;
    public Pointer C_DecryptUpdate;
    public Pointer C_DecryptFinal;
    public Pointer C_DigestInit;
    public Pointer C_Digest;
    public Pointer C_DigestUpdate;
    public Pointer C_DigestKey;
    public Pointer C_DigestFinal;
    public Pointer C_SignInit;
    public Pointer C_Sign;
    public Pointer C_SignUpdate;
    public Pointer C_SignFinal;
    public Pointer C_SignRecoverInit;
    public Pointer C_SignRecover;
    public Pointer C_VerifyInit;
    public Pointer C_Verify;
    public Pointer C_VerifyUpdate;
    public Pointer C_VerifyFinal;
    public Pointer C_VerifyRecoverInit;
    public Pointer C_VerifyRecover;
    public Pointer C_DigestEncryptUpdate;
    public Pointer C_DecryptDigestUpdate;
    public Pointer C_SignEncryptUpdate;
    public Pointer C_DecryptVerifyUpdate;
    public Pointer C_GenerateKey;
    public Pointer C_GenerateKeyPair;
    public Pointer C_WrapKey;
    public Pointer C_UnwrapKey;
    public Pointer C_DeriveKey;
    public Pointer C_SeedRandom;
    public Pointer C_GenerateRandom;
    public Pointer C_GetFunctionStatus;
    public Pointer C_CancelFunction;
    public Pointer C_WaitForSlotEvent;

    public CK_FUNCTION_LIST() {
        super();
    }

    public CK_FUNCTION_LIST(Pointer pStruct) {
        super(pStruct);
        read();
    }
}
