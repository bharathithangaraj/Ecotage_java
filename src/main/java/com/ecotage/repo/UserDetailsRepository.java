package com.ecotage.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecotage.model.UserDetail;
import com.ecotage.response.dto.UserDetailDTO;

public interface UserDetailsRepository extends JpaRepository<UserDetail, Long>{

	List<UserDetail> findByUserId(Long userId);

}
