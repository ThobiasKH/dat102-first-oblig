SRC_DIR = src
OUT_DIR = target
MAIN_CLASS = no.hvl.data102.filmarkiv.klient.FilmarkivMain
TEST_CLASSES = no.hvl.data102.filmarkiv.test.*

all: compile run

compile:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) -sourcepath $(SRC_DIR) $(SRC_DIR)/no/hvl/data102/filmarkiv/**/*.java

test:
	java -jar junit-platform-console-standalone.jar --classpath $(OUT_DIR) --scan-classpath

run:
	java -cp $(OUT_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(OUT_DIR)
