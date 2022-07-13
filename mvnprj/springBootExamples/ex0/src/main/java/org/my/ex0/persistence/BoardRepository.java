package org.my.ex0.persistence;
	import org.my.ex0.entity.BoardEntity;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	import java.util.List;
	import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

	//List<BoardEntity> findByUserId(String userId);//저장된 엔티티를 포함하는 새 리스트를 리턴
}
