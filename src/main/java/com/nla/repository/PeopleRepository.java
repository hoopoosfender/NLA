package com.nla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nla.model.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
