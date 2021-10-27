package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReceiverInfo {
    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_phone_number")
    private String phoneNumber;
}
