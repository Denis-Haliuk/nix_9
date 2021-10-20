call cd ..
call cd string_helper
call mvn clean install

call cd ..
call cd hw_2_strings
call mvn clean install

call cd target
call java -jar hw_2_strings.jar