package dao;
import java.util.List;
import javax.sql.DataSource;
import logic.Item;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ItemDaoImpl implements ItemDao {

	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	private static final String SELECT_ALL = 
	"SELECT item_id, item_name, price, description, picture_url FROM item order by item_id";
	
	//밑에만 추가 한줄짜리 가져오는것
	private static final String SELECT_BY_PRIMARY_KEY = 
	"SELECT item_id, item_name, price, description, picture_url FROM item WHERE item_id = ?";
	
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);
	}
	public Item findByPrimaryKey(Integer itemId) {//오버라이드
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.queryForObject(SELECT_BY_PRIMARY_KEY, mapper, itemId);// 한줄짜리 가져오는것
						//mapper는꺼내온데이터 설정해주는것				//itemId는 무름표에들어갈거
	}
}
















