package com.example.demo.handlers;

import java.util.List;

import com.example.demo.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
	private String status;
    private String message;

}
