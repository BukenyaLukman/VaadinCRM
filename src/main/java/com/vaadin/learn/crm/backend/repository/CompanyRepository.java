package com.vaadin.learn.crm.backend.repository;

import com.vaadin.learn.crm.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long>{

}
