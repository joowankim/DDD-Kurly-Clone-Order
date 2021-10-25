package com.codesoom.dddkurlycloneorder.member.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    private String memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = Reserves.class)
    private Reserves reserves;
}
