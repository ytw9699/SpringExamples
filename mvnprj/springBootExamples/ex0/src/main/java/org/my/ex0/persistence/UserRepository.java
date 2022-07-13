package org.my.ex0.persistence;
	import org.my.ex0.entity.UserEntity;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByUserId(String userId);
	Boolean existsByUserId(String userId);
	UserEntity findByUserIdAndPassword(String userId, String password);

}
