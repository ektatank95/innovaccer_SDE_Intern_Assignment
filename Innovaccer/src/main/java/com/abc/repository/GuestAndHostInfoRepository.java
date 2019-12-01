package com.abc.repository;

import com.abc.entity.GuestAndHostInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestAndHostInfoRepository extends CrudRepository<GuestAndHostInfo,Integer> {}