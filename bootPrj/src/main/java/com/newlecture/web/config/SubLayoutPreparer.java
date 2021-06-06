package com.newlecture.web.config;

import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;

public class SubLayoutPreparer implements ViewPreparer { // tiles에 넣기위한 클래스 //고정된 데이터,값을 넣기위한

	@Override	//tiles가 제공하는 Request → 알아서 tiles.xml로 넣어준다.	
	public void execute(Request tilesContext, AttributeContext attributeContext) {

		Map<String, Object> model = tilesContext.getContext("request");

		model.put("data", "default data"); //모든 페이지에 사용될 기본값 //.header.jsp랑 연결
		Object title = model.get("title"); //layout.jsp랑 연결
		if (title == null)
			model.put("title", "뉴렉처 온라인2");

	}

}
