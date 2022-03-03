package com.umt.umt_server.dto;

import com.github.dozermapper.core.Mapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * DTO는 계층간 데이터 교환을 위한 객체
 * DB의 데이터를 Service나 Controller 등으로 보낼 때 사용하는 객체 입니다.
 */
@Builder
@Getter
@AllArgsConstructor
@ApiModel("사용자 가입 정보")
public class UserRegistrationData {

    @NotBlank(message = "사용자 이름을 입력하세요.")
    @Mapping("name")
    @ApiModelProperty(value = "사용자 이름", required = true, example = "김민우")
    private String name;

}
