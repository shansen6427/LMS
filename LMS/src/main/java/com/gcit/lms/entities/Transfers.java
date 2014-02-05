package com.gcit.lms.entities;

// Generated Feb 5, 2014 3:10:53 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TblTransfers generated by hbm2java
 */
@Entity
@Table(name = "tbl_transfers", catalog = "library")
public class Transfers implements java.io.Serializable {

	private TransfersId id;
	private LibraryBranch tblLibraryBranchByToBranchId;
	private LibraryBranch tblLibraryBranchByFromBranchId;
	private int transCopies;

	public Transfers() {
	}

	public Transfers(TransfersId id,
			LibraryBranch tblLibraryBranchByToBranchId,
			LibraryBranch tblLibraryBranchByFromBranchId, int transCopies) {
		this.id = id;
		this.tblLibraryBranchByToBranchId = tblLibraryBranchByToBranchId;
		this.tblLibraryBranchByFromBranchId = tblLibraryBranchByFromBranchId;
		this.transCopies = transCopies;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "fromBranchId", column = @Column(name = "fromBranchId", nullable = false)),
			@AttributeOverride(name = "toBranchId", column = @Column(name = "toBranchId", nullable = false)),
			@AttributeOverride(name = "catId", column = @Column(name = "catId", nullable = false)) })
	public TransfersId getId() {
		return this.id;
	}

	public void setId(TransfersId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "toBranchId", nullable = false, insertable = false, updatable = false)
	public LibraryBranch getTblLibraryBranchByToBranchId() {
		return this.tblLibraryBranchByToBranchId;
	}

	public void setTblLibraryBranchByToBranchId(
			LibraryBranch tblLibraryBranchByToBranchId) {
		this.tblLibraryBranchByToBranchId = tblLibraryBranchByToBranchId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fromBranchId", nullable = false, insertable = false, updatable = false)
	public LibraryBranch getTblLibraryBranchByFromBranchId() {
		return this.tblLibraryBranchByFromBranchId;
	}

	public void setTblLibraryBranchByFromBranchId(
			LibraryBranch tblLibraryBranchByFromBranchId) {
		this.tblLibraryBranchByFromBranchId = tblLibraryBranchByFromBranchId;
	}

	@Column(name = "transCopies", nullable = false)
	public int getTransCopies() {
		return this.transCopies;
	}

	public void setTransCopies(int transCopies) {
		this.transCopies = transCopies;
	}

}