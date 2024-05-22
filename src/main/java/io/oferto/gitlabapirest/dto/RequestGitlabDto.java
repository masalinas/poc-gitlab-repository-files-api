package io.oferto.gitlabapirest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestGitlabDto {
	private String accessToken;
	private int projectId;
	private String branch;
	private String filePath;
}
