package com.saw.apigrahql.repository;

import com.saw.apigrahql.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

}