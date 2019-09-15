package wp.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private Connection con;

	public void deleteBook(String code){
		try{
			String sql = "delete from books where bookid=?";
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1,code);
			st.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		                   
		
	}
	public void saveBook(Book book) {
		try {
			String sql = "insert into books values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getCode());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getSubject());
			ps.setString(5, book.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Book searchBook(String code) {
		Book book = null;
		String sql = "SELECT * FROM books WHERE bookid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setCode(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setSubject(rs.getString(4));
				book.setPrice(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	public List<Book> getAllBooks() {
		ArrayList<Book> al = new ArrayList();
		String sql  = "select * from books";
		return null;
	}

	public BookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "abcd1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
