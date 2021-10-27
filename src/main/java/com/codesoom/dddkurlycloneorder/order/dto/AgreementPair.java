package com.codesoom.dddkurlycloneorder.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AgreementPair {
    private String termsId;
    private Boolean shouldCheckAgreement;
}
