package com.hoangnt.repository;

import com.hoangnt.model.dto.UserDTO;
import com.hoangnt.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByName(String firstName);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"user.name\": \"?0\"}}]}}")
    Page<User> findByUserNameUsingCustomQuery(String name, Pageable pageable);
}
