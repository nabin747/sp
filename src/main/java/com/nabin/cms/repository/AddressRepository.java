package com.nabin.cms.repository;

import com.nabin.cms.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nabin
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}
