CREATE TABLE PUBLIC.GAMEINFO (	
	GAME_ID INTEGER NOT NULL,
	TS TIMESTAMP NOT NULL,
	METHOD_NAME CHAR(50) NOT NULL, 
	PLAYER_ID DECIMAL(10,0) NOT NULL,
	TRANSFER_OBJECT BINARY(5000) NOT NULL,
	DESCRIPTION CHAR(2000) NOT NULL,
	PRIMARY KEY (GAME_ID, TS));



