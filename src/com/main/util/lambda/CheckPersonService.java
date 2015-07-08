package com.main.util.lambda;

public class CheckPersonService implements CheckPerson {

	@Override
	public boolean test(Person p) {
		return p.gender == Sex.MALE;
	}

}
