package com.vlad.contracts.model;

import java.util.Objects;

/**
 * A class that represents the list of documents that belong to one contract.
 */
public class Document {
    private String hash;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String documentType;
    private String dateModified;
    private String id;
    private String relatedItem;
    private String description;
    private String language;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Document{" +
                "hash='" + hash + '\'' +
                ", format='" + format + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", documentOf='" + documentOf + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", documentType='" + documentType + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", id='" + id + '\'' +
                ", relatedItem='" + relatedItem + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(hash, document.hash) &&
                Objects.equals(format, document.format) &&
                Objects.equals(url, document.url) &&
                Objects.equals(title, document.title) &&
                Objects.equals(documentOf, document.documentOf) &&
                Objects.equals(datePublished, document.datePublished) &&
                Objects.equals(documentType, document.documentType) &&
                Objects.equals(dateModified, document.dateModified) &&
                Objects.equals(id, document.id) &&
                Objects.equals(relatedItem, document.relatedItem) &&
                Objects.equals(description, document.description) &&
                Objects.equals(language, document.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, format, url, title, documentOf, datePublished, documentType, dateModified, id, relatedItem, description, language);
    }
}
