package dataService;

import java.sql.SQLException;
import java.util.ArrayList;

import po.BussinessAreaPO;

public interface BussinessAreaDataService {

	public ArrayList<String> findCity() throws SQLException;
	
	public ArrayList<BussinessAreaPO> findBussinessAreaByCity(String city) throws SQLException;
}
