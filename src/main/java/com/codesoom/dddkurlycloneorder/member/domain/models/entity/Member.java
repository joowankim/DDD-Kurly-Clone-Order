package com.codesoom.dddkurlycloneorder.member.domain.models.entity;

import com.codesoom.dddkurlycloneorder.member.domain.models.vo.Reserves;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "members")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Embedded
    private Reserves reserves;
}
