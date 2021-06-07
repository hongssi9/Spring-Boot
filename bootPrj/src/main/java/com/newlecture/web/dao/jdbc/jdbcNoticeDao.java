package com.newlecture.web.dao.jdbc;

import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class jdbcNoticeDao implements NoticeDao{

	@Override
	public Notice get(int id) {
		
		Notice notice = null;

//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
//		Class.forName("oracle.jdbc.OracleDriver");
//		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
//
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql); // 서버에 있는걸 가져오는..공간
//		if (rs.next()) {
//			String title = rs.getString("title");
//			String content = rs.getString("content");
//			String writerId = rs.getString("writer_Id");
//			Date regDate = rs.getDate("regDate");
//			int hit = rs.getInt("hit");
//			String files = rs.getString("files");
//
//			notice = new Notice();
//			notice.setId(id);
//			notice.setTitle(title);
//			notice.setContent(content);
//			notice.setRegDate(regDate);
//			notice.setHit(hit);
//			notice.setFiles(files);
//			notice.setWriterId(writerId);
//
//		}
//		rs.close();
//		st.close();
//		con.close(); // 서버닫기!
		return notice;
		
		
	}

	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int padge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int padge, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inser(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
