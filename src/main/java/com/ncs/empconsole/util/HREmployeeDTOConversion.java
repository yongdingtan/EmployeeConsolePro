package com.ncs.empconsole.util;

import org.springframework.stereotype.Component;

import com.ncs.empconsole.dto.HREmployeeResponseDTO;
import com.ncs.empconsole.model.Employee;


public class HREmployeeDTOConversion {

		public static HREmployeeResponseDTO convertToHRReponse(Employee e)
		{
			HREmployeeResponseDTO dto = new HREmployeeResponseDTO();
			
			dto.setEmpId(e.getEmpId());
			dto.setDesignation(e.getDesignation());
			dto.setEmail(e.getEmail());
			dto.setName(e.getName());
			dto.setAddress(e.getAddress());
			
			return dto;
		}
	
}
