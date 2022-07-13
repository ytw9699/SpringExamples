package org.my.ex0.controller;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.my.ex0.dto.BoardDTO;
    import org.my.ex0.dto.ResponseDTO;
    import org.my.ex0.entity.BoardEntity;
    import org.my.ex0.service.BoardService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.web.bind.annotation.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/board/test")
    public String test(){

        return "test";
    }

    @PostMapping("board")
    public ResponseEntity<?> createBoard(@AuthenticationPrincipal String userId, @RequestBody BoardDTO dto) {

        try {

            // (1) BoardEntity로 변환한다.
            BoardEntity entity = BoardDTO.toEntity(dto);

            // (3) 임시 유저 아이디를 설정 해 준다.
            // 이 부분은 4장 인증과 인가에서 수정 할 예정이다.
            // 지금은 인증과 인가 기능이 없으므로 한 유저(temporary-user)만 로그인 없이 사용 가능한 어플리케이션인 셈이다
            //entity.setUserId(dto.getUserId());
            entity.setUserId(userId);

            // (4) 서비스를 이용해 Todo엔티티를 생성한다.
            List<BoardEntity> entities = service.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.

            List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());

            // (6) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
            ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();

            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.

            String error = e.getMessage();
            log.warn(error);
            ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("board")
    public ResponseEntity<?> readBoard(@RequestParam("board_num") Long board_num) {

        List<BoardEntity> entities = service.read(board_num);

        List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());

        // (6) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok(response);
    }

    @PutMapping("board")
    public ResponseEntity<?> updateBoard(@AuthenticationPrincipal String userId, @RequestBody BoardDTO dto) {
        // (1) dto를 entity로 변환한다.
        BoardEntity entity = BoardDTO.toEntity(dto);

        // (2) id를 userId 초기화 한다.
        entity.setUserId(userId);

        // (3) 서비스를 이용해 entity를 업데이트 한다.
        List<BoardEntity> entities = service.update(entity);

        // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO리스트로 변환한다.
        List<BoardDTO> dtos = entities.stream().map(BoardDTO::new).collect(Collectors.toList());

        // (5) 변환된 TodoDTO리스트를 이용해ResponseDTO를 초기화한다.
        ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();

        // (6) ResponseDTO를 리턴한다.
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("board")
    public ResponseEntity<?> deleteBoard(@AuthenticationPrincipal String userId, @RequestBody BoardDTO dto) {

        try {
            // (1) TodoEntity로 변환한다.
            BoardEntity entity = BoardDTO.toEntity(dto);

            // (2) 임시 유저 아이디를 설정 해 준다.
            entity.setUserId(userId);

            // (3) 서비스를 이용해 entity를 삭제 한다.
            service.delete(entity);

            // (6) ResponseDTO를 리턴한다.
            return ResponseEntity.ok("delete");

        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
