package org.my.ex0.service;
	import lombok.RequiredArgsConstructor;
	import lombok.extern.slf4j.Slf4j;
	import org.my.ex0.entity.BoardEntity;
	import org.my.ex0.persistence.BoardRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository repository;

	public List<BoardEntity> create(final BoardEntity entity) {

		validate(entity);

		repository.save(entity).getBoard_num();

		log.info("Entity Id : {} is saved.", entity.getBoard_num());

		return read(entity.getBoard_num());
	}

	public List<BoardEntity> read(final long board_num) {

		Optional<BoardEntity> result = repository.findById(board_num);

		BoardEntity boardEntity = result.get();
		ArrayList<BoardEntity> list = new ArrayList();
		list.add(boardEntity);
		return list;
	}

	public List<BoardEntity> update(final BoardEntity entity) {
		// (1) 저장 할 엔티티가 유효한지 확인한다. 이 메서드는 2.3.1 Create Todo에서 구현했다.
		validate(entity);

		// (2) 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않는 엔티티는 업데이트 할 수 없기 때문이다.
		final Optional<BoardEntity> originBoardEntity = repository.findById(entity.getBoard_num());

		originBoardEntity.ifPresent(newBoardEntity -> {
			// (3) 반환된 TodoEntity가 존재하면 값을 새 entity의 값으로 덮어 씌운다.
			newBoardEntity.setTitle(entity.getTitle());
			newBoardEntity.setContent(entity.getContent());
			newBoardEntity.setDone(entity.isDone());
			// (4) 데이터베이스에 새 값을 저장한다.
			repository.save(newBoardEntity);
		});

		// 2.3.2 Retrieve Todo에서 만든 메서드를 이용해 유저의 모든 Todo 리스트를 리턴한다.
		return read(entity.getBoard_num());
	}

	public void delete(final BoardEntity entity) {
		// (1) 저장 할 엔티티가 유효한지 확인한다. 이 메서드는 2.3.1 Create Todo에서 구현했다.
		validate(entity);

		try {
			// (2) 엔티티를 삭제한다.
			repository.delete(entity);

		} catch(Exception e) {
			// (3) exception 발생시 id와 exception을 로깅한다.
			log.error("error deleting entity ", entity.getBoard_num(), e);

			// (4) 컨트롤러로 exception을 날린다. 데이터베이스 내부 로직을 캡슐화 하기 위해 e를 리턴하지 않고 새 exception 오브젝트를 리턴한다.
			throw new RuntimeException("error deleting entity " + entity.getBoard_num());
		}
	}

	private void validate(final BoardEntity entity) {//	Validations 넘어온 엔티티가 유효한지 검사하는 로직, 코드가 더 커지면 분리
	//private이 맞는가? 136p
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}

		if(entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
	}

}
