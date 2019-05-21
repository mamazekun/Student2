import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServletMzk extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op=req.getParameter("op");
        if(op.equals("select")){
            System.out.println("查询");
            select(req,resp);
        }
        if(op.equals("insert")){
            System.out.println("添加");
            insert(req,resp);
        }
        if(op.equals("delete")){
            System.out.println("删除");
            delete(req,resp);
        }
        if(op.equals("tomodify")){
            System.out.println("获取");
            get(req,resp);
        }
        if(op.equals("modify")){
            System.out.println("修改");
            modify(req,resp);
        }
    }
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentMzklist",new StudentJdbcMzk().select());
        req.getRequestDispatcher("/studentlistmzk.jsp").forward(req,resp);
    }
    public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentMzk studentMzk = new StudentMzk();
        studentMzk.setXueke(req.getParameter("xueke"));
        studentMzk.setXuefen(Integer.parseInt(req.getParameter("xuefen")));
        studentMzk.setTeachername(req.getParameter("teachername"));
        new StudentJdbcMzk().insert(studentMzk);
        select(req,resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids[]=req.getParameterValues("ids");
        StudentJdbcMzk studentJdbcMzk = new StudentJdbcMzk();
        for(int i=0;i<ids.length;i++){
            studentJdbcMzk.delete(Integer.parseInt(ids[i]));
        }
        select(req,resp);
    }
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentMzk",new StudentJdbcMzk().get(Integer.parseInt(req.getParameter("ids"))));
        req.getRequestDispatcher("/modifymzk.jsp").forward(req,resp);
    }
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentMzk studentMzk = new StudentMzk();
        studentMzk.setXueke(req.getParameter("xueke"));
        studentMzk.setXuefen(Integer.parseInt(req.getParameter("xuefen")));
        studentMzk.setTeachername(req.getParameter("teachername"));
        studentMzk.setId(Integer.parseInt(req.getParameter("id")));
        new StudentJdbcMzk().modify(studentMzk);
        select(req,resp);
    }
}
