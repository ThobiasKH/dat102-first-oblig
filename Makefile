SRC_DIR = src
OUT_DIR = target
MAIN_CLASS = no.hvl.data102.filmarkiv.klient.FilmarkivMain
TEST_CLASSES = no.hvl.data102.filmarkiv.test.*

# Use JUnit 4 since `org.junit.Test` and `Assert.assertEquals` are from JUnit 4
JUNIT_JAR = junit-4.13.2.jar:hamcrest-core-1.3.jar

all: compile run

compile:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) -cp $(JUNIT_JAR) -sourcepath $(SRC_DIR) $(SRC_DIR)/no/hvl/data102/filmarkiv/**/*.java


#test:
#	@find $(OUT_DIR) -name "*.class" | sed 's|/|.|g' | sed 's|$(OUT_DIR)/||' | sed 's|.class$$||' > test_classes.txt
#	@java -cp $(OUT_DIR):$(JUNIT_JAR) org.junit.runner.JUnitCore $$(cat test_classes.txt | grep "test")
test:
	java -cp $(OUT_DIR):junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore no.hvl.data102.filmarkiv.test.FilmarkivTest

run:
	java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)
