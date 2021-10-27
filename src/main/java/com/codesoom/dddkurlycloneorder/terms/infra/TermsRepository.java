package com.codesoom.dddkurlycloneorder.terms.infra;

import com.codesoom.dddkurlycloneorder.terms.domain.models.entity.Terms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<Terms, String> {
}
