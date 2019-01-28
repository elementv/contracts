CREATE TABLE CONTRACTS (
    ContractID VARCHAR(50) PRIMARY KEY
);

CREATE TABLE DOCUMENTS (
    DocumentID VARCHAR(50) PRIMARY KEY,
    ContractID VARCHAR(50) REFERENCES CONTRACTS(ContractID),
    Hash VARCHAR(50),
    Format VARCHAR(50),
    Url TEXT,
    Title VARCHAR(50),
    DocumentOf VARCHAR(50),
    DatePublished TIMESTAMPTZ,
    DocumentType VARCHAR(50),
    DateModified TIMESTAMPTZ,
    RelatedItem VARCHAR(50),
    Description TEXT,
    DocumentLanguage VARCHAR(50)
);

INSERT INTO DOCUMENTS (DocumentID, DatePublished)
VALUES
('4f6d6dc59d1844bb80143ccc2e727a2f', '2018-09-19T13:12:21.136232+03:00');


SELECT DatePublished
FROM  DOCUMENTS