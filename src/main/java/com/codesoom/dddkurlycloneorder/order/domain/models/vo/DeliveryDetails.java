package com.codesoom.dddkurlycloneorder.order.domain.models.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeliveryDetails {
    @Embedded
    private ReceiverInfo receiverInfo;

    @Column(name = "place_to_receive")
    private String placeToReceive;

    @Column(name = "procedure_of_entrace")
    private String procedureOfEntrance;

    @Column(name = "time_to_get_msg")
    private String timeToGetMsg;
}
