/*
 * Copyright (c) 2018, JSC Aktiv-Soft. See the LICENSES/Aktiv-Soft file at the top-level directory of this distribution.
 * All Rights Reserved.
 */

package ru.rutoken.pkcs11jna;
/* Derived from rtpkcs11f.h include file for PKCS #11. */

/*
 * @author Aktiv Co. <hotline@rutoken.ru>
 */

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.NativeLongByReference;
import com.sun.jna.ptr.PointerByReference;

public interface RtPkcs11 extends Pkcs11 {

    /**
     * Returns the extended function list.
     *
     * @param ppFunctionList receives pointer to extended function list
     */
    NativeLong C_EX_GetFunctionListExtended(Pointer[] ppFunctionList);

    /**
     * Initializes a token with full format.
     *
     * @param slotID    ID of the token's slot
     * @param pPin      the SO's initial PIN
     * @param ulPinLen  length in bytes of the PIN
     * @param pInitInfo init parameters
     */
    NativeLong C_EX_InitToken(
            NativeLong slotID,
            byte[] pPin,
            NativeLong ulPinLen,
            CK_RUTOKEN_INIT_PARAM pInitInfo
    );

    /**
     * Obtains information about the particular token in the system.
     *
     * @param slotID ID of the token's slot
     * @param pInfo  receives the token information
     */
    NativeLong C_EX_GetTokenInfoExtended(NativeLong slotID, CK_TOKEN_INFO_EXTENDED pInfo);

    /**
     * Unblocks the blocked User's PIN.
     * Requires same conditions as a C_InitPIN.
     *
     * @param hSession the session's handle
     */
    NativeLong C_EX_UnblockUserPIN(NativeLong hSession);

    /**
     * Modifies the token symbol name (label) if User is logged in.
     * Can only be called in the "R/W User Functions" state.
     *
     * @param hSession   the session's handle
     * @param pLabel     the new label
     * @param ulLabelLen length of the new label
     */
    NativeLong C_EX_SetTokenName(NativeLong hSession, byte[] pLabel, NativeLong ulLabelLen);

    /**
     * Modifies the token license if User or SO is logged in.
     * Can only be called in the "R/W User Functions" state or "R/W SO Functions" state.
     *
     * @param hSession     the session's handle
     * @param ulLicenseNum the number of the new license, can only be 1 or 2
     * @param pLicense     byte buffer with the data of new license
     * @param ulLicenseLen length of the new license, can only be 72
     */
    NativeLong C_EX_SetLicense(
            NativeLong hSession,
            NativeLong ulLicenseNum,
            byte[] pLicense,
            NativeLong ulLicenseLen
    );


    /**
     * Reads the token license.
     * Can be called in any state.
     * pulLicenseLen [in/out] -
     * [in]- sets license length, can only be 72
     * [out] - gets license length (if pLicense is null)
     *
     * @param hSession      the session's handle
     * @param ulLicenseNum  the number of the license, can only be 1 or 2
     * @param pLicense      receives the license
     * @param pulLicenseLen length of the license
     */
    NativeLong C_EX_GetLicense(
            NativeLong hSession,
            NativeLong ulLicenseNum,
            byte[] pLicense,
            NativeLongByReference pulLicenseLen
    );


    /**
     * Gets text information about certificate.
     * Can be called in any state.
     *
     * @param hSession   the session's handle
     * @param hCert      the object's handle
     * @param pInfo      returns address of allocated buffer with text information
     * @param pulInfoLen length of the allocated buffer
     */
    NativeLong C_EX_GetCertificateInfoText(
            NativeLong hSession,
            NativeLong hCert,
            Pointer pInfo,
            NativeLongByReference pulInfoLen
    );

    /**
     * Signs data and packs it to PKCS#7 format.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     */
    NativeLong C_EX_PKCS7Sign(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            NativeLong hCert,
            Pointer ppEnvelope,
            NativeLongByReference pEnvelopeLen,
            NativeLong hPrivKey,
            NativeLong[] phCertificates,
            NativeLong ulCertificatesLen,
            NativeLong flags
    );

    /**
     * Initializes PKCS#7 verify operation.
     *
     * @param pCms   CK_BYTE_PTR
     * @param pStore CK_VENDOR_X509_STORE_PTR
     */
    NativeLong C_EX_PKCS7VerifyInit(
            NativeLong hSession,
            Pointer pCms,
            NativeLong ulCmsLen,
            CK_VENDOR_X509_STORE pStore,
            NativeLong ckMode,
            NativeLong flags
    );

    /**
     * Finishes PKCS#7 verify operation and return signed data and signer certificates.
     *
     * @param ppData               CK_BYTE_PTR_PTR
     * @param ppSignerCertificates CK_VENDOR_BUFFER_PTR_PTR
     */
    NativeLong C_EX_PKCS7Verify(
            NativeLong hSession,
            PointerByReference ppData,
            NativeLongByReference pulDataLen,
            PointerByReference ppSignerCertificates,
            NativeLongByReference pulSignerCertificatesCount
    );


    /**
     * Creates a certification request and packs it in PKCS#10 format.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     */
    NativeLong C_EX_CreateCSR(
            NativeLong hSession,
            NativeLong hPublicKey,
            String[] dn,
            NativeLong dnLength,
            Pointer pCsr,
            NativeLongByReference pulCsrLength,
            NativeLong hPrivKey,
            NativeLong[] pAttributes,
            NativeLong ulAttributesLength,
            String[] pExtensions,
            NativeLong ulExtensionsLength
    );

    /**
     * Frees buffer, allocated in extended functions.
     *
     * @param pBuffer pointer to the buffer
     */
    NativeLong C_EX_FreeBuffer(Pointer pBuffer);

    /**
     * Returns the token symbol name (label)
     *
     * @param hSession    the session's handle
     * @param pLabel      byte buffer for label
     * @param pulLabelLen length of the label
     */
    NativeLong C_EX_GetTokenName(
            NativeLong hSession,
            byte[] pLabel,
            NativeLongByReference pulLabelLen
    );

    /**
     * Modifies the local PIN for devices which supported it.
     *
     * @param slotID           ID of the token's slot
     * @param pUserPin         the current User PIN
     * @param ulUserPinLen     length of current User PIN
     * @param pNewLocalPin     the new local PIN
     * @param ulNewLocalPinLen length of the new local PIN
     * @param ulLocalID        ID of the local PIN
     */
    NativeLong C_EX_SetLocalPIN(
            NativeLong slotID,
            byte[] pUserPin,
            NativeLong ulUserPinLen,
            byte[] pNewLocalPin,
            NativeLong ulNewLocalPinLen,
            NativeLong ulLocalID
    );

    NativeLong C_EX_LoadActivationKey(NativeLong hSession, byte[] key, NativeLong keySize);

    NativeLong C_EX_SetActivationPassword(NativeLong slotID, byte[] password);

    NativeLong C_EX_GetVolumesInfo(
            NativeLong slotID,
            CK_VOLUME_INFO_EXTENDED[] pInfo,
            NativeLongByReference pulInfoCount
    );

    NativeLong C_EX_ChangeVolumeAttributes(
            NativeLong slotId,
            NativeLong userType,
            byte[] pPin,
            NativeLong ulPinLen,
            NativeLong idVolume,
            NativeLong newAccessMode,
            byte bPermanent
    );
}
