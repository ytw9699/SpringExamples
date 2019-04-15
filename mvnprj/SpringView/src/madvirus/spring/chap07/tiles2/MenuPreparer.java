package madvirus.spring.chap07.tiles2;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;

public class MenuPreparer implements ViewPreparer {

@Override
public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
	List<String> menuList = new ArrayList<String>();
	menuList.add("홈");
	menuList.add("로그인");
	menuList.add("회원가입");
	tilesContext.getRequestScope().put("menuList", menuList);
}
}
