package com.demo.mybeans;

import java.util.Objects;

public class Person {
	private int personId;
	private String personFirstName;
	private String personLastName;
	
	public Person() {}

	public Person(int personId, String personFirstName, String personLastName) {
		super();
		this.personId = personId;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(personFirstName, personId, personLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(personFirstName, other.personFirstName) && personId == other.personId
				&& Objects.equals(personLastName, other.personLastName);
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personFirstName=" + personFirstName + ", personLastName="
				+ personLastName + "]";
	}
}
