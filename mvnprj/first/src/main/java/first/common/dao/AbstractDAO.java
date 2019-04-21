package first.common.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	protected Log log = LogFactory.getLog(AbstractDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);//쿼리문에대한걸 콘솔에찍으려고
		}
	}
	public Object insert(String queryId, Object params){
		printQueryId(queryId);//로그찍고
		return sqlSession.insert(queryId, params);//마이바티스쪽 id에 해당되는건 호출 작업
	}
	public Object update(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}
	public Object delete(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}
	public Object selectOne(String queryId){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}
	public Object selectOne(String queryId, Object params){//오버로딩
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	@SuppressWarnings("rawtypes")//@SuppressWarnings은 경고 부분인데 신경스지말자
	public List selectList(String queryId){
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){//오버로딩
		printQueryId(queryId);
		return sqlSession.selectList(queryId,params);
	}
}
