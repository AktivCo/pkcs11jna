/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;
/* Derived from pkcs11f.h include file for PKCS #11. */

/* Copyright (c) OASIS Open 2016. All Rights Reserved./
 * /Distributed under the terms of the OASIS IPR Policy,
 * [http://www.oasis-open.org/policies-guidelines/ipr], AS-IS, WITHOUT ANY
 * IMPLIED OR EXPRESS WARRANTY; there is no warranty of MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE or NONINFRINGEMENT of the rights of others.
 */

/* Latest version of the specification:
 * http://docs.oasis-open.org/pkcs11/pkcs11-base/v2.40/pkcs11-base-v2.40.html
 */

/* This header file contains pretty much everything about all the
 * Cryptoki function prototypes.  Because this information is
 * used for more than just declaring function prototypes, the
 * order of the functions appearing herein is important, and
 * should not be altered.
 */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;

public interface Pkcs11 extends Library {
    /* General-purpose */

    /**
     * C_Initialize initializes the Cryptoki library.
     *
     * @param pInitArgs nullable initialization arguments
     */
    NativeLong C_Initialize(CK_C_INITIALIZE_ARGS pInitArgs);

    /**
     * C_Finalize indicates that an application is done with the Cryptoki library.
     *
     * @param pReserved reserved. Should be null
     */
    NativeLong C_Finalize(Pointer pReserved);

    /**
     * C_GetInfo returns general information about Cryptoki.
     *
     * @param pInfo location that receives information
     */
    NativeLong C_GetInfo(CK_INFO pInfo);

    /**
     * C_GetFunctionList returns the function list.
     *
     * @param ppFunctionList receives pointer to function list
     */
    NativeLong C_GetFunctionList(PointerByReference ppFunctionList);

    /* Slot and token management */

    /**
     * C_GetSlotList obtains a list of slots in the system.
     *
     * @param tokenPresent only slots with tokens
     * @param pSlotList    receives array of slot IDs
     * @param pulCount     receives number of slots
     */
    NativeLong C_GetSlotList(byte tokenPresent, NativeLong[] pSlotList, NativeLongByReference pulCount);

    /**
     * C_GetSlotInfo obtains information about a particular slot in the system.
     *
     * @param slotID the ID of the slot
     * @param pInfo  receives the slot information
     */
    NativeLong C_GetSlotInfo(NativeLong slotID, CK_SLOT_INFO pInfo);

    /**
     * C_GetTokenInfo obtains information about a particular token in the system.
     *
     * @param slotID ID of the token's slot
     * @param pInfo  receives the token information
     */
    NativeLong C_GetTokenInfo(NativeLong slotID, CK_TOKEN_INFO pInfo);

    /**
     * C_GetMechanismList obtains a list of mechanism types supported by a token.
     *
     * @param slotID         ID of token's slot
     * @param pMechanismList gets mech. array
     * @param pulCount       gets # of mechs.
     */
    NativeLong C_GetMechanismList(NativeLong slotID, NativeLong[] pMechanismList, NativeLongByReference pulCount);

    /**
     * C_GetMechanismInfo obtains information about a particular mechanism possibly supported by a token.
     *
     * @param slotID ID of the token's slot
     * @param type   type of mechanism
     * @param pInfo  receives mechanism info
     */
    NativeLong C_GetMechanismInfo(NativeLong slotID, NativeLong type, CK_MECHANISM_INFO pInfo);

    /**
     * C_InitToken initializes a token.
     *
     * @param slotID   ID of the token's slot
     * @param pPin     the SO's initial PIN
     * @param ulPinLen length in bytes of the PIN
     * @param pLabel   32-byte token label (blank padded)
     */
    NativeLong C_InitToken(NativeLong slotID, byte[] pPin, NativeLong ulPinLen, byte[] pLabel);

    /**
     * C_InitPIN initializes the normal user's PIN.
     *
     * @param hSession the session's handle
     * @param pPin     the normal user's PIN
     * @param ulPinLen length in bytes of the PIN
     */
    NativeLong C_InitPIN(NativeLong hSession, byte[] pPin, NativeLong ulPinLen);

    /**
     * C_SetPIN modifies the PIN of the user who is logged in.
     *
     * @param hSession the session's handle
     * @param pOldPin  the old PIN
     * @param ulOldLen length of the old PIN
     * @param pNewPin  the new PIN
     * @param ulNewLen length of the new PIN
     */
    NativeLong C_SetPIN(
            NativeLong hSession,
            byte[] pOldPin,
            NativeLong ulOldLen,
            byte[] pNewPin,
            NativeLong ulNewLen
    );

    /* Session management */

    /**
     * C_OpenSession opens a session between an application and a token.
     *
     * @param slotID       the slot's ID
     * @param flags        from CK_SESSION_INFO
     * @param pApplication passed to callback
     * @param Notify       callback function
     * @param phSession    gets session handle
     */
    NativeLong C_OpenSession(
            NativeLong slotID,
            NativeLong flags,
            Pointer pApplication,
            Callback Notify,
            NativeLongByReference phSession
    );

    /**
     * C_CloseSession closes a session between an application and a token.
     *
     * @param hSession the session's handle
     */
    NativeLong C_CloseSession(NativeLong hSession);

    /**
     * C_CloseAllSessions closes all sessions with a token.
     *
     * @param slotID the token's slot
     */
    NativeLong C_CloseAllSessions(NativeLong slotID);

    /**
     * C_GetSessionInfo obtains information about the session.
     *
     * @param hSession the session's handle
     * @param pInfo    receives session info
     */
    NativeLong C_GetSessionInfo(NativeLong hSession, CK_SESSION_INFO pInfo);

    /**
     * C_GetOperationState obtains the state of the cryptographic operation in a session.
     *
     * @param hSession             session's handle
     * @param pOperationState      gets state
     * @param pulOperationStateLen gets state length
     */
    NativeLong C_GetOperationState(
            NativeLong hSession,
            byte[] pOperationState,
            NativeLongByReference pulOperationStateLen
    );

    /**
     * C_SetOperationState restores the state of the cryptographic operation in a session.
     *
     * @param hSession            session's handle
     * @param pOperationState     holds state
     * @param ulOperationStateLen holds state length
     * @param hEncryptionKey      en/decryption key
     * @param hAuthenticationKey  sign/verify key
     */
    NativeLong C_SetOperationState(
            NativeLong hSession,
            byte[] pOperationState,
            NativeLong ulOperationStateLen,
            NativeLong hEncryptionKey,
            NativeLong hAuthenticationKey
    );

    /**
     * C_Login logs a user into a token.
     *
     * @param hSession the session's handle
     * @param userType the user type
     * @param pPin     the user's PIN
     * @param ulPinLen the length of the PIN
     */
    NativeLong C_Login(NativeLong hSession, NativeLong userType, byte[] pPin, NativeLong ulPinLen);

    /**
     * C_Logout logs a user out from a token.
     *
     * @param hSession the session's handle
     */
    NativeLong C_Logout(NativeLong hSession);

    /* Object management */

    /**
     * C_CreateObject creates a new object.
     *
     * @param hSession  the session's handle
     * @param pTemplate the object's template
     * @param ulCount   attributes in template
     * @param phObject  gets new object's handle
     */
    NativeLong C_CreateObject(
            NativeLong hSession,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulCount,
            NativeLongByReference phObject
    );

    /**
     * C_CopyObject copies an object, creating a new object for the copy.
     *
     * @param hSession    the session's handle
     * @param hObject     the object's handle
     * @param pTemplate   template for new object
     * @param ulCount     attributes in template
     * @param phNewObject receives handle of copy
     */
    NativeLong C_CopyObject(
            NativeLong hSession,
            NativeLong hObject,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulCount,
            NativeLongByReference phNewObject
    );

    /**
     * C_DestroyObject destroys an object.
     *
     * @param hSession the session's handle
     * @param hObject  the object's handle
     */
    NativeLong C_DestroyObject(NativeLong hSession, NativeLong hObject);

    /**
     * C_GetObjectSize gets the size of an object in bytes.
     *
     * @param hSession the session's handle
     * @param hObject  the object's handle
     * @param pulSize  receives size of object
     */
    NativeLong C_GetObjectSize(NativeLong hSession, NativeLong hObject, NativeLongByReference pulSize);

    /**
     * C_GetAttributeValue obtains the value of one or more object attributes.
     *
     * @param hSession  the session's handle
     * @param hObject   the object's handle
     * @param pTemplate specifies attrs; gets vals
     * @param ulCount   attributes in template
     */
    NativeLong C_GetAttributeValue(
            NativeLong hSession,
            NativeLong hObject,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulCount
    );

    /**
     * C_SetAttributeValue modifies the value of one or more object attributes.
     *
     * @param hSession  the session's handle
     * @param hObject   the object's handle
     * @param pTemplate specifies attrs and values
     * @param ulCount   attributes in template
     */
    NativeLong C_SetAttributeValue(
            NativeLong hSession,
            NativeLong hObject,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulCount
    );

    /**
     * C_FindObjectsInit initializes a search for token and session objects that match a template.
     *
     * @param hSession  the session's handle
     * @param pTemplate attribute values to match
     * @param ulCount   attrs in search template
     */
    NativeLong C_FindObjectsInit(NativeLong hSession, CK_ATTRIBUTE[] pTemplate, NativeLong ulCount);

    /**
     * C_FindObjects continues a search for token and session objects that match a template,
     * obtaining additional object handles.
     *
     * @param hSession         session's handle
     * @param phObject         gets obj. handles
     * @param ulMaxObjectCount max handles to get
     * @param pulObjectCount   actual # returned
     */
    NativeLong C_FindObjects(
            NativeLong hSession,
            NativeLong[] phObject,
            NativeLong ulMaxObjectCount,
            NativeLongByReference pulObjectCount
    );

    /**
     * C_FindObjectsFinal finishes a search for token and session objects.
     *
     * @param hSession the session's handle
     */
    NativeLong C_FindObjectsFinal(NativeLong hSession);

    /* Encryption and decryption */

    /**
     * C_EncryptInit initializes an encryption operation.
     *
     * @param hSession   the session's handle
     * @param pMechanism the encryption mechanism
     * @param hKey       handle of encryption key
     */
    NativeLong C_EncryptInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_Encrypt encrypts single-part data.
     *
     * @param hSession            session's handle
     * @param pData               the plaintext data
     * @param ulDataLen           bytes of plaintext
     * @param pEncryptedData      gets ciphertext
     * @param pulEncryptedDataLen gets c-text size
     */
    NativeLong C_Encrypt(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pEncryptedData,
            NativeLongByReference pulEncryptedDataLen
    );

    /**
     * C_EncryptUpdate continues a multiple-part encryption operation.
     *
     * @param hSession            session's handle
     * @param pPart               the plaintext data
     * @param ulPartLen           plaintext data len
     * @param pEncryptedPart      gets ciphertext
     * @param pulEncryptedPartLen gets c-text size
     */
    NativeLong C_EncryptUpdate(
            NativeLong hSession,
            byte[] pPart,
            NativeLong ulPartLen,
            byte[] pEncryptedPart,
            NativeLongByReference pulEncryptedPartLen
    );

    /**
     * C_EncryptFinal finishes a multiple-part encryption operation.
     *
     * @param hSession                session handle
     * @param pLastEncryptedPart      last c-text
     * @param pulLastEncryptedPartLen gets last size
     */
    NativeLong C_EncryptFinal(
            NativeLong hSession,
            byte[] pLastEncryptedPart,
            NativeLongByReference pulLastEncryptedPartLen
    );

    /**
     * C_DecryptInit initializes a decryption operation.
     *
     * @param hSession   the session's handle
     * @param pMechanism the decryption mechanism
     * @param hKey       handle of decryption key
     */
    NativeLong C_DecryptInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_Decrypt decrypts encrypted data in a single part.
     *
     * @param hSession           session's handle
     * @param pEncryptedData     ciphertext
     * @param ulEncryptedDataLen ciphertext length
     * @param pData              gets plaintext
     * @param pulDataLen         gets p-text size
     */
    NativeLong C_Decrypt(
            NativeLong hSession,
            byte[] pEncryptedData,
            NativeLong ulEncryptedDataLen,
            byte[] pData,
            NativeLongByReference pulDataLen
    );

    /**
     * C_DecryptUpdate continues a multiple-part decryption operation.
     *
     * @param hSession           session's handle
     * @param pEncryptedPart     encrypted data
     * @param ulEncryptedPartLen input length
     * @param pPart              gets plaintext
     * @param pulPartLen         p-text size
     */
    NativeLong C_DecryptUpdate(
            NativeLong hSession,
            byte[] pEncryptedPart,
            NativeLong ulEncryptedPartLen,
            byte[] pPart,
            NativeLongByReference pulPartLen
    );

    /**
     * C_DecryptFinal finishes a multiple-part decryption operation.
     *
     * @param hSession       the session's handle
     * @param pLastPart      gets plaintext
     * @param pulLastPartLen p-text size
     */
    NativeLong C_DecryptFinal(NativeLong hSession, byte[] pLastPart, NativeLongByReference pulLastPartLen);

    /* Message digesting */

    /**
     * C_DigestInit initializes a message-digesting operation.
     *
     * @param hSession   the session's handle
     * @param pMechanism the digesting mechanism
     */
    NativeLong C_DigestInit(NativeLong hSession, CK_MECHANISM pMechanism);

    /**
     * C_Digest digests data in a single part.
     *
     * @param hSession     the session's handle
     * @param pData        data to be digested
     * @param ulDataLen    bytes of data to digest
     * @param pDigest      gets the message digest
     * @param pulDigestLen gets digest length
     */
    NativeLong C_Digest(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pDigest,
            NativeLongByReference pulDigestLen
    );

    /**
     * C_DigestUpdate continues a multiple-part message-digesting operation.
     *
     * @param hSession  the session's handle
     * @param pPart     data to be digested
     * @param ulPartLen bytes of data to be digested
     */
    NativeLong C_DigestUpdate(NativeLong hSession, byte[] pPart, NativeLong ulPartLen);

    /**
     * C_DigestKey continues a multi-part message-digesting operation, by digesting the value of a secret key
     * as part of the data already digested.
     *
     * @param hSession the session's handle
     * @param hKey     secret key to digest
     */
    NativeLong C_DigestKey(NativeLong hSession, NativeLong hKey);

    /**
     * C_DigestFinal finishes a multiple-part message-digesting operation.
     *
     * @param hSession     the session's handle
     * @param pDigest      gets the message digest
     * @param pulDigestLen gets byte count of digest
     */
    NativeLong C_DigestFinal(NativeLong hSession, byte[] pDigest, NativeLongByReference pulDigestLen);

    /* Signing and MACing */

    /**
     * C_SignInit initializes a signature (private key encryption) operation, where the signature is (will be)
     * an appendix to the data, and plaintext cannot be recovered from the signature.
     *
     * @param hSession   the session's handle
     * @param pMechanism the signature mechanism
     * @param hKey       handle of signature key
     */
    NativeLong C_SignInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_Sign signs (encrypts with private key) data in a single part, where the signature is (will be)
     * an appendix to the data, and plaintext cannot be recovered from the signature.
     *
     * @param hSession        the session's handle
     * @param pData           the data to sign
     * @param ulDataLen       count of bytes to sign
     * @param pSignature      gets the signature
     * @param pulSignatureLen gets signature length
     */
    NativeLong C_Sign(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pSignature,
            NativeLongByReference pulSignatureLen
    );

    /**
     * C_SignUpdate continues a multiple-part signature operation, where the signature is (will be)
     * an appendix to the data, and plaintext cannot be recovered from the signature.
     *
     * @param hSession  the session's handle
     * @param pPart     the data to sign
     * @param ulPartLen count of bytes to sign
     */
    NativeLong C_SignUpdate(NativeLong hSession, byte[] pPart, NativeLong ulPartLen);

    /**
     * C_SignFinal finishes a multiple-part signature operation, returning the signature.
     *
     * @param hSession        the session's handle
     * @param pSignature      gets the signature
     * @param pulSignatureLen gets signature length
     */
    NativeLong C_SignFinal(NativeLong hSession, byte[] pSignature, NativeLongByReference pulSignatureLen);

    /**
     * C_SignRecoverInit initializes a signature operation, where the data can be recovered from the signature.
     *
     * @param hSession   the session's handle
     * @param pMechanism the signature mechanism
     * @param hKey       handle of the signature key
     */
    NativeLong C_SignRecoverInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_SignRecover signs data in a single operation, where the data can be recovered from the signature.
     *
     * @param hSession        the session's handle
     * @param pData           the data to sign
     * @param ulDataLen       count of bytes to sign
     * @param pSignature      gets the signature
     * @param pulSignatureLen gets signature length
     */
    NativeLong C_SignRecover(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pSignature,
            NativeLongByReference pulSignatureLen
    );

    /* Verifying signatures and MACs */

    /**
     * C_VerifyInit initializes a verification operation, where the signature is an appendix to the data,
     * and plaintext cannot be recovered from the signature (e.g. DSA).
     *
     * @param hSession   the session's handle
     * @param pMechanism the verification mechanism
     * @param hKey       verification key
     */
    NativeLong C_VerifyInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_Verify verifies a signature in a single-part operation, where the signature is an appendix to the data,
     * and plaintext cannot be recovered from the signature.
     *
     * @param hSession       the session's handle
     * @param pData          signed data
     * @param ulDataLen      length of signed data
     * @param pSignature     signature
     * @param ulSignatureLen signature length
     */
    NativeLong C_Verify(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pSignature,
            NativeLong ulSignatureLen
    );

    /**
     * C_VerifyUpdate continues a multiple-part verify operation, where the signature is an appendix to the data,
     * and plaintext cannot be recovered from the signature.
     *
     * @param hSession  the session's handle
     * @param pPart     signed data
     * @param ulPartLen length of signed data
     */
    NativeLong C_VerifyUpdate(NativeLong hSession, byte[] pPart, NativeLong ulPartLen);

    /**
     * C_VerifyFinal finishes a multiple-part verification operation, checking the signature.
     *
     * @param hSession       the session's handle
     * @param pSignature     signature to verify
     * @param ulSignatureLen signature length
     */
    NativeLong C_VerifyFinal(NativeLong hSession, byte[] pSignature, NativeLong ulSignatureLen);

    /**
     * C_VerifyRecoverInit initializes a signature verification operation,
     * where the data is recovered from the signature.
     *
     * @param hSession   the session's handle
     * @param pMechanism the verification mechanism
     * @param hKey       verification key
     */
    NativeLong C_VerifyRecoverInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * C_VerifyRecover verifies a signature in a single-part operation, where the data is recovered from the signature.
     *
     * @param hSession       the session's handle
     * @param pSignature     signature to verify
     * @param ulSignatureLen signature length
     * @param pData          gets signed data
     * @param pulDataLen     gets signed data len
     */
    NativeLong C_VerifyRecover(
            NativeLong hSession,
            byte[] pSignature,
            NativeLong ulSignatureLen,
            byte[] pData,
            NativeLongByReference pulDataLen
    );

    /* Dual-function cryptographic operations */

    /**
     * C_DigestEncryptUpdate continues a multiple-part digesting and encryption operation.
     *
     * @param hSession            session's handle
     * @param pPart               the plaintext data
     * @param ulPartLen           plaintext length
     * @param pEncryptedPart      gets ciphertext
     * @param pulEncryptedPartLen gets c-text length
     */
    NativeLong C_DigestEncryptUpdate(
            NativeLong hSession,
            byte[] pPart,
            NativeLong ulPartLen,
            byte[] pEncryptedPart,
            NativeLongByReference pulEncryptedPartLen
    );

    /**
     * C_DecryptDigestUpdate continues a multiple-part decryption and digesting operation.
     *
     * @param hSession           session's handle
     * @param pEncryptedPart     ciphertext
     * @param ulEncryptedPartLen ciphertext length
     * @param pPart              gets plaintext
     * @param pulPartLen         gets plaintext len
     */
    NativeLong C_DecryptDigestUpdate(
            NativeLong hSession,
            byte[] pEncryptedPart,
            NativeLong ulEncryptedPartLen,
            byte[] pPart,
            NativeLongByReference pulPartLen
    );

    /**
     * C_SignEncryptUpdate continues a multiple-part signing and encryption operation.
     *
     * @param hSession            session's handle
     * @param pPart               the plaintext data
     * @param ulPartLen           plaintext length
     * @param pEncryptedPart      gets ciphertext
     * @param pulEncryptedPartLen gets c-text length
     */
    NativeLong C_SignEncryptUpdate(
            NativeLong hSession,
            byte[] pPart,
            NativeLong ulPartLen,
            byte[] pEncryptedPart,
            NativeLongByReference pulEncryptedPartLen
    );

    /**
     * C_DecryptVerifyUpdate continues a multiple-part decryption and verify operation.
     *
     * @param hSession           session's handle
     * @param pEncryptedPart     ciphertext
     * @param ulEncryptedPartLen ciphertext length
     * @param pPart              gets plaintext
     * @param pulPartLen         gets p-text length
     */
    NativeLong C_DecryptVerifyUpdate(
            NativeLong hSession,
            byte[] pEncryptedPart,
            NativeLong ulEncryptedPartLen,
            byte[] pPart,
            NativeLongByReference pulPartLen
    );

    /* Key management */

    /**
     * C_GenerateKey generates a secret key, creating a new key object.
     *
     * @param hSession   the session's handle
     * @param pMechanism key generation mech.
     * @param pTemplate  template for new key
     * @param ulCount    # of attrs in template
     * @param phKey      gets handle of new key
     */
    NativeLong C_GenerateKey(
            NativeLong hSession,
            CK_MECHANISM pMechanism,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulCount,
            NativeLongByReference phKey
    );

    /**
     * C_GenerateKeyPair generates a public-key/private-key pair, creating new key objects.
     *
     * @param hSession                   session handle
     * @param pMechanism                 key-gen mech.
     * @param pPublicKeyTemplate         template for pub. key
     * @param ulPublicKeyAttributeCount  # pub. attrs.
     * @param pPrivateKeyTemplate        template for priv. key
     * @param ulPrivateKeyAttributeCount # priv. attrs.
     * @param phPublicKey                gets pub. key handle
     * @param phPrivateKey               gets priv. key handle
     */
    NativeLong C_GenerateKeyPair(
            NativeLong hSession,
            CK_MECHANISM pMechanism,
            CK_ATTRIBUTE[] pPublicKeyTemplate,
            NativeLong ulPublicKeyAttributeCount,
            CK_ATTRIBUTE[] pPrivateKeyTemplate,
            NativeLong ulPrivateKeyAttributeCount,
            NativeLongByReference phPublicKey,
            NativeLongByReference phPrivateKey
    );

    /**
     * C_WrapKey wraps (i.e., encrypts) a key.
     *
     * @param hSession         the session's handle
     * @param pMechanism       the wrapping mechanism
     * @param hWrappingKey     wrapping key
     * @param hKey             key to be wrapped
     * @param pWrappedKey      gets wrapped key
     * @param pulWrappedKeyLen gets wrapped key size
     */
    NativeLong C_WrapKey(
            NativeLong hSession,
            CK_MECHANISM pMechanism,
            NativeLong hWrappingKey,
            NativeLong hKey,
            byte[] pWrappedKey,
            NativeLongByReference pulWrappedKeyLen
    );

    /**
     * C_UnwrapKey unwraps (decrypts) a wrapped key, creating a new key object.
     *
     * @param hSession         session's handle
     * @param pMechanism       unwrapping mech.
     * @param hUnwrappingKey   unwrapping key
     * @param pWrappedKey      the wrapped key
     * @param ulWrappedKeyLen  wrapped key len
     * @param pTemplate        new key template
     * @param ulAttributeCount template length
     * @param phKey            gets new handle
     */
    NativeLong C_UnwrapKey(
            NativeLong hSession,
            CK_MECHANISM pMechanism,
            NativeLong hUnwrappingKey,
            byte[] pWrappedKey,
            NativeLong ulWrappedKeyLen,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulAttributeCount,
            NativeLongByReference phKey
    );

    /**
     * C_DeriveKey derives a key from a base key, creating a new key object.
     *
     * @param hSession         session's handle
     * @param pMechanism       key deriv. mech.
     * @param hBaseKey         base key
     * @param pTemplate        new key template
     * @param ulAttributeCount template length
     * @param phKey            gets new handle
     */
    NativeLong C_DeriveKey(
            NativeLong hSession,
            CK_MECHANISM pMechanism,
            NativeLong hBaseKey,
            CK_ATTRIBUTE[] pTemplate,
            NativeLong ulAttributeCount,
            NativeLongByReference phKey
    );

    /* Random number generation */

    /**
     * C_SeedRandom mixes additional seed material into the token's random number generator.
     *
     * @param hSession  the session's handle
     * @param pSeed     the seed material
     * @param ulSeedLen length of seed material
     */
    NativeLong C_SeedRandom(NativeLong hSession, byte[] pSeed, NativeLong ulSeedLen);

    /**
     * C_GenerateRandom generates random data.
     *
     * @param hSession    the session's handle
     * @param RandomData  receives the random data
     * @param ulRandomLen # of bytes to generate
     */
    NativeLong C_GenerateRandom(NativeLong hSession, byte[] RandomData, NativeLong ulRandomLen);

    /* Parallel function management */

    /**
     * C_GetFunctionStatus is a legacy function; it obtains an updated status
     * of a function running in parallel with an application.
     *
     * @param hSession the session's handle
     * @deprecated
     */
    @Deprecated
    NativeLong C_GetFunctionStatus(NativeLong hSession);

    /**
     * C_CancelFunction is a legacy function; it cancels a function running in parallel.
     *
     * @param hSession the session's handle
     * @deprecated
     */
    @Deprecated
    NativeLong C_CancelFunction(NativeLong hSession);

    /**
     * C_WaitForSlotEvent waits for a slot event (token insertion, removal, etc.) to occur.
     *
     * @param flags     blocking/nonblocking flag
     * @param pSlot     location that receives the slot ID
     * @param pReserved reserved. Should be null
     */
    NativeLong C_WaitForSlotEvent(NativeLong flags, NativeLongByReference pSlot, Pointer pReserved);
}
