package dev.stepherson.customer.domain.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @Column(nullable = false, name = "customer_type")
    private String customerType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false)
    private List<Address> addresses;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @Column
    private LocalDateTime deleted_at;

    @Column(nullable = false)
    private Boolean deleted;

    public Customer(String name, String email, String phoneNumber, String document, List<Address> addresses) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.document = document;
        this.addresses = addresses;
    }

    @PrePersist
    private void PrePersist() {
        this.created_at = LocalDateTime.now();
        this.customerType = getPersonTypeByDocument(this.document);
        this.updated_at = created_at;

        if (this.deleted == null) {
            this.deleted = Boolean.FALSE;
        }
    }

    @PreUpdate
    private void PreUpdate() {
        this.updated_at = LocalDateTime.now();
    }

    public void markAsDeleted() {
        this.deleted = true;
        this.deleted_at = LocalDateTime.now();
    }

    public String getPersonTypeByDocument(String document) {
        if (document != null) {
            if (document.length() == 11)
                return "PF";
            if (document.length() == 14)
                return "PJ";
        }

        return "UNKNOWN";
    }

}
