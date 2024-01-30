# Makefile
run-dist: # Run application
	@./build/install/app/bin/app -h

build:
	@./gradlew clean build

install:
	@./gradlew clean install

test:
	@./gradlew test

report:
	@./gradlew jacocoTestReport

asciinema:
	./build/install/app/bin/app -h
	@sleep 1
	./build/install/app/bin/app src/test/resources/j1.json src/test/resources/j2.json
	@sleep 1
	./build/install/app/bin/app -f plain src/test/resources/y1.yml src/test/resources/y2.yml
	@sleep 1
	./build/install/app/bin/app -f json src/test/resources/y1.yml src/test/resources/y2.yml


.PHONY: build