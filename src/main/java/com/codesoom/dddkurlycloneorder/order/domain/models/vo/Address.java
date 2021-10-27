package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Address {
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "streest_name_address")
    private String streetNameAddress;

    @Column(name = "address_details")
    private String addressDetails;
}
