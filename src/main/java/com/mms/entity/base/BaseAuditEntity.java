package com.mms.entity.base;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class BaseAuditEntity extends BaseEntity {

    private String createdBy;

    private String updatedBy;

    @CreationTimestamp
    private Date createdAt;

    @CreationTimestamp
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = Date.from(Instant.now());
        this.createdBy = "anonymous";
        this.updatedAt = Date.from(Instant.now());
        this.updatedBy = "anonymous";
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = Date.from(Instant.now());
        this.updatedBy = "anonymous";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseAuditEntity that = (BaseAuditEntity) o;
        return Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), createdBy, updatedBy, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "BaseAuditEntity{" +
                "createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
