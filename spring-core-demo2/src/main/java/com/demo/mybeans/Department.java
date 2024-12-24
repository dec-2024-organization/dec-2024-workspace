package com.demo.mybeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode		
@Data

@Component
public class Department {
	@Value("101")
	private int deptId;
	
	@Value("ADMIN")
	private String deptName;
}
