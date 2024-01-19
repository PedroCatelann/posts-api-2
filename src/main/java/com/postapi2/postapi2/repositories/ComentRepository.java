package com.postapi2.postapi2.repositories;

import com.postapi2.postapi2.domain.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<Coment, Long> {
}
