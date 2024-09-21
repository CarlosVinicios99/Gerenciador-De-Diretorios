CREATE TABLE TABLE_FILES (
	file_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name VARCHAR(100) NOT NULL,
	created_timestamp BIGINT NOT NULL,
	updated_timestamp BIGINT NOT NULL,
	super_directory_id UUID NOT NULL,
	
	FOREIGN KEY (super_directory_id) REFERENCES TABLE_DIRECTORIES(directory_id)
);
