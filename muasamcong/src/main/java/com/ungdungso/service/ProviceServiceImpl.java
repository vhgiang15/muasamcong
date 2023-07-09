package com.ungdungso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungdungso.model.Province;
import com.ungdungso.repository.ProvinceRepository;

@Service

public class ProviceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public List<Province> getProvinceByArea(String area) {
		List<Province> list= provinceRepository.queryGetProvinceByArea(area);		
		return list;
	}

}
