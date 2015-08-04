package com.web.model;

import com.web.util.Util;

public class BaseModel {
	@Override
	public String toString(){
		return Util.toJson(this);
	}
}
