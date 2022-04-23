package org.zerock.service;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	import org.zerock.domain.BoardAttachVO;
	import org.zerock.domain.BoardVO;
	import org.zerock.domain.Criteria;
	import org.zerock.mapper.BoardAttachMapper;
	import org.zerock.mapper.BoardMapper;
	import lombok.Setter;
	import lombok.ToString;
	import lombok.extern.log4j.Log4j;

@Log4j
@ToString
@Service//비즈니스 영역담당 어노테이션
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;//spring4.3이상에서 자동처리//202쪽

	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	@Override
	public BoardVO get(Long bno) {

		log.info("get......" + bno);

		return mapper.read(bno);
	}
	
	@Transactional
	@Override
	public void register(BoardVO board) {

		log.info("register......" + board);

		mapper.insertSelectKey(board);

		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}

		board.getAttachList().forEach(attach -> {// attach는 BoardAttachVO

			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Transactional
	@Override
	public boolean modify(BoardVO board) {

		log.info("modify......" + board);

		attachMapper.deleteAll(board.getBno());//일단 첨부파일 모두 삭제

		boolean modifyResult = mapper.update(board) == 1; 
		
		if (modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {

			board.getAttachList().forEach(attach -> {

				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}

		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {

		log.info("remove...." + bno);

		attachMapper.deleteAll(bno);

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {

		log.info("get List with criteria: " + cri);

		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {

		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {

		log.info("get Attach list by bno" + bno);

		return attachMapper.findByBno(bno);
	}

	@Override
	public void removeAttach(Long bno) {

		log.info("remove all attach files");

		attachMapper.deleteAll(bno);
	}

}
