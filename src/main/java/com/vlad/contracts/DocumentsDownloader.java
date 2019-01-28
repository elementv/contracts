package com.vlad.contracts;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Downloads documents of a contract.
 */
public class DocumentsDownloader {
    private OkHttpClient client = new OkHttpClient();

    private static final String DOWNLOAD_DOCUMENTS_URL_TEMPLATE = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/%s/documents";

    protected String buildLink(String contractID) {
        return String.format(DOWNLOAD_DOCUMENTS_URL_TEMPLATE, contractID);
    }

    /**
     * Downloads a document's contracts in JSON format.
     *
     * @param contractID contract ID. for example, 23567e24f52746ef92c470be6059d193
     * @return document list in JSON format
     * @throws IOException problems fetching data
     */
    public String downloadDocuments(String contractID) throws IOException {
        Request request = new Request.Builder().url(buildLink(contractID)).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
