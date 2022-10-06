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

/**
 * @see <a href="https://dev.rutoken.ru/pages/viewpage.action?pageId=3178555">Online docs on dev.rutoken.ru</a>
 */
public interface RtPkcs11 extends Pkcs11 {

    /**
     * Returns the extended function list.
     *
     * @param ppFunctionList receives pointer to extended function list
     */
    NativeLong C_EX_GetFunctionListExtended(PointerByReference ppFunctionList);

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
     * Requires same conditions as a {@link #C_InitPIN}.
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
     * @param ulLicenseNum the number of the new license, can be from 1 to 4 depending on a token
     * @param pLicense     byte buffer with the data of new license
     * @param ulLicenseLen length of the new license
     */
    NativeLong C_EX_SetLicense(
            NativeLong hSession,
            NativeLong ulLicenseNum,
            byte[] pLicense,
            NativeLong ulLicenseLen
    );


    /**
     * Reads the token license.
     *
     * @param hSession      the session's handle
     * @param ulLicenseNum  the number of the license, can be from 1 to 4 depending on a token
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
     *
     * @param hSession   the session's handle
     * @param hCert      the object's handle
     * @param pInfo      receives an address of allocated buffer with text information
     * @param pulInfoLen length of the allocated buffer
     */
    NativeLong C_EX_GetCertificateInfoText(
            NativeLong hSession,
            NativeLong hCert,
            PointerByReference pInfo,
            NativeLongByReference pulInfoLen
    );

    /**
     * Signs data and packs it to PKCS#7 format.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession          the session's handle
     * @param pData             data to sign
     * @param ulDataLen         data length
     * @param hCert             certificate handle
     * @param ppEnvelope        buffer for message (CMS)
     * @param pEnvelopeLen      buffer length
     * @param hPrivKey          private key handle matching specified certificate.
     *                          If set to «0», then private key is searched by certificate ID.
     * @param phCertificates    handles of certificates to be included in CMS
     * @param ulCertificatesLen certificates array length
     * @param flags             operation flags
     */
    NativeLong C_EX_PKCS7Sign(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            NativeLong hCert,
            PointerByReference ppEnvelope,
            NativeLongByReference pEnvelopeLen,
            NativeLong hPrivKey,
            NativeLong[] phCertificates,
            NativeLong ulCertificatesLen,
            NativeLong flags
    );

    /**
     * Creates a certificate request and packs it in PKCS#10 format.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession           the session's handle
     * @param hPublicKey         public key handle
     * @param dn                 distinguished name - string array,
     *                           where first string is a type in text format or OID (CN or «2.5.4.3»).
     *                           Next pairs are passed the same way, string count should be multiple of two.
     * @param dnLength           length of the dn array
     * @param pCsr               CSR buffer
     * @param pulCsrLength       CSR buffer size
     * @param hPrivKey           private key matching specified public key.
     *                           If set to «0», then private key is searched by public key ID.
     * @param pAttributes        additional attributes for including into request. Format is the same as for dn.
     * @param ulAttributesLength attributes array length
     * @param pExtensions        extensions for including into request. Format is the same as for dn.
     * @param ulExtensionsLength extensions array length
     */
    NativeLong C_EX_CreateCSR(
            NativeLong hSession,
            NativeLong hPublicKey,
            String[] dn,
            NativeLong dnLength,
            PointerByReference pCsr,
            NativeLongByReference pulCsrLength,
            NativeLong hPrivKey,
            String[] pAttributes,
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
     * Returns the token symbol name (label).
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
     * Modifies the local PIN for devices which support it.
     * If local PIN does not exist, the User PIN should be passed as the pUserPin.
     * Then PIN will be created with the specified value.
     * If local PIN exists, its current value should be passed as the pUserPin
     * and it will be changed to the specified value.
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

    /**
     * Activates secure messaging channel.
     * Function is supported on Rutoken ECP Bluetooth with firmware version 20 or below.
     *
     * @param hSession the session's handle
     * @param key      activation key
     * @param keySize  size of the key in bytes
     * @deprecated unsupported by rtpkcs11ecp 2.6.0.0+
     */
    @Deprecated
    NativeLong C_EX_LoadActivationKey(NativeLong hSession, byte[] key, NativeLong keySize);

    /**
     * Activates secure messaging channel.
     * Function is supported on Rutoken ECP Bluetooth with firmware version 21 and above.
     *
     * @param slotID   ID of the token's slot
     * @param password null terminated C-string with the password
     * @deprecated unsupported by rtpkcs11ecp 2.6.0.0+
     */
    @Deprecated
    NativeLong C_EX_SetActivationPassword(NativeLong slotID, byte[] password);

    /**
     * Gets volumes information from token drive.
     *
     * @param slotID       ID of the token's slot
     * @param pInfo        array with volumes information
     * @param pulInfoCount array length
     */
    NativeLong C_EX_GetVolumesInfo(
            NativeLong slotID,
            CK_VOLUME_INFO_EXTENDED[] pInfo,
            NativeLongByReference pulInfoCount
    );

    /**
     * Gets memory size of a token drive.
     *
     * @param slotID       ID of the token's slot
     * @param pulDriveSize size in megabytes
     */
    NativeLong C_EX_GetDriveSize(NativeLong slotID, NativeLongByReference pulDriveSize);

    /**
     * Changes volume access attributes.
     *
     * @param slotID        ID of the token's slot
     * @param userType      the volume owner
     * @param pPin          the volume owner's PIN
     * @param ulPinLen      the length of the PIN
     * @param idVolume      volume ID
     * @param newAccessMode new access flags
     * @param bPermanent    permanent change mode flag
     */
    NativeLong C_EX_ChangeVolumeAttributes(
            NativeLong slotID,
            NativeLong userType,
            byte[] pPin,
            NativeLong ulPinLen,
            NativeLong idVolume,
            NativeLong newAccessMode,
            byte bPermanent
    );

    /**
     * Formats drive with specified volumes.
     *
     * @param slotID            ID of the token's slot
     * @param userType          the user type, possible values are {@link Pkcs11Constants#CKU_SO}
     *                          and {@link Pkcs11Constants#CKU_USER}
     * @param pPin              the user's PIN
     * @param ulPinLen          the length of the PIN
     * @param pInitParams       array with volumes information
     * @param ulInitParamsCount array length
     */
    NativeLong C_EX_FormatDrive(
            NativeLong slotID,
            NativeLong userType,
            byte[] pPin,
            NativeLong ulPinLen,
            CK_VOLUME_FORMAT_INFO_EXTENDED[] pInitParams,
            NativeLong ulInitParamsCount
    );

    /**
     * Token management function.
     *
     * @param hSession the session's handle
     * @param ulMode   function mode
     * @param pValue   value depends on function mode
     */
    NativeLong C_EX_TokenManage(NativeLong hSession, NativeLong ulMode, Pointer pValue);

    /**
     * Generates secure messaging activation password.
     *
     * @param hSession               the session's handle
     * @param ulPasswordNumber       number of generated password
     * @param pPassword              password buffer
     * @param pulPasswordSize        buffer size
     * @param ulPasswordCharacterSet allowed password character set
     * @deprecated unsupported by rtpkcs11ecp 2.6.0.0+
     */
    @Deprecated
    NativeLong C_EX_GenerateActivationPassword(
            NativeLong hSession,
            NativeLong ulPasswordNumber,
            byte[] pPassword,
            NativeLongByReference pulPasswordSize,
            NativeLong ulPasswordCharacterSet
    );

    /**
     * Gets operations journal.
     *
     * @param slotID         ID of the token's slot
     * @param pJournal       token's journal
     * @param pulJournalSize size of the journal
     */
    NativeLong C_EX_GetJournal(
            NativeLong slotID,
            byte[] pJournal,
            NativeLongByReference pulJournalSize
    );

    /**
     * Initializes sign operation without showing it on a token screen.
     *
     * @param hSession   the session's handle
     * @param pMechanism the signature mechanism
     * @param hKey       handle of signature key
     * @deprecated unsupported by rtpkcs11ecp 2.0.3.0+
     */
    @Deprecated
    NativeLong C_EX_SignInvisibleInit(NativeLong hSession, CK_MECHANISM pMechanism, NativeLong hKey);

    /**
     * Signs data without showing it on a token screen.
     *
     * @param hSession        the session's handle
     * @param pData           the data to sign
     * @param ulDataLen       count of bytes to sign
     * @param pSignature      gets the signature
     * @param pulSignatureLen gets signature length
     * @deprecated unsupported by rtpkcs11ecp 2.0.3.0+
     */
    @Deprecated
    NativeLong C_EX_SignInvisible(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataLen,
            byte[] pSignature,
            NativeLongByReference pulSignatureLen
    );

    /**
     * Token management function.
     *
     * @param slotID ID of the token's slot
     * @param ulMode function mode
     * @param pValue function mode parameter
     */
    NativeLong C_EX_SlotManage(NativeLong slotID, NativeLong ulMode, Pointer pValue);

    /**
     * Generates a content encryption key (CEK) in token RAM, derives key encryption key (KEK),
     * wraps CEK using KEK and returns CEK handle and CEK wrapped value.
     *
     * @param hSession             the session's handle
     * @param pGenerationMechanism CEK generation mechanism
     * @param pKeyTemplate         CEK template
     * @param ulKeyAttributeCount  CEK template attributes count
     * @param pDerivationMechanism KEK derivation mechanism
     * @param hBaseKey             private key handle for KEK derivation
     * @param pWrappingMechanism   CEK encryption mechanism
     * @param pWrappedKey          encrypted CEK
     * @param pulWrappedKeyLen     encrypted CEK length
     * @param phKey                CEK handle
     * @deprecated unsupported by rtpkcs11ecp 2.0.8.0+
     */
    @Deprecated
    NativeLong C_EX_WrapKey(
            NativeLong hSession,
            CK_MECHANISM pGenerationMechanism,
            CK_ATTRIBUTE[] pKeyTemplate,
            NativeLong ulKeyAttributeCount,
            CK_MECHANISM pDerivationMechanism,
            NativeLong hBaseKey,
            CK_MECHANISM pWrappingMechanism,
            byte[] pWrappedKey,
            NativeLongByReference pulWrappedKeyLen,
            NativeLongByReference phKey
    );

    /**
     * Derives key encryption key (KEK), decrypts encrypted content encryption key (CEK),
     * imports CEK to token RAM, returns its handle.
     *
     * @param hSession             the session's handle
     * @param pDerivationMechanism KEK derivation mechanism
     * @param hBaseKey             private key handle for KEK derivation
     * @param pUnwrappingMechanism decryption mechanism
     * @param pWrappedKey          encrypted CEK
     * @param ulWrappedKeyLen      encrypted CEK length
     * @param pKeyTemplate         CEK template
     * @param ulKeyAttributeCount  CEK template attributes count
     * @param phKey                CEK handle
     * @deprecated unsupported by rtpkcs11ecp 2.0.8.0+
     */
    @Deprecated
    NativeLong C_EX_UnwrapKey(
            NativeLong hSession,
            CK_MECHANISM pDerivationMechanism,
            NativeLong hBaseKey,
            CK_MECHANISM pUnwrappingMechanism,
            byte[] pWrappedKey,
            NativeLong ulWrappedKeyLen,
            CK_ATTRIBUTE[] pKeyTemplate,
            NativeLong ulKeyAttributeCount,
            NativeLongByReference phKey
    );

    /**
     * Initializes PKCS#7 verify operation.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession  the session's handle
     * @param pCms      buffer with PKCS#7 message
     * @param ulCmsSize buffer size
     * @param pStore    structure with trusted certificates, signer certificates and CRLs
     * @param ckMode    CRLs verify mode
     * @param flags     option flags
     */
    NativeLong C_EX_PKCS7VerifyInit(
            NativeLong hSession,
            Pointer pCms, /* do not use byte[] as native code may store this reference */
            NativeLong ulCmsSize,
            CK_VENDOR_X509_STORE pStore,
            NativeLong ckMode,
            NativeLong flags
    );

    /**
     * Finishes PKCS#7 verify operation for attached CMS and returns signed data and signer certificates.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession                   the session's handle
     * @param ppData                     signed data (eContent field of an EncapsulatedContentInfo)
     * @param pulDataSize                size of the data
     * @param ppSignerCertificates       pointer to signer certificates array of {@link CK_VENDOR_BUFFER}s
     * @param pulSignerCertificatesCount certificates array size
     */
    NativeLong C_EX_PKCS7Verify(
            NativeLong hSession,
            PointerByReference ppData,
            NativeLongByReference pulDataSize,
            PointerByReference ppSignerCertificates,
            NativeLongByReference pulSignerCertificatesCount
    );

    /**
     * Continues PKCS#7 verify operation for detached CMS.
     * Data that was signed should be passed to the library using this method.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession   the session's handle
     * @param pData      data block which was signed
     * @param ulDataSize size of the data
     */
    NativeLong C_EX_PKCS7VerifyUpdate(
            NativeLong hSession,
            byte[] pData,
            NativeLong ulDataSize
    );

    /**
     * Finishes PKCS#7 verify operation for detached CMS and returns signer certificates.
     * Can only be called in the "R/W User Functions" or "R User Functions" state.
     *
     * @param hSession                   the session's handle
     * @param ppSignerCertificates       pointer to signer certificates array of {@link CK_VENDOR_BUFFER}s
     * @param pulSignerCertificatesCount certificates array size
     */
    NativeLong C_EX_PKCS7VerifyFinal(
            NativeLong hSession,
            PointerByReference ppSignerCertificates,
            NativeLongByReference pulSignerCertificatesCount
    );
}
