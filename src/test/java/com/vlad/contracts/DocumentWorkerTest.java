package com.vlad.contracts;

import com.vlad.contracts.database.ContractEntity;
import com.vlad.contracts.database.DocumentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.transaction.Synchronization;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DocumentWorkerTest {
    private String firstOutput;
    private String secondOutput;
    private String thirdOutput;

    private List<DocumentEntity> firtContractEntities;

    @Before
    public void beforeTest() throws IOException {
        firstOutput = new String(Files.readAllBytes(Paths.get("src//test//resources//documents1.json")));
        secondOutput = new String(Files.readAllBytes(Paths.get("src//test//resources//documents2.json")));
        thirdOutput = new String(Files.readAllBytes(Paths.get("src//test//resources//documents3.json")));
        ContractEntity contractEntity1 = new ContractEntity();
        contractEntity1.setContractID("23567e24f52746ef92c470be6059d193");
        DocumentEntity firstContractEntity1 = new DocumentEntity();
        firstContractEntity1.setDocumentID("4f6d6dc59d1844bb80143ccc2e727a2f");
        firstContractEntity1.setHash("md5:232dba893a22ac722249ad92f8bccf22");
        firstContractEntity1.setDatePublished(OffsetDateTime.parse("2018-09-19T13:12:21.136232+03:00"));
        firstContractEntity1.setDateModified(OffsetDateTime.parse("2018-09-19T13:12:21.136263+03:00"));
        firstContractEntity1.setFormat("text/plain");
        firstContractEntity1.setUrl("https://public-docs-sandbox.prozorro.gov.ua/get/3500487074064bd98f1076c21fe69e9a?KeyID=1331dc52&Signature=w%252BTQLJCiU%2FDQXfp%2FxB0VfDNRzImPv7zch3e8H1jfVOZrDJZuam%2FOTVLlvpdUiz9WVLHdUzdMrQJclbl4Vs28CQ%253D%253D");
        firstContractEntity1.setTitle("11.09.2018.xlsx");
        firstContractEntity1.setDocumentOf("tender");
        firstContractEntity1.setDocumentType("subContract");
        firstContractEntity1.setRelatedItem(null);
        firstContractEntity1.setDescription(null);
        firstContractEntity1.setLanguage(null);
        firstContractEntity1.setContractEntity(contractEntity1);
        DocumentEntity firstContractEntity2 = new DocumentEntity();
        firstContractEntity2.setDocumentID("a5ef4c3063d94b10a13630fa9cca90b9");
        firstContractEntity2.setHash("md5:ee80acf16c48f3b659a2132526ae9800");
        firstContractEntity2.setDatePublished(OffsetDateTime.parse("2018-09-19T13:13:07.776613+03:00"));
        firstContractEntity2.setDateModified(OffsetDateTime.parse("2018-09-19T13:13:07.776633+03:00"));
        firstContractEntity2.setFormat("application/pkcs7-signature");
        firstContractEntity2.setUrl("https://public-docs-sandbox.prozorro.gov.ua/get/04a93d0ba3e44e7e93a104a1b1ec8aaf?KeyID=1331dc52&Signature=o1V0G3cmFYjuu7MqIJxTY9zhDAj7PTblieehL0PEG%2FA5uc0VZlpY%252BMhQy0ZxTPdymnkPvAVxivDEodSI4RFDCw%253D%253D");
        firstContractEntity2.setTitle("sign.p7s");
        firstContractEntity2.setDocumentOf("tender");
        firstContractEntity2.setDocumentType(null);
        firstContractEntity2.setRelatedItem(null);
        firstContractEntity2.setDescription(null);
        firstContractEntity2.setLanguage(null);
        firstContractEntity2.setContractEntity(contractEntity1);
        DocumentEntity firstContractEntity3 = new DocumentEntity();
        firstContractEntity3.setDocumentID("f58353848e744791ad72f9baf84b5734");
        firstContractEntity3.setHash("md5:061044f40512fa72e03c2674d1539e0f");
        firstContractEntity3.setDatePublished(OffsetDateTime.parse("2018-09-24T16:00:29.527286+03:00"));
        firstContractEntity3.setDateModified(OffsetDateTime.parse("2018-09-24T16:00:29.527311+03:00"));
        firstContractEntity3.setFormat("text/plain");
        firstContractEntity3.setUrl("https://public-docs-sandbox.prozorro.gov.ua/get/5e03ef2402bd42ddb7dc78d526c95f81?KeyID=1331dc52&Signature=VjKGxj7WlIe%252BqZpE4OJl1qtIt0VQJ%2FMff8n8KaJWVHDANkFZB%252BcZbsq%2Fr%252BzW6S81cqeSU9hYlLLnq1WGpJ%252BuCQ%253D%253D");
        firstContractEntity3.setTitle("тест.docx");
        firstContractEntity3.setDocumentOf("change");
        firstContractEntity3.setDocumentType(null);
        firstContractEntity3.setRelatedItem("6167ab1f7a184f75881b166b9c2e9193");
        firstContractEntity3.setDescription(null);
        firstContractEntity3.setLanguage(null);
        firstContractEntity3.setContractEntity(contractEntity1);
        firtContractEntities = Arrays.asList(firstContractEntity1, firstContractEntity2, firstContractEntity3);
    }

    @Test
    public void processDocumentsTest1() throws IOException {
        List<DocumentEntity> savedDocumentEntities = new ArrayList<DocumentEntity>();
        Session sessionMocked = mock(Session.class);
        when(sessionMocked.save(Mockito.any(DocumentEntity.class))).then(documentEntity -> {
            DocumentEntity firstArgument = (DocumentEntity) documentEntity.getArguments()[0];
            savedDocumentEntities.add(firstArgument);
            return null;
        });
        when(sessionMocked.beginTransaction()).then(arg -> null);
        when(sessionMocked.getTransaction()).then(arg -> new Transaction() {
            @Override
            public void begin() {

            }

            @Override
            public void commit() {

            }

            @Override
            public void rollback() {

            }

            @Override
            public void setRollbackOnly() {

            }

            @Override
            public boolean getRollbackOnly() {
                return false;
            }

            @Override
            public boolean isActive() {
                return false;
            }

            @Override
            public TransactionStatus getStatus() {
                return null;
            }

            @Override
            public void registerSynchronization(Synchronization synchronization) throws HibernateException {

            }

            @Override
            public void setTimeout(int i) {

            }

            @Override
            public int getTimeout() {
                return 0;
            }
        });
        SessionFactory sessionFactoryMocked = mock(SessionFactory.class);
        when(sessionFactoryMocked.openSession()).thenReturn(sessionMocked);
        DocumentsDownloader documentsDownloader = mock(DocumentsDownloader.class);
        when(documentsDownloader.downloadDocuments("23567e24f52746ef92c470be6059d193")).thenReturn(firstOutput);
        DocumentParser documentParser = new DocumentParser(documentsDownloader);
        DocumentWorker documentWorker = new DocumentWorker(documentParser);
        documentWorker.setSessionFactory(sessionFactoryMocked);
        documentWorker.processDocuments(Arrays.asList("23567e24f52746ef92c470be6059d193"));
        assertEquals(firtContractEntities, savedDocumentEntities);
    }
}
