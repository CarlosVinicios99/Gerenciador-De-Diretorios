CREATE TABLE TABLE_DIRECTORIES (
	directory_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name VARCHAR(64) NOT NULL,
	created_timestamp BIGINT NOT NULL,
	updated_timestamp BIGINT NOT NULL,
	super_directory_id UUID NOT NULL,
	
	FOREIGN KEY (directory_id) REFERENCES TABLE_DIRECTORIES(directory_id)
);