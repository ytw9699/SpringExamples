package dao;
	import java.util.List;
	import javax.sql.DataSource;
	import logic.Item;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
	//db쪽 작업
	public class ItemDaoImpl implements ItemDao {//dao가 여러개 되야 이 전체적인 구조를 이해할수있다 지금은 이렇게 한개.. 
	
		private SimpleJdbcTemplate template;
		//모든 메소드 기능 합쳐놓은 SimpleJdbcTemplate , 3가지경우다쓰는 템플릿 이라 이거쓰자
		public void setDataSource(DataSource dataSource) {
			this.template = new SimpleJdbcTemplate(dataSource);//이 객체가 있어야 디비단작업함
		}
		private static final String SELECT_ALL = //상수로 쿼리문 정의
	"SELECT item_id, item_name, price, description, picture_url FROM item order by item_id";// item테이블에서 
	//item_id기준 오름차순 정렬
	public List<Item> findAll() {//ItemDao에서 오버라이드
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		//생성자에 자바빈이름만 넣어주면 SELECT문으로 꺼내온데이터를 자바빈에 자동으로 셋팅하는듯
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);//mapper객체를 통해 자바빈에 꺼내온거 설정
	}
}
//1.이 과정(RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);)을
//2.ItemDaoImpl.SELECT_ALL, mapper);의 mapper이름으로 넣어줘서 아래 3. 코드 를 생략

//3.return this.template.query(ItemDaoImpl.SELECT_ALL, new GuestMessageRowMapper());
/*3.new RowMapper<GuestMessage>(){//쿼리문이 실행되서 꺼내온데이터를  자바빈에 설정,이너클래스의 한 종류인 어노미머스 이너클래스
	@Override
	public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {//이클래스의 메소드 오버라이드
		GuestMessage message = new GuestMessage();
			message.setId(rs.getInt("MESSAGE_ID"));
			message.setGuestName(rs.getString("GUEST_NAME"));
			message.setMessage(rs.getString("MESSAGE"));
			message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
			return message;
		}
});*/

//query는 여러컬럼의 여러줄을 가져옴
/*ITEM_ID	ITEM_NAME	PRICE				DESCRIPTION	   							PICTURE_URL	
181			레몬			50		레몬에 포함된 구연산은 피로회복에 좋습니다. 비타민 C도 풍부합니다.	lemon.jpg	
182			오렌지		100		비타민 C가 풍부합니다. 생과일 주스로 마시면 좋습니다.				orange.jpg	
183			키위			200		비타민 C가 매우 풍부합니다. 다이어트나 미용에 좋습니다.			kiui.jpg	
184			포도			300		폴리페놀을 다량 함유하고 있어 항산화 작용을 합니다.				budou.jpg	
185			딸기			800		비타민 C나 플라보노이드를 다량 함유하고 있습니다.					ichigo.jpg	
186			귤			1000	시네피린을 함유하고 있어 감기 예방에 좋다고 합니다.				mikan.jpg	*/










