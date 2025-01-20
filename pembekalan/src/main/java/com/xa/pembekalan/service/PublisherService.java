package com.xa.pembekalan.service;

import java.util.List;

import com.xa.pembekalan.dto.request.PublisherRequestDto;
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.entity.Publisher;

public interface PublisherService {
    List<PublisherResponseDto> getAllPublishers();

    PublisherResponseDto getPublisherById(Integer id);

    Publisher savePublisher(PublisherRequestDto publisherRequestDto);

    void deletePublisherById(Integer id);
}
