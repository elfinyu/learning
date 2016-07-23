package pageobjects;

import org.testng.annotations.Test;

import data.DataManagement;

public class DataManagementTest {

	@Test
	public void test(){
		DataManagement instance = DataManagement.getInstance();
	}
}
