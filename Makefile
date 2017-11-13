.PHONY: createdb dropdb recreatedb

createdb:
	createdb -h 127.0.0.1 -U library library-manager

dropdb:
	dropdb -h 127.0.0.1 -U library library-manager

recreatedb: dropdb createdb
