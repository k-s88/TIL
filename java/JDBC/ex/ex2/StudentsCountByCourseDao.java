package J4_ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsCountByCourseDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

	String USER_ID     = "test_user";

	String USER_PASS   = "test_pass";

	public List<StudentsCountByCourseDto> selectData(){

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection        con = null ;
		PreparedStatement ps  = null ;
		ResultSet         rs  = null ;

		List<StudentsCountByCourseDto> dtoList = new ArrayList<StudentsCountByCourseDto>();

		try {

			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			StringBuffer buf = new StringBuffer();
			buf.append("  SELECT                 ");
			buf.append("  C.BRANCH_NAME          ");
			buf.append("  登録支店,              ");
			buf.append("  B.COURSE_NAME          ");
			buf.append("  受講講座,              ");
			buf.append("  COUNT(*)               ");
			buf.append("  受講者数               ");
			buf.append("  FROM                   ");
			buf.append("  course B               ");
			buf.append("  INNER JOIN             ");
			buf.append("  uzuz_student A         ");
			buf.append("  ON                     ");
			buf.append("  B.COURSE_ID            ");
			buf.append("  =                      ");
			buf.append("  A.COURSE_ID            ");
			buf.append("  JOIN                   ");
			buf.append("  branch C               ");
			buf.append("  ON                     ");
			buf.append("  A.BRANCH_ID            ");
			buf.append("  =                      ");
			buf.append("  C.BRANCH_ID            ");
			buf.append("  GROUP BY               ");
			buf.append("  BRANCH_NAME,           ");
			buf.append("  COURSE_NAME            ");
			buf.append("  ORDER BY               ");
			buf.append("  C.BRANCH_ID            ");

			ps = con.prepareStatement(buf.toString());

			rs = ps.executeQuery();

			while(rs.next()){
				StudentsCountByCourseDto dto = new StudentsCountByCourseDto();
				dto.setBranch( rs.getString( "登録支店" ) );
				dto.setCourse( rs.getString( "受講講座" ) );
				dto.setCount ( rs.getInt   ( "受講者数" ) );
				dtoList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return dtoList;
	}
}