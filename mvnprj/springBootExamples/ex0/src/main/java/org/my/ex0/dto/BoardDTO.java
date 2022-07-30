package org.my.ex0.dto;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import org.my.ex0.entity.BoardEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	private Long board_num;
	private String title;
	private String userId;
	private String content;
	private boolean done;

	public BoardDTO(final BoardEntity entity) {
		this.board_num = entity.getBoard_num();
		this.title = entity.getTitle();
		this.userId = entity.getUserId();
		this.content = entity.getContent();
		this.done = entity.isDone();
	}

	public static BoardEntity toEntity(final BoardDTO dto) {

		return BoardEntity.builder()
						.title(dto.getTitle())
						.board_num(dto.getBoard_num())
						.userId(dto.getUserId())
						.content(dto.getContent())
						.done(dto.isDone())
						.build();
	}
}

