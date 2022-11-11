package org.ec.example.community.dto.hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Long> {
}
