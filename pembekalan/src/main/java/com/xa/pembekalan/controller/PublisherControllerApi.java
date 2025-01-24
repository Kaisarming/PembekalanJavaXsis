package com.xa.pembekalan.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.pembekalan.dto.request.PublisherRequestDto;
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.service.PublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import com.xa.pembekalan.entity.Publisher;

@RestController
@RequestMapping("/publisher/api")
public class PublisherControllerApi {
    @Autowired
    PublisherService publisherService;

    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @GetMapping()
    public ResponseEntity<?> getAllPublishers() {
        List<PublisherResponseDto> publisherResponseDtos = publisherService.getAllPublishers();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        // put hanya bilt-in method biasa untuk LinkedHashMap
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", publisherResponseDtos);
        // Return dari ResponseEntity ini bisa kita lihat menggunakan Postman
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    // @PathVariable digunakan untuk mengekstrak id yang ada pada API Endpoint (API
    // URL)
    @GetMapping("/{id}")
    public ResponseEntity<?> getPublisherById(@PathVariable Integer id) {
        PublisherResponseDto publisherResponseDto = publisherService.getPublisherById(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", publisherResponseDto);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    // @RequestBody digunakan untuk mengonversi JSON object menjadi object Java yang
    // sesuai
    @PostMapping("/save")
    public ResponseEntity<?> savePublisher(@RequestBody PublisherRequestDto publisherRequestDto) {
        Publisher publisher = publisherService.savePublisher(publisherRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", publisher);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @PutMapping("save/{id}")
    public ResponseEntity<?> updatePublisher(@PathVariable Integer id,
            @RequestBody PublisherRequestDto publisherRequestDto) {
        PublisherResponseDto publisherResponseDto = publisherService.getPublisherById(id);
        Publisher publisher = modelMapper().map(publisherResponseDto, Publisher.class);
        publisher.setId(id);
        publisher = publisherService.savePublisher(publisherRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", publisher);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Integer id) {
        publisherService.deletePublisherById(id);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}