package com.gcit.lms.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.gcit.lms.entities.Author;
import com.gcit.lms.entities.LibraryBranch;


public class Test {

	
	public static void main(String[] args) throws Exception{
		
		AdminService adminService = new AdminService();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Author author = new Author();
		LibraryBranch lib = new LibraryBranch();
		lib.setBranchAddress("XYZ");
		lib.setBranchId(110);
		lib.setBranchName("ABC");
		LibrarianService libService = new LibrarianService();
		libService.updateBranchDetails(lib);
		
		System.out.println("enter author name");
		author.setAuthorName(in.readLine());
		//author.setAuthorId(10);
		adminService.insertUpdate(author);
		System.out.println("SUCCESS");
		
	}
}
