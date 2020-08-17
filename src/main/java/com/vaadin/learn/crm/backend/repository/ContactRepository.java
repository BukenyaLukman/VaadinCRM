package com.vaadin.learn.crm.backend.repository;

import com.vaadin.learn.crm.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long>{

}
