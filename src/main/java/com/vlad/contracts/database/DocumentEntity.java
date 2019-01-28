package com.vlad.contracts.database;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Represents an entry of the database and represents one document.
 */
@Entity
@Table(name = "DOCUMENTS")
public class DocumentEntity implements Serializable {
    @Id
    @Column(name = "DocumentID")
    private String documentID;

    @Column(name = "Hash")
    private String hash;

    @Column(name = "DatePublished", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime datePublished;

    @Column(name = "dateModified", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime dateModified;

    @Column(name = "Format")
    private String format;

    @Column(name = "Url")
    private String url;

    @Column(name = "Title")
    private String title;

    @Column(name = "DocumentOf")
    private String documentOf;

    @Column(name = "DocumentType")
    private String documentType;

    @Column(name = "RelatedItem")
    private String relatedItem;

    @Column(name = "Description")
    private String description;

    @Column(name = "Language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "ContractID", nullable = false, foreignKey = @ForeignKey(name="ContractID"))
    private ContractEntity contractEntity;

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public OffsetDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(OffsetDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public OffsetDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(OffsetDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(String documentOf) {
        this.documentOf = documentOf;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }

    @Override
    public String toString() {
        return "DocumentEntity{" +
                "documentID='" + documentID + '\'' +
                ", hash='" + hash + '\'' +
                ", datePublished=" + datePublished +
                ", dateModified=" + dateModified +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", documentType='" + documentType + '\'' +
                ", relatedItem='" + relatedItem + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", contractEntity=" + contractEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentEntity that = (DocumentEntity) o;
        return Objects.equals(documentID, that.documentID) &&
                Objects.equals(hash, that.hash) &&
                Objects.equals(datePublished, that.datePublished) &&
                Objects.equals(dateModified, that.dateModified) &&
                Objects.equals(format, that.format) &&
                Objects.equals(url, that.url) &&
                Objects.equals(title, that.title) &&
                Objects.equals(documentOf, that.documentOf) &&
                Objects.equals(documentType, that.documentType) &&
                Objects.equals(relatedItem, that.relatedItem) &&
                Objects.equals(description, that.description) &&
                Objects.equals(language, that.language) &&
                Objects.equals(contractEntity, that.contractEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentID, hash, datePublished, dateModified, format, url, title, documentOf, documentType, relatedItem, description, language, contractEntity);
    }
}
