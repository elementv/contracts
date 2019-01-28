package com.vlad.contracts.model;

import java.util.List;
import java.util.Objects;

public class Documents {
    private List<Document> data;

    public List<Document> getData() {
        return data;
    }

    public void setData(List<Document> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documents documents = (Documents) o;
        return Objects.equals(data, documents.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
