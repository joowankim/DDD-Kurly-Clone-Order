package com.codesoom.dddkurlycloneorder.order.domain.models;

import javax.persistence.*;

@Entity
public class DeliveryDetails {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(targetEntity = ReceiverInfo.class)
    private ReceiverInfo receiverInfo;

    @Column(name = "place_to_receive")
    private String placeToReceive;

    @Column(name = "procedure_of_entrace")
    private String procedureOfEntrance;

    @Column(name = "time_to_get_msg")
    private String timeToGetMsg;
}
