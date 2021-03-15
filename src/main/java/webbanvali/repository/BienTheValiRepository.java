package webbanvali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import webbanvali.entity.BienTheVali;
import webbanvali.entity.BienTheVali_PK;

public interface BienTheValiRepository extends JpaRepository<BienTheVali, BienTheVali_PK>, JpaSpecificationExecutor<BienTheVali>{

	
}
