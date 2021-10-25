package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "streest_name_address")
    private String streetNameAddress;

    @Column(name = "address_details")
    private String addressDetails;
}
