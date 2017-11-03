package dbTest;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbTest.Person;


/**
 * Servlet implementation class CRUDServlet
 */
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String SELECT = "select";
    
    private final String ADD = "add";
    private final String INSERT = "insert"; 
    
    private final String UPDATE = "update"; 
    private final String EDIT = "edit";
    private final String DO_UPDATE = "do_update";
    
    private final String DELETE = "delete";
    private final String DO_DELETE = "Delete";
    private final String HOME = "Home";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if(op.equals(SELECT)) {
			request.setAttribute("action", SELECT);
			showDBcontent(request, response);
			
			
		}else if (op.equals(INSERT)) {
			request.setAttribute("action", ADD);
			request.setAttribute("actionName", "add");
			request.setAttribute("firstName", "");
			request.setAttribute("lastName", "");
			request.setAttribute("age", "");
			Person p = new Person(-1,"","",-1);
			request.setAttribute("person", p);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editTable.jsp");
			dispatcher.forward(request, response);

			}else if(op.equals(ADD)) {
				String firstname = request.getParameter("firstName");
				String lastname = request.getParameter("lastName");
				int age = Integer.parseInt(request.getParameter("age"));	
				System.out.println("Adding person with fn=" + firstname + ", ln=" + lastname + ", age=" + age);
				try {
					DatabaseOperation.addPerson(new Person(-1,firstname , lastname , age));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUD-Servlet?op=select");
			dispatcher.forward(request, response);
			
		}else if(op.equals(UPDATE)) {
			request.setAttribute("action", UPDATE);
			showDBcontent(request, response);
			
		}else if(op.equals(EDIT)) {
			request.setAttribute("action", EDIT);
			request.setAttribute("actionName", "edit");
			
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				Person person = DatabaseOperation.getPersonByID(id);
				
				request.setAttribute("person", person);
				request.setAttribute("firstName", person.getFirstname());
				request.setAttribute("lastName", person.getLastname());
				request.setAttribute("age", person.getAge());
				RequestDispatcher dispatcher = request.getRequestDispatcher("editTable.jsp");
				dispatcher.forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}else if(op.equals(DO_UPDATE)) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age = Integer.parseInt(request.getParameter("age"));
			try {
				DatabaseOperation.editPersonByID(id, new Person(0, firstName, lastName, age));
			} catch (SQLException e1) {
				System.out.println("non riesce a modificare la tabella!");
				e1.printStackTrace();
			}
			request.setAttribute("action", SELECT);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUD-Servlet?op=select");
			dispatcher.forward(request, response);
			try {
				DatabaseOperation.editPersonByID(id, new Person(0, firstName, lastName, age));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}else if(op.equals(DELETE)) {
			request.setAttribute("action", DELETE);
			showDBcontent(request, response);
		}else if(op.equals(DO_DELETE)) {
			int id = Integer.parseInt(request.getParameter("id"));
			DatabaseOperation.deletePersonByID(id);
			
			request.setAttribute("action", SELECT);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CRUD-Servlet?op=select");
			dispatcher.forward(request, response);
		}else if(op.equals(HOME)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	private void showDBcontent(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		List<Person> person = DatabaseOperation.readPersonTable();
		request.setAttribute("person", person);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showTable.jsp");
		dispatcher.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
