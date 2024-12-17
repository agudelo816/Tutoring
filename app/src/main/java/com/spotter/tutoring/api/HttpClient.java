package com.spotter.tutoring.api;


import android.content.Context;
import android.util.Log;

import com.spotter.tutoring.R;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpClient {

    public static OkHttpClient getSecureOkHttpClient(Context context) {
        try {
            // Load the certificate from res/raw
            InputStream certInputStream = context.getResources().openRawResource(R.raw.cert);  // my_cert.crt

            // Create a CertificateFactory
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(certInputStream);

            // Create a KeyStore and add the certificate to it
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("server-cert", certificate);

            // Create a TrustManager that trusts the certificate
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            // Create an SSLContext using the TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new java.security.SecureRandom());

            // Create an OkHttpClient with the SSLContext
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0])
                    .addInterceptor(loggingInterceptor)  // Optional: For logging HTTP requests
                    .build();
        } catch (Exception e) {
            Log.e("HttpClient", "Error setting up SSL: " + e.getMessage(), e);
            return new OkHttpClient(); // Fallback to the default OkHttpClient
        }
    }
}
