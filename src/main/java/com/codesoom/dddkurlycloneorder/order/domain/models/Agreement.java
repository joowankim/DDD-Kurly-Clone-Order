package com.codesoom.dddkurlycloneorder.order.domain.models;

import com.codesoom.dddkurlycloneorder.terms.domain.models.Terms;

import javax.persistence.*;

@Entity
public class Agreement {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Terms.class)
    private Terms terms;

    @Column(name = "should_check_approved")
    private Boolean shouldCheckApproved;
}
