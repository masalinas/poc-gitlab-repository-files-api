package io.oferto.gitlabapirest.service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import io.oferto.gitlabapirest.dto.RequestGitlabDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class GitlabService {
	private final RestTemplate restTemplate;
	
	public String findFile(RequestGitlabDto requestGitlabDto) {
		log.debug("findFile: found file with path {} in projectId {} and branch {}", requestGitlabDto.getFilePath(), requestGitlabDto.getProjectId(), requestGitlabDto.getBranch());
		
		HttpHeaders headers = new HttpHeaders();
	    headers.set("PRIVATE-TOKEN", requestGitlabDto.getAccessToken());
	    HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
	    	    	    	    	    	  	    
  	    URI gitlabUri = UriComponentsBuilder.newInstance()
  	      .scheme("https")
  	      .host("desgitlab.consum.es")
  	      .path("/api/v4/projects/" + requestGitlabDto.getProjectId() + "/repository/files/")
  	      .path(URLEncoder.encode(requestGitlabDto.getFilePath(), StandardCharsets.UTF_8))
  	      .path("/raw")
  	      .queryParam("ref", requestGitlabDto.getBranch())
  	      .build(true)
  	      .toUri();
  	    
  	    return restTemplate.exchange(gitlabUri, HttpMethod.GET, requestEntity, String.class).getBody();
	}
}
