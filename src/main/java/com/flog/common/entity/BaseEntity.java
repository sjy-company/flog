package com.flog.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.flog.domain.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    private Boolean isDeleted = false;

    @CreatedBy
    @ManyToOne
    @JoinColumn(updatable = false)
    private User createdBy;

    @CreatedDate()
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate()
    private LocalDateTime updatedAt;
}
