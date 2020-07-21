package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class getAjaxDataServlet
 */
@WebServlet("/getAjaxDataServlet")
public class getAjaxDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAjaxDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		empDAO dao = new empDAO();
		List<Employee> list = dao.getSelect();
		JSONObject obj = new JSONObject();
//		JSONArray ary = new JSONArray();
		JSONArray outAry = new JSONArray();
		for(Employee str: list) {
			JSONArray inAry = new JSONArray();
			inAry.add(str.getFirstName());
			inAry.add(str.getLastName());
			inAry.add(str.getEmail());
			inAry.add(str.getJobId());
			inAry.add(str.getHireDate());
			inAry.add(str.getSalary());
		outAry.add(inAry);
		
		}
		obj.put("data",outAry);
		PrintWriter out = response.getWriter();
		out.write(obj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
