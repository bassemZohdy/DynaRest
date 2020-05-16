package com.dynarest.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private boolean disabled;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Field> fields;

    @JsonIgnore
    @Version
    private Long version;
    @Column(nullable = false, updatable = false)

    @JsonIgnore
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @JsonIgnore
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @JsonIgnore
    @CreatedBy
    private String createdBy;
    @JsonIgnore
    @LastModifiedBy
    private String modifiedBy;

    @PrePersist
    @PreUpdate
    void preSave(){
        for(Field f : fields) {
            if(f.getResource()==null){
                f.setResource(this);
            }
        }
    }
}