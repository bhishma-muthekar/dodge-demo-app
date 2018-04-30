package com.dodge.dodgedemoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodge.dodgedemoapp.entity.InfactRecord;
import com.dodge.dodgedemoapp.repository.InfactRecordRepository;

@Service
public class InfactRecordServiceImpl implements InfactRecordService {

	@Autowired
	private InfactRecordRepository infactRecordRepository;

	@Override
	public List<InfactRecord> list() {
		return infactRecordRepository.findAll();
	}

	@Override
	public void save(InfactRecord infactRecord) {
		try {
			infactRecordRepository.save(infactRecord);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

	@Override
	public InfactRecord get(Long recordId) {
		try {
			return infactRecordRepository.findByRecordId(recordId);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(InfactRecord infactRecord) {
		infactRecordRepository.save(infactRecord);
	}

}
