package com.postapi2.postapi2.repositories;

import com.postapi2.postapi2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
