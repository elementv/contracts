package com.vlad.contracts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlad.contracts.model.Documents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentParser {
    private DocumentsDownloader documentsDownloader;

    public DocumentParser(DocumentsDownloader documentsDownloader) {
        this.documentsDownloader = documentsDownloader;
    }

    public DocumentParser() {
        this(new DocumentsDownloader());
    }

    public Documents parseDocuments(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Documents.class);
    }

    public Documents getDocuments(String contactID) throws IOException {
        return parseDocuments(documentsDownloader.downloadDocuments(contactID));
    }

    /**
     * @return Map where the key is the contract ID and the value is the list of documents that belong to the contract
     */
    public Map<String, Documents> getContractDocumentMap(List<String> contractIDs) throws IOException {
        Map<String, Documents> map = new HashMap<>();
        for (String contractID : contractIDs) {
            map.put(contractID, getDocuments(contractID));
        }
        return map;
    }
}
