package de.tekup.vue.ui.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int id;
	
	private String name;
	
	private String password;
		
	private String email;
	
	private LocalDate date;
	
	public void setDate(String date) {
		this.date = LocalDate.parse(date);
	}
	
	public String getDate() {
		return date.format(DateTimeFormatter.ISO_DATE);
	}

}
