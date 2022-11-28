package J4_ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentListDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	String JDBC_URL    = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";

	String USER_ID     = "test_user";

	String USER_PASS   = "test_pass";

	public List<StudentListDto> selectData(){

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection        con = null ;
		PreparedStatement ps  = null ;
		ResultSet         rs  = null ;

		List<StudentListDto> dtoList = new ArrayList<StudentListDto>();

		try {

			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			StringBuffer buf = new StringBuffer();
			buf.append("  SELECT                               ");
			buf.append("  STUDENT_NAME                         ");
			buf.append("  名前,                                ");
			buf.append("  CASE                                 ");
			buf.append("  GENDER                               ");
			buf.append("  WHEN                                 ");
			buf.append("  1                                    ");
			buf.append("  THEN                                 ");
			buf.append("  '男性'                               ");
			buf.append("  WHEN                                 ");
			buf.append("  2                                    ");
			buf.append("  THEN                                 ");
			buf.append("  '女性'                               ");
			buf.append("  END                                  ");
			buf.append("  性別,                                ");
			buf.append("  AGE                                  ");
			buf.append("  年齢,                                ");
			buf.append("  CASE                                 ");
			buf.append("  WHEN                                 ");
			buf.append("  CAREER_MON<12&&CAREER_MON>0          ");
			buf.append("  THEN                                 ");
			buf.append("  CONCAT                               ");
			buf.append("  (                                    ");
			buf.append("  CAREER_MON,                          ");
			buf.append("  'ヶ月'                               ");
			buf.append("  )                                    ");
			buf.append("  WHEN                                 ");
			buf.append("  CAREER_MON>=12&&CAREER_MON%12=0      ");
			buf.append("  THEN                                 ");
			buf.append("  CONCAT                               ");
			buf.append("  (                                    ");
			buf.append("  CAREER_MON                           ");
			buf.append("  DIV                                  ");
			buf.append("  12,                                  ");
			buf.append("  '年'                                 ");
			buf.append("  )                                    ");
			buf.append("  WHEN                                 ");
			buf.append("  CAREER_MON>=12&&CAREER_MON%12!=0     ");
			buf.append("  THEN                                 ");
			buf.append("  CONCAT                               ");
			buf.append("  (                                    ");
			buf.append("  CAREER_MON                           ");
			buf.append("  DIV                                  ");
			buf.append("  12,                                  ");
			buf.append("  '年',                                ");
			buf.append("  CAREER_MON                           ");
			buf.append("  MOD                                  ");
			buf.append("  12,                                  ");
			buf.append("  'ヶ月'                               ");
			buf.append("  )                                    ");
			buf.append("  WHEN                                 ");
			buf.append("  CAREER_MON=0                         ");
			buf.append("  THEN                                 ");
			buf.append("  '職歴なし'                           ");
			buf.append("  END                                  ");
			buf.append("  職歴,                                ");
			buf.append("  BRANCH_NAME                          ");
			buf.append("  登録支店,                            ");
			buf.append("  CASE                                 ");
			buf.append("  WHEN                                 ");
			buf.append("  COURSE_NAME                          ");
			buf.append("  IS                                   ");
			buf.append("  NULL                                 ");
			buf.append("  THEN                                 ");
			buf.append("  '受講なし'                           ");
			buf.append("  ELSE                                 ");
			buf.append("  COURSE_NAME                          ");
			buf.append("  END                                  ");
			buf.append("  登録講座                             ");
			buf.append("  FROM                                 ");
			buf.append("  course                               ");
			buf.append("  B                                    ");
			buf.append("  RIGHT                                ");
			buf.append("  OUTER                                ");
			buf.append("  JOIN                                 ");
			buf.append("  uzuz_student                         ");
			buf.append("  A                                    ");
			buf.append("  ON                                   ");
			buf.append("  B.COURSE_ID                          ");
			buf.append("  =                                    ");
			buf.append("  A.COURSE_ID                          ");
			buf.append("  JOIN                                 ");
			buf.append("  branch                               ");
			buf.append("  C                                    ");
			buf.append("  ON                                   ");
			buf.append("  A.BRANCH_ID                          ");
			buf.append("  =                                    ");
			buf.append("  C.BRANCH_ID                          ");
			buf.append("  ;                                    ");

			ps = con.prepareStatement(buf.toString());

			rs = ps.executeQuery();

			while(rs.next()){
				StudentListDto dto = new StudentListDto();
				dto.setName  ( rs.getString( "名前"     ) );
				dto.setGender( rs.getString( "性別"     ) );
				dto.setAge   ( rs.getInt   ( "年齢"     ) );
				dto.setCareer( rs.getString( "職歴"     ) );
				dto.setBranch( rs.getString( "登録支店" ) );
				dto.setCourse( rs.getString( "登録講座" ) );
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