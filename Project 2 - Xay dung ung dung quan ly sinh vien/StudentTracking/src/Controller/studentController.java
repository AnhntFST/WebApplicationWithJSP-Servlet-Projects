package Controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.Student.Student;
import com.Student.StudentDBUtil;

/**
 * Servlet implementation class studentController
 */
@WebServlet("/student")
public class studentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDBUtil studentDBUtil;
	
	@Resource(name = "jdbc/web_student_tracker")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		try {
		if (theCommand == null) {
			theCommand = "LIST";
		}
		switch(theCommand) {
			case "LIST":
				listStudent(request, response);
				break;
			case "ADD":
				addStudent(request, response);
				break;
			case "LOAD":
				loadStudent(request, response);
				break;
			case "UPDATE":
				updateSTD(request, response);
				break;
			case "DELETE":
				deleteStudent(request, response);
				break;
			case "SEARCH":
				searchStudent(request, response);
			default:
			listStudent(request, response);
		}
		}catch (Exception e) {
			throw new ServletException();
		}
		
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String theNameSearch = request.getParameter("theSearchName");
		
		// get Student by name search
		List<Student> theStudents = studentDBUtil.searchName(theNameSearch);
		
		request.setAttribute("LIST_STUDENT", theStudents);
		
		request.getRequestDispatcher("list-student.jsp").forward(request, response);
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer TheId =Integer.parseInt(request.getParameter("id"));
		
		studentDBUtil.deleteStudent(TheId);
		
		listStudent(request, response);
	}

	private void updateSTD(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get info from form
		Integer id =Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create new Student
		Student std = new Student(id, firstName, lastName, email);
		// and update on database
		studentDBUtil.updateStd(std);
		
		// show student
		listStudent(request, response);
		
	}

	
	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theId = request.getParameter("id");
		// Get student by id
		if (theId != null) {
			Integer id = Integer.parseInt(theId);
			Student theStudent = studentDBUtil.getStudentByID(id);
			request.setAttribute("STUDENT", theStudent);
			request.getRequestDispatcher("update-student-form.jsp").forward(request, response);
		}
		
			
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get student from form and create new student
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		Student student = new Student(firstName, lastName, email);
		
		// add to database
		studentDBUtil.addStudent(student);
		
		//return to list
		listStudent(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = studentDBUtil.getStudent();
		
		request.setAttribute("LIST_STUDENT", list);
		
		request.getRequestDispatcher("list-student.jsp").forward(request, response);
		
	}

}
