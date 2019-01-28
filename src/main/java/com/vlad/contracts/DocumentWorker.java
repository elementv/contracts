package com.vlad.contracts;

import com.vlad.contracts.database.ContractEntity;
import com.vlad.contracts.database.DocumentEntity;
import com.vlad.contracts.model.Document;
import com.vlad.contracts.model.Documents;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * Download documents from the server and uploads them to the database.
 */
@Component
public class DocumentWorker {
    @Autowired
    private SessionFactory sessionFactory;

    private DocumentParser documentParser;

    public DocumentWorker(DocumentParser documentParser) {
        this.documentParser = documentParser;
    }

    public DocumentWorker() {
        this(new DocumentParser());
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Downloads documents from the server and writes them to the database.
     *
     * @param contractIDs list of contract IDs
     */
    public void processDocuments(List<String> contractIDs) throws IOException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Map<String, Documents> contractDocumentMap = documentParser.getContractDocumentMap(contractIDs);
        contractDocumentMap.forEach((contractID, documents) ->
                documents.getData().forEach(document -> {
                    DocumentEntity documentEntity = convertFromRestToDBType(contractID, document);
                    session.save(documentEntity);
                })
        );
        session.getTransaction().commit();
    }

    /**
     * Converts a document in REST type to a document in the database type.
     *
     * @param document
     * @return
     */
    public static DocumentEntity convertFromRestToDBType(String contractID, Document document) {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setDateModified(OffsetDateTime.parse(document.getDateModified()));
        documentEntity.setDatePublished(OffsetDateTime.parse(document.getDatePublished()));
        documentEntity.setDescription(document.getDescription());
        documentEntity.setDocumentID(document.getId());
        documentEntity.setDocumentOf(document.getDocumentOf());
        documentEntity.setDocumentType(document.getDocumentType());
        documentEntity.setFormat(document.getFormat());
        documentEntity.setHash(document.getHash());
        documentEntity.setLanguage(document.getLanguage());
        documentEntity.setUrl(document.getUrl());
        documentEntity.setTitle(document.getTitle());
        documentEntity.setRelatedItem(document.getRelatedItem());
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setContractID(contractID);
        documentEntity.setContractEntity(contractEntity);
        return documentEntity;
    }
}
