package dao;
	import java.util.List;
	import javax.sql.DataSource;
	import logic.Item;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
	//db�� �۾�
	public class ItemDaoImpl implements ItemDao {//dao�� ������ �Ǿ� �� ��ü���� ������ �����Ҽ��ִ� ������ �̷��� �Ѱ�.. 
	
		private SimpleJdbcTemplate template;
		//��� �޼ҵ� ��� ���ĳ��� SimpleJdbcTemplate , 3�������پ��� ���ø� �̶� �̰ž���
		public void setDataSource(DataSource dataSource) {
			this.template = new SimpleJdbcTemplate(dataSource);//�� ��ü�� �־�� �����۾���
		}
		private static final String SELECT_ALL = //����� ������ ����
	"SELECT item_id, item_name, price, description, picture_url FROM item order by item_id";// item���̺��� 
	//item_id���� �������� ����
	public List<Item> findAll() {//ItemDao���� �������̵�
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		//�����ڿ� �ڹٺ��̸��� �־��ָ� SELECT������ �����µ����͸� �ڹٺ� �ڵ����� �����ϴµ�
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);//mapper��ü�� ���� �ڹٺ� �����°� ����
	}
}
//1.�� ����(RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);)��
//2.ItemDaoImpl.SELECT_ALL, mapper);�� mapper�̸����� �־��༭ �Ʒ� 3. �ڵ� �� ����

//3.return this.template.query(ItemDaoImpl.SELECT_ALL, new GuestMessageRowMapper());
/*3.new RowMapper<GuestMessage>(){//�������� ����Ǽ� �����µ����͸�  �ڹٺ� ����,�̳�Ŭ������ �� ������ ���̸ӽ� �̳�Ŭ����
	@Override
	public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {//��Ŭ������ �޼ҵ� �������̵�
		GuestMessage message = new GuestMessage();
			message.setId(rs.getInt("MESSAGE_ID"));
			message.setGuestName(rs.getString("GUEST_NAME"));
			message.setMessage(rs.getString("MESSAGE"));
			message.setRegistryDate(rs.getDate("REGISTRY_DATE"));
			return message;
		}
});*/

//query�� �����÷��� �������� ������
/*ITEM_ID	ITEM_NAME	PRICE				DESCRIPTION	   							PICTURE_URL	
181			����			50		���� ���Ե� �������� �Ƿ�ȸ���� �����ϴ�. ��Ÿ�� C�� ǳ���մϴ�.	lemon.jpg	
182			������		100		��Ÿ�� C�� ǳ���մϴ�. ������ �ֽ��� ���ø� �����ϴ�.				orange.jpg	
183			Ű��			200		��Ÿ�� C�� �ſ� ǳ���մϴ�. ���̾�Ʈ�� �̿뿡 �����ϴ�.			kiui.jpg	
184			����			300		��������� �ٷ� �����ϰ� �־� �׻�ȭ �ۿ��� �մϴ�.				budou.jpg	
185			����			800		��Ÿ�� C�� �ö󺸳��̵带 �ٷ� �����ϰ� �ֽ��ϴ�.					ichigo.jpg	
186			��			1000	�ó��Ǹ��� �����ϰ� �־� ���� ���濡 ���ٰ� �մϴ�.				mikan.jpg	*/










