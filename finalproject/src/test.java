import com.controller.demo.dao.imp.EmployeeDaoImpJdbc;
import com.controller.demo.dao.imp.OfficeDaoImpJdbc;
import com.controller.demo.domain.Employee;
import com.controller.demo.domain.Office;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDaoImpJdbc order=new EmployeeDaoImpJdbc();
	
		order.remove(11);

	}

}
