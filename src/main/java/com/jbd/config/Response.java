package com.jbd.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*******************************************************************************************************************************************************
 *   
 * Created By: @author Digvijay.Jatkar 
 * Description: This classes is created for the response 
 * Created Date: 27/10/2022
 * History:
 * Version	 Modified Date 		By 							Description 
 * 1.0 	     27/10/2022 	Digvijay Jatkar    			This classes is created for the response 
 * ***************************************************************************************************************************************************
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	@JsonInclude(Include.NON_NULL)
	private String message;
	@JsonInclude(Include.NON_NULL)
	private Object data;
	@JsonInclude(Include.NON_NULL)
	private String errorMessage;
}