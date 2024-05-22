package io.oferto.gitlabapirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import io.oferto.gitlabapirest.dto.RequestGitlabDto;
import io.oferto.gitlabapirest.service.GitlabService;

@RestController
@RequiredArgsConstructor
@RequestMapping("gitlab")
public class GitLabController {
	private final GitlabService gitlabService;
	
	@GetMapping("/files")
	public ResponseEntity<String> findFile(@RequestBody RequestGitlabDto requestGitlabDto) {
		String fileValue = gitlabService.findFile(requestGitlabDto);
									
		return new ResponseEntity<String>(fileValue, HttpStatus.OK);		
		
	}
}
