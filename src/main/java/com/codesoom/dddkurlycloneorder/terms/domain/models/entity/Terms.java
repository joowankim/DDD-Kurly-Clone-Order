package com.codesoom.dddkurlycloneorder.terms.domain.models.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terms")
@NoArgsConstructor
public class Terms {
    @Id
    private String termsId;

    @Column(name = "content")
    private String content;

    public Terms(String termsId, String content) {
        this.termsId = termsId;
        this.content = content;
    }
}
