package com.ungdungso.service;

import java.util.List;

import com.ungdungso.model.Province;

public interface ProvinceService {
	public List<Province> getProvinceByArea(String area);
}
