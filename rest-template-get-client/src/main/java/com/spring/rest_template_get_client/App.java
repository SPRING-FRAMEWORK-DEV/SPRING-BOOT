package com.spring.rest_template_get_client;

import com.app.client.EmployeeControllerClient;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EmployeeControllerClient.displayEmployeeById("1011");
		EmployeeControllerClient.displayEmployeeList();
	}
}
