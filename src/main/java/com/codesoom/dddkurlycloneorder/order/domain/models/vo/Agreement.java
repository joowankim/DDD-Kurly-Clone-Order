package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import com.codesoom.dddkurlycloneorder.terms.domain.models.entity.Terms;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {
    @ManyToOne(targetEntity = Terms.class)
    private Terms terms;

    @Column(name = "should_check_approved")
    private Boolean shouldCheckApproved;
}
