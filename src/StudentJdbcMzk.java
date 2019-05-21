import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcMzk {
    public List<StudentMzk> select(){
        List<StudentMzk> studentMzklist=new ArrayList();
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("select id,xueke,xuefen,teachername from student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StudentMzk studentMzk = new StudentMzk();
                studentMzk.setId(rs.getInt("id"));
                studentMzk.setXueke(rs.getString("xueke"));
                studentMzk.setXuefen(rs.getInt("xuefen"));
                studentMzk.setTeachername(rs.getString("teachername"));
                studentMzklist.add(studentMzk);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentMzklist;
    }
    public void insert(StudentMzk studentMzk){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("insert into student(xueke,xuefen,teachername) values (?,?,?)");
            ps.setString(1,studentMzk.getXueke());
            ps.setInt(2,studentMzk.getXuefen());
            ps.setString(3,studentMzk.getTeachername());
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void delete(int id){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
            ps.setInt(1,id);
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public StudentMzk get(int id){
        Connection conn =null;
        StudentMzk studentMzk = new StudentMzk();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("select id,xueke,xuefen,teachername from student where id="+id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                studentMzk.setXueke(rs.getString("xueke"));
                studentMzk.setXuefen(rs.getInt("xuefen"));
                studentMzk.setTeachername(rs.getString("teachername"));
                studentMzk.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentMzk;
    }
    public void modify(StudentMzk studentMzk){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            PreparedStatement ps = conn.prepareStatement("update student set xueke=?,xuefen=?,teachername=? where id=?");
            ps.setString(1,studentMzk.getXueke());
            ps.setInt(2,studentMzk.getXuefen());
            ps.setString(3,studentMzk.getTeachername());
            ps.setInt(4,studentMzk.getId());
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
