INSERT INTO TABLE_DIRECTORIES (name, created_timestamp, updated_timestamp)
	VALUES ('root', EXTRACT(EPOCH FROM NOW()) * 1000, EXTRACT(EPOCH FROM NOW()) * 1000);
