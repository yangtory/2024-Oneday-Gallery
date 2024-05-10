package com.tory.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GalleryVO {
	private String g_id; //	VARCHAR(125)		PRIMARY KEY,
	private String g_author; //	VARCHAR(20)	NOT NULL	,
	private String g_password; // VARCHAR(10) NOT NULL,
	private String g_subject; //	VARCHAR(40)	NOT NULL,	
	private String g_content; //	VARCHAR(100)	NOT NULL	,
	private String g_origin_image; //	VARCHAR(255)	NOT NULL,	
	private String g_up_image; //	VARCHAR(255)	NOT NULL	
}
