-- OneDayGallery
CREATE DATABASE gallerydb3;
USE gallerydb3;

CREATE TABLE tbl_gallerys(
g_id	VARCHAR(125)		PRIMARY KEY,
g_author	VARCHAR(50)	NOT NULL	,
g_password VARCHAR(10) NOT NULL,
g_subject	VARCHAR(40)	NOT NULL,	
g_content	VARCHAR(100)	NOT NULL	,
g_origin_image	VARCHAR(255)	NOT NULL,	
g_up_image	VARCHAR(255)	NOT NULL	
);

CREATE TABLE tbl_images(
i_id	VARCHAR(125)		PRIMARY KEY	,
i_gid	VARCHAR(125)	NOT NULL,
i_origin_image	VARCHAR(255)	NOT NULL		,
i_up_image	VARCHAR(255)	NOT NULL		,
CONSTRAINT tbl_gallerys FOREIGN KEY (i_gid)
REFERENCES tbl_gallerys(g_id) 
ON DELETE CASCADE
);

select * from tbl_gallerys;
select * from tbl_images;

drop database galleryDB3;

alter table tbl_gallerys
modify column g_author varchar(50);

alter table tbl_gallerys
add column g_date varchar(10),
add column g_time varchar(10);
