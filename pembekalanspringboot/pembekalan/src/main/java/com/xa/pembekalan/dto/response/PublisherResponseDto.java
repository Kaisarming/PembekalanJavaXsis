package com.xa.pembekalan.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PublisherResponseDto {
    private Integer id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDelete;
}
