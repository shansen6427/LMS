package com.gcit.lms.entities;

// Generated Jan 30, 2014 2:32:50 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TblLibraryBranch generated by hbm2java
 */
@Entity
@Table(name = "tbl_library_branch", catalog = "library")
public class LibraryBranch implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7105946468378683614L;
	private Integer branchId;
	private String branchName;
	private String branchAddress;
	private Set<BookLoans> bookLoans = new HashSet<BookLoans>(0);
	private Set<BookCopies> bookCopies = new HashSet<BookCopies>(0);

	public LibraryBranch() {
	}

	public LibraryBranch(String branchName, String branchAddress,
			Set<BookLoans> tblBookLoans, Set<BookCopies> tblBookCopies) {
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.bookLoans = tblBookLoans;
		this.bookCopies = tblBookCopies;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "branchId", unique = true, nullable = false)
	public Integer getBranchId() {
		return this.branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	@Column(name = "branchName", length = 45)
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "branchAddress", length = 45)
	public String getBranchAddress() {
		return this.branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libraryBranch")
	public Set<BookLoans> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(Set<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libraryBranch")
	public Set<BookCopies> getBookCopies() {
		return this.bookCopies;
	}

	public void setBookCopies(Set<BookCopies> bookCopies) {
		this.bookCopies = bookCopies;
	}

}