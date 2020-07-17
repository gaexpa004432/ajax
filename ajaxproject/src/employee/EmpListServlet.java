package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("창ㅇ이호");
//		response.getWriter().append("{\"id\":\"user1\",\"first_name\":\"hong\"}");
//		out.write("{\\\"id\\\":\\\"user1\\\",\\\"first_name\\\":\\\"hong\\\"}");
		empDAO dao = new empDAO();
		List<Employee> list = dao.getEmpList();
		int oo =0;
//		ObjectMapper mapper = new ObjectMapper();

//		String jsonStr = mapper.writeValueAsString(list);



//		System.out.println(jsonStr);



	
		out.write('[');
		for(Employee emp : list) {
			
			out.write("{\"id\":\""+emp.getEmployeeId()+
					"\",\"first_name\":\""+emp.getFirstName()+
					"\",\"email\":\""+emp.getEmail()+
					"\",\"salary\":\"" +emp.getSalary()+"\"}");
			if(++oo == list.size()) {
				
			}else {
				out.write(",");
			}
			
			
		}
		out.write("]");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
