package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import webbanvali.entity.Vali;

public interface ValiRepository extends JpaRepository<Vali, String>, JpaSpecificationExecutor<Vali>{

	
}
