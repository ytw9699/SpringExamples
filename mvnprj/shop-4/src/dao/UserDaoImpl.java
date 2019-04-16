package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDaoImpl implements UserDao {

	private static final String INSERT = "INSERT INTO user_account (user_id, user_name, password, postcode, address, email, job, birthday)"
			+ " VALUES(:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}

	public void create(User user) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.template.update(UserDaoImpl.INSERT, parameterSource);
	}
}
