package ru.rutoken.pkcs11jna;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({ "pTrustedCertificates", "ulTrustedCertificatesCount", "pCertificates",
        "ulCertificatesCount", "pCrls", "ulCrlsCount" })
public class CK_VENDOR_X509_STORE extends Pkcs11Structure {

    public CK_VENDOR_BUFFER.ByReference pTrustedCertificates; // CK_VENDOR_BUFFER_PTR
    public NativeLong ulTrustedCertificatesCount;
    public CK_VENDOR_BUFFER.ByReference pCertificates; // CK_VENDOR_BUFFER_PTR
    public NativeLong ulCertificatesCount;
    public CK_VENDOR_BUFFER.ByReference pCrls; // CK_VENDOR_BUFFER_PTR
    public NativeLong ulCrlsCount;

    public CK_VENDOR_X509_STORE() {
    }

    public CK_VENDOR_X509_STORE(CK_VENDOR_BUFFER.ByReference[] pTrustedCertificates,
                                CK_VENDOR_BUFFER.ByReference[] pCertificates,
                                CK_VENDOR_BUFFER.ByReference[] pCrls) {
        if (pTrustedCertificates != null && pTrustedCertificates.length != 0) {
            this.pTrustedCertificates = pTrustedCertificates[0];
            this.ulTrustedCertificatesCount = new NativeLong(pTrustedCertificates.length);
        } else {
            this.ulTrustedCertificatesCount = new NativeLong(0);
        }
        if (pCertificates != null && pCertificates.length != 0) {
            this.pCertificates = pCertificates[0];
            this.ulCertificatesCount = new NativeLong(pCertificates.length);
        } else {
            this.ulCertificatesCount = new NativeLong(0);
        }
        if (pCrls != null && pCrls.length != 0) {
            this.pCrls = pCrls[0];
            this.ulCrlsCount = new NativeLong(pCrls.length);
        } else {
            this.ulCrlsCount = new NativeLong(0);
        }
    }
}
