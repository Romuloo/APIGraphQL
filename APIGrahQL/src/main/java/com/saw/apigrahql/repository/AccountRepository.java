package com.saw.apigrahql.repository;

import com.saw.apigrahql.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, Long> {

}
