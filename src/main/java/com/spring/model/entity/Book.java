package com.spring.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private double price;
	
	@Transient
	private double discount;

	@ManyToOne
	@JoinColumn(name = "auther_id")
	private Auther auther;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	List<Borrower> borrowers;

	public Book(String name) {
		this.name = name;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
		for (Borrower borrower : borrowers) {
			borrower.setBook(this);
		}
	}
	
	public double getDiscount() {
		return price * 0.10;
	}

}
