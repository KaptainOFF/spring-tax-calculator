package com.kapitanov.database;

import java.util.HashMap;
import java.util.Map;

import com.kapitanov.springTaxCalculator.model.UserData;

public class TemporaryDatabase {
	
	private static Map<Long, UserData> userData = new HashMap<Long, UserData>();

	public static Map<Long, UserData> getUserData() {
		return userData;
	}

	public static void setUserData(Map<Long, UserData> userData) {
		TemporaryDatabase.userData = userData;
	}

}
