package com.umt.umt_server.dto;

import com.github.dozermapper.core.Mapping;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * DTO는 계층간 데이터 교환을 위한 객체
 * DB의 데이터를 Service나 Controller 등으로 보낼 때 사용하는 객체 입니다.
 */

@Builder
@Getter
@AllArgsConstructor
@ApiModel("사용자 결과 정보")
public class UserResultData {

    @ApiModelProperty(value = "사용자 인덱스", example = "김민우")
    private String id;

    @ApiModelProperty(value = "사용자 이름", example = "김민우")
    private String name;
}
