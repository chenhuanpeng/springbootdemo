/*
 * Copyright (c) 2020 cdss4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.springbootdemo.demos.util;


import com.example.springbootdemo.demos.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String code;

	@Getter
	@Setter
	private String msg;

	@Getter
	@Setter
	private T data;

	@Getter
	@Setter
	private String traceId;

	public static <T> R<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, CommonConstants.FAIL, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, CommonConstants.FAIL, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, CommonConstants.FAIL, null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, CommonConstants.FAIL, msg);
	}

	public static <T> R<T> result(T data, String code, String msg) {
		return restResult(data, code, msg);
	}

	public static <T> R<T> restResult(T data, String code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		apiResult.setTraceId(MDC.get("traceId"));
		return apiResult;
	}

	public Boolean isSuccess() {
		return (CommonConstants.SUCCESS.equals(this.code));
	}

	public static R err(String returnCode) {
		R responseDto = new R();
		responseDto.code = returnCode;
		responseDto.msg = "fail";
		responseDto.setTraceId(MDC.get("traceId"));
		return responseDto;
	}

	public R msg(String msg) {
		this.msg = msg;
		return this;
	}

	public R data(T data) {
		this.data = data;
		return this;
	}
}
