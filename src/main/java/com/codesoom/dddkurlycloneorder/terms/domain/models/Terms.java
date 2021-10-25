package com.codesoom.dddkurlycloneorder.terms.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terms {
    @Id
    private String termsId;

    @Column(name = "content")
    private String content;
}
