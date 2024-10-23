package chapter17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteEx05 {

	public static void main(String[] args) {

		Connection con = null;

		try {
			// 1. JDBC 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");

			// 2. Connection 얻기
			// 연결문자열
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// 사용자
			String user = "system";
			// 비밀번호
			String password = "12345";

			con = DriverManager.getConnection(url, user, password);

			// 3. 매개 변수화된 SQL 문 작성
			String sql = "DELETE FROM userTBL WHERE userid = ?";

			// 4. PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "connect");

			// 5. SQL 구문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 user 수 : " + rows);

			pstmt.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close(); // 연결 종료
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
