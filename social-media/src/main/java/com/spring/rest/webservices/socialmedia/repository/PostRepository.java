package com.spring.rest.webservices.socialmedia.repository;

import com.spring.rest.webservices.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
