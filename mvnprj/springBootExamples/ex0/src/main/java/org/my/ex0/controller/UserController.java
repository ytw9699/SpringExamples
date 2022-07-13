package org.my.ex0.controller;
	import lombok.RequiredArgsConstructor;
	import lombok.extern.slf4j.Slf4j;
	import org.my.ex0.dto.ResponseDTO;
	import org.my.ex0.dto.UserDTO;
	import org.my.ex0.entity.UserEntity;
	import org.my.ex0.security.TokenProvider;
	import org.my.ex0.service.BoardService;
	import org.my.ex0.service.UserService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final TokenProvider tokenProvider;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/auth/signup")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {

		try {

			UserEntity user = UserEntity.builder()
							.userId(userDTO.getUserId())
							.nickName(userDTO.getNickName())
							.password(passwordEncoder.encode(userDTO.getPassword()))
							.build();	// 리퀘스트를 이용해 저장할 유저 만들기


			UserEntity userEntity = userService.create(user);// 서비스를 이용해 리파지토리에 유저 저장

			UserDTO responseUserDTO = UserDTO.builder()
							.userId(userEntity.getUserId())
							.nickName(userEntity.getNickName())
							.build();

			return ResponseEntity.ok(responseUserDTO);
			// 유저 정보는 항상 하나이므로 그냥 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.

		}catch (Exception e) {

			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();

			return ResponseEntity
							.badRequest()
							.body(responseDTO);
		}
	}

	@PostMapping("/auth/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {

		UserEntity userEntity = userService.getUserAuthenticated(
				userDTO.getUserId(),
				userDTO.getPassword(),
				passwordEncoder);

		if(userEntity != null) {	// 토큰 생성

			final String token = tokenProvider.create(userEntity);

			final UserDTO responseUserDTO = UserDTO.builder()
					.userId(userEntity.getUserId())
					.nickName(userEntity.getNickName())
					.token(token)
					.build();

			return ResponseEntity.ok().body(responseUserDTO);

		} else {

			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Login failed.")
					.build();

			return ResponseEntity
					.badRequest()
					.body(responseDTO);
		}
	}
}
