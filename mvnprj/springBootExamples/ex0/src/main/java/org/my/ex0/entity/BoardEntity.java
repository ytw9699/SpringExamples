package org.my.ex0.entity;
	import javax.persistence.*;

	import lombok.AllArgsConstructor;
	import lombok.Builder;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import org.hibernate.annotations.GenericGenerator;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Board")
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//키 생성 전략 IDENTITY = 사용하는 데이터베이스가 키 생성을 결정 MariaDB의 경우 auto increment 방식을 이용
	private Long board_num;

	@Column(length = 200, nullable = false)
	private String userId;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(length = 4000, nullable = false)
	private String content;

	private boolean done;
}

