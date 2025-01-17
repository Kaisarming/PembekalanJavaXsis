package com.xa.pembekalan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.pembekalan.dto.request.PublisherRequestDto;
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.entity.Publisher;
import com.xa.pembekalan.repository.PublisherRepository;
import com.xa.pembekalan.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public List<PublisherResponseDto> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherResponseDto> publisherResponseDtos = publishers.stream()
                .map(publisher -> modelMapper().map(publisher, PublisherResponseDto.class))
                .collect(Collectors.toList());
        return publisherResponseDtos;
    }

    @Override
    public PublisherResponseDto getPublisherById(Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        PublisherResponseDto publisherResponseDto = modelMapper().map(publisher, PublisherResponseDto.class);
        return publisherResponseDto;
    }

    @Override
    public Publisher savePublisher(PublisherRequestDto publisherRequestDto) {
        Publisher publisher = modelMapper().map(publisherRequestDto, Publisher.class);
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisherById(Integer id) {
        publisherRepository.deleteById(id);
    }
}
