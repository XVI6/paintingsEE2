#!/bin/sh

java -cp /usr/lib/dev/hsqldb-2.3.4/hsqldb/lib/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost/workdb
