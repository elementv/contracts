package com.vlad.contracts.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Represents an entry of the database and represents one contract.
 */
@Entity
@Table(name = "CONTRACTS")
public class ContractEntity {
    @Id
    @Column(name = "ContractID")
    private String contractID;

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    @Override
    public String toString() {
        return "ContractEntity{" +
                "contractID='" + contractID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractEntity that = (ContractEntity) o;
        return Objects.equals(contractID, that.contractID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractID);
    }
}
