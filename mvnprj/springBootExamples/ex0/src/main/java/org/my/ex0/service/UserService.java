package org.my.ex0.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.my.ex0.entity.UserEntity;
import org.my.ex0.persistence.BoardRepository;
import org.my.ex0.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserEntity create(final UserEntity userEntity) {

		if(userEntity == null || userEntity.getUserId() == null || userEntity.getNickName() == null) {
			throw new RuntimeException("Invalid arguments");
		}

		final String userId = userEntity.getUserId();

		if(userRepository.existsByUserId(userId)) {
			log.warn("userId already exists {}", userId);
			throw new RuntimeException("userId already exists");
		}

		return userRepository.save(userEntity);
	}

	public UserEntity getUserAuthenticated(final String userId, final String password, final PasswordEncoder encoder) {

		final UserEntity userEntity = userRepository.findByUserId(userId);

		// matches 메서드를 이용해 패스워드가 같은지 확인
		if(userEntity != null && encoder.matches(password, userEntity.getPassword())) {
			return userEntity;
		}

		return null;
	}
}
