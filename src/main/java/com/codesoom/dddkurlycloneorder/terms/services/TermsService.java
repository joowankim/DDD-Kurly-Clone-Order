package com.codesoom.dddkurlycloneorder.terms.services;

import com.codesoom.dddkurlycloneorder.terms.domain.models.entity.Terms;
import com.codesoom.dddkurlycloneorder.terms.infra.TermsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TermsService {
    private final TermsRepository termsRepository;

    public Terms get(String termsId) {
        return termsRepository.getById(termsId);
    }
}
