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
	menuList.add("Ȩ");
	menuList.add("�α���");
	menuList.add("ȸ������");
	tilesContext.getRequestScope().put("menuList", menuList);
}
}