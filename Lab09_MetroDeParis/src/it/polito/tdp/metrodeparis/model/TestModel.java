package it.polito.tdp.metrodeparis.model;

import java.sql.SQLException;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println("TODO: write a Model class and test it!");
		try {
			model.createGraph();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
